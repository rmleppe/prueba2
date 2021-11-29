<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Registro</title>
</head>


<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light" >
        <div class="container-fluid">
          <a class="navbar-brand" href="/">NTT data</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          
        </div>
      </nav>
<div class="container">  

	<form:form method="post" action="/usuario/registrar" modelAttribute="usuario">
			<form:label path="nombre">Nombre</form:label>
			<form:input type="text" path="nombre"/>
			<br>
			<form:label path="email">email</form:label>
			<form:input type="text" path="email"/>
			<br>
			<form:label path="pass">Contrasena</form:label>
			<form:input type="password" path="pass"/>
			<br>
		
			<input type="button" class="btn btn-secondary" value="Limpiar">
			<input type="submit" class="btn btn-primary" value="Submit">
	
	</form:form> 
			<table class="table">
				  <thead>
				    <tr>
				      <th scope="col">#</th>
				      <th scope="col">Nombre</th>
				      <th scope="col">Email</th>
				      
				    </tr>
				  </thead>
				  <tbody>
				  	<c:forEach items="${listaUsuarios}" var="usuario" >
			    <tr>
			      <th scope="row">${usuario.getId()}</th>
			      <td>${usuario.getNombre()}</td>
			      <td>${usuario.getEmail()}</td>
			      
			      
			      <td>
				  			<td> <form action="/usuario/eliminar">
				  			<input type="hidden" name="id" value="${usuario.getId() }">
				  			<input type="submit" value="Eliminar" class="btn btn-danger">
				  			</form>		</td>
				  			
				  			<td>
			      			<a href="/usuario/${usuario.getId()}/editar" class="btn btn-primary" role="button" data-bs-toggle="button">Editarr</a>
			      
			      			</td>
				  		</tr>			  		
				  		</c:forEach>  
				  </tbody>			
				</table>
				
	
				
	
	</div>
</body>
</html>