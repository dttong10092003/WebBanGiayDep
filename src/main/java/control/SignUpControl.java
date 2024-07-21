package control;

import java.io.IOException;

import dao.AccountDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "SignUpControl", urlPatterns = { "/signup" })
public class SignUpControl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		String re_pass = request.getParameter("repass");
		String email = request.getParameter("email");
		if (!pass.equals(re_pass) || user == null || pass == null || email == null || user.trim().isEmpty()
				|| pass.trim().isEmpty() || email.trim().isEmpty() || re_pass == null || re_pass.trim().isEmpty()
				|| (!email.endsWith("@gmail.com") && !email.endsWith("@email.com"))) {

			if (!pass.equals(re_pass)) {
				request.setAttribute("error", "Passwords do not match");
			} else if (!email.endsWith("@gmail.com") && !email.endsWith("@email.com")) {
				request.setAttribute("error", "Email must end with @gmail.com or @email.com");
			} else {
				request.setAttribute("error", "Cannot be empty");
			}

			request.setAttribute("signupUsername", user);
			request.setAttribute("signupEmail", email);
			request.getRequestDispatcher("Login.jsp").forward(request, response);
			return;

		} else {
			AccountDAO accountDAO = new AccountDAO();
			if (accountDAO.checkUsername(user)) {
				request.setAttribute("error", "Username already exists");
				request.setAttribute("signupEmail", email);
				request.getRequestDispatcher("Login.jsp").forward(request, response);
				return;
			} else {
				accountDAO.insertAccount(user, pass, email, false);
				request.setAttribute("user", user);
				request.setAttribute("pass", pass);
				request.getRequestDispatcher("login").forward(request, response);
				
			}
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

}
