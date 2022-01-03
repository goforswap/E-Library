import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {

	String sql= "INSERT INTO login Values (?,?,?)";
	String url= "jdbc:mysql://localhost:3306/e_library?useSSL=false";
	String username="root";
	String password="pass123";
	public void check(String name, String uname, String pass)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, name);
			st.setString(2, uname);
			st.setString(3, pass);
			st.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
