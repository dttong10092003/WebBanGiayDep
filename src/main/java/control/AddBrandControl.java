package control;

import java.io.IOException;

import dao.BrandDAO;
import entity.Supplier;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "AddBrandControl", urlPatterns = {"/addBrand"})
public class AddBrandControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	        request.setCharacterEncoding("UTF-8");
	        String name = request.getParameter("name");
	      
	        
			if (name == null || name.isEmpty()) {
				request.setAttribute("error", "Please fill all fields!");
				request.getRequestDispatcher("managerBrand").forward(request, response);
				return;
			}
								
	        
	       	BrandDAO brandDAO = new BrandDAO();
	       	brandDAO.insertBrand(name);
	        request.setAttribute("mess", "Brand Added!");
	        request.getRequestDispatcher("managerBrand").forward(request, response);
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
