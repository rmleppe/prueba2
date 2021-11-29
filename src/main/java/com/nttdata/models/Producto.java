package com.nttdata.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity	//representcion de la entidad modelo (entidad = tablas)
@Table(name="productos")//nombre de la tabla en la bd
public class Producto {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY) //auto incrementable
	private Long id;

	private String nombre;
	private String descripcion;
	private Double precio;
	private Float stock;
	
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	
	

	//relacion many to many
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
	name="categorias_productos",//tabla intermedia
	joinColumns = @JoinColumn(name="producto_id"),
	inverseJoinColumns = @JoinColumn(name="categoria_id")
	)

	//relacion many to many
	private List<Categoria> categorias;
	
	
	public Producto() {
		super();
	}



	public Producto(String nombre, String descripcion, Double precio, Float stock) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
	}


	
	

	public List<Categoria> getCategorias() {
		return categorias;
	}



	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	


	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public Double getPrecio() {
		return precio;
	}



	public void setPrecio(Double precio) {
		this.precio = precio;
	}



	public Float getStock() {
		return stock;
	}



	public void setStock(Float stock) {
		this.stock = stock;
	}



	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", stock=" + stock
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}



	


	
	
	
	
	
	
	
}
