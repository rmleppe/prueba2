package com.nttdata.controllers;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttdata.models.Usuario;
import com.nttdata.services.UsuarioService;

@Controller
public class HomeController {

	

	@Autowired //INYECCION DE DEPENDENCIAS
	UsuarioService usuarioService;
	@RequestMapping("/")
	//METODO INICIAL PARA PAGINA HOME, DONED REDIRIGE EL LOCALHOST:8080
	public String index() {
		return "index";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "usuario/login";
	}
	
	@RequestMapping("/registro")
	public String registro(@ModelAttribute("usuario") Usuario usuario) {
		return "usuario/registro";
	}
	
	//MOSTRAR DATOS DE USUARIO EN HOME.JSP
		@RequestMapping("/home")
		public String home(HttpSession session, Model model) {
			
			//obtniendi as variables de sesion
			String nombre = (String) session.getAttribute("nombre_usuario");
			Long usuarioId = (Long) session.getAttribute("usuario_id");
			
			model.addAttribute("nombre_usuario", nombre);
			model.addAttribute("usuario_id", usuarioId);
			
			return "home";
		}
		
		
		
}
