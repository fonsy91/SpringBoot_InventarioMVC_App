package com.sistema.inventario.categoria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//@RestController // devuelve un JSON
@Controller // devuelve una vista HTML
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping("/categorias")
	public String listarCategorias(Model modelo) {
		List<Categoria> listaCategorias = categoriaRepository.findAll();
		//Model se usa para pasar datos desde el controlador a la vista de la aplicacion
		//addAttribute permite agregar atributos a model para poder ser usados en la vista (objetos,cadenas, numeros)
		//addAttribute acepta dos parametros el nombre del atributo y valor
		modelo.addAttribute("listaCategorias",listaCategorias);
		//devolvemos el archivo HTML correspondiente a la vista de la lista de categorias (categorias.html)
		return "categorias";
	}
	
	//Metodo que nos lleva al formulario de agregar categorias 
	@GetMapping("/categorias/nuevo")
	public String mostrarFormularioDeNuevaCategoria(Model modelo) {
		modelo.addAttribute("categoria", new Categoria());
		return "categoria_formulario";
	}
	
	
	@PostMapping("/categorias/guardar")
	public String guardarCategoria(Categoria categoria) {
		categoriaRepository.save(categoria);
		//No redirigimos a la pantalla de lista de categorias
		return "redirect:/categorias";
	}
	
	
}
