package com.sistema.inventario.categoria;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //porque va a ser incrementable 
	private Integer id;
	
	@Column(length = 45, nullable = false, unique = true)
	private String nombre;

	//Constructores 
	public Categoria() {
		super();
	}

	public Categoria(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Categoria(Integer id) {
		super();
		this.id = id;
	}
	
	public Categoria(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	//Getters and Setters 
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
