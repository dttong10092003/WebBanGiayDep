package control;

import java.io.IOException;
import java.util.ArrayList;
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
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "ShopControl", urlPatterns = { "/shop" })
public class ShopControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		
		
		System.out.println(session.toString());

		if (request.getParameterMap().isEmpty()) {
			session.removeAttribute("gender");
			session.removeAttribute("brand");
			session.removeAttribute("category");
			session.removeAttribute("price");
			session.removeAttribute("priceMin");
			session.removeAttribute("priceMax");
			session.removeAttribute("color");
			session.removeAttribute("txtS");
		}

		String[] genders = request.getParameterValues("gender");
		List<Integer> genderList = new ArrayList<>();
		if (genders != null) {
			session.setAttribute("gender", genders);
		} else {
			genders = (String[]) session.getAttribute("gender");
		}

		String brand = request.getParameter("brand");
		if (brand != null) {
			session.setAttribute("brand", brand);
		} else {
			brand = (String) session.getAttribute("brand");
		}

		String category = request.getParameter("category");
		if (category != null) {
			session.setAttribute("category", category);
		} else {
			category = (String) session.getAttribute("category");
		}

		String price = request.getParameter("price");
		if (price != null) {
			session.setAttribute("price", price);
		} else {
			price = (String) session.getAttribute("price");
		}

		String priceMin = request.getParameter("priceMin");
		if (priceMin != null) {
			session.setAttribute("priceMin", priceMin);
		} else {
			priceMin = (String) session.getAttribute("priceMin");
		}

		String priceMax = request.getParameter("priceMax");
		if (priceMax != null) {
			session.setAttribute("priceMax", priceMax);
		} else {
			priceMax = (String) session.getAttribute("priceMax");
		}

		String color = request.getParameter("color");
		if (color != null) {
			session.setAttribute("color", color);
		} else {
			color = (String) session.getAttribute("color");
		}

		String txtS = request.getParameter("txt");
		if (txtS != null) {
			session.setAttribute("txtS", txtS);
		} else {
			txtS = (String) session.getAttribute("txtS");
		}

		String index = request.getParameter("index");
		if (index == null) {
			index = "1";
		}
		int indexPage = Integer.parseInt(index);

		CategoryDAO categoryDAO = new CategoryDAO();
		BrandDAO brandDAO = new BrandDAO();
		ProductDAO productDAO = new ProductDAO();
		List<Category> listCategory = categoryDAO.getAllCategory();
		List<Brand> listBrand = brandDAO.getAllBrand();
		List<String> colors = productDAO.getAllColor();

		System.out.println("Gender:" + genders);
		System.out.println("Brand:" + brand);
		System.out.println("Category:" + category);
		System.out.println("Price:" + price);
		System.out.println("PriceMin:" + priceMin);
		System.out.println("PriceMax:" + priceMax);
		System.out.println("Color:" + color);
		System.out.println("Txt:" + txtS);
		System.out.println("Index:" + indexPage);

//		List<Product> listProduct = productDAO.getProductByIndex(indexPage);
//		int count = productDAO.getCountAllProduct();
		int count = productDAO.countProducts(genders, brand, category, price, priceMin, priceMax, color, txtS);
		int pageSize = 9;
		int lastPage = count / pageSize;
		if (count % 9 != 0) {
			lastPage++;
		}

		List<Product> listProduct = productDAO.getFilterProducts(indexPage, genders, brand, category, price, priceMin,
				priceMax, color, txtS);

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
