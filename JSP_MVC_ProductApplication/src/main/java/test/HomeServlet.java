package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/home")
public class HomeServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		String s1=req.getParameter("s1");
		ServletContext sct=this.getServletContext();
		sct.setAttribute("logintype",s1);
		if(s1.equals("UserLogin")) 
		{
			RequestDispatcher rd=req.getRequestDispatcher("Login1.html");
			rd.forward(req, res);
		}else
		{
			RequestDispatcher rd=req.getRequestDispatcher("Login2.html");
			rd.forward(req, res);
		}
	}

}
