<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top custom-navbar">
  <div class="container">
	  <div class="nav-header">
		  <div class="brand">
		     <a class="brand-anchor" href="<%= request.getContextPath() %>">
		     	Online Shopping
		     </a>
		  </div>   
	  </div>
  </div>
  <div class="nav-link-container clearfix">
  	<div class="container">
	  	<ul class="nav navbar-nav">
			<c:forEach items="${categories}" var="parentCategory">
				<c:if test="${parentCategory.parentId == 0}">
					<li>
						<div class="dropdown">
							<a href="<%= request.getContextPath()%>/cdp/${parentCategory.name}/${parentCategory.encodedId}"><button class="dropbtn">${parentCategory.name} <i class="caret"></i></button></a>
							<div class="dropdown-content">
								<c:forEach items="${categories}" var="category">
									<c:if test="${parentCategory.id == category.parentId}">
										<a class="categories" href="<%= request.getContextPath()%>/cdp/${category.name}/${category.encodedId}">${category.name} <span class="fa fa-caret-right"></span></a>
										<c:forEach items="${categories}" var="subCategory">
											<c:if test="${category.id == subCategory.parentId}">
												<div><a class="subCategories" href="#">${subCategory.name}</a></div>
											</c:if>
										</c:forEach>
							    	</c:if>
							    </c:forEach>	
							</div>
						</div>
					</li>
				</c:if>
			</c:forEach>
		</ul>
    </div>
  </div>
	
</nav>
 

</body>
</html>