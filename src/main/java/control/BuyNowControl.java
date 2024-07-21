package control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import dao.CartDAO;
import dao.ProductDAO;
import entity.Account;
import entity.Cart;
import entity.ProductVariant;

@WebServlet(name = "BuyNowControl", urlPatterns = { "/buyNow" })
public class BuyNowControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO = new ProductDAO();
	private CartDAO cartDAO = new CartDAO();

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String productID = request.getParameter("pid");
		int amount = Integer.parseInt(request.getParameter("quantity"));
		int size = Integer.parseInt(request.getParameter("selectedSize"));
		String img = request.getParameter("selectedImage");
		System.out.println("productID: " + productID);
		System.out.println("amount: " + amount);
		System.out.println("selectedSize: " + size);
		System.out.println("selectedImage: " + img);

		ProductVariant productVariant = productDAO.getProductVariantByProductIDSizeAndImg(productID, size, img);
		System.out.println("productVariant: " + productVariant);

		HttpSession session = request.getSession();
		Account acc = (Account) session.getAttribute("acc");
		if (acc == null) {
			response.sendRedirect("/WebBanGiayDep/login?pid=" + productID);
			return;
		}

		int accountID = acc.getId();
		int productVariantID = productVariant.getId();
		int quantity = productDAO.getQuantity(productVariantID);
		System.out.println("Quantity " + quantity);

		Cart cartExisted = cartDAO.checkCartExisted(accountID, productVariantID);
		if (cartExisted != null) {
			int amountExisted = cartExisted.getAmount();
			int newAmount = amount + amountExisted;
			int cartID = cartExisted.getId();
			if (quantity >= newAmount) {
				cartDAO.updateAmountCart(cartID, newAmount);
			} else {
				request.setAttribute("checkQuantity", false);
				request.getRequestDispatcher("/detail?pid=" + productID).forward(request, response);
				return;
			}
		} else {
			if (quantity >= amount) {
				cartDAO.insertCart(accountID, productVariantID, amount);
			} else {
				request.setAttribute("checkQuantity", false);
				request.getRequestDispatcher("/detail?pid=" + productID).forward(request, response);
				return;
			}
		}
		response.sendRedirect("managerCart");

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
