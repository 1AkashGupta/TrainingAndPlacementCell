<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*,org.tap.* "%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="studentdetails.css">
</head>
<body>
	<section id="main" align="center">
	<% int s_id = Integer.parseInt(request.getParameter("cid"));
		String backlog;%>
	
	<%  
	ArrayList<Student> list = (ArrayList<Student>)request.getAttribute("LIST");
	%> 
			
			<% for(Student p: list){ %>
			<% 
				SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
			
				String date = sm.format(p.getDate());
			
				if(p.getBacklog()==0)
					backlog = "NO";
				else
					backlog = "YES";%>
			
				 Name : <%=p.getName()%><br> 
				 Father's Name : <%=p.getF_name()%><br> 
				 Mother's Name : <%=p.getM_name()%><br> 
				 Gender : <%=p.getGender()%><br>
				 Date Of Bith: <%= date %><br> 
				 Address : <%=p.getAddress()%><br> 
				 Email : <%=p.getEmail()%><br> 
				 Department : <%=p.getDept()%><br> 
				 CGPA : <%=p.getCgpa()%><br> 
				 Marks : <%=p.getHs_marks()%><br> 
				 Secondary : <%=p.getSec_marks()%><br>
				 Backlog : <%=backlog%><br>
				 Skills : <%=p.getSkill() %><br> 
				
				
				
			<%}%>
			
		<form action="studenthome.jsp" method="get">
			<input type="hidden" name="cid" value="<%=s_id%>">
    		<input type="submit" value="Back">
		</form>
		<form action="EditDetailsServlet" method="get">
			<input type="hidden" name="cid" value="<%=s_id%>">
		
    		<input type="submit" value="Edit">

		</form>
		</section>

</body>
</html>