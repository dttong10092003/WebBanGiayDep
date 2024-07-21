package control;

import java.io.IOException;

import dao.AccountDAO;
import entity.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "EditAccountControl", urlPatterns = { "/editAccount" })
public class EditAccountControl extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		Account a = (Account) session.getAttribute("acc");
		int id = a.getId();
		String currentPassword = request.getParameter("currentPassword");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		if (password == null || email == null || password.trim().isEmpty() || email.trim().isEmpty()
				|| (!email.endsWith("@gmail.com") && !email.endsWith("@email.com"))) {
			if (email == null || email.trim().isEmpty()) {
				request.setAttribute("error", "Email cannot be empty");
			} else if (password == null || password.trim().isEmpty()) {
				request.setAttribute("error", "Password cannot be empty");
			} else {
				request.setAttribute("error", "Email must end with @gmail.com or @email.com");
			}
			request.getRequestDispatcher("EditAccount.jsp").forward(request, response);
			return;
		} else {
			AccountDAO accountdao = new AccountDAO();
			if (accountdao.checkPassword(currentPassword, id)) {
				accountdao.editAccount(password, email, id);
				request.setAttribute("mess", "Edit account successfully! Please login again!");			
				session.removeAttribute("acc");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			} else {
				request.setAttribute("error", "Current password is incorrect");
                request.getRequestDispatcher("EditAccount.jsp").forward(request, response);
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
