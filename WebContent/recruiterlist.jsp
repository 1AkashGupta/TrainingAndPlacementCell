<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*,org.tap.* "%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="tpohome.css">
</head>
<body>

	<section id="main">
		<%
			String department = request.getParameter("dept").trim();
			float cgpa = Float.parseFloat(request.getParameter("cgpa"));
			String back = request.getParameter("backlog").trim();
			int backlog = 0;
			if(back.equalsIgnoreCase("yes"))
				backlog = 1;
			String skill = request.getParameter("skills").trim();
		
			
			ArrayList<Recruiter> list = (ArrayList<Recruiter>)request.getAttribute("LIST");
			int c = 0;
        %>
		  <table border="1" align="center">
		
		  <tr>
		  <th>Sl<br>No</th><th>Company<br>Name</th><th>Visit<br>Date</th><th>CGPA</th><th>Department</th><th>Skills</th><th>Backlog<br>Allowed</th>
		  </tr>
		
		<% for(Recruiter p: list){
			c++;
			int n = p.getBacklog();
			String b;
			if(n==1)
				b="YES";
			else
				b="NO";
			System.out.println(department);
        %>
            
			<form action="AllocateServlet" method="get">	
			
			  <tr>
			  <td><%=c%></td>
			  <td><%=p.getComp_name()%></td>
			  <td><%=p.getV_date()%></td>
			  <td><%=p.getCgpa()%></td>
			  <td><%=p.getDept()%></td>
			  <td><%=p.getSkill()%></td>
			  <td><%=b%></td>
			  <input type="hidden" name="cid" value="<%=p.getCid() %>">
			  <input type="hidden" name="dept" value=" <%=department %>">
			 <input type="hidden" name="cgpa" value="<%=cgpa %>">
			 <input type="hidden" name="backlog" value="<%=backlog %>">
			 <input type="hidden" name="skills" value="<%=skill %>">
			
                <td><input type="submit" value="Allocate"><td>
			  </tr>
			  
            
            </form>
		<%}%>
		  </table>
		  
		  </section>

</body>
</html>

