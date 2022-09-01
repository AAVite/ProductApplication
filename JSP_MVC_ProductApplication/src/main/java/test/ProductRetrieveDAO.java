package test;
import java.sql.*;
import jakarta.servlet.http.*;
public class ProductRetrieveDAO {
	public ProductBean pb=null;
	public ProductBean retrieve(HttpServletRequest req)
	{
		try {
			 Connection con = DBConnection.getCon();
			 PreparedStatement ps = con.prepareStatement
			 ("select * from Product44 where pcode=?");
			 ps.setString(1,req.getParameter("pcode"));
			 ResultSet rs = ps.executeQuery();
			 if(rs.next())
			 {
				 pb=new ProductBean();
				 pb.setCode(rs.getString(1));
				 pb.setName(rs.getString(2));
				 pb.setPrice(rs.getFloat(3));
				 pb.setQty(rs.getInt(4));
			 }
		}catch(Exception e) {e.printStackTrace();}
		return pb;
	}
}
