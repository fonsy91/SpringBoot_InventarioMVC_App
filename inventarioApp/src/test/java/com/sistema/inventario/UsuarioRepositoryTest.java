package com.sistema.inventario;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.sistema.inventario.usuario.Rol;
import com.sistema.inventario.usuario.Usuario;
import com.sistema.inventario.usuario.UsuarioRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCrearRoles() {
		Rol rolAdmin = new Rol("Administrador");
		Rol rolEditor = new Rol("Editor");
		Rol rolVisitante = new Rol("Visitante");
		
		entityManager.persist(rolAdmin);
		entityManager.persist(rolEditor);
		entityManager.persist(rolVisitante);
	}
	
	@Test
	public void testCrearNuevoUsuarioConRol() {
		Rol rolAdmin = entityManager.find(Rol.class, 1);
		Usuario usuario = new Usuario("alfonso91fp@gmail.com", "12345");
		usuario.añadirRol(rolAdmin);
		usuarioRepository.save(usuario);
	}
	
	@Test
	public void testCrearNuevoUsuarioConDosRoles() {
		Rol rolEditor = entityManager.find(Rol.class, 2);
		Rol rolVisitante = entityManager.find(Rol.class, 3);
		Usuario usuario = new Usuario("juan91fp@gmail.com", "12345");
		
		usuario.añadirRol(rolEditor);
		usuario.añadirRol(rolVisitante);
		
		usuarioRepository.save(usuario);
	}
	
	@Test
	public void testAsignarRolAusuarioExistente() {
		Usuario usuario = usuarioRepository.findById(1).get();
		Rol rolEditor = entityManager.find(Rol.class, 2);
		usuario.añadirRol(rolEditor);
		usuarioRepository.save(usuario);
	}
	
	@Test
	public void testEliminarRolUsuarioExistente() {
		Usuario usuario = usuarioRepository.findById(1).get();
		Rol rol = new Rol(2); //Id del rol a eliminar
		usuario.eliminarRol(rol); //Del Usuario 1 eliminamos el Rol 2
	}
	
	@Test
	public void testCrearNuevoUsuarioConNuevoRol() {
		Rol rolVendedor = new Rol("Vendedor");
		Usuario usuario = new Usuario("pedro91fp@gmail.com", "12345");
		usuario.añadirRol(rolVendedor);
		usuarioRepository.save(usuario);
	}
	
	@Test
	public void testObtenerUsuario() {
		Usuario usuario = usuarioRepository.findById(1).get();
		//Con el detach no se guardan los valores en la base de datos
		entityManager.detach(usuario);
		System.out.println(usuario.getEmail());
		System.out.println(usuario.getRoles());
	}
	
	@Test
	public void testEliminarUsuario() {
		usuarioRepository.deleteById(2);
	}
	
	
	
}
