package com.sistema.inventario.producto;

import java.util.ArrayList;
import java.util.List;

import com.sistema.inventario.categoria.Categoria;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //porque va a ser incrementable 
	private Integer id;
	
	//Con unique=true expecificamos que no se repetira el valor de esta columna nunca
	@Column(length = 128, nullable = false, unique = true)
	private String nombre;
	
	private float precio;
	
	//Muchos productos van a estar en una categoria
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	//Columna de la tabla Producto que une esta tabla con la de categoria
	private Categoria categoria;

	@OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
	private List<ProductoDetalles> detalles = new ArrayList<>();

	//Constructores 
	public Producto(Integer id, String nombre, float precio, Categoria categoria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.categoria = categoria;
	}
	
	public Producto() {
		super();
	}

	public Producto(String nombre, float precio, Categoria categoria) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.categoria = categoria;
	}

	public Producto(String nombre) {
		super();
		this.nombre = nombre;
	}

	//Getters anda Setters
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

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public List<ProductoDetalles> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<ProductoDetalles> detalles) {
		this.detalles = detalles;
	}

	//METODOS DE LA CLASE
	//Metodo para añadir detalles a un array
	public void agregarDetalles(String nombre, String valor) {
		this.detalles.add(new ProductoDetalles(nombre,valor,this));
	}
	
	public void setDetalle(Integer id, String nombre, String valor) {
		this.detalles.add(new ProductoDetalles(id, nombre, valor, this));
	}

}
