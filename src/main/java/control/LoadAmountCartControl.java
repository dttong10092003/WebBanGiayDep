package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import dao.CartDAO;
import entity.Account;
import entity.Cart;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "LoadAmountCartControl", urlPatterns = { "/loadAllAmountCart" })
public class LoadAmountCartControl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		int totalAmountCart = 0;
		HttpSession session = request.getSession();
		Account a = (Account) session.getAttribute("acc");
		if (a == null) {
			PrintWriter out = response.getWriter();
			out.println(totalAmountCart);
			return;
		}
		int accountID = a.getId();
		CartDAO cartDAO = new CartDAO();
		List<Cart> list = cartDAO.getCartByAccountID(accountID);
		totalAmountCart = list.size();	
		System.out.println("totalAmountCart: " + totalAmountCart);
		PrintWriter out = response.getWriter();
		out.println(totalAmountCart);


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
