<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<style>
      .footer {
        background-color: #343a40;
        color: white;
        text-align: center;
        padding: 20px;
        margin-top: 200px;
      }
      table {
  border-collapse: collapse;
  width: 100%;
}
th, td {
padding: 8px;
text-align: left;
border-bottom: 1px solid #ddd;
}

tr:hover {background-color: coral;}
      </style>
</head>

<body>
${message}
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Orders</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav ml-auto">
      <li class="nav-item active">
        <a class="nav-link" href="logout">Logout</a>
      </li>
    </ul>
  </div>
</nav>
<div class="container">
<div class="container-fluid mt-3">
  <div class="row">
    <div class="col-md-12">
      <h1></h1>
      <table class="table table-striped">
        <thead class="thead-dark">
          <tr>
            <th scope="col">Id</th>
            <th scope="col">Name</th>
            <th scope="col">Client</th>
            <th scope="col">Created At</th>
            <th scope="col">Item</th>
            <th scope="col">Quantity</th>
            <th scope="col">Status</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="order" items="${ordersList}">
            <tr>
              <td><a href="orderDetails/${order.id}">${order.id}</a></td>
              <td>${order.name}</td>
              <td>${order.client}</td>
              <td>${order.created_at}</td>
              <td>${order.item}</td>
              <td>${order.quantity} ${order.unit}</td>
              <td>
                <c:set var="status" value="${order.status}"/>  
                <c:if test="${fn:contains(status, 'Completed')}">  
                  Completed  
                </c:if>  
                <c:if test="${fn:contains(status, 'Draft')}">  
                  <a href="createShipmentPage?orderId=${order.id}">Create Shipment</a>
                </c:if>
                <c:if test="${fn:contains(status, 'In Progress')}">  
                  In Progress
                </c:if>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
      <br>
      <a href="createOrderPage" class="btn btn-primary">Create Order</a>
      <a href="allItems" class="btn btn-primary">All Items</a>
      

      
 </div>
 </div>
 </div>
 </div>
  <footer class="footer">
    
        <p>&copy; 2023 Logistic Management System. All Rights Reserved.</p>

    </footer>
        
</body>
</html>