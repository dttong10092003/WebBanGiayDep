package control;

import java.io.IOException;

import dao.SupplierDAO;
import entity.Supplier;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(name = "AddSupplierControl", urlPatterns = {"/addSupplier"})
public class AddSupplierControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	        request.setCharacterEncoding("UTF-8");
	        String nameSupplier = request.getParameter("nameSupplier");
	        String phoneSupplier = request.getParameter("phoneSupplier");
	        String emailSupplier = request.getParameter("emailSupplier");
	        String addressSupplier = request.getParameter("addressSupplier");
	        
			if (nameSupplier == null || phoneSupplier == null || emailSupplier == null || addressSupplier == null
					|| nameSupplier.isEmpty() || phoneSupplier.isEmpty() || emailSupplier.isEmpty()
					|| addressSupplier.isEmpty()) {
				request.setAttribute("error", "Please fill all fields!");
				request.getRequestDispatcher("managerSupplier").forward(request, response);
				return;
			}
			
			if (!emailSupplier.endsWith("@gmail.com") && !emailSupplier.endsWith("@email.com")) {
				request.setAttribute("error", "Email must end with @gmail.com or @email.com");
				request.getRequestDispatcher("managerSupplier").forward(request, response);
				return;
			}
			
			// Kiểm tra định dạng số điện thoại
			if (!phoneSupplier.matches("^0\\d{9}$")) {
				request.setAttribute("mess",
						"Số điện thoại không hợp lệ. Số điện thoại phải có 10 kí tự và bắt đầu bằng số 0.");
				request.getRequestDispatcher("managerSupplier").forward(request, response);
				return;
			}						
	        
	       	SupplierDAO dao = new SupplierDAO();
	       	Supplier s = new Supplier();
	       	s.setName(nameSupplier);
	       	s.setPhoneNumber(phoneSupplier);
	       	s.setEmail(emailSupplier);
	       	s.setAddress(addressSupplier);
	        dao.insertSupplier(s);
	        request.setAttribute("mess", "Supplier Added!");
	        request.getRequestDispatcher("managerSupplier").forward(request, response);
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
