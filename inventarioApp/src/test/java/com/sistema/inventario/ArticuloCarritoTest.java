package com.sistema.inventario;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.sistema.inventario.carrito.compras.ArticuloCarrito;
import com.sistema.inventario.carrito.compras.ArticuloCarritoRepository;
import com.sistema.inventario.producto.Producto;
import com.sistema.inventario.usuario.Usuario;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ArticuloCarritoTest {

	@Autowired
	private ArticuloCarritoRepository repositorio;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void agregarArticulo() {
		Producto producto = entityManager.find(Producto.class, 2);
		Usuario usuario = entityManager.find(Usuario.class, 1);
		ArticuloCarrito articulo = new ArticuloCarrito(1,producto,usuario);
		
		repositorio.save(articulo);
	}
}
