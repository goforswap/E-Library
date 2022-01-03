

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<head>\r\n" + 
				"<style> \r\n" + 
				"        .tab { \r\n" + 
				"            tab-size: 50; \r\n" + 
				"        } \r\n" +
				"body {\r\n" + 
				" color: #FFFFFF;"+
				"background: url(\"image.jpg\");\r\n" + 
				"}"+
				"</style>"
				+ "</head>");
		out.println("<pre class=\"tab\" style=\"line-height: 150%;\">"+
				"<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>"+
				"<br><h2>	If You Have Downloaded the E-Book, Thank You For Downloading The E-Book. </h2>" +
				"<br><h2>	You have been Successfully Logged Out. We Hope You Enjoyed The Experienced. Please Login Again. </h2>" +
				"<br><h2>	You Will be Redirected to Home Page in 5 Seconds. </h2></pre>");
		response.setHeader("Refresh", "5; URL=http://localhost:8080/E-Library-New/index.html");
	}
}
