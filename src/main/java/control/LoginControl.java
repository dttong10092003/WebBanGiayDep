package control;

import java.io.IOException;

import dao.AccountDAO;
import entity.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "LoginControl", urlPatterns = { "/login" })
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie arr[] = request.getCookies();
		if (arr != null) {
			for (Cookie o : arr) {
				if (o.getName().equals("userC")) {
					request.setAttribute("username", o.getValue());
				}
				if (o.getName().equals("passC")) {
					request.setAttribute("password", o.getValue());
				}
			}
		}
		request.getRequestDispatcher("Login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		String remember = request.getParameter("remember");

		AccountDAO daoAccount = new AccountDAO();
		Account acc = daoAccount.getAccount(username, password);

		if (acc == null) {
			request.setAttribute("error", "Sai username hoặc password!");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("acc", acc);
			session.setMaxInactiveInterval(60 * 60 * 24);
			// Lưu account vào cookie
			Cookie cUser = new Cookie("userC", username);
			Cookie cPass = new Cookie("passC", password);

			if (remember != null) {
				cPass.setMaxAge(60 * 60 * 24);
			} else {
				cPass.setMaxAge(0);
			}

			cUser.setMaxAge(60 * 60 * 24 * 365); // 1 năm

			response.addCookie(cUser);
			response.addCookie(cPass);

			response.sendRedirect("home");
		}

	}

}
