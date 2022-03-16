package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbtest {
	
	public static void main(String[] args) {
		Connection con=null;
		String url="jdbc:mariadb://localhost:3306/";
		String driver="org.mariadb.jdbc.Driver";
		String dbname="testing";
		String username="root";
		String pwd="";
		
		try {
			
			Class.forName(driver).newInstance();
			con=DriverManager.getConnection(url+dbname,username,pwd);
			System.out.println(con.isClosed());
			Statement st=con.createStatement();
			ResultSet set= st.executeQuery("select * from employee");
			System.out.println(set);
			PreparedStatement cst= con.prepareStatement("select * from employee where Age=?");
			cst.setInt(1, 31);
			ResultSet rs= cst.executeQuery();
			
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"-----"+rs.getString(2)+"------"+rs.getInt(3));
			}
			
			while(set.next())
			{
				
				System.out.println(set.getString(1)+"------"+set.getString(2)+"--------"+set.getString(3));
			}
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			try {
				if(!con.isClosed())
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}
