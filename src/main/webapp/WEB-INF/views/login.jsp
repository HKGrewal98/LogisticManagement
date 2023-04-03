<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
<style>
.btn-close{
	margin-top: 0px;
}
  h1 {
  font-size: 3rem;
  font-weight: bold;
  color: black;
  text-align: center;
  margin-bottom: 2rem;
  margin-top: 50px;
 
}
  form {
    width: 400px;
    margin: auto;
    border: 2px solid #d6d8db;
    border-radius: 5px;
    padding: 20px;
    background-color: #f8f9fa;
    margin-top: 100px;
    border: 2px solid black;
  }
  label {
    font-weight: bold;
  }
  input[type="text"],
  input[type="password"] {
    width: 100%;
    padding: 10px;
    margin-bottom: 20px;
    border-radius: 5px;
    border: 1px solid #ced4da;
  }
  input[type="submit"] {
    width: 100%;
    background-color: #007bff;
    color: white;
    border-radius: 5px;
    border: none;
    padding: 10px;
    margin-top: 10px;
  }
  input[type="submit"]:hover {
    background-color: #0069d9;
  }
  .alert {
    width: 400px;
    margin: auto;
    margin-top: 20px;
    text-align: center;
  }
  .container{
  	
  }
  
</style>
</head>
<body>
<a href="/LogisticManagement/" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></a>
<div class="container">
  <h1>Login</h1>
   ${message}
  <form method="post" action="signIn">
    
    <div class="form-group">
      <label for="user">Username</label>
      <input type="text" class="form-control" name="user" id="user" required/>
    </div>

    <div class="form-group">
      <label for="password">Password</label>
      <input type="password" class="form-control" name="password" id="password" required/>
    </div>

    <input type="submit" class="btn btn-primary" value="Login"/>
  </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.min.js" integrity="sha384-heAjqF+bCxXpCWLa6Zhcp4fu20XoNIA98ecBC1YkdXhszjoejr5y9Q77hIrv8R9i" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>


</body>
</html>