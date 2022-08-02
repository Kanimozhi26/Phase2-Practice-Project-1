import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
public class login extends HttpServlet{
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String uName=request.getParameter("userName");
		String uPassword=request.getParameter("userPassword");
		HttpSession theSession=request.getSession();
		if(uName.trim().equals("Kanimozhi")&&uPassword.trim().equals("Kani@26")){
			theSession.setAttribute("userName",uName);
			theSession.setAttribute("userPassword",uPassword);
			response.sendRedirect("dashboard");	
		}
		else {
			out.println("<font color='red'>INVALID USER NAME OR PASSWORD</font>");
			RequestDispatcher dispatcher=request.getRequestDispatcher("index.html");
			dispatcher.include(request,response);
		}
	}
}

