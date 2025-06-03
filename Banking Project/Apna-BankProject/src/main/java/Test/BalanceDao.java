package Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BalanceDao 
{    
	NewAcBean nb=null;
    public NewAcBean balanceform(int acno,String name)
    {     
    	try
    	{
    	Connection con=DBConnection.getConnection();
    	PreparedStatement ps=con.prepareStatement("select * from bank where acno=? and uname=?");
    	ps.setInt(1, acno);
    	ps.setString(2, name);
    	ResultSet rs = ps.executeQuery();
    	if(rs.next())
    	{
    		nb=new NewAcBean();
    		nb.setAcno(rs.getInt(1));
    		nb.setUname(rs.getString(2));
    		nb.setPword(rs.getString(3));
    		nb.setRepword(rs.getString(4));
    		nb.setAmount(rs.getDouble(5));
    		nb.setAddress(rs.getString(6));
    		nb.setPhone(rs.getLong(7));
    		
    	}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return nb;
    }
}
