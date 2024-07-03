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


@WebServlet(name = "LoadMoreAdidasControl", urlPatterns = {"/loadAdidas"})
public class LoadMoreAdidasControl extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String amount = request.getParameter("exitsAdidas");
        int iamount = Integer.parseInt(amount);
        ProductDAO dao = new ProductDAO();
        List<Product> list = dao.getNext4AdidasProducts(iamount);
        PrintWriter out = response.getWriter();

        for (Product o : list) {
        	out.println("<div class=\"productAdidas col-12 col-md-6 col-lg-3\">\r\n"
        	        + "    <div class=\"card\">\r\n"
        	        + "        <div class=\"view zoom z-depth-2 rounded\">\r\n"
        	        + "            <a href=\"detail?pid=" + o.getId() + "\" title=\"View Product\"><img class=\"img-fluid w-100\" src=\"" + o.getImage() + "\" alt=\"Card image cap\"></a>\r\n"
        	        + "        </div>\r\n"
        	        + "        <div class=\"card-body\">\r\n"
        	        + "            <h5 class=\"card-title show_txt\"><a href=\"detail?pid=" + o.getId() + "\" title=\"View Product\">" + o.getName() + "</a></h5>\r\n"
        	        + "            <p class=\"card-text show_txt\">" + o.getDescription() + "</p>\r\n"
        	        + "            <div class=\"row\">\r\n"
        	        + "                <div class=\"col\">\r\n"
        	        + "                    <a href=\"detail?pid=" + o.getId() + "\" class=\"btn btn-success btn-block\">" + o.getPrice() + " $</a>\r\n"
        	        + "                </div>\r\n"
        	        + "            </div>\r\n"
        	        + "        </div>\r\n"
        	        + "    </div>\r\n"
        	        + "</div>");

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
