

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Download
 */
@WebServlet("/Download")
public class Download extends HttpServlet {
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
		String Username = (String)session.getAttribute("username");
		String Book = request.getParameter("getEBook");
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String Date = myDateObj.format(myFormatObj);
		String fileName = Book+".pdf";
		String filePath = "C:\\E-Books\\";
		response.setContentType("APPLICATION/OCTET-STREAM");
		response.setHeader("Content-Disposition", "attachment; filename=\""+fileName+"\"");
		FileInputStream fs = new FileInputStream(filePath+fileName);
		int i;
		while((i=fs.read()) != -1){
		out.write(i);
		}
		String sql= "INSERT INTO user_log(username,ebook_name, date) Values (?,?,?)";
		String url= "jdbc:mysql://localhost:3306/e_library?useSSL=false";
		String username="root";
		String password="pass123";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, Username);
			st.setString(2, Book);
			st.setString(3, Date);
			st.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		fs.close();
		out.close();
	}
}