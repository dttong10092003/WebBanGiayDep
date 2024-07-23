package control;

import java.io.IOException;
import java.util.Map;

import dao.ProductDAO;
import entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "Top10ProductControl", urlPatterns = {"/top10Product"})
public class Top10ProductControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
       
        ProductDAO dao = new ProductDAO();
        Map<Product, Integer> listTop10Product = dao.getTop10ProductSold();


        
        request.setAttribute("listTop10Product", listTop10Product);

        request.getRequestDispatcher("Top10ProductSold.jsp").forward(request, response);
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

