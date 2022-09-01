package test;
import java.util.*;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewProductsServlet extends HttpServlet{
 protected void doGet(HttpServletRequest req,HttpServletResponse res)throws
 ServletException,IOException
 {
	 HttpSession hs = req.getSession();
	if(hs==null) {
		req.setAttribute("msg","Session expired...<br>");
		RequestDispatcher rd = req.getRequestDispatcher("Invalid.jsp");
		rd.forward(req, res);
	}else 
	{
		 ArrayList<ProductBean> al = new RetrieveDAO().retrieve();
		 hs.setAttribute("al", al);
		 RequestDispatcher rd = 
		 req.getRequestDispatcher("ViewProducts.jsp");
		 rd.forward(req, res);
	 }
 }
}
