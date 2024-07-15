package control;

import java.io.IOException;
import java.util.List;

import dao.CartDAO;
import dao.ProductDAO;
import entity.Account;
import entity.Cart;
import entity.ProductVariant;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "RemoveFromCartControl", urlPatterns = { "/removeFromCart" })
public class RemoveFromCartControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductDAO productDAO = new ProductDAO();
		CartDAO cartDAO = new CartDAO();
		String productID = request.getParameter("pid");
		int size = Integer.parseInt(request.getParameter("size"));
		String image = request.getParameter("image");
		ProductVariant productVariant = productDAO.getProductVariantByProductIDSizeAndImg(productID, size, image);
		int productVariantID = productVariant.getId();
		HttpSession session = request.getSession();
		Account acc = (Account) session.getAttribute("acc");
		if (acc == null) {
			response.sendRedirect("/WebBanGiayDep/login");
			return;
		}
		int accountID = acc.getId();
		System.out.println("productID: " + productID);
		System.out.println("size: " + size);
		System.out.println("image: " + image);
		System.out.println("accountID: " + accountID);
		System.out.println("productVariantID: " + productVariantID);

		boolean result = cartDAO.deleteItemFromCart(productVariantID, accountID);
		System.out.println("result: " + result);
		List<Cart> listCart = cartDAO.getCartByAccountID(accountID);
		double totalPrice = cartDAO.getTotalPriceCartByAccountID(accountID);

		request.setAttribute("cart", listCart);
		request.setAttribute("totalPrice", totalPrice);
		request.setAttribute("showCart", true);

		request.getRequestDispatcher("/detail?pid=" + productID).forward(request, response);

//		response.setStatus(result ? HttpServletResponse.SC_OK : HttpServletResponse.SC_BAD_REQUEST);

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