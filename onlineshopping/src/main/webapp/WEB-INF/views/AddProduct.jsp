<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<spring:url var="css" value="/resources/css"/>
<spring:url var="js" value="/resources/js"/>
<spring:url var="images" value="/resources/images"/>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
					<h3>Add Product</h3>
					<form class="form-horizontal" action="${contextRoot}/admin/updateProductProcess" method="post" 
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
									<option value="${productObj.category.categoryId }">${productObj.category.categoryName}</option>
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
									<option value="${productObj.supplier.supplierId }">${productObj.supplier.supplierName}</option>
									<c:forEach items="${supplierList}" var="supplier">
										 <option value="${supplier.supplierId}">Supplier : ${supplier.supplierName}</option>	
									</c:forEach>
								</select>
							</div>
						</div> 
						
						
						
						 <div class="form-group">
							<label class="control-label col-sm-4" for="pimage">Upload New Image :  </label>
							<div class="col-sm-6">
								<input  type="file" class="form-control" id="file" placeholder="Upload Product Image" name="file"/>
							</div>
						</div>  
				
        
						
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
							<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
							<input type="hidden" name="productId" value="${productObj.productId}">
								<button type="submit" class="btn btn-default">Update Product</button>
							</div>
						</div>
					</form>
