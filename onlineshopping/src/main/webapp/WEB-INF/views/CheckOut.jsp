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
    	<h2>${message}</h2><br/>
    	
    	<c:if test="${message=='Select a Delivery Address'||message=='New Address Added Succesfully'||message=='Address Updated Succesfully'}">
    	<h3><c:out value="${userObj.name}"></c:out></h3>
    	<c:forEach items="${userObj.addresses}" var="addr">
    		<p>
    			House no. ${addr.houseNumber} , ${addr.locality}<br/>
    			${addr.city} , ${addr.state} ${addr.pinCode}
    		</p>
    		<a href="${contextRoot}/cart/deliver?addrId=${addr.id}" class="btn btn-info">Deliver to this Address</a>
    		<a href="${contextRoot}/cart/editAddress?addrId=${addr.id}" class="btn btn-info">Edit</a>
    		<br/>
    	</c:forEach>
    		
    		<br/>
    		    	<a href="${contextRoot}/cart/addNewAddress?user=${sessionScope.email}" class="btn btn-primary">Add New Address</a>
    	</c:if>
    	
    	
    	
    	<c:if test="${message=='Edit Form'}">
    		 <form:form action="${contextRoot}/cart/addAddressEditProcess" method="POST" class="form-horizontal"
         id="addressForm" modelAttribute="addressObj"
        >
        
          
           <form:hidden path="id" class="form-control"/>
          
         <div class="form-group">
          <label for="houseNo" class="col-md-4 control-label">House Number: </label>
          <div class="col-md-8">
           <form:input path="houseNumber" class="form-control"/>
          </div>
         </div>
         
         <div class="form-group">
          <label for="locality" class="col-md-4 control-label">Locality: </label>
          <div class="col-md-8">
           <form:input path="locality" class="form-control"/>
          </div>
         </div>
         
         <div class="form-group">
          <label for="city" class="col-md-4 control-label">City: </label>
          <div class="col-md-8">
           <form:input path="city" class="form-control"/>
          </div>
         </div>
         
         <div class="form-group">
          <label for="state" class="col-md-4 control-label">State: </label>
          <div class="col-md-8">
           <form:input path="state" class="form-control"/>
          </div>
         </div>
         
         <div class="form-group">
          <label for="pinCode" class="col-md-4 control-label">Pin Code: </label>
          <div class="col-md-8">
           <form:input path="pinCode" class="form-control"/>
          </div>
         </div>
         
         <div class="form-group">
          <div class="col-md-offset-4 col-md-8">
      	   <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
          <input type="submit" value="Edit Details" class="btn btn-primary"/>
          </div>
         </div>
        </form:form>
       
    	</c:if>
    		    		
    </div>
    
    <!-- /.container -->
	<%@include file="./shared/footer.jsp" %>
	
	<!-- Self coded javascript -->
		<script src="${js}/myapp.js"></script>	
	
	</div>
</body>

</html>
