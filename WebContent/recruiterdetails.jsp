<%@page import="java.text.SimpleDateFormat"%>
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
			int c = 0;
			ArrayList<Recruiter> list = (ArrayList<Recruiter>)request.getAttribute("LIST");
        %>
		  <table border="1" align="center">
		
		  <tr>
		  <th>Sl<br>No</th><th>Company<br>Name</th><th>Visit<br>Date</th><th>CGPA</th><th>Department</th><th>Skills</th><th>Backlog<br>Allowed</th>
		  </tr>
		
		<% for(Recruiter p: list){
			c++;
			SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
			String date = sm.format(p.getV_date());
			int n = p.getBacklog();
			String b;
			if(n==1)
				b="YES";
			else
				b="NO";
        %>
				
			
			  <tr>
			  <td><%=c%></td>
			  <td><%=p.getComp_name()%></td>
			  <td><%=date%></td>
			  <td><%=p.getCgpa()%></td>
			  <td><%=p.getDept()%></td>
			  <td><%=p.getSkill()%></td>
			  <td><%=b%></td>
			  </tr>
			
		<%}%>
		  </table>
		  
		  </section>

</body>
</html>