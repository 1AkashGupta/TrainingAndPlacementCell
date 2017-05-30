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
 * Servlet implementation class TpoLoginServlet
 */
@WebServlet("/TpoLoginServlet")
public class TpoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TpoLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String un = request.getParameter("usr").trim();
		String pa = request.getParameter("pass").trim();
		String username = "admin";
		String password = "admin123";
		
		
		
		if (un.equals(username) && pa.equals(password)){
		
			DataAccessRecruiter da;
			ArrayList<Recruiter> list;
			
			try {
				da = new DataAccessRecruiter();
				list = da.getAllRecruiter();
				request.setAttribute("LIST", list);
	        	RequestDispatcher rd = request.getRequestDispatcher("/TpoHome.jsp");
	        	rd.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			


		
		
		}else{
			//out.println("<h2>Invalid user or password </h2>");
			response.sendRedirect("tlogin.jsp?errmsg=invalid");
		}
		
		
		
	}

}
