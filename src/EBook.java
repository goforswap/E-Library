

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

/**
 * Servlet implementation class EBook
 */
@WebServlet("/EBook")
public class EBook extends HttpServlet {
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
		out.println("<h1 style=\"color: #000000;\">	Hello, "+session.getAttribute("username")+"!");
		out.println("<div style=\"float:right;\">"
				+ "<form action=\"Logout\" method=\"post\" autocomplete=\"off\">"+
				"<input type=\"submit\" value=\"Logout\">"
				+"</form> </div> </h1>");
		String branch = (String)session.getAttribute("Branch");
		String subject = request.getParameter("getSubject");
		session.setAttribute("Subject", subject);
		String sql= "select distinct ebook_name from subject_ebook where subject_name=? order by ebook_name";
		String url= "jdbc:mysql://localhost:3306/e_library?useSSL=false";
		String username="root";
		String password="pass123";
		out.println("<pre class=\"tab\" style=\"line-height: 150%;\">"+
				"<form action='Download' method='post' autocomplete=off>"+ 
				"<br><br><br><br><br><br><br><br><br><br>"
				+ "<h2>	Your Selected Branch Is: "+branch+"</h2><br>"
				+ "<h2>	Your Selected Subject Is: "+subject+"</h2><br>"
				+ "<h2>	Select Your E-Book: <input type='text'\r\n" + 
				"name='getEBook' list='EBook' placeholder='Choose your E-Book...' size=65px; required=''/></h2>\r\n" + 
				"<h2>	<input type='Submit' value='Download E-Book'> </h2>" +
				"<br><br><h2>	Want To Change The Branch? <a class=\"link\" href=\"Welcome\">Click Here.</a>"+
				"<h2>	Want To Change The Subject? <a class=\"link\" href=\"Subject\">Click Here.</a>"+
				"</form>" + 
				"</pre>" + 
				"<datalist id='EBook'>");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,subject);
			ResultSet rs = st.executeQuery();
			while(rs.next())	
			{
				String ebook = rs.getString("ebook_name"); 
				out.println("<option value='"+ebook+"'>"+ebook+"</option>");
			}
		}
			catch(Exception e){
				e.printStackTrace();
			}
			out.println("</datalist>");
	}
}
