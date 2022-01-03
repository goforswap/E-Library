

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserDelete
 */
@WebServlet("/UserDelete")
public class UserDelete extends HttpServlet {
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
				"            tab-size: 50; \r\n" + 
				"        } \r\n" +
				"body {\r\n" + 
				" color: #FFFFFF;"+
				" background: url(\'image.jpg\');\r\n" + 
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
				"</style>"
				+ "</head>");
		String uname = request.getParameter("getUsername");
		String sql= "DELETE FROM login WHERE uname=?";
		String url= "jdbc:mysql://localhost:3306/e_library?useSSL=false";
		String username="root";
		String password="pass123";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,username,password);
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, uname);
				st.executeUpdate();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			out.println("<pre class=\"tab\" style=\"line-height: 150%;\">"+
					"<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>"+
					"<br><h2>	The User has been Deleted Successfully.</h2>" +
					"<br><h2>	To Check The List Of All The Users,<a class=\"link\" href=\"UserList\"> Click Here </a></h2>"+
					"<br><h2>	You Will be Redirected to the Admin Home Page in 8 Seconds. </h2></pre>");
			response.setHeader("Refresh", "8; URL=http://localhost:8080/E-Library-New/WelcomeAdmin");
	}
}
