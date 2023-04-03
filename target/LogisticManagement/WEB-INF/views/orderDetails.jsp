<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Details</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<!-- Bootstrap JS -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>
  .footer {
        background-color: #343a40;
        color: white;
        text-align: center;
        padding: 20px;
        margin-top: 300px;
      }
</style>
</head>
<body>


<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Order Details</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

</nav>
<h1></h1>

<div class="container">


  <table class="table table-bordered">

    <tr>
      <td><b>Id</b></td>
      <td>${orderDetails.id}</td>
    </tr>

    <tr>
      <td><b>Name</b></td>
      <td>${orderDetails.name}</td>
    </tr>

    <tr>
      <td><b>Client</b></td>
      <td>${orderDetails.client}</td>
    </tr>

    <tr>
      <td><b>CreatedAt</b></td>
      <td>${orderDetails.created_at}</td>
    </tr>

    <tr>
      <td><b>Item</b></td>
      <td>${orderDetails.item}</td>
    </tr>

    <tr>
      <td><b>Quantity</b></td>
      <td>${orderDetails.quantity}</td>
    </tr>

    <tr>
      <td><b>Unit</b></td>
      <td>${orderDetails.unit}</td>
    </tr>

    <tr>
      <td><b>Status</b></td>
      <td>${orderDetails.status}</td>
    </tr>

    <tr>
      <td><b>Shipper Company</b></td>
      <td>${orderDetails.shipperCompany}</td>
    </tr>

    <tr>
      <td><b>Vehicle</b></td>
      <td>${orderDetails.vehicle}</td>
    </tr>

    <tr>
      <td><b>Start Location</b></td>
      <td>${orderDetails.startLocation}</td>
    </tr>

    <tr>
      <td><b>End Location</b></td>
      <td>${orderDetails.endLocation}</td>
    </tr>

    <tr>
      <td><b>Shipping Start Date</b></td>
      <td>${orderDetails.shippingStartDate}</td>
    </tr>

    <tr>
      <td><b>Shipping End Date</b></td>
      <td>${orderDetails.shippingEndDate}</td>
    </tr>

  </table>

</div>
<footer class="footer">
    
        <p>&copy; 2023 Logistic Management System. All Rights Reserved.</p>

    </footer>
        

</body>
</html>
