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

	VareListe vlist = new VareListe();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s = request.getSession(false);
		if(s != null) {
			s.invalidate();
		}else {
			s = request.getSession(true);
			s.setMaxInactiveInterval(30);
			s.setAttribute("password", request.getParameter("PW"));
			
			
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
			out.println("<button> leggtil</button>");
			out.println("<input type=\"text\" name=\"vare\"/>");
			out.println("</p>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
			s.setAttribute("vare", request.getParameter("vare"));
			vlist = (VareListe) s.getAttribute("vare");
		
		
		
		
		}
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
