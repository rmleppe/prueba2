package com.nttdata.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.models.Producto;



@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long>{

	List<Producto> findAll();
	
	 
	@Query("SELECT u.nombre FROM Producto u")
	List<String> findAllProductosNombres();
	
	@Query("SELECT u.nombre, u.descripcion FROM Producto u")
	List<Object[]> findAllProductosNombreDescripcion();
	
	@Query("SELECT u FROM Producto u Where id = ?1")
	List<Producto> obtenerProductoWhereId(Long id);
	
	
	
	
	
}