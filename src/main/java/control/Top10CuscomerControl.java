package control;

import java.io.IOException;
import java.util.Map;

import dao.AccountDAO;
import entity.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "Top10CuscomerControl", urlPatterns = { "/top10Customer" })
public class Top10CuscomerControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		AccountDAO dao = new AccountDAO();

		Map<Account, Double> listTop10Customer = dao.getTop10Customer();

		request.setAttribute("listTop10Customer", listTop10Customer);
		request.getRequestDispatcher("Top10Customer.jsp").forward(request, response);
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
