package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/log2")
public class AdminLoginServlet extends HttpServlet{
 protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
 {
	 UserBean ub = new LoginDAO().login(req);
	 if(ub==null) 
	 {
		 req.setAttribute("msg","Invalid Login Process...<br>");
		 RequestDispatcher rd = req.getRequestDispatcher("Invalid.jsp");
		 rd.forward(req, res);
	 }else
	 {
		 HttpSession hs = req.getSession();//Creating Session
		 hs.setAttribute("ubean",ub);
		 RequestDispatcher rd = req.getRequestDispatcher("Valid.jsp");
		 rd.forward(req, res); 
	 }
  }
}
 