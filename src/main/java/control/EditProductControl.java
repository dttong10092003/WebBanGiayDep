package control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.ProductDAO;
import entity.Product;
import entity.ProductVariant;

@WebServlet(name = "EditProductControl", urlPatterns = {"/edit"})
public class EditProductControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		ProductDAO productDAO = new ProductDAO();
		String productID = request.getParameter("id");
		String name = request.getParameter("name");
		String image = request.getParameter("image");
		String priceStr = request.getParameter("price");
		String retailPriceStr = request.getParameter("retailPrice");
		String description = request.getParameter("description");
		String genderStr = request.getParameter("gender");
		String brandIDStr = request.getParameter("brandID");
		String categoryIDStr = request.getParameter("categoryID");
		String supplierIDStr = request.getParameter("supplierID");

		if (name == null || image == null || priceStr == null || retailPriceStr == null || genderStr == null
				|| brandIDStr == null || categoryIDStr == null || supplierIDStr == null || name.isEmpty()
				|| image.isEmpty() || priceStr.isEmpty() || retailPriceStr.isEmpty() || genderStr.isEmpty()
				|| brandIDStr.isEmpty() || categoryIDStr.isEmpty() || supplierIDStr.isEmpty()) {
			request.setAttribute("error", "Please fill all fields!");
			request.getRequestDispatcher("loadProduct?pid=" + productID).forward(request, response);
			return;
		} else {
			try {
				double price = Double.parseDouble(priceStr);
				double retailPrice = Double.parseDouble(retailPriceStr);
				int gender = Integer.parseInt(genderStr);
				int brandID = Integer.parseInt(brandIDStr);
				int categoryID = Integer.parseInt(categoryIDStr);
				int supplierID = Integer.parseInt(supplierIDStr);

				if (price <= 0 || retailPrice <= 0) {
					request.setAttribute("error", "Price must be greater than 0!");
					request.getRequestDispatcher("loadProduct?pid=" + productID).forward(request, response);
					return;
				}

				if (price > retailPrice) {
					request.setAttribute("error", "Price must be less than retail price!");
					request.getRequestDispatcher("loadProduct?pid=" + productID).forward(request, response);
					return;
				}

				productDAO.updateProduct(productID, name, image, price, retailPrice, description, categoryID, brandID,
						supplierID, gender);

			} catch (Exception e) {
				request.setAttribute("error", "Sai định dạng!");
				request.getRequestDispatcher("loadProduct?pid=" + productID).forward(request, response);
				return;
			}
		}
		
		
		List<ProductVariant> listVariant = productDAO.getProductVariantByProductID(productID);
		for (ProductVariant productVariant : listVariant) {
			String quantityStr = request.getParameter("quantity_" + productVariant.getColor() + "_size_" + productVariant.getSize());
			String image1 = request.getParameter("image1_" + productVariant.getColor() + "_size_" + productVariant.getSize());
			String image2 = request.getParameter("image2_" + productVariant.getColor() + "_size_" + productVariant.getSize());
			String image3 = request.getParameter("image3_" + productVariant.getColor() + "_size_" + productVariant.getSize());
			String image4 = request.getParameter("image4_" + productVariant.getColor() + "_size_" + productVariant.getSize());
			
			if (quantityStr == null || quantityStr.isEmpty() || image1 == null || image1.isEmpty() || image2 == null
					|| image2.isEmpty() || image3 == null || image3.isEmpty() || image4 == null || image4.isEmpty()) {
				request.setAttribute("error", "Please fill all fields!");
				request.getRequestDispatcher("loadProduct?pid=" + productID).forward(request, response);
				return;
			} else {
				try {
					int quantity = Integer.parseInt(quantityStr);
					if (quantity <= 0) {
						request.setAttribute("error", "Quantity must be greater than 0!");
						request.getRequestDispatcher("loadProduct?pid=" + productID).forward(request, response);
						return;
					}
					productDAO.updateProductVariant(quantity, image1, image2, image3, image4, productVariant.getId());
					System.out.println(productVariant.getId() +  " " + quantity);
				} catch (Exception e) {
					request.setAttribute("error", "Sai định dạng!");
					request.getRequestDispatcher("loadProduct?pid=" + productID).forward(request, response);
					return;
				}
			}
		}			

		request.setAttribute("mess", "Product Updated!");
		request.getRequestDispatcher("manager").forward(request, response);
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
