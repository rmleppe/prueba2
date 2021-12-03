<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
  <head>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
      crossorigin="anonymous"
    />

    <meta charset="ISO-8859-1" />
    <title>LOGIN USUARIO</title>
  </head>
  <body>
    <div class="col d-flex justify-content-center">
      <div class="col-sm-6">
        <div class="card border-secondary mb-3" style="top: 75px">
          <div class="card-body">
            <form action="usuario/login" method="post">
              <label for="email">Email:</label>
			        <input type="text" class="form-control" name="email" placeholder="Ingresa tu email">   
              <br>
              <label for="pass">Password:</label>
              <input type="password" class="form-control" name="pass" placeholder="Ingresa tu password">
              <br>
              <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"> 
              <input type="submit" class="btn btn-primary" value= "Ingresar">
            </form>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
