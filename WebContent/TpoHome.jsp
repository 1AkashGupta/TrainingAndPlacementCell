<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="java.util.*,org.tap.* "%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="tpohome.css"></head><body>
		<section id="main">
		
			<%ArrayList<Recruiter> list = (ArrayList<Recruiter>)request.getAttribute("LIST");
			int c = 0;%>
		 <table border="1" align="center"> 
		
		 <tr> 
		 <th>Sl<br>No</th><th>Company<br>Id</th><th>Company<br>Name</th><th>Visit<br>Date</th><th>CGPA</th><th>Department</th><th>Skills</th><th>Backlog</th><th>Contact<br>Number</th><th>E-mail</th> 
		 </tr> 
		
		<% for(Recruiter p: list){ %>
			<% c++; 
				SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
				String date = sm.format(p.getV_date());
			
			%>
			 <tr> 
			 <td><%=c%></td> 
			 <td><%=p.getCid()%></td> 
			 <td><%=p.getComp_name() %></td> 
			 <td><%=date %></td> 
			 <td><%=p.getCgpa() %></td> 
			 <td><%=p.getDept() %></td> 
			 <td><%=p.getSkill() %></td> 
			 <td><%=p.getBacklog() %></td> 
			 <td><%=p.getContact_no() %></td> 
			 <td><%=p.getEmail() %></td> 
			 </tr> 
			
		<%}%>
		 </table> 
		
		
		 <form action="studentsearch.html" method="get" align="center"> 
		 <input type="submit" value="Student's Corner"> 
		 </form><form action="newrecruiter.html" method="get" align="center"> 
		 <input type="submit" value="Create New Placement Drive"> 
		 </form> 
		 </section> 
		 </body>
            </html> 
