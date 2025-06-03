package Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection 
{
	private DBConnection () {}
	private static Connection con=null;
	static
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection()
	{
		return con;
		
	}
}
