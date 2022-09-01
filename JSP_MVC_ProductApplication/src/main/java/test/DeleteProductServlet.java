package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/delete")
public class DeleteProductServlet extends HttpServlet{
 protected void doPost(HttpServletRequest req,
		 HttpServletResponse res)throws ServletException,IOException
 {
	 HttpSession hs = req.getSession(false);
	 if(hs==null)
	 {
		 req.setAttribute("msg","Session Expired...<br>");
		 RequestDispatcher rd=req.getRequestDispatcher("Invalid.jsp");
		 rd.forward(req, res);
	 }else 
	 {
		 int k = new DeleteProductDAO().delete(req);
		 if(k>0) 
		 {
			 RequestDispatcher rd=req.getRequestDispatcher("Delete.jsp");
			 rd.forward(req, res);
		 }
    }
  }
}