package control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.InvoiceDAO;

@WebServlet(name = "RevenueByWeekdaysControl", urlPatterns = {"/revenuebyweekdays"})
public class RevenueByWeekdaysControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        InvoiceDAO invoiceDAO = new InvoiceDAO();
        
        double totalMoney1 = invoiceDAO.getTotalMoneyDay(1);
		double totalMoney2 = invoiceDAO.getTotalMoneyDay(2);
		double totalMoney3 = invoiceDAO.getTotalMoneyDay(3);
		double totalMoney4 = invoiceDAO.getTotalMoneyDay(4);
		double totalMoney5 = invoiceDAO.getTotalMoneyDay(5);
		double totalMoney6 = invoiceDAO.getTotalMoneyDay(6);
		double totalMoney7 = invoiceDAO.getTotalMoneyDay(7);
        
        
        
        request.setAttribute("totalMoney1", totalMoney1);
        request.setAttribute("totalMoney2", totalMoney2);
        request.setAttribute("totalMoney3", totalMoney3);
        request.setAttribute("totalMoney4", totalMoney4);
        request.setAttribute("totalMoney5", totalMoney5);
        request.setAttribute("totalMoney6", totalMoney6);
        request.setAttribute("totalMoney7", totalMoney7);
        
    
        
        request.getRequestDispatcher("RevenueByWeekdays.jsp").forward(request, response);
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
