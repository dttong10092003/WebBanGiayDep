package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import dao.ProductDAO;
import entity.ProductVariant;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "LoadImgControl", urlPatterns = { "/loadSizes" })
public class LoadSizesControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String color = request.getParameter("color");
		String productID = request.getParameter("productID");
		System.out.println("color: " + color);
		System.out.println("productID: " + productID);

		ProductDAO productDAO = new ProductDAO();
		List<ProductVariant> productVariants = productDAO.getProductVariantByProductIDAndColor(productID, color);

		StringBuilder htmlResponse = new StringBuilder();

		// First part: Sizes
		htmlResponse.append("<div id='sizeSection'>");
		for (int i = 0; i < productVariants.size(); i++) {
			if (i == 0) {
				htmlResponse.append("<a href=\"#\" class=\"selected\">" + productVariants.get(i).getSize() + "</a>");
			} else {
				htmlResponse.append("<a href=\"#\">" + productVariants.get(i).getSize() + "</a>");
			}
		}

		htmlResponse.append("</div>");

		// Second part: Images
		ProductVariant firstProductVariant = productVariants.get(0);
		htmlResponse.append("<div id='imageSection'>");
		htmlResponse.append("<div class=\"col-12 mb-0\">");
		htmlResponse.append("<figure class=\"view overlay rounded z-depth-1 main-img\" style=\"max-height: 450px;\">");
		htmlResponse.append(
				"<a href=\"https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/15a.jpg\" data-size=\"710x823\">");
		htmlResponse.append("<img src=\"" + firstProductVariant.getImage1()
				+ "\" class=\"img-fluid z-depth-1\" style=\"margin-top: -90px;\">");
		htmlResponse.append("</a>");
		htmlResponse.append("</figure>");

		htmlResponse.append("<figure class=\"view overlay rounded z-depth-1\" style=\"visibility: hidden;\">");
		htmlResponse.append(
				"<a href=\"https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/12a.jpg\" data-size=\"710x823\">");
		htmlResponse.append("<img src=\"" + firstProductVariant.getImage2() + "\" class=\"img-fluid z-depth-1\">");
		htmlResponse.append("</a>");
		htmlResponse.append("</figure>");

		htmlResponse.append("<figure class=\"view overlay rounded z-depth-1\" style=\"visibility: hidden;\">");
		htmlResponse.append(
				"<a href=\"https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/13a.jpg\" data-size=\"710x823\">");
		htmlResponse.append("<img src=\"" + firstProductVariant.getImage3() + "\" class=\"img-fluid z-depth-1\">");
		htmlResponse.append("</a>");
		htmlResponse.append("</figure>");

		htmlResponse.append("<figure class=\"view overlay rounded z-depth-1\" style=\"visibility: hidden;\">");
		htmlResponse.append(
				"<a href=\"https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/14a.jpg\" data-size=\"710x823\">");
		htmlResponse.append("<img src=\"" + firstProductVariant.getImage4() + "\" class=\"img-fluid z-depth-1\">");
		htmlResponse.append("</a>");
		htmlResponse.append("</figure>");
		htmlResponse.append("</div>");

		htmlResponse.append("<div class=\"col-12\">");
		htmlResponse.append("<div class=\"row\">");
		htmlResponse.append("<div class=\"col-3\">");
		htmlResponse.append("<div class=\"view overlay rounded z-depth-1 gallery-item hoverable\">");
		htmlResponse.append("<img src=\"" + firstProductVariant.getImage1() + "\" class=\"img-fluid\">");
		htmlResponse.append("<div class=\"mask rgba-white-slight\"></div>");
		htmlResponse.append("</div>");
		htmlResponse.append("</div>");

		htmlResponse.append("<div class=\"col-3\">");
		htmlResponse.append("<div class=\"view overlay rounded z-depth-1 gallery-item hoverable\">");
		htmlResponse.append("<img src=\"" + firstProductVariant.getImage2() + "\" class=\"img-fluid\">");
		htmlResponse.append("<div class=\"mask rgba-white-slight\"></div>");
		htmlResponse.append("</div>");
		htmlResponse.append("</div>");

		htmlResponse.append("<div class=\"col-3\">");
		htmlResponse.append("<div class=\"view overlay rounded z-depth-1 gallery-item hoverable\">");
		htmlResponse.append("<img src=\"" + firstProductVariant.getImage3() + "\" class=\"img-fluid\">");
		htmlResponse.append("<div class=\"mask rgba-white-slight\"></div>");
		htmlResponse.append("</div>");
		htmlResponse.append("</div>");

		htmlResponse.append("<div class=\"col-3\">");
		htmlResponse.append("<div class=\"view overlay rounded z-depth-1 gallery-item hoverable\">");
		htmlResponse.append("<img src=\"" + firstProductVariant.getImage4() + "\" class=\"img-fluid\">");
		htmlResponse.append("<div class=\"mask rgba-white-slight\"></div>");
		htmlResponse.append("</div>");
		htmlResponse.append("</div>");

		htmlResponse.append("</div>");
		htmlResponse.append("</div>");
		htmlResponse.append("</div>");

		PrintWriter out = response.getWriter();
		out.println(htmlResponse);

	}

}
