<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel=stylesheet href=studenthome.css>
</head>
	<body>
	<% int i = Integer.parseInt(request.getParameter("cid")); %>
		 <section id=main>
		 	<form action=StudentDetailsServlet method=get align=center>
				 <input type="hidden" name="cid" value="<%=i%>">
		 		<input type=submit value="View/Edit Personal Data">
			 </form>
			 <form action=RecruiterDetailsServlet method=get align=center>
				 <input type=submit value="View Recruiters List">
			 </form>
		 </section>
	</body>
</html>