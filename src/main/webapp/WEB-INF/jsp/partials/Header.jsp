<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="DeviceType.jsp" %>

<script>
var _js = _js || {
	utils : this.utils || {},
	services : this.services || {},
	globals : this.globals || {}
}; 

(function(document , window , $ , _js , undefined){
	_js.globals.ctx = '<%= request.getContextPath()%>';
	_js.globals.deviceType = '<%= session.getAttribute("deviceType")  %>';
})(document , window , jQuery , _js);
</script>

<% if(session.getAttribute("deviceType") == "S"){%>
<%@include file="Header_sm_xs.jsp" %>
<% }
   if(session.getAttribute("deviceType") == "L"){ %>
<%@include file="Header_md_lg.jsp" %>
<% }%>

<%@include file="../SignUpAndLoginModal.jsp" %>
<%@include file="../SignUpAndLoginModal_sm_xs.jsp" %>
</body>
</html>