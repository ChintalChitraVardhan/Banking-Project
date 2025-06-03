package Test;
import java.sql.*;
public class TransferDao 
{
    public String Transferform(int acno,String uname,int tacno,double amt)
    {
    	try
    	{
    		Connection con=DBConnection.getConnection();
    		con.setAutoCommit(false);
    		PreparedStatement ps1=con.prepareStatement("select amount from bank where acno=?");
    		ps1.setInt(1, acno);
    		PreparedStatement ps2=con.prepareStatement("update bank set amount=amount+? where acno=?");
    		Savepoint s = con.setSavepoint();
    		ResultSet rs = ps1.executeQuery();
    		if(rs.next())
    		{
    			double bal=rs.getDouble(1);
    			if(amt<=bal)
    			{
    				ps2.setDouble(1, -amt);
    	    		ps2.setInt(2, acno);
    	    		int t1=ps2.executeUpdate();
    	    		ps2.setDouble(1, amt);
    	    		ps2.setInt(2, tacno);
    	    		int t2=ps2.executeUpdate();
    	    		if(t1==1&&t2==1)
    	    		{
    	    			con.commit();
    	    			return "Transaction Successful";
    	    		}
    	    		else
    	    		{
    	    			con.rollback(s);
    	    			return "Transaction Failed";
    	    			
    	    		}
    			}
    		}
    		
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return "";
    }
}
