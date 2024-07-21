package control;

import java.io.IOException;
import java.util.List;

import dao.InvoiceDAO;
import entity.Invoice;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "InvoiceControl", urlPatterns = {"/invoice"})
public class InvoiceControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        InvoiceDAO invoiceDAO = new InvoiceDAO();
        
        List<Invoice> listAllInvoice = invoiceDAO.gettAllInvoice();
        
        
        request.setAttribute("listAllInvoice", listAllInvoice);
        
      
        request.getRequestDispatcher("Invoice.jsp").forward(request, response);
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
