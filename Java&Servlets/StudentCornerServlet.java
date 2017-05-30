package org.tap;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentCornerServlet
 */
@WebServlet("/StudentCornerServlet")
public class StudentCornerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentCornerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String department = request.getParameter("dept").trim();
		
		float cgpa = Float.parseFloat(request.getParameter("cgpa"));
		String back = request.getParameter("backlog").trim();
		int backlog = 0;
		if(back.equalsIgnoreCase("yes"))
			backlog = 1;
		String skill = request.getParameter("skills").trim();
		
		
		DataAccessStudents da;
		
		try {
			da = new DataAccessStudents();
			ArrayList<Student> list;
        	if(backlog == 0){
        		list = da.searchStudent(department, cgpa, backlog, skill);}
        	else{
        		list = da.searchStudent(department, cgpa, skill);}
        	if(list == null)
        		response.sendRedirect("studentsearch1.html");
        	else
        		
        	request.setAttribute("dept", department);
        	request.setAttribute("cgpa", cgpa);
        	request.setAttribute("backlog", back);
        	request.setAttribute("skills", skill);
        	request.setAttribute("LIST", list);
        	RequestDispatcher rd = request.getRequestDispatcher("/studentcorner.jsp");
        	rd.forward(request, response);
        	
        	
        	
        	
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
