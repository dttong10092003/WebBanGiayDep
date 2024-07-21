package control;

import java.io.IOException;

import dao.AccountDAO;
import entity.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ForgotPasswordControl", urlPatterns = {"/forgotPassword"})
public class ForgotPasswordControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("ForgotPassword.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String emailAddress = request.getParameter("email");
			String username = request.getParameter("username");
			
			AccountDAO accountDAO = new AccountDAO();
			Account account = accountDAO.getAccountByUsernameAndEmail(username, emailAddress);
			if(account == null) {
				request.setAttribute("error", "Email or username is not correct!");
				request.getRequestDispatcher("ForgotPassword.jsp").forward(request, response);
			}else {
				String subject = "Lấy lại mật khẩu";
				StringBuilder sb = new StringBuilder();
				sb.append("Hello " + username + "\n");
				sb.append("Your password is: " + account.getPassword() + "\n");
				String content = sb.toString();
				request.setAttribute("mess", "Mật khẩu đã được gửi đến email của bạn!");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
				accountDAO.sendEmail(emailAddress, subject, content);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
    

}
