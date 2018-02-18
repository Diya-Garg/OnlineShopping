
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
   
    
    <!-- Page Content -->
    <div class="content">
    
    
    	<c:if test="${message=='listAllProducts'}">
    	<div class="table-responsive">
    				<table  class="table table-striped table-borderd">
    					<thead style="background-color:blue">
    						<tr>
    							<td>Product Name</td>
    							<!-- <td>Description</td>
    							 --><td>Price</td>
    							<td>Availability</td>
    							<td>Category</td>
    							<td>Supplier</td>
    							<td>Product Image</td>
    							<td>Details</td>
    							
    						</tr>
    					</thead>
    					<tbody>
    						<h1>Product List</h1>
 		   					<c:forEach items="${productList}" var="product">
 		   						<tr>
 		   							<td>${product.productName}</td>
 		   							<%-- <td>${product.description}</td> --%>
 		   							<td>${product.price}</td>
 		   							<td>
 		   								<c:if test="${product.quantity==0}">
 		   									Out of Stock
 		   								</c:if>
 		   								<c:if test="${product.quantity!=0}">
 		   									In	Stock
 		   								</c:if>
 		   							</td>
 		   							<td>${product.category.categoryName}</td>
 		   							<td>${product.supplier.supplierName}</td>
 		   							<td>
 		   								<img src="${images}/${product.imgname}" style="height:50px;width: 50px "/> 
 		   							</td>
 		   							<td>
 		   								<a class="btn btn-primary" href="getProductById?prodid=${product.productId}" style="text-decoration:underline;">View Details</a>
 		   							</td>
 		   							
 		   						</tr>
    						</c:forEach>
    					</tbody>
    				</table>
    			</div>
    			</c:if>		
    			
    			
    			<c:if test="${message=='ViewProductDetails'}">
    				<h1>Product Details : </h1>
    				<div class="row">
    					<div class="col-sm-3" align="center">
    						<img  src="${images}/${productObj.imgname}" style="height:200px;width:200px "/>
    					</div>
    					<div class="col-sm-6">
    						<div class="table-responsive"> 
    					<table class="table table-striped table-borderd">
    						<tr>
    							<td>Product Name : </td>
    							<td>${productObj.productName}</td>
    						</tr>
    						<tr>
    							<td>Description : </td>
    							<td>${productObj.description}</td>
    						</tr>
    						<tr>
    							<td>Price : </td>
    							<td>${productObj.price }</td>
    						</tr>
    						<tr>
    							<td>Availability</td>
    							<c:if test="${productObj.quantity==0}">
 		   								<td>Out of Stock</td>
 		   						</c:if>
								<c:if test="${productObj.quantity!=0}">
 		   								<td>In	Stock</td>
 		   						</c:if>
    						</tr>
    						<tr>
    							<td>Category</td>
    							<td>${productObj.category.categoryName}</td>
    						</tr>
    						<tr>
    							<td>Supplier</td>
    							<td>${productObj.supplier.supplierName}</td>
    						</tr>
    						
    						<tr>
    							<td><a href="addToCart?prodid=${productObj.productId}" class="btn btn-primary">Add to Cart</a></td>
    						</tr>
    						
    					</table> 
    				</div>
    					</div>
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