package control;

import java.io.IOException;
import java.io.PrintWriter;


import dao.CartDAO;
import entity.Account;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet(name = "TotalMoneyCartControl", urlPatterns = {"/totalMoneyCart"})
public class TotalMoneyCartControl extends HttpServlet {

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
        int accountID = a.getId();
        CartDAO cartDAO = new CartDAO();
        double totalPriceCart = cartDAO.getTotalPriceCartByAccountID(accountID);
        

        
        	
        PrintWriter out = response.getWriter();
        		out.println(" <li class=\"d-flex justify-content-between py-3 border-bottom\"><strong class=\"text-muted\">Subtotal</strong><strong>"+totalPriceCart+" $</strong></li>\r\n"
        				+ "                                        <li class=\"d-flex justify-content-between py-3 border-bottom\"><strong class=\"text-muted\">Delivery/Shipping</strong><strong>Free</strong></li>\r\n"
        				+ "                                        <li class=\"d-flex justify-content-between py-3 border-bottom\"><strong class=\"text-muted\">Total</strong>\r\n"
        				+ "                                            <h5 style=\"color: red;\" class=\"font-weight-bold\">"+totalPriceCart+" $</h5>\r\n"
        				+ "                                        </li>");
        	
        
        		
        	
         
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
