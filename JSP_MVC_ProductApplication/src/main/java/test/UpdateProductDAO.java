package test;
import java.sql.*;
public class UpdateProductDAO {
	public int k=0;
	 public int update(ProductBean pb)
	 {
		 try 
		 {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("update Product44 set pprice=?,pqty=? where pcode=?");
			ps.setFloat(1,pb.getPrice());
			ps.setInt(2,pb.getQty());
			ps.setString(3,pb.getCode());
			k = ps.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		 return k;
	 }
}

