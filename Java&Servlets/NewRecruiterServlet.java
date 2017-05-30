package org.tap;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewRecruiterServlet
 */
@WebServlet("/NewRecruiterServlet")
public class NewRecruiterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewRecruiterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		int c_id;
		String cname;
		//date variables
		String da;
		java.util.Date date = new java.util.Date();
		
		
		float cgpa;
		String dept;
		String skill;
		String back;
		int backlog = 0;
		long contact;
		String email;
		
		cname = request.getParameter("c_name").trim();
		
		
		
		//accepting the date
		try {
			da = request.getParameter("date");
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			date = sdf.parse(da);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cgpa = Float.parseFloat(request.getParameter("cgpa").trim());
		
		dept = request.getParameter("dept").trim();
		
		skill = request.getParameter("skill").trim();
		
		back = request.getParameter("back").trim();
		
		if(back.equalsIgnoreCase("yes"))
			backlog = 1;
		
		
		contact = Long.parseLong(request.getParameter("number").trim());
		
		email = request.getParameter("email").trim();
		
		try {
			DataAccessRecruiter data = new DataAccessRecruiter();
			data.insertIntoRecruiters(cname, date, cgpa, dept, skill, backlog, contact, email);
			response.sendRedirect("TpoHome.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
