package control;

import java.io.IOException;
import java.util.List;

import dao.ProductDAO;
import entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "HomeControl", urlPatterns = { "/home" })
public class HomeControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		ProductDAO productDAO = new ProductDAO();
		List<Product> top8Products = productDAO.getTop8Products();
		List<Product> top4NikeProductsNew = productDAO.getTop4NikeProductsNew();
		List<Product> top4AdidasProductsNew = productDAO.getTop4AdidasProductsNew();
		System.out.println(top8Products.size() + " " + top4NikeProductsNew.size());

		request.setAttribute("top8Products", top8Products);
		request.setAttribute("top4NikeProductsNew", top4NikeProductsNew);
		request.setAttribute("top4AdidasProductsNew", top4AdidasProductsNew);
		

		request.getRequestDispatcher("Home.jsp").forward(request, response);
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
