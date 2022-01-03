

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserLog
 */
@WebServlet("/UserLog")
public class UserLog extends HttpServlet {
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
				"            tab-size: 23; \r\n" + 
				"        } \r\n" +
				"body {\r\n" + 
				" color: #FFFFFF;"+
				" background: url(\'image.jpg\');\r\n" + 
				" background-repeat: no-repeat;\r\n" + 
				" background-attachment: fixed;"+
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
				"table {\r\n" + 
				"            border-collapse: collapse;\r\n" + 
				"            width: 40%;\r\n" + 
				"            }\r\n" + 
				"table.center {\r\n" + 
				"    margin-left: auto;\r\n" + 
				"    margin-right: auto;\r\n" + 
				"}"+
				"\r\n" + 
				"            th, td {\r\n" + 
				"            text-align: center;\r\n" + 
				"            padding: 8px;\r\n" + 
				"            }\r\n" + 
				"\r\n" + 
				"            tr:nth-child(even){background-color: rgba(242, 242, 242, 0.2)}\r\n" + 
				"            \r\n" + 
				"            tr:nth-child(odd){background-color: rgba(255, 192, 203, 0.2)}\r\n" + 
				"\r\n" + 
				"            th {\r\n" + 
				"            background-color: rgba(0, 191, 255, 0.7);\r\n" + 
				"            color: white;\r\n" + 
				"            }\r\n" + 
				"            \r\n" + 
				"            .head\r\n" + 
				"            {\r\n" + 
				"                color : green;\r\n" +
				" 				 font-size: 300%;" + 
				"            }"+
				"</style>"
				+ "</head>");
		out.println("<h1 style=\"color: #000000;\">	Hello, "+session.getAttribute("username")+"!");
		out.println("<div style=\"float:right;\">"
				+ "<form action=\"Logout\" method=\"post\" autocomplete=\"off\">"+
				"<input type=\"submit\" value=\"Logout\">"
				+"</form> </div> </h1>");
		out.println("<pre class=\"tab\"><h1 class=\"head\">	LOG REGARDING E-BOOKS DOWNLOADED BY USERS</h1></pre>");
		out.println("<table class=\"center\">\r\n" + 
				"    <tr>\r\n" + 
				"        <th><h2> USERNAME </h2></th>\r\n" + 
				"		 <th><h2> E-BOOK NAME  </h2></th> \r\n" +	
				"        <th><h2> DATE & TIME </h2></th>\r\n" + 
				"    </tr>");
		String sql = "SELECT username,ebook_name,date FROM user_log order by S_No DESC";
		String url= "jdbc:mysql://localhost:3306/e_library?useSSL=false";
		String username="root";
		String password="pass123";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
		    Statement st = con.createStatement();
		    ResultSet rs = st.executeQuery(sql);
		    while(rs.next())
		    {
		        out.println("<tr>"
		        		+ "<td><h3>"+rs.getString(1)+"</h3></td>"
		        		+ "<td><h3>"+rs.getString(2)+"</h3></td>"
		                + "<td><h3>"+rs.getString(3)+"</h3></td>");
		    }
		}
		catch(Exception e){
			e.printStackTrace();
		}
		out.println("</table><pre class=\"tab\" style=\"line-height: 150%;\">"+
				"<br><br>"+
				"<h2>			<a class=\"link\" href=\"WelcomeAdmin\">Click Here To Return To Admin Home Page</a></h2></pre>");
		}
}
