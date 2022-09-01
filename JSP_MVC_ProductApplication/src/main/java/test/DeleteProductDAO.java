package test;
import java.sql.*;
import jakarta.servlet.http.*;
public class DeleteProductDAO {
 public int k=0;
 public int delete(HttpServletRequest req)
 {
	 try {
		Connection con = DBConnection.getCon();
		PreparedStatement ps = con.prepareStatement("delete from Product44 where pcode=?");
		ps.setString(1,req.getParameter("pcode"));
		k = ps.executeUpdate();
	}catch(Exception e) {e.printStackTrace();}
	 return k;
 }
}
