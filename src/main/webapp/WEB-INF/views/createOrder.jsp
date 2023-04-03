<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Order</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
  .footer {
        background-color: #343a40;
        color: white;
        text-align: center;
        padding: 20px;
        margin-top: 300px;
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

tr:hover {background-color: coral;}</style>
</head>
<body>


<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Create Order</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

</nav>
<div class="container">

 <h1></h1>
  <form:form method="post" action="saveOrder" modelAttribute="orderRequest" class="form-horizontal"> 
    <div class="form-group">
      <label class="control-label col-sm-2" for="orderName">Order Name:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" name="orderName" id="orderName" required>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="client">Select Client:</label>
      <div class="col-sm-10">
        <select class="form-control" name="clientId" id="client">
         <c:forEach var="client" items="${clientList}"> 
              <option value=${client.id}>${client.name}, ${client.address}</option>
         </c:forEach> 
        </select>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="item">Select Item:</label>
      <div class="col-sm-10">
        <select class="form-control" name="itemId" id="item">
          <c:forEach var="item" items="${inventoryList}"> 
                <option value=${item.id}>${item.name}</option>
           </c:forEach>
        </select>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="quantity">Item Quantity:</label>
      <div class="col-sm-10">
        <input type="number" class="form-control" name="quantity" id="quantity" required>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="units">Units:</label>
      <div class="col-sm-10">
        <select class="form-control" name="unit" id="units">
          <c:forEach var="unit" items="${unitsList}"> 
                <option value=${unit}>${unit}</option>
           </c:forEach>
        </select>
      </div>
    </div>
    <div class="form-group"> 
      <div class="col-sm-offset-2 col-sm-10">
        <input type="submit" class="btn btn-primary" value="Create Order"/>
        <input type="reset" class="btn btn-default"/>
      </div>
    </div>
  </form:form> 
</div>
<footer class="footer">
    
        <p>&copy; 2023 Logistic Management System. All Rights Reserved.</p>

    </footer>
        
</body>
</html> 