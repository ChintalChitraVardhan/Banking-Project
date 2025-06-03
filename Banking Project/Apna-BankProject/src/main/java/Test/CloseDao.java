package Test;
import java.sql.*;
public class CloseDao {

	public int closefrom(String name,String pword,int acno)
	{
		int k=0;
		try
		{
		Connection con=DBConnection.getConnection();
		PreparedStatement ps=con.prepareStatement("delete from bank where acno=? and uname=?");
		ps.setInt(1, acno);
		ps.setString(2, name);
		//ps.setString(3, pword);
		k=ps.executeUpdate();
		//System.out.println(k);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;
	}
}
