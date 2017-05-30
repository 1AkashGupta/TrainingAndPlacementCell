package org.tap;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class LoginAccess {
	String url = "jdbc:mysql://localhost:3306/Sample";
	String user = "root";
	String pass ="chayan";
	String stmt = "SELECT * FROM studentlogin WHERE username=? and password=?";
		
	
	Driver sqld;
	Connection con;
	PreparedStatement pstmt;
	
	
	public LoginAccess() throws SQLException{
		
		sqld = new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(sqld);
		con = (Connection)DriverManager.getConnection(url, user, pass);
		System.out.println("Connection successful");
		pstmt = (PreparedStatement) con.prepareStatement(stmt);
		 
		
		
	}
	
	public int validateUser(String user, String pass) throws SQLException{
		pstmt.setString(1, user);
		pstmt.setString(2, pass);
		int i = 0;
		ResultSet rs = (ResultSet) pstmt.executeQuery();
		while(rs.next()){
			i = rs.getInt(1);
		}
		return i;
	}
	

}
