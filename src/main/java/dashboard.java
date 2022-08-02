import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/dashboard")
public class dashboard extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException {
		response.setContentType("text/html");
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		if((session.getAttribute("userName")!=null)&&(session.getAttribute("userPassword")!=null)){
			out.println("<h3>WELCOME USER "+session.getAttribute("userName"));
			out.println("<br>LOGGED IN!</h3>");
			out.println("<p><h4><a href='logout'>LOGOUT</a></h4>");
		}
		else {
			response.sendRedirect("index.html");
		}
	}
}

