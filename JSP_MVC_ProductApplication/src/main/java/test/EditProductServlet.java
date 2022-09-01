package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/edit")
public class EditProductServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		HttpSession hs = req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg","Session Expired...<br>");
			RequestDispatcher rd = req.getRequestDispatcher("Invalid.jsp");
			rd.forward(req, res);
		}else
		{
			ProductBean pb = new ProductRetrieveDAO().retrieve(req);
			if(pb==null) 
			{
				RequestDispatcher rd =req.getRequestDispatcher("EditFail.jsp");
				rd.forward(req, res);
		    }else
		    {
				hs.setAttribute("pb",pb);
				RequestDispatcher rd =req.getRequestDispatcher("Edit.jsp");
				rd.forward(req, res);
		    }
	    }
   }
}
