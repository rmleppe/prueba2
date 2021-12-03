<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light" >
        <div class="container-fluid">
          <a class="navbar-brand" href="/">NTT data</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
            <div class="collapse navbar-collapse justify-content-between" id="navbarNav">
              <ul class="navbar-nav mr-auto">
                        <li class="nav-item" >
                          <a class="nav-link active" aria-current="page" href="producto">Productos</a>
                        </li>

                        <li class="nav-item" >
                          <a class="nav-link active" aria-current="page" href="">Carrito</a>
                        </li>
                        
                      
                      <li class="nav-item">
                        <a class="nav-link" href="/categoria">Categoria</a>
                      </li>
                      
               </ul> 
                      <ul class="navbar-nav">                      
                      <li class="nav-item justify-content-end " >
                        <a class="nav-link " aria-current="page" >Hola ${nombre_usuario}! </a>
                      </li>
                      </ul>

                      
               
          </div>
        </div>
      </nav>    

    
</body>
</html>