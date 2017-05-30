<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.*,org.tap.*"
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="tpohome.css">
</head>
<body>
<section id="main">
	<% String department = request.getParameter("dept").trim();
		float cgpa = Float.parseFloat(request.getParameter("cgpa"));
		String back = request.getParameter("backlog").trim();
		int backlog = 0;
		if(back.equalsIgnoreCase("yes"))
			backlog = 1;
		String skill = request.getParameter("skills").trim();
        %>

		
		
			<% ArrayList<Student> list = (ArrayList<Student>)request.getAttribute("LIST");
			String b = "";%>			
			
			 <table border= 1  align= center > 
			<tr><th>Name</th><th>Average<br>CGPA</th><th>Department</th><th>Backlog</th><th>Skill</th><th>Email</th></tr>
			
			
			<% for(Student p: list){%>
				<%  if(p.getBacklog()==0)
						b="NO";
					else
						b="YES";
				%>
				 <tr> 
				 <td><%=p.getName()%></td>
				 <td><%=p.getCgpa()%></td> 
				 <td><%=p.getDept()%></td> 
				 <td><%=b %></td>
				 <td><%=p.getSkill() %></td>
				 <td><%=p.getEmail()%></td> 
				 </tr> 
				 
				
			<%}%>
			 </table> 
			 <form action="RecruiterListServlet" method="get">
			 <input type="hidden" name="dept" value=" <%=department %>">
			 <input type="hidden" name="cgpa" value="<%=cgpa %>">
			 <input type="hidden" name="backlog" value="<%=backlog %>">
			 <input type="hidden" name="skills" value="<%=skill %>">
			 <input type="submit" value="Allocate Selected Students">
			 </form>
			 </section>
</body>
</html>