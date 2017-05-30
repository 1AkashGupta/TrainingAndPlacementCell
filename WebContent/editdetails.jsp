<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*,org.tap.* "%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="editdetails.css">
</head>
<body>

	<section id="main" align="center">
	<% 
		int s_id = Integer.parseInt(request.getParameter("cid"));
		String backlog;%>
	
	<%  
		ArrayList<Student> list = (ArrayList<Student>)request.getAttribute("LIST"); 
	%> 
			
			<% for(Student p: list){ %>
			<% 
				
				if(p.getBacklog()==0)
					backlog = "NO";
				else
					backlog = "YES";%>
			<form action="EditDetailsServlet" method="get">
				Name : <input type="text" name="name" value="<%=p.getName()%>"><br> 
				Father's Name : <input type="text" name="fname" value="<%=p.getF_name()%>"><br> 
				Mother's Name : <input type="text" name="mname" value="<%=p.getM_name()%>"><br>
				
				Gender : <input type="text" name="gender" value="<%=p.getGender()%>" disabled><br> 
				Address : <input type="text" name="address" value="<%=p.getAddress()%>"><br> 
				Email : <input type="text" name="email" value="<%=p.getEmail()%>"><br> 
				Department : <input type="text" name="dept" value="<%=p.getDept()%>" disabled><br> 
				CGPA : <input type="text" name="cgpa" value="<%=p.getCgpa()%>" disabled><br> 
				Higher Secondary Marks : <input type="text" name="hsmarks" value="<%=p.getHs_marks()%>" disabled><br> 
				Secondary : <input type="text" name="secmarks" value="<%=p.getSec_marks()%>" disabled><br>
				Backlog : <input type="text" name="backlog" value="<%=backlog%>" disabled><br>
    			Skill : <input type="text" name="skill" value="<%=p.getSkill() %>" ><br>
				
				
				
			<%}%>
			
		
			<input type="hidden" name="cid" value="<%=s_id%>">
    		<input type="submit" value="Confirm Update">
		</form>
		
		</section>

</body>
</html>