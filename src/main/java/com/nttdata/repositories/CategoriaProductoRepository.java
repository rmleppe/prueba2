package com.nttdata.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.models.CategoriaProducto;



@Repository
public interface CategoriaProductoRepository extends  CrudRepository<CategoriaProducto, Long> {
	
		List<CategoriaProducto> findAll();
		
		
		
		//QUERY NATIVA, DIRECTA DE LA TABLA :)
		@Query(value = "SELECT * FROM categorias_productos u Where categoria_id = ?1",nativeQuery =true)
		List<CategoriaProducto> obtenerCategoriaProductoCategoriaWhereId(Long id);
		

}
