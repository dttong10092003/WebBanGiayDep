package control;

import java.io.IOException;
import java.util.List;

import dao.BrandDAO;
import dao.CategoryDAO;
import dao.ProductDAO;
import dao.SupplierDAO;
import entity.Brand;
import entity.Category;
import entity.Product;
import entity.ProductVariant;
import entity.Supplier;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "LoadProductControl", urlPatterns = { "/loadProduct" })
public class LoadProductControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String productID = request.getParameter("pid");
		ProductDAO productDAO = new ProductDAO();
		BrandDAO brandDAO = new BrandDAO();
		CategoryDAO categoryDAO = new CategoryDAO();
		SupplierDAO supplierDAO = new SupplierDAO();

		Product product = productDAO.getProductByID(productID);
		List<ProductVariant> listVariant = productDAO.getProductVariantByProductID(productID);
		List<Brand> listBrand = brandDAO.getAllBrand();
		List<Category> listCategory = categoryDAO.getAllCategory();
		List<Supplier> listSupplier = supplierDAO.getAllSupplier();

		request.setAttribute("product", product);
		request.setAttribute("listVariant", listVariant);
		request.setAttribute("listCategory", listCategory);
		request.setAttribute("listBrand", listBrand);
		request.setAttribute("listSupplier", listSupplier);
		request.getRequestDispatcher("Edit.jsp").forward(request, response);
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
