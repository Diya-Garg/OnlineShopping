<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<spring:url var="css" value="/resources/css" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap Readable Theme -->
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="${css}/myapp.css" rel="stylesheet">


<title>Online Shopping - ${title}</title>
<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
	
</head>

<body>

	<div class="wrapper">

		<!-- Navigation -->
	     <%@include file="./shared/navbar.jsp"%>		
 
 		<br/><br/><br/><br/>
		<!-- Page Content -->

		<div class="content">
			
   <div class="container">
    
     
    <div class="row">
     
     <div class="col-md-offset-3 col-md-6">
      
      <div class="panel panel-primary">
       
       <div class="panel-heading">
        <h4>Change Password Form</h4>
       </div>
       
       
       <div class="panel-body">
       
        <form:form action="changePasswordProcess" method="POST" class="form-horizontal"
          modelAttribute="userObj">
        
        
         <div class="form-group">
          <label for="username" class="col-md-4 control-label">Password: </label>
          <div class="col-md-8">  
           <form:password path="password" class="form-control"/>
          </div>
          </div>
         <div class="form-group">
          <label for="password" class="col-md-4 control-label">Password: </label>
          <div class="col-md-8">
           <form:password path="password2" class="form-control"/>
          </div>
         </div>
         <div class="form-group">
          <div class="col-md-offset-4 col-md-8">
      	   <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
          <input type="submit" value="Login" class="btn btn-primary"/>
          </div>
         </div>
        </form:form>
       
       </div>
       
      
      </div> 
    
 	     </div>
     
    </div>    
   
   </div>

			
		</div>

	<%@include file="./shared/footer.jsp" %>
		
	</div>

</body>

</html>