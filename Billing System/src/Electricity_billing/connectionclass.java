
package Electricity_billing;
import java.sql.*;

public class connectionclass {
    Connection cn;
	Statement stm;
	public connectionclass()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/billing","root","");
			stm=cn.createStatement();
//			if(cn.isClosed())
//			{
//				System.out.println("closed");
//			}
//			else
//			{
//				System.out.println("open......");
//			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String s[])
	{
		new connectionclass();
	}
    
}
