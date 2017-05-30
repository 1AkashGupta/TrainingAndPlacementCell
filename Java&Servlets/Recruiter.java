package org.tap;

import java.util.Date;

public class Recruiter {
	private int cid;
	private	String comp_name;
	private java.util.Date v_date;
	private	float cgpa;
	private String dept;
	private String skill;
	private int backlog;
	private long contact_no;
	private String email;
	
	
	
	public int getCid() {
		return cid;
	}



	public void setCid(int cid) {
		this.cid = cid;
	}



	public String getComp_name() {
		return comp_name;
	}



	public void setComp_name(String comp_name) {
		this.comp_name = comp_name;
	}



	public java.util.Date getV_date() {
		return v_date;
	}



	public void setV_date(java.util.Date v_date) {
		this.v_date = v_date;
	}



	public float getCgpa() {
		return cgpa;
	}



	public void setCgpa(float cgpa) {
		this.cgpa = cgpa;
	}



	public String getDept() {
		return dept;
	}



	public void setDept(String dept) {
		this.dept = dept;
	}



	public String getSkill() {
		return skill;
	}



	public void setSkill(String skill) {
		this.skill = skill;
	}



	public int getBacklog() {
		return backlog;
	}



	public void setBacklog(int backlog) {
		this.backlog = backlog;
	}



	public long getContact_no() {
		return contact_no;
	}



	public void setContact_no(long contact_no) {
		this.contact_no = contact_no;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}

	

	public Recruiter(int cid, String comp_name, Date v_date, float cgpa, String dept, String skill, int backlog,
			long contact_no, String email) {
		super();
		this.cid = cid;
		this.comp_name = comp_name;
		this.v_date = v_date;
		this.cgpa = cgpa;
		this.dept = dept;
		this.skill = skill;
		this.backlog = backlog;
		this.contact_no = contact_no;
		this.email = email;
	}



	public Recruiter() {
		super();
	
	}
		
	
	
}
