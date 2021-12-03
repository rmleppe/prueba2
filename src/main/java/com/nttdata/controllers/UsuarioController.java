package com.nttdata.controllers;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nttdata.models.Usuario;
import com.nttdata.services.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired //INYECCION DE DEPENDENCIAS
	UsuarioService usuarioService;
	
	@RequestMapping("")
	public String registrar(@ModelAttribute("usuario") Usuario usuario,Model model) {
		
		
		model.addAttribute("listaUsuarios", usuarioService.obtenerListaUsuarios());
		return "usuarios/usuario";
	}
	
	@RequestMapping("/registrarjsp")
	public String registrarjsp(@ModelAttribute("usuario") Usuario usuario) {

		return "usuario/registro.jsp";
	}
	//METODO PARA EL BOTON REGISTRAR EN REGISTRO.JSP
			@RequestMapping("/registrar")
			public String registrar(@Valid @ModelAttribute("usuario") Usuario usuario)
			{
				System.out.println("si");
				Usuario usuario2 = usuarioService.findByEmail(usuario.getEmail());
				if(usuario2!=null) {
					System.out.println("usuario existe");
				}else {
					//usuarioService.registroUsuario(usuario);
					usuarioService.persistirUsuarioRol(usuario);
				}
				//retorno mensaje
				
				return "redirect:/login";
			}
			
	//capturr¿ar la info de formulario
			@RequestMapping("/login")
			public String login(Principal principal, Model model,HttpSession session) {
				
				String nombre = principal.getName();
				
				Usuario usuario= usuarioService.findByNombre(nombre);
				model.addAttribute("nombre_usuario", usuario.getNombre());
				
				
				return "home";
				
			}
		
		/*public String login(@RequestParam("email")String email,
				@RequestParam("pass") String pass,
				HttpSession session) {
				
			
			boolean resultado = usuarioService.loginUsuario(email, pass);
			if(resultado) {
				Usuario usuario = usuarioService.findByEmail(email);
				//almacenando varibles de sesion
				session.setAttribute("usuario_id", usuario.getId());
				session.setAttribute("nombre_usuario", usuario.getNombre());
				return "redirect:/home";
				
			}else {
				
				return "redirect:/login";
			}
			
		}*/
	
		
		
		@RequestMapping("/eliminar")
		public String eliminarUsuario(@RequestParam("id") Long id) {
			
			Usuario usuario = usuarioService.buscarUsuarioId(id);
			
			if(usuario !=null) {
				
				usuarioService.eliminarUsuarioObjeto(usuario);
			}
			
				
			return "redirect:/usuario";
	
		}
		
		
		
		//llamar para editar
				@RequestMapping("/{id}/editar")
				public String editarUsuario(@PathVariable("id") Long id, Model model) {
					Usuario usuario = usuarioService.buscarUsuarioId(id);
					if(usuario != null) {
						
						model.addAttribute("usuario", usuario);
						return "usuario/editar";
					}
					return "redirect:/usuario";
				}
				
				
			
				@RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
				
			    public String update(@Valid @ModelAttribute("usuario") Usuario usuario) {
			    	System.out.println("Update");
			      
			        	usuarioService.updateUsuario(usuario);
			            return "redirect:/usuario";
			        }
			    
	
	
	
	
	
}
