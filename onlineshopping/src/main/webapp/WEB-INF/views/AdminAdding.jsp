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
   	
		<!-- <div class="container1" align="center" >
			<h1>Admin Adding Page</h1>
		</div> -->
		<div id="exTab1" class="container">
			<ul class="nav nav-pills">
				<li class="active">
					<a href="#a1" data-toggle="tab">Product</a>
				</li>
				<li>
					<a href="#2a" data-toggle="tab">Category</a>
				</li>
				<li>
					<a href="#3a" data-toggle="tab">Supplier</a>
				</li>
			</ul>
			
			<div class="tab-content clearfix">
				<div class="tab-pane active" id="a1">
					
										<h3>Add Product</h3>
					<form class="form-horizontal" action="${contextRoot}/admin/addProduct" method="post" 
					enctype="multipart/form-data">
						<div class="form-group">
							<label class="control-label col-sm-4" for="productName">Product Name :  </label>
							<div class="col-sm-6">
								<input type="text" value="${productObj.productName}" class="form-control" id="productName" placeholder="Enter Product Name" name="productName"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="description">Description :  </label>
							<div class="col-sm-6">
								<input type="text" value="${productObj.description}" class="form-control" id="description" placeholder="Enter Description" name="description"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="price">Price :  </label>
							<div class="col-sm-6">
								<input type="text" value="${productObj.price}" class="form-control" id="price" placeholder="Enter Price" name="price"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="quantity">Quantity :  </label>
							<div class="col-sm-6">
								<input type="text" value="${productObj.quantity}" class="form-control" id="quantity" placeholder="Enter Quantity" name="quantity"/>
							</div>
						</div>
						 <div class="form-group">
							<label class="control-label col-sm-4" for="category">Category :  </label>
							<div class="col-sm-6">
								<select  id="category" name="category" class="form-control">
									<option value="none">---Choose Category---</option>
									<c:forEach items="${categoryList}" var="category">
										 <option value="${category.categoryId}">Category : ${category.categoryName}</option>	
									</c:forEach>
								</select>
							</div>
						</div> 
						
						
						 <div class="form-group">
							<label class="control-label col-sm-4" for="supplier">Supplier :  </label>
							<div class="col-sm-6">
								<select path="supplier" id="supplier" name="supplier" class="form-control">
									<option value="none">---Choose Supplier---</option>
									<c:forEach items="${supplierList}" var="supplier">
										 <option value="${supplier.supplierId}">Supplier : ${supplier.supplierName}</option>	
									</c:forEach>
								</select>
							</div>
						</div> 
						
						
						
						  <div class="form-group">
							<label class="control-label col-sm-4" for="pimage">Upload Image :  </label>
							<div class="col-sm-6">
								<input  type="file" class="form-control" id="file" placeholder="Upload Product Image" name="file"/>
							</div>
						</div>  
				
        
						
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
							<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
								<button type="submit" class="btn btn-default">Update Product</button>
							</div>
						</div>
					</form>


				</div>
				
				
				
				<div class="tab-pane" id="2a">
					<h3>Add Category</h3>
					<form:form class="form-horizontal" action="${contextRoot}/admin/addCategory" method="post" modelAttribute="categoryObj">
						<div class="form-group">
							<label class="control-label col-sm-4" for="categoryId">Category Id :  </label>
							<div class="col-sm-6">
								<form:input path="categoryId" class="form-control" id="categoryId" placeholder="Enter Category Id" name="categoryId"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="categoryName">Category Name :  </label>
							<div class="col-sm-6">
								<form:input path="categoryName" class="form-control" id="categoryName" placeholder="Enter Category Name" name="categoryName"/>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-default">Add Category</button>
							</div>
						</div>
					</form:form>
				</div>
				<div class="tab-pane" id="3a">
					<h3>Add Supplier</h3>
					<form:form class="form-horizontal" action="${contextRoot}/admin/addSupplier" method="post" modelAttribute="supplierObj">
						<div class="form-group">
							<label class="control-label col-sm-4" for="supplierId">Supplier Id :  </label>
							<div class="col-sm-6">
								<form:input path="supplierId" class="form-control" id="supplierId" placeholder="Enter Supplier Id" name="supplierId"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="supplierName">Supplier Name :  </label>
							<div class="col-sm-6">
								<form:input path="supplierName" class="form-control" id="supplierName" placeholder="Enter Supplier Name" name="supplierName"/>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-default">Add Supplier</button>
							</div>
						</div>
					</form:form>
					
				</div>
			</div> 
			
		</div>
		
<%@include file="./shared/footer.jsp" %> 
	
	<!-- Self coded javascript -->
		<script src="${js}/myapp.js"></script>	
	
	</div>
</body>

</html>
		