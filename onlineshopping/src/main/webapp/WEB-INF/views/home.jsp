<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<br/>  
    <div class="container">

        <div class="row">

            <div class="col-md-3">
                 <p class="lead">Select Category</p> 
                <div class="list-group">
                	<c:forEach items="${categories}" var="category">
                		<a href="listProducts?category=${category.categoryName}" class="list-group-item active">${category.categoryName}</a>
                	</c:forEach>
                    
                </div>
            </div>

            <div class="col-md-9">

                <div class="thumbnail">
                    <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="${images}/Banner5.jpg" alt="Los Angeles" style="width:900px;height: 500px">
      </div>

      <div class="item">
        <img src="${images}/Banner4.jpg" alt="Chicago" style="width:900px;height: 500px">
      </div>
    
      <div class="item">
        <img src="${images}/Banner3.jpg" alt="New york" style="width:900px;height: 500px">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
  <div class="jumbotron" style="margin-top: 10px">
    <h1>How OurShop Works</h1>      
    <p>
    	Each week we partner with leading urban and outdoor brands to bring you a curated selection of apparel and gear at members-only prices.
    </p>
    <p>	
    	Sales begin on Tuesday and Thursday and typically last 7 days , after which our site will refresh with new brands.
    <p>	
    	In addition to unique brands , you'll also find original content in our journal , links to interesting stories , inane videos , and fresh beats that are circulating around our warehouse.
    </p>
  </div>
     
</div>
                
                

                <div class="well">

                    <div class="text-right">
                        <a class="btn btn-success">Leave a Review</a>
                    </div>

                    <hr>

                    <div class="row">
                        <div class="col-md-12">
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star-empty"></span>
                            Anonymous
                            <span class="pull-right">10 days ago</span>
                            <p>This product was great in terms of quality. I would definitely buy another!</p>
                        </div>
                    </div>

                    <hr>

                    <div class="row">
                        <div class="col-md-12">
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star-empty"></span>
                            Anonymous
                            <span class="pull-right">12 days ago</span>
                            <p>I've alredy ordered another one!</p>
                        </div>
                    </div>

                    <hr>

                    <div class="row">
                        <div class="col-md-12">
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star-empty"></span>
                            Anonymous
                            <span class="pull-right">15 days ago</span>
                            <p>I've seen some better than this, but not at this price. I definitely recommend this item.</p>
                        </div>
                    </div>

                </div>

            </div>

        </div>

    </div>