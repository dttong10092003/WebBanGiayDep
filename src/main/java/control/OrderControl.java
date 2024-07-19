package control;

import java.io.IOException;
import java.util.List;

import dao.CartDAO;
import dao.InvoiceDAO;
import dao.ProductDAO;
import entity.Account;
import entity.Cart;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "OrderControl", urlPatterns = { "/order" })
public class OrderControl extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		CartDAO cartDAO = new CartDAO();
		ProductDAO productDAO = new ProductDAO();
		InvoiceDAO invoiceDAO = new InvoiceDAO();

		HttpSession session = request.getSession();
		Account a = (Account) session.getAttribute("acc");
		if (a == null) {
			response.sendRedirect("login");
			return;
		}
		int accountID = a.getId();
		List<Cart> listCart = cartDAO.getCartByAccountID(accountID);
		if (listCart.isEmpty()) {
			request.setAttribute("mess", "Giỏ hàng trống!");
			request.getRequestDispatcher("managerCart").forward(request, response);
			return;
		}

		// Lấy dữ liệu từ form
		String fullName = request.getParameter("fullName");
		String phoneNumber = request.getParameter("phoneNumber");
		String street = request.getParameter("street");
		String ward = request.getParameter("ward");
		String district = request.getParameter("district");
		String province = request.getParameter("province");
		System.out.println("fullName: " + fullName);

		// Kiểm tra xem các giá trị có null, rỗng hay không hợp lệ
		if (fullName == null || fullName.trim().isEmpty() || phoneNumber == null || phoneNumber.trim().isEmpty()
				|| street == null || street.trim().isEmpty() || ward == null || ward.trim().isEmpty()
				|| district == null || district.trim().isEmpty() || province == null || province.trim().isEmpty()) {
			request.setAttribute("mess", "Vui lòng điền đầy đủ thông tin.");
			request.getRequestDispatcher("managerCart").forward(request, response);
			return;
		}

		// Kiểm tra định dạng số điện thoại
		if (!phoneNumber.matches("^0\\d{9}$")) {
			request.setAttribute("mess",
					"Số điện thoại không hợp lệ. Số điện thoại phải có 10 kí tự và bắt đầu bằng số 0.");
			request.getRequestDispatcher("managerCart").forward(request, response);
			return;
		}

		boolean check = true;
		double totalPrice = cartDAO.getTotalPriceCartByAccountID(accountID);

		for (Cart c : listCart) {
			check = cartDAO.checkQuantity(c.getProductVariant().getId(), c.getAmount());
			if (!check) {
				String nameProduct = c.getProductVariant().getProductID().getName();
				int quantityProduct = c.getProductVariant().getQuantity();
				request.setAttribute("mess", "Sản phẩm " + nameProduct + " chỉ còn " + quantityProduct + " sản phẩm!");
				request.getRequestDispatcher("managerCart").forward(request, response);
				return;
			}
		}

		String address = street + ", " + ward + ", " + district + ", " + province;

		int invoiceID = invoiceDAO.insertInvoice(accountID, fullName, phoneNumber, address, totalPrice,
				getCurrentDate());

		if (invoiceID == -1) {
			request.setAttribute("mess", "Đặt hàng thất bại!");
			request.getRequestDispatcher("managerCart").forward(request, response);
			return;
		}

		for (Cart c : listCart) {
			System.out.println("123");
			invoiceDAO.insertInvoiceDetail(invoiceID, c.getProductVariant().getId(), c.getAmount(),
					c.getProductVariant().getProductID().getRetailPrice() * c.getAmount());
			productDAO.updateQuantityAndSoldQuantity(c.getProductVariant().getId(), c.getAmount());
		}
		System.out.println("invoiceID: " + invoiceID);
		// Xóa giỏ hàng sau khi đặt hàng thành công
		cartDAO.deleteCartByAccountID(accountID);
		request.setAttribute("mess", "Đặt hàng thành công!");
		request.getRequestDispatcher("managerCart").forward(request, response);

	}

	private java.sql.Date getCurrentDate() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Date(today.getTime());
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
