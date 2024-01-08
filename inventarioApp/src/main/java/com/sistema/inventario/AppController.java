package com.sistema.inventario;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
	
	//Cuando arrancas la aplicacion la primera pagina es el index
	// URL: http://localhost:8081/

	@GetMapping("")
	public String verPaginaDeInicio() {
		return "index";
	}
}
