

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class WelcomeAdmin
 */
@WebServlet("/WelcomeAdmin")
public class WelcomeAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		HttpSession session = request.getSession();
		if(session.getAttribute("username")==null)
		{
			response.sendRedirect("./login.html");
		}
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<head>\r\n" + 
				"<style> \r\n" + 
				"        .tab { \r\n" + 
				"            tab-size: 45; \r\n" + 
				"        } \r\n" +
				"body {\r\n" + 
				" color: #FFFFFF;"+
				" background: url(\'image.jpg\');\r\n" + 
				"}"+
				"input[type=submit] {"
				+ "background-color: #4CAF50;\r\n" + 
				"  color: white;\r\n" + 
				"  padding: 12px 20px;\r\n" + 
				"  border: none;\r\n" + 
				"  border-radius: 4px;\r\n" + 
				"  cursor: pointer;\r\n"
				+ "padding: 12px 20px;"
				+ "}"
				+ "input[type=submit]:hover {\r\n" + 
				"  background-color: #45a049;\r\n" + 
				"}" +
				".link"
				+ "{"
				+ "color : #FFFFFF;"
				+ "text-decoration: none;" 
				+ "background-color: none;"
				+ "}"
				+ ".link:hover"
				+ "{"
				+ "color : #000000"
				+ "}"+
				"</style>"
				+ "</head>");
		out.println("<h1 style=\"color: #000000;\">	Hello, "+session.getAttribute("username")+"!");
		out.println("<div style=\"float:right;\">"
				+ "<form action=\"Logout\" method=\"post\" autocomplete=\"off\">"+
				"<input type=\"submit\" value=\"Logout\">"
				+"</form> </div> </h1>");
		out.println("<pre class=\"tab\" style=\"line-height: 150%;\">"+
				"<br><br><br><br><br><br><br><br><br><br>"+
				"<h1>	<a class=\"link\" href=\"UserLog\">Check The User-Log Activity</a></h1>"+
				"<br><h1>	<a class=\"link\" href=\"UserList\">Check The List Of The Usernames</a></h1>"+
				"<br><h1>	<a class=\"link\" href=\"UserAddForm\">Add A User</a></h1>"+
				"<br><h1>	<a class=\"link\" href=\"UserDeleteForm\">Delete A User</a></h1>");
	}
}
