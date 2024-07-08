package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import dao.ProductDAO;
import entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "CategoryShopControl", urlPatterns = {"/categoryShop"})
public class CategoryShopControl extends HttpServlet {

    
	private static final long serialVersionUID = 1L;


	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int categoryID = Integer.parseInt(request.getParameter("cid"));
        ProductDAO dao = new ProductDAO();
        List<Product> list = dao.getProductByCategoryID(categoryID);
        System.out.println(list.size());
        PrintWriter out = response.getWriter();
        for(Product o : list) {
        	out.println("  <!-- Grid column -->\r\n"
        			+ "              <div class=\"col-md-4 mb-5\">\r\n"
        			+ "\r\n"
        			+ "                <!-- Card -->\r\n"
        			+ "                <div class=\"\">\r\n"
        			+ "\r\n"
        			+ "                  <div class=\"view zoom overlay rounded z-depth-2\">\r\n"
        			+ "                    <img class=\"img-fluid w-100 equal-image\"\r\n"
        			+ "                      src=\""+o.getImage()+"\" alt=\"Sample\">\r\n"
        			+ "                    <a href=\"detail?pid="+o.getId()+"\">\r\n"
        			+ "                      <div class=\"mask\">\r\n"
        			+ "                        <img class=\"img-fluid w-100\"\r\n"
        			+ "                          src=\""+o.getImage()+"\">\r\n"
        			+ "                        <div class=\"mask rgba-black-slight\"></div>\r\n"
        			+ "                      </div>\r\n"
        			+ "                    </a>\r\n"
        			+ "                  </div>\r\n"
        			+ "\r\n"
        			+ "                  <div class=\"text-center pt-4\">\r\n"
        			+ "\r\n"
        			+ "                    <h5>"+o.getName()+"</h5>\r\n"
        			+ "                    <p><span class=\"mr-1\"><strong>"+o.getPrice()+"$</strong></span></p>\r\n"
        			+ "\r\n"
        			+ "                  </div>\r\n"
        			+ "\r\n"
        			+ "                </div>\r\n"
        			+ "                <!-- Card -->\r\n"
        			+ "\r\n"
        			+ "              </div>\r\n"
        			+ "              <!-- Grid column -->");
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
