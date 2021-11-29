package com.nttdata.models;



import java.util.Date;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="categorias_productos")
public class CategoriaProducto {


	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	
	//relacion
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="categoria_id")
	private Categoria categoria;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="producto_id")
	private Producto producto;
	
	
	
	public CategoriaProducto() {
	super();
	}
	
	
	
	public CategoriaProducto(Categoria categoria, Producto producto) {
	super();
	this.categoria = categoria;
	this.producto = producto;
	}
	
	
	
	public Long getId() {
	return id;
	}
	
	
	
	public void setId(Long id) {
	this.id = id;
	}
	
	
	
	public Categoria getCategoria() {
	return categoria;
	}
	
	
	
	public void setCategoria(Categoria categoria) {
	this.categoria = categoria;
	}
	
	
	
	public Producto getProducto() {
	return producto;
	}
	
	
	
	public void setProducto(Producto producto) {
	this.producto = producto;
	}
	




}