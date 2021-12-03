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
<div class="col d-flex justify-content-center">	
	<div class="col-sm-6 ">  
		<div class="card border-secondary mb-3" style="top: 75px;">
			
				<div class="card-body" >
				
					<form:form method="post" action="/usuario/registrar" modelAttribute="usuario">
						<input type="hidden" name="_method" value="put">
						<form:label path="nombre" class="col-sm-2 col-form-label">Nombre:</form:label>
						<form:input type="text" path="nombre" class="form-control"/>
						<br>
						<form:label path="email" class="col-sm-2 col-form-label">Email:</form:label>
						<form:input type="email" path="email" class="form-control"/>
						<br>
						<form:label path="pass" class="col-sm-2 col-form-label">Contrasena:</form:label>
						<form:input type="password" path="pass" class="form-control"/>
						<br>
						<form:label path="passConfirmation" class="col-sm-6 col-form-label">Confirme Contrasena:</form:label>
						<form:input type="password" path="passConfirmation" class="form-control"/>
						<br>
						<input type="reset" class="btn btn-secondary" value="Limpiar">
						<input type="submit" class="btn btn-primary" value="Registrar">
						
						
					</form:form>

				</div>
			
		</div>
	</div>		
</div>	
			<!-- <table class="table">
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
				 -->
	
				
	
	
</body>
</html>