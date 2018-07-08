<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 

	if(request.getHeader("User-Agent").toLowerCase().indexOf("mobile") == -1 || request.getHeader("User-Agent").toLowerCase().indexOf("mobile") == 98){
		if(request.getHeader("User-Agent").toLowerCase().contains("tablet") == true)
		{
			session.setAttribute("deviceType", "S");
		}
		else
		{
			session.setAttribute("deviceType", "L");	
		}
		
	}else{
		session.setAttribute("deviceType", "S");
	}

%>
</body>
</html>