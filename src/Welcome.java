

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Welcome")
public class Welcome extends HttpServlet {
	/**
	 * 
	 */
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
		session.setAttribute("Branch",null);
		out.println("<head>\r\n" + 
				"<style> \r\n" + 
				"        .tab { \r\n" + 
				"            tab-size: 50; \r\n" + 
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
				+ "}"+
				"input[type=text] {\r\n" + 
				"  padding: 5px;\r\n" + 
				"  border: none;\r\n" + 
				"  background-color: rgb(0,0,0,0.0);\r\n" +
				"  color: white;"+
				"  font: bold 17px Arial, sans-serif;"+
				"  border-bottom: 2px solid black;\r\n" + 
				"}"+
				"input[type=submit]:hover {\r\n" + 
				"  background-color: #45a049;\r\n" + 
				"}" +
				"</style>"
				+ "</head>");
		out.println("<h1 style=\"color: #000000;\">	Hello, "+session.getAttribute("username")+"!");
		out.println("<div style=\"float:right;\">"
				+ "<form action=\"Logout\" method=\"post\" autocomplete=\"off\">"+
				"<input type=\"submit\" value=\"Logout\">"
				+"</form> </div> </h1>");
		String sql= "select distinct branch_name from branch_subject order by branch_name";
		String url= "jdbc:mysql://localhost:3306/e_library?useSSL=false";
		String username="root";
		String password="pass123";
		out.println("<pre class=\"tab\" style=\"line-height: 150%;\">"+
				"<form action='Subject' method='post' autocomplete=off>"+ 
				"<br><br><br><br><br><br><br><br><br><br>"
				+ "<h2>	Select Your Branch: <input type='text'\r\n" + 
				"name='getBranch' list='branch' placeholder='Choose your Branch...' size=35px; required=''/></h2>\r\n" + 
				"<h2>	<input type='Submit' value='Submit'> </h2>" +
				"</form>" + 
				"</pre>" + 
				"<datalist id='branch'>"); 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next())	
			{
				String branch = rs.getString("branch_name"); 
				out.println("<option value='"+branch+"'>"+branch+"</option>");
			}
		}
			catch(Exception e){
				e.printStackTrace();
			}
			out.println("</datalist>");
	}
}