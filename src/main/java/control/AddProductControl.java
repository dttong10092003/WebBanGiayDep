package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.ProductDAO;
import entity.Product;
import entity.ProductVariant;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "AddProductControl", urlPatterns = { "/addProduct" })
public class AddProductControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		ProductDAO productDAO = new ProductDAO();
		String[] colors = request.getParameterValues("colors");
		if (colors == null || colors.length == 0) {
            request.setAttribute("error", "Please choose at least one color!");
            request.getRequestDispatcher("manager").forward(request, response);
            return;
		}
		
		
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
			request.getRequestDispatcher("manager").forward(request, response);
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
					request.getRequestDispatcher("manager").forward(request, response);
					return;
				}

				if (price > retailPrice) {
					request.setAttribute("error", "Price must be less than retail price!");
					request.getRequestDispatcher("manager").forward(request, response);
					return;
				}

				String productID = "SP0001";
				Product productLast = productDAO.getProductLast();
				if (productLast != null) {
					productID = "SP" + String.format("%04d", Integer.parseInt(productLast.getId().substring(2)) + 1);
				}

				productDAO.addProduct(productID, name, image, price, retailPrice, description, categoryID, brandID,
						supplierID, gender);

			} catch (Exception e) {
				request.setAttribute("error", "Sai định dạng!");
				request.getRequestDispatcher("manager").forward(request, response);
				return;
			}
		}
		
		
		List<ProductVariant> variants = new ArrayList<>();
		String productID = productDAO.getProductLast().getId();
		if (colors != null) {
            for (String color : colors) {
               String sizes = request.getParameter("size_" + color);
				if (!(sizes != null || sizes.isEmpty())) {
					request.setAttribute("error", "Please fill all fields!");
					request.getRequestDispatcher("manager").forward(request, response);
					return;
				}else {
					String[] sizeArray = sizes.split(",\\s*");
					for (String size : sizeArray) {
						String quantityStr = request.getParameter("quantity_" + color);
						String image1 = request.getParameter("image1_" + color);
						String image2 = request.getParameter("image2_" + color);
						String image3 = request.getParameter("image3_" + color);
						String image4 = request.getParameter("image4_" + color);
						
						if(quantityStr == null || quantityStr.isEmpty() || image1 == null || image1.isEmpty() || image2 == null || image2.isEmpty() || image3 == null || image3.isEmpty() || image4 == null || image4.isEmpty()) {
                            request.setAttribute("error", "Please fill all fields!");
                            request.getRequestDispatcher("manager").forward(request, response);
                            return;
						} else {
							try {
                                int quantity = Integer.parseInt(quantityStr);
                                int sizeInt = Integer.parseInt(size);
                                if (quantity <= 0) {
                                    request.setAttribute("error", "Quantity must be greater than 0!");
                                    request.getRequestDispatcher("manager").forward(request, response);
                                    return;
                                }
								if (sizeInt <= 0) {
									request.setAttribute("error", "Size must be greater than 0!");
									request.getRequestDispatcher("manager").forward(request, response);
									return;
								}
                                ProductVariant variant = new ProductVariant();
								variant.setProductID(productDAO.getProductByID(productID));
                                variant.setColor(color);
                                variant.setSize(sizeInt);
                                variant.setQuantity(quantity);
                                variant.setImage1(image1);
                                variant.setImage2(image2);
                                variant.setImage3(image3);
                                variant.setImage4(image4);
                                variants.add(variant);
                                
                                productDAO.addProductVariant(variant);
                                
                            } catch (Exception e) {
                                request.setAttribute("error", "Sai định dạng!");
                                request.getRequestDispatcher("manager").forward(request, response);
                                return;
                            }
						}
					}
				}
                
            }
		}

		request.setAttribute("mess", "Product Added!");
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
