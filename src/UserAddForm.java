

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserAddForm
 */
@WebServlet("/UserAddForm")
public class UserAddForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
				"            tab-size: 10; \r\n" + 
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
				"}"+
				"input[type=text], input[type=password] {\r\n" + 
				"  width: 20%;\r\n" + 
				"  padding: 5px;\r\n" + 
				"  border: none;\r\n" + 
				"  background-color: rgb(0,0,0,0.0);\r\n" +
				"  color: white;"+
				"  font: bold 17px Arial, sans-serif;"+
				"  border-bottom: 2px solid black;\r\n" + 
				"}"+
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
				"            .head\r\n" + 
				"            {\r\n" + 
				"                color : green;\r\n" +
				"				 font-size: 235%;" + 
				"            }"+
				"</style>"
				+ "</head>");
		out.println("<h1 style=\"color: #000000;\">	Hello, "+session.getAttribute("username")+"!");
		out.println("<div style=\"float:right;\">"
				+ "<form action=\"Logout\" method=\"post\" autocomplete=\"off\">"+
				"<input type=\"submit\" value=\"Logout\">"
				+"</form> </div> </h1>");
		out.println("<h1 class=\"head\"><center>ADD A USER</center></h1>");
		out.println("<pre class=\"tab\" style=\"line-height: 150%;\">"+
				"<form action='UserAdd' method='post' autocomplete=off>"+ 
				"<br><br><br><br><br><br><br>"+
				"<h2>							Name:	<input type='text'\r\n" +
				"name='getName' placeholder='Enter The Name...' size=30px; required=''/></h2><br>\r\n" +
				"<h2>							Username:	<input type='text'\r\n" +
				"name='getUsername' placeholder='Enter The Username...' size=30px; required=''/></h2><br>\r\n" +
				"<h2>							Password:	<input type='password'\r\n" +
				"name='getPassword' placeholder='Enter The Password...' size=30px; required=''/></h2><br>\r\n" +
				"<h2>							<input type='Submit' value='Submit'> </h2>"+
				"<br><br>"+
				"<h2>							<a class=\"link\" href=\"WelcomeAdmin\">Click Here To Return To Admin Home Page</a></h2>");
	}
}
