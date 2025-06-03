package Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class withdrawDao 
{
	 public static int withdrawform(double amt,int acno,String name)
	   {
		   int k=0;
		   try
		   {
		   Connection con=DBConnection.getConnection();
		   PreparedStatement ps=con.prepareStatement("update  bank set amount=amount-? where acno=? and uname=?");
			ps.setDouble(1, amt);
	    	ps.setInt(2, acno);
	    	ps.setString(3, name);
	    	k=ps.executeUpdate();
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
		   return k;
	   }
}
