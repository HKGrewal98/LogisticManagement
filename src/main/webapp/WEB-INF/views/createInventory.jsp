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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<style>
  .footer {
        background-color: #343a40;
        color: white;
        text-align: center;
        padding: 20px;
        margin-top: 200px;
      }</style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Inventory</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

</nav>
<div class="container mt-4">
    <h1></h1>
    <br/><br/>

    <form:form method="post" action="saveInventory" modelAttribute="inventoryRequest"> 

        <input type="hidden" name="itemId" value="${itemId}"/>

        <div class="form-group">
            <label for="name">Item Name:</label>
            <input type="text" class="form-control" name="name" value="${inventoryRequest.name}" required>
        </div>

        <div class="form-group">
            <label for="quantity">Quantity:</label>
            <input type="number" class="form-control" name="quantity" value="${inventoryRequest.quantity}" required>
        </div>

        <div class="form-group">
            <label for="units">Units:</label>
            <select class="form-control" name="unit" id="units" >
                <c:forEach var="unit" items="${unitsList}"> 
                    <option value=${unit} selected>${unit}</option>
                </c:forEach>
            </select>
        </div>

        <br/><br/><br/>

        <button type="submit" class="btn btn-primary">Done</button>
        <a href="/LogisticManagement/allItems" class="btn btn-secondary">Cancel</a>

    </form:form>
</div>

<footer class="footer">
    
        <p>&copy; 2023 Logistic Management System. All Rights Reserved.</p>

    </footer>
        
<!-- Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<!-- Bootstrap JS -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>