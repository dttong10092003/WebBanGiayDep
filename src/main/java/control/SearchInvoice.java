package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import dao.InvoiceDAO;
import entity.Account;
import entity.Invoice;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "SearchInvoice", urlPatterns = { "/searchInvoice" })
public class SearchInvoice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String date = request.getParameter("date");
		InvoiceDAO dao = new InvoiceDAO();
		List<Invoice> listInvoiceByDate = dao.searchByDate(date);
		PrintWriter out = response.getWriter();

		for (Invoice invoice : listInvoiceByDate) {
			out.println("<tr>\r\n" + "                  <th scope=\"row\"></th>\r\n" + "                  <td>"
					+ invoice.getId() + "</td>\r\n" + "                  <td>" + invoice.getAccountID().getUsername()
					+ "</td>\r\n" + "                  <td>" + invoice.getTotalPrice() + "</td>\r\n"
					+ "                  <td>" + invoice.getDate() + "</td> \r\n" + "                </tr>");
		}

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
