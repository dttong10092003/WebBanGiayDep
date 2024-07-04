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

@WebServlet(name = "LoadImgControl", urlPatterns = { "/loadImg" })
public class LoadImgControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String color = request.getParameter("color");
		String productID = request.getParameter("productID");
		System.out.println("color: " + color);
		System.out.println("productID: " + productID);

		ProductDAO productDAO = new ProductDAO();
		List<ProductVariant> listSize = productDAO.getProductVariantByProductIDAndColor(productID, color);

		
		
		
		StringBuilder htmlResponse = new StringBuilder();
		for (ProductVariant pv : listSize) {
			htmlResponse.append("<a href=\"#\">" + pv.getSize() + "</a>");
		}
		
		PrintWriter out = response.getWriter();
		out.println(htmlResponse);

	}

}
