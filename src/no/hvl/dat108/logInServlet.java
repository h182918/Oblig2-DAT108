package no.hvl.dat108;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class logInServlet
 */
@WebServlet("/")
public class logInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>");
		out.println("Oppgi passord");
		out.println("</h1>");
		out.println("<form action=\"myServlet\" method=\"get\">");
		out.println("<p>Oppgi passord:");
        out.println("<input type=\"text\" name=\"PW\" />");
        out.println("</p>");
		out.println("<p><input type=\"submit\" value=\"Send data\" /></p>");
		out.println("<form>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
