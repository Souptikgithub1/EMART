<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${categoryName}</title>
</head>
<body class="bg-custom">
<%@include file="partials/HeaderUtil.jsp"%>
<div id="header-div">
<%@include file="partials/Header.jsp" %>
</div>
<div class="container">
${catId}
    <app-root></app-root>
</div>
</body>
</html>