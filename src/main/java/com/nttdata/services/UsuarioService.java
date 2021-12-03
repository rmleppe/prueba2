package com.nttdata.services;

import java.util.List;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nttdata.models.Usuario;
import com.nttdata.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	RoleService roleService;
	
	
	
	//LOGIN
	@Autowired	
	BCryptPasswordEncoder bcpe;
		//---------------------	--------------------------------------------------------------------------------
	//SIIIIIIIIIIIIIII	
		public Usuario persistirUsuarioRol(Usuario usuario) {
			usuario.setPass(bcpe.encode(usuario.getPass()));	
			usuario.setRoles(roleService.findByNombre("ROLE_USER"));
			return usuarioRepository.save(usuario);
		}
	
	
	
		//METODO PARA BUSCAR USUARIO POR EMAIL
		public Usuario findByEmail(String email) {
			return usuarioRepository.findByEmail(email);
		}
		
		//INSERTAR USUARIO PARA LOGIN
		public Usuario registroUsuario(Usuario usuario) {
			
			//HASHEAR PASS, 
			String hashpw = BCrypt.hashpw(usuario.getPass(), BCrypt.gensalt());
			
			//SOBREESCRIBIR LA PASS AHORA ENCRIPTADA
			usuario.setPass(hashpw);
			
			return usuarioRepository.save(usuario);
		}
		
		//------------------------------------------------------------------------------------------------------
	
	public void insertarUsuario(@Valid Usuario usuario) {
		
		usuarioRepository.save(usuario);
		
	}
	
	public List<Usuario> obtenerListaUsuarios() {
		
		
		return usuarioRepository.findAll();
	}
	
	public Usuario buscarUsuarioId(Long id) {
		
		return usuarioRepository.findById(id).get();
	}

	public void eliminarUsuario(Long id) {
		
		usuarioRepository.deleteById(id);
		
	}
	
	public void eliminarUsuarioObjeto(Usuario usuario) {
		
		usuarioRepository.delete(usuario);
		
	}
	
	
	
	public void updateUsuario(@Valid Usuario usuario) {
		if(usuarioRepository.existsById(usuario.getId())){
			usuarioRepository.save(usuario);
		}		
	}
	
	public boolean loginUsuario(String email, String pass) {
		
		Usuario usuario = usuarioRepository.findByEmail(email);
		
		if(usuario == null) {
			return false;
		} else {
			//if(password.equals(usuario.getPassword())) {
			if(BCrypt.checkpw(pass, usuario.getPass())) {
				return true;
			}else {
				return false;
			}
		}	
	}


	public Usuario findByNombre(String nombre) {
		return usuarioRepository.findByNombre(nombre);
		
	}
}
