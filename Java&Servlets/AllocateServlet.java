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
 * Servlet implementation class AllocateServlet
 */
@WebServlet("/AllocateServlet")
public class AllocateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllocateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int cid = Integer.parseInt(request.getParameter("cid"));
		
		String department = request.getParameter("dept").trim();
		float cgpa = Float.parseFloat(request.getParameter("cgpa"));
		String back = request.getParameter("backlog").trim();
		int backlog = 0;
		if(back.equalsIgnoreCase("yes"))
			backlog = 1;
		System.out.println(department);
		String skill = request.getParameter("skills").trim();
		String b;

		
		
			
            DataAccessStudents da;
			try {
				da = new DataAccessStudents();
	            ArrayList<Student> list;
	            	if(backlog == 0){
	            		list = da.searchStudent(department, cgpa, backlog, skill);
	            		System.out.println("List = "+ department);
	            		}
	            	else{
	            		list = da.searchStudent(department, cgpa, skill);
	            		
	            		System.out.println("else List = "+ department);
	            		}
	            	
	            	
	         
				for(Student p: list){
					
					 if(p.getBacklog()==0)
							b="NO";
						else
							b="YES";
					 int s_id = p.getS_id();
					
					 String name = p.getName();
					  
					 String dept = p.getDept();	
					 da.allocateStudents(cid, s_id, name, dept);
					 String user = "admin";
					 String pass = "admin123";
					 request.setAttribute("usr",user);
						request.setAttribute("pass", pass );
			        	RequestDispatcher rd = request.getRequestDispatcher("TpoLoginServlet");
			        	rd.forward(request, response);
					 
				}
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
