package no.hvl.dat108;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "login", urlPatterns = "/login")
public class logInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String PW = null;
	Boolean pass = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession s = request.getSession(false);
		
		if(s != null) {
			s.invalidate();
		}else {
			s = request.getSession(true);
			s.setMaxInactiveInterval(30);
			s.setAttribute("password", request.getParameter("PW"));
		}
		response.setContentType("text/html; charset=ISO-8859-1");
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<body>");
		out.println("<form action=\"login\" method=\"post\">");
		out.println("<fieldset>");
		out.println("<legend>Login</legend>");
		if(pass) {
			out.println("<h3>");
			out.println("Oppgi passord");
			out.println("</h3>");
		}else if(!pass) {
			out.println("<h3>");
			out.println("Passordet du oppga var feil! Prøv igjen:");
			out.println("</h3>");
		}
		out.println("<p>");
        out.println("<input type=\"password\" name=\"PW\"/>");
        out.println("</p>");
		out.println("<p><input type=\"submit\" value=\"Send data\" /></p>");
		out.println("</fieldset>");
		out.println("<form>");
		out.println("</body>");
		out.println("</html>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rPW = request.getParameter("PW");
		if(!rPW.equals(PW)) {
			pass = false;
			response.sendRedirect("login");
		}else {
			pass = true;
			HttpSession s = request.getSession(false);
			if(s != null) {
				s.invalidate();
			}else {
				s = request.getSession(true);
				s.setMaxInactiveInterval(30);
				s.setAttribute("password", request.getParameter("PW"));
				s.setAttribute("Listen", new VareListe());
				response.sendRedirect("handlelisteServlet");
			}
		
		}
	}
	
	public void init(ServletConfig config) throws ServletException {
		pass = true;
		PW = config.getInitParameter("password");
	}
}
