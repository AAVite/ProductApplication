package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/update")
public class UpdateProductServlet extends HttpServlet{
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
			 ProductBean pb = (ProductBean)hs.getAttribute("pb");
			 pb.setPrice(Float.parseFloat(req.getParameter("pprice")));
			 pb.setQty(Integer.parseInt(req.getParameter("pqty")));
			 int k = new UpdateProductDAO().update(pb);
			 if(k>0)
			 {
				 RequestDispatcher rd=req.getRequestDispatcher("Update.jsp");
				 rd.forward(req, res);
			 }
		}
	} 
}