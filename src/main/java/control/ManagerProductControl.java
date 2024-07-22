package control;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import dao.BrandDAO;
import dao.CategoryDAO;
import dao.ProductDAO;
import dao.SupplierDAO;
import entity.Brand;
import entity.Category;
import entity.Product;
import entity.Supplier;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ManagerControl", urlPatterns = { "/manager" })
public class ManagerProductControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		String index = request.getParameter("index");
		if (index == null) {
			index = "1";
		}
		int indexPage = Integer.parseInt(index);

		ProductDAO productDAO = new ProductDAO();
		BrandDAO brandDAO = new BrandDAO();
		CategoryDAO categoryDAO = new CategoryDAO();
		SupplierDAO supplierDAO = new SupplierDAO();

		List<Product> listProduct = productDAO.get5ProductByIndex(indexPage);
		List<Brand> listBrand = brandDAO.getAllBrand();
		List<Category> listCategory = categoryDAO.getAllCategory();
		List<Supplier> listSupplier = supplierDAO.getAllSupplier();

		int countAllProduct = productDAO.getCountAllProduct();

		int endPage = countAllProduct / 5;
		if (countAllProduct % 5 != 0) {
			endPage++;
		}
		String[] colors = { "white", "black", "red", "yellow", "pink", "purple", "blue", "brown", "green", "organe",
				"gray", "navy", "cream",  };
		List<String> listColor = Arrays.asList(colors);

		request.setAttribute("tag", indexPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("listP", listProduct);
		request.setAttribute("listBrand", listBrand);
		request.setAttribute("listCategory", listCategory);
		request.setAttribute("listSupplier", listSupplier);
		request.setAttribute("listColor", listColor);

		request.getRequestDispatcher("ManagerProduct.jsp").forward(request, response);

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
