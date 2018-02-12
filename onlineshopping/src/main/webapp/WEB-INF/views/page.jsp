<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<spring:url var="css" value="/resources/css"/>
<spring:url var="js" value="/resources/js"/>
<spring:url var="images" value="/resources/images"/>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Online Shopping - ${title}</title>

	<script>
		window.menu='${title}';
	</script>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="${css}/myapp.css"/>
	
	<!-- Self coded javascript -->
	<script src="${js}/myapp.js"></script>
	
</head>

<body>

    <!-- Navigation -->
    <%@include file="./shared/navbar.jsp" %>
    
    <!-- Page Content -->
    <c:if test="${userClicksHome==true}">
    	<%@include file="home.jsp"%>
	</c:if>
	 <c:if test="${userClickAbout==true}">
    	<%@include file="about.jsp"%>
	</c:if>
	 <c:if test="${userClickContact==true}">
    	<%@include file="contact.jsp"%>
	</c:if>
	
    <!-- /.container -->
	<%@include file="./shared/footer.jsp" %>

	

</body>

</html>
