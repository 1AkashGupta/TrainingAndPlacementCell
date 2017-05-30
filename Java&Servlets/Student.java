package org.tap;

import java.util.Date;

public class Student {
	//s_id, s_name, f_name, m_name, dob, gender, address, email, dept, average_cgpa, hs_dip_perc, sec_perc, backlog, skill
	private int s_id;
	private String name;
	private String f_name;
	private String m_name;
	private java.util.Date date;
	private char gender;
	private String address;
	private String email;
	private String dept;
	private float cgpa;
	private float hs_marks;
	private float sec_marks;
	private int backlog;
	private String skill;
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public java.util.Date getDate() {
		return date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public float getCgpa() {
		return cgpa;
	}
	public void setCgpa(float cgpa) {
		this.cgpa = cgpa;
	}
	public float getHs_marks() {
		return hs_marks;
	}
	public void setHs_marks(float hs_marks) {
		this.hs_marks = hs_marks;
	}
	public float getSec_marks() {
		return sec_marks;
	}
	public void setSec_marks(float sec_marks) {
		this.sec_marks = sec_marks;
	}
	public int getBacklog() {
		return backlog;
	}
	public void setBacklog(int backlog) {
		this.backlog = backlog;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	
	public Student(int s_id, String name, String f_name, String m_name, Date date, char gender, String address,
			String email, String dept, float cgpa, float hs_marks, float sec_marks, int backlog, String skill) {
		super();
		this.s_id = s_id;
		this.name = name;
		this.f_name = f_name;
		this.m_name = m_name;
		this.date = date;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.dept = dept;
		this.cgpa = cgpa;
		this.hs_marks = hs_marks;
		this.sec_marks = sec_marks;
		this.backlog = backlog;
		this.skill = skill;
	}
	
	public Student() {
		super();
	} 
	
	
	
	

}
