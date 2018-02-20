<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

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
        <h4>SignUp Form</h4>
       </div>
       
       
       <div class="panel-body">
       
        <form action="signupprocess" method="POST" class="form-horizontal"
         id="registrationForm"
        >
        
        <div class="form-group">
          <label for="name" class="col-md-4 control-label">Name : </label>
          <div class="col-md-8">
           <input type="text" name="name" id="name" class="form-control"/>
          </div>
         </div>
         
         <div class="form-group">
          <label for="email" class="col-md-4 control-label">Email: </label>
          <div class="col-md-8">
           <input type="text" name="email" id="email" class="form-control"/>
          </div>
         </div>
         <div class="form-group">
          <label for="password" class="col-md-4 control-label">Password: </label>
          <div class="col-md-8">
           <input type="password" name="password" id="password" class="form-control"/>
          </div>
         </div>
         <div class="form-group">
          <label for="password2" class="col-md-4 control-label">Confirm Password: </label>
          <div class="col-md-8">
           <input type="password" name="password2" id="password2" class="form-control"/>
          </div>
         </div>
         
         <div class="form-group">
          <label for="phone" class="col-md-4 control-label">Phone: </label>
          <div class="col-md-8">
           <input type="phone" name="phone" id="phone" class="form-control"/>
          </div>
         </div>
         
         
         <div class="form-group">
          <label for="houseNo" class="col-md-4 control-label">House Number: </label>
          <div class="col-md-8">
           <input type="text" name="houseNo" id="houseNo" class="form-control"/>
          </div>
         </div>
         
         <div class="form-group">
          <label for="locality" class="col-md-4 control-label">Locality: </label>
          <div class="col-md-8">
           <input type="text" name="locality" id="locality" class="form-control"/>
          </div>
         </div>
         
         <div class="form-group">
          <label for="city" class="col-md-4 control-label">City: </label>
          <div class="col-md-8">
           <input type="text" name="city" id="city" class="form-control"/>
          </div>
         </div>
         
         <div class="form-group">
          <label for="state" class="col-md-4 control-label">State: </label>
          <div class="col-md-8">
           <input type="text" name="state" id="state" class="form-control"/>
          </div>
         </div>
         
         <div class="form-group">
          <label for="pinCode" class="col-md-4 control-label">Pin Code: </label>
          <div class="col-md-8">
           <input type="text" name="pinCode" id="pinCode" class="form-control"/>
          </div>
         </div>
         
         <div class="form-group">
          <div class="col-md-offset-4 col-md-8">
      	   <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
          <input type="submit" value="Sign Up" class="btn btn-primary"/>
          </div>
         </div>
        </form>
       
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