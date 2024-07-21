package control;

import java.io.IOException;

import dao.AccountDAO;
import dao.InvoiceDAO;
import dao.ProductDAO;
import entity.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "StatisticControl", urlPatterns = { "/admin" })
public class StatisticControl extends HttpServlet {

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
		AccountDAO accountDAO = new AccountDAO();
		InvoiceDAO invoiceDAO = new InvoiceDAO();
		ProductDAO productDAO = new ProductDAO();
		if (a == null) {
			response.sendRedirect("login");
			return;
		}
		int accountID = a.getId();
		boolean isAdmin = accountDAO.getIsAdmin(accountID);
		if (!isAdmin) {
			response.sendRedirect("login");
			return;
		}

		int totalSoldQuantity = productDAO.totalSoldQuantity();
		int countProduct = productDAO.getCountAllProduct();
		double sumAllInvoice = invoiceDAO.sumAllInvoice();
		
		request.setAttribute("totalSoldQuantity", totalSoldQuantity);
		request.setAttribute("countProduct", countProduct);
		request.setAttribute("sumAllInvoice", sumAllInvoice);
		
		request.getRequestDispatcher("Statistic.jsp").forward(request, response);
		
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
