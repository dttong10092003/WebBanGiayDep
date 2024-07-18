package control;

import java.io.IOException;

import dao.CartDAO;
import entity.Account;
import entity.Cart;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "SubAmountCartControl", urlPatterns = { "/subAmountCart" })
public class SubAmountCartControl extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Account a = (Account) session.getAttribute("acc");
		if (a == null) {
			response.sendRedirect("login");
			return;
		}
		System.out.println("aaaa");
		int accountID = a.getId();
		int productVariantID = Integer.parseInt(request.getParameter("productVariantID"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		amount -= 1;
		if (amount == 0) {
			response.sendRedirect("deleteCart?productVariantID=" + productVariantID);
			return;
		}
		CartDAO cartDAO = new CartDAO();
		Cart cart = cartDAO.checkCartExisted(accountID, productVariantID);
		cartDAO.updateAmountCart(cart.getId(), amount);
		request.getRequestDispatcher("managerCart").forward(request, response);
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
