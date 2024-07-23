package control;

import java.io.IOException;
import java.util.List;

import dao.SupplierDAO;
import entity.Supplier;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ManagerSupplierControl", urlPatterns = {"/managerSupplier"})
public class ManagerSupplierControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	       
	        SupplierDAO supplierDAO = new SupplierDAO();
	        
	        List<Supplier> listAllSupplier = supplierDAO.getAllSupplier();


	        request.setAttribute("listAllSupplier", listAllSupplier);

	        request.getRequestDispatcher("Supplier.jsp").forward(request, response);
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
