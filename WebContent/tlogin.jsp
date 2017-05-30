<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="loginstyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String errmsg=request.getParameter("errmsg");
	%>
	
	<% if(errmsg!=null){ %>
		<h3>Invalid User Or Password</h3>
		
	<%}%>
	<form action="TpoLoginServlet" align="center" method="post">
            <section id="user">
                <div class="inp">
                    <h2>LOGIN</h2>
                    <p>USERNAME<br> <input type="text" name="usr"><br></p>
                    <p>PASSWORD<br><input type="password" name="pass"><br></p>
                    
                </div>
                <div class="submit"><input type="submit" value="LOGIN"></div>
            </section>
        </form> 
</body>
</html>