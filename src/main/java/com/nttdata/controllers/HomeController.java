package com.nttdata.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	//METODO INICIAL PARA PAGINA HOME, DONED REDIRIGE EL LOCALHOST:8080
	public String index() {
		return "index";
	}
	
	@RequestMapping("login")
	public String login() {
		return "usuarios/login";
	}
}
