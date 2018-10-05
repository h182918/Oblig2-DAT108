package no.hvl.dat108;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/handlelisteServlet")
public class handlelisteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//viser handlelisten etter man er logget inn/lagt til eller slettet et element, dette er alltid siden som vises etter korrekt innlogging
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Sjekke om det er en aktiv session eller sender tilbake til hovedsiden
		HttpSession s = request.getSession(false);
		if (s == null) {
			response.sendRedirect("login");
		} else {
			VareListe liste = (VareListe) s.getAttribute("Listen");
			response.setContentType("text/html; charset=ISO-8859-1");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<body>");
			out.println("<h3>");
			out.println("Min handleliste");
			out.println("</h3>");
			out.println("<form action = \"handlelisteServlet\" accept-charset=\"utf-8\"method = \"post\">");
			out.println("<input type=\"hidden\" name=\"formName\" value=\"leggtil\" />");
			out.println("<p>");
			out.println("<button> Legg til</button>");
			out.println("<input type=\"text\" name=\"vare\"/>");
			out.println("</p>");
			out.println("</form>");
			if (liste.str() > 0) {
				for (int i = 0; i < liste.str(); i++) {
					out.println("<form action = \"handlelisteServlet\" accept-charset=\"utf-8\" method = \"post\">");
					out.println("<input type=\"hidden\" name=\"formName\" value=\"slett\" />");
					out.println("<p><input type=\"submit\" value=\"Slett\" />	" + liste.hent().get(i) + "</p>" );
					out.println("<input type=\"hidden\" name=\"Vare\" value=\"" + liste.hent().get(i) + "\" />");
					out.println("</form>");
				}
			}
			out.println("</body>");
			out.println("</html>");
		}
	}

	//får en form fra doGet metoden og skjekker om den skal legge til eller slette et element
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		//sender input i leggtil skjemaet til en valideringsklasse
		String input = Inputvalidering.valider(request);
		
		HttpSession s = request.getSession(false);
		if (s == null) {
			response.sendRedirect("login?ikkeloggetinn");
		} else {
			String fName = request.getParameter("formName");
			VareListe liste = (VareListe) s.getAttribute("Listen");
			if(!(input.equals("feil")) && fName.equals("leggtil")) {
				liste.leggTil(input);
				response.sendRedirect("handlelisteServlet");
			}else if(fName.equals("slett")){
				String vare = request.getParameter("Vare");
				synchronized(liste) {
					liste.slett(vare);
					response.sendRedirect("handlelisteServlet");
				}
				response.sendRedirect("handlelisteServlet");
			}else {
				//Hvis noe kommer seg gjennom som ikke er slett eller leggtil vil siden bare vises på nytt
				response.sendRedirect("handlelisteServlet");
			}
		}
	}
}
