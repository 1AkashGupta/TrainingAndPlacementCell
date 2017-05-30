package org.tap;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class DataAccessRecruiter {
	String url = "jdbc:mysql://localhost:3306/Sample";
	String user = "root";
	String pass ="chayan";
	String stmt = "SELECT * FROM recruiters";
	String stmtinsert = "INSERT INTO recruiters(c_name, visit_date, cgpa, dept, skill, backlog, contact_no, email) values(?,?,?,?,?,?,?,?) ";
	
	
	Driver sqld;
	Connection con;
	PreparedStatement pstmt, pstmtinsert;
	
public DataAccessRecruiter() throws SQLException{
		
		sqld = new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(sqld);
		con = (Connection)DriverManager.getConnection(url, user, pass);
		System.out.println("Connection successful");
		pstmt = (PreparedStatement) con.prepareStatement(stmt);	
		pstmtinsert = (PreparedStatement) con.prepareStatement(stmtinsert);
	}
public ArrayList<Recruiter> getAllRecruiter() throws SQLException{
	ResultSet rs = (ResultSet) pstmt.executeQuery();
	ArrayList<Recruiter> list=null;
	while(rs.next()){
		if(list==null)
			list = new ArrayList<>();
		
		java.sql.Date sqld = rs.getDate(3);
		java.util.Date d = new java.util.Date(sqld.getTime());
		
		Recruiter p = new Recruiter(rs.getInt(1), rs.getString(2), d, rs.getFloat(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getLong(8), rs.getString(9));
		System.out.print(rs.getInt(1));
		list.add(p);
	}
	
	return list;
	
	
	
}

public void insertIntoRecruiters(String name, java.util.Date date, float cgpa, String dept, String skill, int back, long c_no, String email) throws SQLException{
	
	java.sql.Date d = new java.sql.Date(date.getTime());
	//cid, c_name, visit_date, cgpa, dept, skill, backlog, contact_no, email
	pstmtinsert.setString(1, name);
	pstmtinsert.setDate(2, d);
	pstmtinsert.setFloat(3, cgpa);
	pstmtinsert.setString(4, dept);
	pstmtinsert.setString(5, skill);
	pstmtinsert.setInt(6, back);
	pstmtinsert.setLong(7, c_no);
	pstmtinsert.setString(8, email);

	pstmtinsert.executeUpdate();
}


}
