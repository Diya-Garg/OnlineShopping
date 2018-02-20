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
	window.menu = '${title}';
	</script>

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
		<div class="container" style="padding-top: 20px">
		  <c:if test="${message=='Category Added Succesfully'}">
    		<h1>${message}</h1>
    	</c:if>
    	<c:if test="${message=='Supplier Added Succesfully'}">
    		<h1>${message}</h1>
    	</c:if>
    	<c:if test="${message=='Product Added Succesfully'}">
    		<h1>${message}</h1>
    	</c:if>
    	<c:if test="${message=='productList'}">
    		
	    		<div class="table-responsive">
    				<table  class="table table-striped table-borderd">
    					<thead style="background-color:blue">
    						<tr>
    							<td>Product Name</td>
    							<td>Description</td>
    							<td>Price</td>
    							<td>Quantity</td>
    							<td>Category</td>
    							<td>Supplier</td>
    							<td>Product Image</td>
    							<td colspan="2">
    								Manage Product
    							</td>
    						</tr>
    					</thead>
    					<tbody>
 		   					<c:forEach items="${productList}" var="product">
 		   						<tr>
 		   							<td>${product.productName}</td>
 		   							<td>${product.description}</td>
 		   							<td>${product.price}</td>
 		   							<td>${product.quantity}</td>
 		   							<td>${product.category.categoryName}</td>
 		   							<td>${product.supplier.supplierName}</td>
 		   							<td>
 		   								<img src="${images}/${product.imgname}" style="height:50px;width: 50px "/> 
 		   							</td>
 		   							<td><a href="${contextRoot}/admin/updateProduct?prodid=${product.productId}"><img src="${images}/update.jpg" style="height:50px;width: 50px "/></a></td>
 		   							<td><a href="${contextRoot}/admin/deleteProduct?prodid=${product.productId}"><img src="${images}/delete.png	" style="height:50px;width: 50px "/></a></td>
 		   						</tr>
    						</c:forEach>
    					</tbody>
    				</table>
    			</div>
    		
    	</c:if>
    	
    	<c:if test="${message=='Product Updated Succesfully'}">
    		<h1>${message}</h1>
    	</c:if>
    	
    	<c:if test="${message=='Product deleted succesfully...'}">
    		<h1>${message}</h1>
    	</c:if>
    	
    	
    	<c:if test="${message=='showProductForm'}">
    		<jsp:include page="AddProduct.jsp"/>
    	</c:if>
    	
    	
		</div>
	</div>
	
    <!-- /.container -->
    
	 <%@include file="./shared/footer.jsp" %> 
	
	<!-- Self coded javascript -->
		<script src="${js}/myapp.js"></script>	
	
	</div>
</body>

</html>
