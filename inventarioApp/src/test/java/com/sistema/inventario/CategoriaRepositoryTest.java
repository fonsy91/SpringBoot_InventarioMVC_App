 package com.sistema.inventario;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.sistema.inventario.categoria.Categoria;
import com.sistema.inventario.categoria.CategoriaRepository;

//Utilizamos esta clase de tipo tests para hacer pruebas directas con la base de datos

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CategoriaRepositoryTest {

	@Autowired
	private CategoriaRepository repositorio; 
	
	@Test
	public void testCrearCategoria() {
		Categoria categoriaGuardada = repositorio.save(new Categoria("Electronica"));
		//Comprobamos si se ha gurdado si lo que nos devuelve es mayor que cero
		assertThat(categoriaGuardada.getId()).isGreaterThan(0);
	}
}
