package com.nttdata.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nttdata.models.Usuario;

public interface UsuarioRepository  extends CrudRepository<Usuario,Long> {

	Usuario findByEmail(String email);
	Usuario findByNombre(String nombre);
	List<Usuario> findAll();
	
	
	
}
