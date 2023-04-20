package com.sistema.inventario.marca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sistema.inventario.categoria.CategoriaRepository;

@Controller
public class MarcaController {

	@Autowired
	private MarcaRepository marcaRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
}
