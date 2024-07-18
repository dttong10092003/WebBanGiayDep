package control;

import java.io.IOException;
import java.util.List;

import dao.CartDAO;
import entity.Account;
import entity.Cart;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "ManagerCartControl", urlPatterns = {"/managerCart"})
public class ManagerCartControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	CartDAO cartDAO = new CartDAO();
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
      
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        if(a == null) {
        	response.sendRedirect("login");
        	return;
        }
        int accountID = a.getId();
        List<Cart> listCart = cartDAO.getCartByAccountID(accountID);
        request.setAttribute("listCart", listCart);
        request.getRequestDispatcher("Cart.jsp").forward(request, response);
//        DAO dao = new DAO();
//        List<Cart> list = dao.getCartByAccountID(accountID);
//        List<Product> list2 = dao.getAllProduct();
      
//        request.setAttribute("listCart", list);
//        request.setAttribute("listProduct", list2);
//        request.getRequestDispatcher("Cart.jsp").forward(request, response);
//        double totalMoney=0;
//        for(Cart o : list) {
//        	for(Product p : list2) {
//        		if(o.getProductID()==p.getId()) {
//        			totalMoney=totalMoney+(p.getPrice()*o.getAmount());
//        		}
//        	}
//        }
//        
//        double totalMoneyVAT=totalMoney+totalMoney*0.1;
//       
//        
//       
//        
//       
//        PrintWriter out = response.getWriter();
//        		out.println(" <li class=\"d-flex justify-content-between py-3 border-bottom\"><strong class=\"text-muted\">Tổng tiền hàng</strong><strong>"+totalMoney+"</strong></li>\r\n"
//        				+ "                                        <li class=\"d-flex justify-content-between py-3 border-bottom\"><strong class=\"text-muted\">Phí vận chuyển</strong><strong>Free ship</strong></li>\r\n"
//        				+ "                                        <li class=\"d-flex justify-content-between py-3 border-bottom\"><strong class=\"text-muted\">VAT</strong><strong>10 %</strong></li>\r\n"
//        				+ "                                        <li class=\"d-flex justify-content-between py-3 border-bottom\"><strong class=\"text-muted\">Tổng thanh toán</strong>\r\n"
//        				+ "                                            <h5 class=\"font-weight-bold\">"+totalMoneyVAT+"</h5>\r\n"
//        				+ "                                        </li>");
//        	
//       
//       
//        		
//        	
//         
//    }
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
