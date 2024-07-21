package control;

import java.io.IOException;

import dao.InvoiceDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "RevenueByMonthControl", urlPatterns = {"/revenuebymonth"})
public class RevenueByMonthControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        InvoiceDAO invoiceDAO = new InvoiceDAO();
      
        double totalMoneyMonth1 = invoiceDAO.getTotalMoneyMonth(1);
		double totalMoneyMonth2 = invoiceDAO.getTotalMoneyMonth(2);
		double totalMoneyMonth3 = invoiceDAO.getTotalMoneyMonth(3);
		double totalMoneyMonth4 = invoiceDAO.getTotalMoneyMonth(4);
		double totalMoneyMonth5 = invoiceDAO.getTotalMoneyMonth(5);
		double totalMoneyMonth6 = invoiceDAO.getTotalMoneyMonth(6);
		double totalMoneyMonth7 = invoiceDAO.getTotalMoneyMonth(7);
		double totalMoneyMonth8 = invoiceDAO.getTotalMoneyMonth(8);
		double totalMoneyMonth9 = invoiceDAO.getTotalMoneyMonth(9);
		double totalMoneyMonth10 = invoiceDAO.getTotalMoneyMonth(10);
		double totalMoneyMonth11 = invoiceDAO.getTotalMoneyMonth(11);
		double totalMoneyMonth12 = invoiceDAO.getTotalMoneyMonth(12);
        

        
        request.setAttribute("totalMoneyMonth1", totalMoneyMonth1);
        request.setAttribute("totalMoneyMonth2", totalMoneyMonth2);
        request.setAttribute("totalMoneyMonth3", totalMoneyMonth3);
        request.setAttribute("totalMoneyMonth4", totalMoneyMonth4);
        request.setAttribute("totalMoneyMonth5", totalMoneyMonth5);
        request.setAttribute("totalMoneyMonth6", totalMoneyMonth6);
        request.setAttribute("totalMoneyMonth7", totalMoneyMonth7);
        request.setAttribute("totalMoneyMonth8", totalMoneyMonth8);
        request.setAttribute("totalMoneyMonth9", totalMoneyMonth9);
        request.setAttribute("totalMoneyMonth10", totalMoneyMonth10);
        request.setAttribute("totalMoneyMonth11", totalMoneyMonth11);
        request.setAttribute("totalMoneyMonth12", totalMoneyMonth12);
        
       
    
        request.getRequestDispatcher("RevenueByMonth.jsp").forward(request, response);
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
