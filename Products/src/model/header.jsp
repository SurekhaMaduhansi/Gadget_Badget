<%@page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/userHome.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
</head>
    <!--Header-->
    <br>
    <div class="topnav sticky">
    
          
           <b> <h2><a href=""> <i class='fas fa-user-alt'></i></a></h2>
              <% String email=session.getAttribute("email").toString(); %>
							  <a href=""><%out.println(email); %></a></b>
            <a href="UserAddProductCart.jsp">Home<i class="fa fa-institution"></i></a>
            <a href="myCart.jsp">My Cart<i class='fas fa-cart-arrow-down'></i></a>
            <a href="myOrders.jsp">My Orders  <i class='fab fa-elementor'></i></a>
            <a href="messageUs.jsp">Message Us <i class='fas fa-comment-alt'></i></a>
     
            <div class="search-container">
                <form action="searchHome.jsp" method="post">
					    	<input type = "text" placeholder="Search Item" name= "search">
					    	<button type = "Submit"><i class="fa fa-search"></i>
					    	 Search</button>
					    
					    </form>
               
             
            </div>
          </div>
           <br>
           <!--table-->
