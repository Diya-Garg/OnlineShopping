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
    
    				<c:if test="${message=='Show Payment Form'}">
    				<h1>Make Payment 
    				 <img src="${images}/visa.svg" style="width:50px;height:50px">
    				 <img src="${images}/master.svg" style="width:50px;height:50px">
    				 <img src="${images}/american.svg" style="width:50px;height:50px">
    				  </h1>
    				
    				  <form:form action="${contextRoot}/cart/makePayment" method="POST" class="form-horizontal" id="paymentForm"
    				  modelAttribute="orderObj">
    				  
    				  	<div class="form-group">
         					 <label for="cardNumber" class="col-md-4 control-label">Card Number</label>
          					 <div class="col-md-4">
           						<form:input type="text" class="form-control" placeholder="Valid Card Number" path="cardNumber"/>
          					</div>
         				</div>
         				<div class="form-group">
         					 <label for="nameOnCard" class="col-md-4 control-label">Name on Card</label>
          					 <div class="col-md-4">
           						<form:input type="text" class="form-control" placeholder="Name on  Card" path="nameOnCard"/>
          					</div>
         				</div>
         				<div class="form-group">
         					 <label for="nameOnCard" class="col-md-4 control-label">Expiration Date</label>
          					 <div class="col-md-2">
           						<form:input type="text" class="form-control" placeholder="MM" path="month"/>
          					</div>
          					<div class="col-md-2">
           						<form:input type="text" class="form-control" placeholder="YY" path="year"/>
          					</div>
         				</div>
        				 <div class="form-group">
         					 <label for="cvv" class="col-md-4 control-label">CVV</label>
          					 <div class="col-md-4">
           						<form:input type="text" class="form-control" placeholder="CVV" path="cvv"/>
          					</div>
         				</div>
         				<div class="form-group">
         					 <label for="cvv" class="col-md-4 control-label">Price</label>
          					 <div class="col-md-4">
           						${totalAmount}
          					</div>
         				</div>			
						 <div class="form-group">
          					<div class="col-md-offset-4 col-md-4">
      	   					<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
          					<input type="submit" value="Make Payment" class="btn btn-primary"/>
          				</div>
    			     </div>	
				</form:form>
				</c:if>
				
				<c:if test="${message=='Show Invoice'}">
					<h1>Thank You for Shopping with Us. Please find the invoice : </h1>
					<div class="table-responsive">
    				<table  class="table table-striped table-borderd">
    					
    					<tbody>
    							<tr>
 		   							<td>Order Id : </td>
 		   							<td>${orderObj.orderId}</td>
 		   						</tr>
    							<tr>
    								<td>Customer Name :</td>
    								<td>${orderObj.user.name}</td>
    							</tr>
    							<tr>
    								<td>Billing Address : </td>
    								<td>
    									House no. ${orderObj.address.houseNumber} , ${orderObj.address.locality}<br/>
    									${orderObj.address.city} , ${orderObj.address.state} ${orderObj.address.pinCode}			
    								</td>
    							</tr>
    							<tr>
    								<td>Total Price : </td>
    								<td>${orderObj.totalPrice}</td>
    							</tr>
    							
    					</tbody>
    				</table>
    			</div>
    			</c:if>	
			</div>				
				
    
    <!-- /.container -->
	<%@include file="./shared/footer.jsp" %>
		
	<!-- Self coded javascript -->
		<script src="${js}/myapp.js"></script>	
	
	</div>
</body>

</html>
