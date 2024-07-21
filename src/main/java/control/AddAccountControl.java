package control;

import java.io.IOException;

import dao.AccountDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "AddAccountControl", urlPatterns = { "/addAccount" })
public class AddAccountControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		String email = request.getParameter("email");
		
		if (user == null || pass == null || email == null || user.trim().isEmpty() || pass.trim().isEmpty()
				|| email.trim().isEmpty()) {
			request.setAttribute("error", "Cannot be empty");
			request.getRequestDispatcher("managerAccount").forward(request, response);
			return;
		}		
		if (!email.endsWith("@gmail.com") && !email.endsWith("@email.com")) {
			request.setAttribute("error", "Email must end with @gmail.com or @email.com");
			request.getRequestDispatcher("managerAccount").forward(request, response);
			return;
		}

		AccountDAO accountDAO = new AccountDAO();
		accountDAO.insertAccount(user, pass, email, true);
		request.setAttribute("mess", "Account Added!");

		request.getRequestDispatcher("managerAccount").forward(request, response);
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
