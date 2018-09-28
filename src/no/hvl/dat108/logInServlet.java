package no.hvl.dat108;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class logInServlet
 */
@WebServlet("/login")
public class logInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String PW = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String rPW = request.getParameter("PW");
		out.println("<html>");
		out.println("<body>");
		out.println("<form action=\"login\" method=\"post\">");
		out.println("<fieldset>");
		out.println("<legend>Login</legend>");
		out.println("<h3>");
		out.println("Oppgi passord");
		out.println("</h3>");
		out.println("<p>");
        out.println("<input type=\"text\" name=\"PW\"/>");
        out.println("</p>");
		out.println("<p><input type=\"submit\" value=\"Send data\" /></p>");
		out.println("</fieldset>");
		out.println("<form>");
		out.println("</body>");
		out.println("</html>");

		if(!rPW.equals(PW)) {
			out.println("<html>");
			out.println("<body>");
			out.println("<p>");
			out.println("Du oppga feil passord");
	        out.println("</p>");
			out.println("</body>");
			out.println("</html>");
		}else {
			HttpSession s = request.getSession(false);
			
			if(s != null) {
				s.invalidate();
			}else {
				s = request.getSession(true);
				s.setMaxInactiveInterval(30);
				s.setAttribute("password", request.getParameter("PW"));
			}
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession s = request.getSession(false);
		
		if(s != null) {
			s.invalidate();
		}else {
			s = request.getSession(true);
			s.setMaxInactiveInterval(30);
			s.setAttribute("password", request.getParameter("PW"));
		}
		
		response.sendRedirect("handlelisteServlet");
	}
	
	public void init() throws ServletException {
		PW = "1234";
	}

}
