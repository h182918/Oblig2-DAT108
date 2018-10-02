package no.hvl.dat108;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringEscapeUtils;

@WebServlet("/handlelisteServlet")
public class handlelisteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Sjekke om det er en aktiv session eller sender tilbake til hovedsiden
		HttpSession s = request.getSession(false);
		if (s == null) {
			response.sendRedirect("login?test");
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
			out.println("<form action = \"handlelisteServlet\" method = \"post\">");
			out.println("<p>");
			out.println("<button> Legg til</button>");
			out.println("<input type=\"text\" name=\"vare\"/>");
			out.println("</p>");
			out.println("</form>");
			if (liste.str() > 0) {
				out.println("<form action = \"handlelisteServlet\" method = \"post\">");
				for (int i = 0; i < liste.str(); i++) {
					out.println("<p><input type=\"submit\" id=" + i + " value=\"Slett\" /></p>" + liste.hent().get(i));
				}
				out.println("</form>");
			}
			out.println("</body>");
			out.println("</html>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String input = StringEscapeUtils.escapeHtml(request.getParameter("vare"));
		HttpSession s = request.getSession(false);

		if (s == null) {
			response.sendRedirect("login?ikkeloggetinn");
		} else {
			VareListe liste = (VareListe) s.getAttribute("Listen");
			liste.leggTil(input);
			response.sendRedirect("handlelisteServlet");
		}
	}
}
