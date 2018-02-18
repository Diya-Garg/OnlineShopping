<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<spring:url var="images" value="/resources/images"/>

 <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${contextRoot}/home" class="active">Online Shopping</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                
                
                	<sec:authorize access="isAnonymous()" >
                	
                    <li>
                        <a href="${contextRoot}/about">About Us</a>
                    </li>
                    
                    <li>
                        <a href="${contextRoot}/contact">Contact</a>
                    </li>
                    <li>
                        <a href="${contextRoot}/listProducts">View Products</a>
                    </li>
                    </sec:authorize>
                    
                    
                    
                    <sec:authorize access="hasRole('ROLE_ADMIN')" >
                	
                    <li>
                        <a href="${contextRoot}/admin/add">Add</a>
                    </li>
                    
                    
                    <li>
                        <a href="${contextRoot}/admin/listProducts">View Products</a>
                    </li>
                    </sec:authorize>
                    
                    
                </ul>
                <ul class="nav navbar-nav navbar-right">
                <%-- <c:out value="${pageContext.request.userPrincipal.name}"/> --%>
                	<c:if test="${pageContext.request.userPrincipal.name==null}">
            	    <li>
            	    	<a href="#" class="nav1options">
            	    		<span class="glyphicon glyphicon-user"></span> Sign Up
            	    	</a>
            	    </li>
      				 <li>
      				 	<a href="${contextRoot}/goToLogin" class="nav1options">
      				 		<span class="glyphicon glyphicon-log-in"></span> Login
      				 	</a>
      				 </li>
      				 </c:if> 
      				<c:if test="${pageContext.request.userPrincipal.name!=null}">
      					
      					<li class="nav1options">	
      					<a href="#" class="nav1options">
            	    		<c:out value="${pageContext.request.userPrincipal.name}"/>
            	    		</a>
      						
                	
      					</li>	
      					
      					<li>
            	    	<a href="${contextRoot}/perform-logout" class="nav1options">
            	    		<span class="glyphicon glyphicon-log-out"></span> Log Out
            	    		</a>
            	   	 	</li>	
            	   	 	
            	   	 	
      				</c:if>
      				 	<li>
            	   	 		<a href="" class="nav1options">
            	   	 			<img src="${images}/MyCart.png" style="height:40px;width: 60px "/>
            	   	 		</a>
            	   	 	</li>
            	   	
      				</ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
   </nav> 
<br/>