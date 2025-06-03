package Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class NewAcDao 
{
	int k=0;
    public int NewAc(NewAcBean nb)
    {
    	try
    	{
    	Connection con=DBConnection.getConnection();
    	PreparedStatement ps=con.prepareStatement("insert into bank values(sq1.nextval,?,?,?,?,?,?)");
    	ps.setString(1, nb.getUname());
    	ps.setString(2, nb.getPword());
    	ps.setString(3, nb.getRepword());
    	ps.setLong(4, (long) nb.getAmount());
    	ps.setString(5, nb.getAddress());
    	ps.setLong(6, nb.getPhone());
    	k=ps.executeUpdate();
    	String name=nb.getUname();
    	String pass=nb.getPword();
    	PreparedStatement ps1=con.prepareStatement("select acno from bank where uname=? and pword=?");
    	ps1.setString(1, name);
    	ps1.setString(2, pass);
    	ResultSet rs = ps1.executeQuery();
    	if(rs.next())
    	nb.setAcno(rs.getInt(1));
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return k;
    }
}
