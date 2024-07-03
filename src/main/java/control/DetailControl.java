/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;


import java.io.IOException;
import java.util.List;

import dao.BrandDAO;
import dao.CategoryDAO;
import dao.ProductDAO;
import entity.Account;
import entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name = "DetailControl", urlPatterns = {"/detail"})
public class DetailControl extends HttpServlet {
	private ProductDAO productDAO = new ProductDAO();
	private BrandDAO brandDAO = new BrandDAO();
	private CategoryDAO categoryDAO = new CategoryDAO();
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("pid");
        System.out.println("id: " + id);
        Product p = productDAO.getProductByID(id);
        
        int cateIDProductDetail = categoryDAO.getCateIDByProductID(id);
        int brandIDProductDetail = brandDAO.getBrandIDByProductID(id);
        
        List<Product> listRelatedProduct = productDAO.getRelatedProduct(cateIDProductDetail, brandIDProductDetail);
        
//        List<Review> listAllReview = dao.getAllReviewByProductID(id);
//        int countAllReview = listAllReview.size();
        
//        List<Account> listAllAcount = dao.getAllAccount();
        
//        Product last = dao.getLast();

        request.setAttribute("detail", p);
        request.setAttribute("listRelatedProduct", listRelatedProduct);
//        request.setAttribute("listAllReview", listAllReview);
//        request.setAttribute("listAllAcount", listAllAcount);
//        request.setAttribute("countAllReview", countAllReview);
//        request.setAttribute("p", last);
        request.getRequestDispatcher("DetailProduct.jsp").forward(request, response);
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
