<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inventory</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
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
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Inventory List</a>
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
  <h1 class="my-4"></h1>
  <div class="my-4">
    <a class="btn btn-primary" href="createInventoryPage" role="button">Create Inventory</a>
    <a class="btn btn-secondary" href="allOrders" role="button">All Orders</a>
  </div>
  <table class="table table-hover">
    <thead>
      <tr>
        <th scope="col">Name</th>
        <th scope="col">Quantity</th>
        <th scope="col">Unit</th>
        <th scope="col">Update</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="item" items="${itemsList}">
        <tr>
          <td>${item.name}</td>
          <td>${item.quantity}</td>
          <td>${item.unit}</td>
          <td><a class="btn btn-warning" href="createInventoryPage?update=true&itemId=${item.id}" role="button">Update Item</a></td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
<footer class="footer">
    
        <p>&copy; 2023 Logistic Management System. All Rights Reserved.</p>

    </footer>
        
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<!-- Bootstrap JS -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>



