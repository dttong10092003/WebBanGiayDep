package control;

import java.io.IOException;
import java.util.List;

import dao.BrandDAO;
import entity.Brand;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ManagerBrandControl", urlPatterns = { "/managerBrand" })
public class ManagerBrandControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		BrandDAO brandDAO = new BrandDAO();

		List<Brand> listAllBrand = brandDAO.getAllBrand();

		request.setAttribute("listAllBrand", listAllBrand);

		request.getRequestDispatcher("Brand.jsp").forward(request, response);
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
