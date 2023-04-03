<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Shipment</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
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
  <a class="navbar-brand" href="#">Create Shipment</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

</nav>
<div class="row justify-content-center mt-4">
  <div class="col-md-6">
  <form:form method="post" action="saveShipment" modelAttribute="shipmentRequest"> 
    <input type="hidden" name="orderId" value="${orderId}"/>
    <div class="form-group">
  <label for="companyName">Company Name</label>
  <input type="text" class="form-control" name="companyName" id="companyName" required/>
</div>

<div class="form-group">
  <label for="startLocation">Start Location:</label>
  <select class="form-control" name="startLocation" id="startLocation">
    <c:forEach var="location" items="${locationList}"> 
      <option value=${location}>${location}</option>
    </c:forEach> 
  </select> 
</div>

<div class="form-group">
  <label for="endLocation">End Location:</label>
  <select class="form-control" name="endLocation" id="endLocation">
    <c:forEach var="location" items="${locationList}"> 
      <option value=${location}>${location}</option>
    </c:forEach> 
  </select> 
</div>

<div class="form-group">
  <label for="startDate">Start Date:</label>
  <input type="date" class="form-control" name="startDate" id="startDate" required />
</div>

<div class="form-group">
  <label for="endDate">End Date:</label>
  <input type="date" class="form-control" name="endDate" id="endDate" required />
</div>

<div class="form-group">
  <label for="vehicleId">Select Vehicle:</label>
  <select class="form-control" name="vehicleId" id="vehicleId">
    <c:forEach var="vehicle" items="${vehicleList}"> 
      <option value=${vehicle.id}>${vehicle.model}, ${vehicle.vehicleNumber}</option>
    </c:forEach> 
  </select> 
</div>

<div class="form-group">
  <input type="submit" class="btn btn-primary" value="Create Shipment"/>
  <input type="reset" class="btn btn-secondary"/>
</div>

</form:form>
</div>
</div>
<footer class="footer">
    
        <p>&copy; 2023 Logistic Management System. All Rights Reserved.</p>

    </footer>
        

</body>
</html>