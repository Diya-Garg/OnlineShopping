<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
	window.menu = '${title}';
	</script>

	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="${css}/bootstrap-readable-theme.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<link rel="stylesheet" href="${css}/myapp.css"/>
	
	
</head>

<body>

	
	<div class="wrapper">

    <!-- Navigation -->  
    <jsp:include page="./shared/navbar.jsp"/>
   
    <br/>
    <!-- Page Content -->
    <div class="content">
    		<h1>Billing Details</h1>
    		<div class="table-responsive">
    				<table  class="table table-striped table-borderd">
    					<tbody>
    						<tr>
    							<td> User Name : </td>
    							<td>${userObj.name}</td>
							</tr>
							<tr>
								<td>Billing Address : </td>
								<td>
									House no. ${addressObj.houseNumber} , ${addressObj.locality}<br/>
    								${addressObj.city} , ${addressObj.state} ${addressObj.pinCode}
								</td>
							</tr>
							<tr>
								<td>Total Amount : </td>
								<td>
									${totalAmount}
								</td>
							</tr>
							<tr>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>Enter Cart Details : </td>
								<td></td>
							</tr>
						</tbody>
    				</table>
    				
    				</div> 
    
    				
    </div>
    
    
    <!-- /.container -->
	<%@include file="./shared/footer.jsp" %>
	
	<!-- Self coded javascript -->
		<script src="${js}/myapp.js"></script>	
	
	</div>
</body>

</html>
