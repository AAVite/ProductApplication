package test;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
public class LoginDAO {
 public UserBean ub=null;
 public UserBean login(HttpServletRequest req) {
	 try {
			Connection con = DBConnection.getCon();
			ServletContext sct = req.getServletContext();
			String s1 = (String)sct.getAttribute("logintype");
			if(s1.equals("UserLogin")) {
			 PreparedStatement ps = con.prepareStatement
			("select * from UserReg44 where uname=? and pword=?");
			 ps.setString(1,req.getParameter("uname"));
			 ps.setString(2,req.getParameter("pword"));
			 ResultSet rs = ps.executeQuery();
			 if(rs.next()) {
				 ub = new UserBean();
				 ub.setuName(rs.getString(1));
				 ub.setpWord(rs.getString(2));
				 ub.setfName(rs.getString(3));
				 ub.setlName(rs.getString(4));
				 ub.setAddr(rs.getString(5));
				 ub.setmId(rs.getString(6));
				 ub.setPhNo(rs.getLong(7));
			 }
		}else 
		{
			 PreparedStatement ps = con.prepareStatement
			 ("select * from AdminReg44 where uname=? and pword=?");
			 ps.setString(1,req.getParameter("uname"));
			 ps.setString(2,req.getParameter("pword"));
			 ResultSet rs = ps.executeQuery();
			 if(rs.next()) 
			 {
				 ub = new UserBean();
				 ub.setuName(rs.getString(1));
				 ub.setpWord(rs.getString(2));
				 ub.setfName(rs.getString(3));
				 ub.setlName(rs.getString(4));
				 ub.setAddr(rs.getString(5));
				 ub.setmId(rs.getString(6));
				 ub.setPhNo(rs.getLong(7));
			 }
		}
	}catch(Exception e) {e.printStackTrace();}
	return ub;
  }
}
