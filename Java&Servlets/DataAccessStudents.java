package org.tap;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class DataAccessStudents {
	String url = "jdbc:mysql://localhost:3306/Sample";
	String user = "root";
	String pass ="chayan";
	String stmt = "SELECT * FROM students";
	String stmtselect1 = "SELECT * FROM students WHERE dept=? and average_cgpa>=? and backlog=? and skill=? ";
	String stmtselect2 = "SELECT * FROM students WHERE dept=? and average_cgpa>=? and skill=? ";
	String stmtsearch = "SELECT * FROM students WHERE s_id=? ";
	String stmtupdate = "UPDATE STUDENTS SET s_name=?, f_name=?, m_name=?, address=?, email=? ,skill=? WHERE s_id=?";
	String stmtallocate = "INSERT INTO allocated(c_id,s_id,s_name,dept) values(?,?,?,?);";
	String stmtallsearch = "SELECT * FROM allocated";
	
	Driver sqld;
	Connection con;
	PreparedStatement pstmt, pstmtselect1, pstmtselect2, pstmtsearch, pstmtupdate, pstmtallocate, pstmtallsearch;
	
	public DataAccessStudents() throws SQLException{
		
		sqld = new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(sqld);
		con = (Connection)DriverManager.getConnection(url, user, pass);
		System.out.println("Connection successful");
		pstmt = (PreparedStatement) con.prepareStatement(stmt);
		pstmtselect1 = (PreparedStatement) con.prepareStatement(stmtselect1);
		pstmtselect2 = (PreparedStatement) con.prepareStatement(stmtselect2);
		pstmtsearch = (PreparedStatement) con.prepareStatement(stmtsearch);
		pstmtupdate = (PreparedStatement) con.prepareStatement(stmtupdate);
		pstmtallocate = (PreparedStatement) con.prepareStatement(stmtallocate);
		pstmtallsearch = (PreparedStatement) con.prepareStatement(stmtallsearch);
	}
	
	//s_id, s_name, f_name, m_name, dob, gender, address, email, dept, average_cgpa, hs_dip_perc, sec_perc, backlog, skill
	public ArrayList<Student> getAllStudents() throws SQLException{
		ResultSet rs = (ResultSet) pstmt.executeQuery();
		ArrayList<Student> list=null;
		while(rs.next()){
			if(list==null)
				list = new ArrayList<>();
			
			java.sql.Date sqld = rs.getDate(5);
			java.util.Date d = new java.util.Date(sqld.getTime());
			char ch = rs.getString(6).charAt(0);
			
			Student p = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), d, ch, rs.getString(7), rs.getString(8), rs.getString(9), rs.getFloat(10), rs.getFloat(11), rs.getFloat(12), rs.getInt(13), rs.getString(14));
			System.out.print("here");
			list.add(p);
		}
		
		return list;
		
		
	}
	
	public ArrayList<Student> searchStudent(String dept, float cgpa, int backlog, String skill) throws SQLException{
		pstmtselect1.setString(1, dept);
		pstmtselect1.setFloat(2, cgpa);
		pstmtselect1.setInt(3, backlog);
		pstmtselect1.setString(4, skill);
		
		
		
		ResultSet rs = (ResultSet) pstmtselect1.executeQuery();
		ArrayList<Student> list=null;
		while(rs.next()){
			if(list==null)
				list = new ArrayList<>();
			
			java.sql.Date sqld = rs.getDate(5);
			java.util.Date d = new java.util.Date(sqld.getTime());
			char ch = rs.getString(6).charAt(0);
			
			Student p = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), d, ch, rs.getString(7), rs.getString(8), rs.getString(9), rs.getFloat(10), rs.getFloat(11), rs.getFloat(12), rs.getInt(13), rs.getString(14));
			
			list.add(p);
		}
		
		return list;
	}
	
	//SELECT * FROM students WHERE dept=? and average_cgpa>=? and skill=?
	
	public ArrayList<Student> searchStudent(String dept, float cgpa,  String skill) throws SQLException{
		pstmtselect2.setString(1, dept);
		pstmtselect2.setFloat(2, cgpa);
		
		pstmtselect2.setString(3, skill);
		
		
		
		ResultSet rs = (ResultSet) pstmtselect2.executeQuery();
		ArrayList<Student> list=null;
		
		while(rs.next()){
			if(list==null)
				list = new ArrayList<>();
			
			java.sql.Date sqld = rs.getDate(5);
			java.util.Date d = new java.util.Date(sqld.getTime());
			char ch = rs.getString(6).charAt(0);
			
			Student p = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), d, ch, rs.getString(7), rs.getString(8), rs.getString(9), rs.getFloat(10), rs.getFloat(11), rs.getFloat(12), rs.getInt(13), rs.getString(14));
			
			list.add(p);
		}
		
			return list;
		
			
		
	}
	
	

	public ArrayList<Student> searchStudent(int i) throws SQLException{
		pstmtsearch.setInt(1, i);
		
		
		
		ResultSet rs = (ResultSet) pstmtsearch.executeQuery();
		ArrayList<Student> list=null;
		while(rs.next()){
			if(list==null)
				list = new ArrayList<>();
			
			java.sql.Date sqld = rs.getDate(5);
			java.util.Date d = new java.util.Date(sqld.getTime());
			char ch = rs.getString(6).charAt(0);
			
			Student p = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), d, ch, rs.getString(7), rs.getString(8), rs.getString(9), rs.getFloat(10), rs.getFloat(11), rs.getFloat(12), rs.getInt(13), rs.getString(14));
			System.out.print("here");
			list.add(p);
		}
		
		return list;
	}
	
	public void updateStudent(int i, String name, String f_name, String m_name, String address, String mail, String skill) throws SQLException{
		pstmtupdate.setString(1, name);
		pstmtupdate.setString(2, f_name);
		pstmtupdate.setString(3, m_name);
		pstmtupdate.setString(4, address);
		pstmtupdate.setString(5, mail);
		pstmtupdate.setString(6, skill);
		pstmtupdate.setInt(7, i);
		pstmtupdate.executeUpdate();
		
	}
	
	public void allocateStudents(int c_id, int s_id, String s_name, String dept) throws SQLException{
		pstmtallocate.setInt(1, c_id);
		pstmtallocate.setInt(2, s_id);
		pstmtallocate.setString(3, s_name);
		pstmtallocate.setString(4, dept);
		pstmtallocate.executeUpdate();
		
	}
	
	
	
}
