package control;

import java.io.IOException;
import java.util.List;

import dao.BrandDAO;
import dao.CategoryDAO;
import dao.ProductDAO;
import entity.Brand;
import entity.Category;
import entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ShopControl", urlPatterns = { "/shop" })
public class ShopControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		CategoryDAO categoryDAO = new CategoryDAO();
		BrandDAO brandDAO = new BrandDAO();
		ProductDAO productDAO = new ProductDAO();
		List<Category> listCategory = categoryDAO.getAllCategory();
		List<Brand> listBrand = brandDAO.getAllBrand();
		String index = request.getParameter("index");
		if (index == null) {
			index = "1";
		}
		int indexPage = Integer.parseInt(index);

		List<Product> listProduct = productDAO.getProductByIndex(indexPage);
		int count = productDAO.getCountAllProduct();
		int lastPage = count / 9;
		if (count % 9 != 0) {
			lastPage++;
		}
		
		List<String> colors = productDAO.getAllColor();
		
		
		request.setAttribute("listProduct", listProduct);
		request.setAttribute("listCategory", listCategory);
		request.setAttribute("listBrand", listBrand);
		request.setAttribute("index", indexPage);
		request.setAttribute("lastPage", lastPage);
		request.setAttribute("colors", colors);
		request.getRequestDispatcher("Shop.jsp").forward(request, response);

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
