package control;

import java.io.IOException;

import dao.CartDAO;
import dao.ProductDAO;
import entity.Account;
import entity.Cart;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "AddAmountCartControl", urlPatterns = { "/addAmountCart" })
public class AddAmountCartControl extends HttpServlet {
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
		int accountID = a.getId();
		int productVariantID = Integer.parseInt(request.getParameter("productVariantID"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		amount += 1;
		CartDAO cartDAO = new CartDAO();
		ProductDAO productDAO = new ProductDAO();
		int quantity = productDAO.getQuantity(productVariantID);
		
		if (amount > quantity) {
			request.setAttribute("mess", "Số lượng không đủ!");			
		}else {
			Cart cart = cartDAO.checkCartExisted(accountID, productVariantID);
			cartDAO.updateAmountCart(cart.getId(), amount);
		}
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
