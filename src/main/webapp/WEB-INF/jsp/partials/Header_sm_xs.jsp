<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div id="" class="header-nav-container container-fluid">
		<div id="header-nav" class="navbar-header">
			<button style="float: left;" id="nav-menu-sm-xs" type="button"
				class="custom-navbar-toggle navbar-toggle" data-toggle="collapse"
				data-target="#custom-menu">
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span>
			</button>
			<a style="float: left;" id="nav-title-sm-xs" class="navbar-brand" href="<%=request.getContextPath()%>">EMart</a>
			<button type="button" class="custom-navbar-toggle navbar-toggle"
				data-toggle="modal" data-target="#signup-login-modal">
				<i class="glyphicon glyphicon-user"></i>
			</button>
			<button type="button" class="custom-navbar-toggle navbar-toggle">
				<i class="glyphicon glyphicon-shopping-cart"></i>
			</button>
			<!-- <button type="button" class="custom-navbar-toggle navbar-toggle"
				data-toggle="collapse" data-target="#search-nav-sm-xs">
				<i class="glyphicon glyphicon-search"></i>
			</button> -->
		</div>
		
		
		<div id="user-nav" class="collapsable-menu collapse navbar-collapse navbar-right">
			<ul class="nav navbar-nav ">
				<li><a href="#" data-toggle="modal" data-target="#signup-login-modal"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
				<li><a href="#" data-toggle="modal" data-target="#login-modal"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
			</ul>
		</div>
		<div id="search-nav" class="collapsable-menu navbar-form navbar-right">
			<div class="input-group">
				<input id="search-field" type="text" class="search-bar form-control" placeholder="Search">
				<div class="input-group-btn">
					<button id="search-btn" class="btn btn-default" type="submit">
						<i class="glyphicon glyphicon-search"></i>
					</button>
				</div>
			</div>
		</div>

		<div id="custom-menu" class="collapsable-menu clearfix collapse navbar-collapse custom-menu">
			<ul class="nav navbar-nav">
				<c:forEach items="${categories}" var="category">
					<c:if test="${category.parentCatId == 0}">
					<li><a href="#">${category.catName}</a></li>
					</c:if>
				</c:forEach>
			</ul>
		</div>
		
		
	</div>
</nav>

</body>
</html>