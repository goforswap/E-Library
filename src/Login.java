

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		LoginDao dao = new LoginDao();
		if(dao.check(username, password))
		{
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(1000);
			session.setAttribute("username",username);
			String admin = username.substring(0,5).toLowerCase();
			if(admin.equals("admin"))
				response.sendRedirect("WelcomeAdmin");
			else
				response.sendRedirect("Welcome");
		}
		else
		{
			response.sendRedirect("./login.html");
		}
	}
}
