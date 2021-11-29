package com.nttdata.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity	//representcion de la entidad modelo (entidad = tablas)
@Table(name="usuarios")//nombre de la tabla en la bd
public class Usuario {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY) //auto incrementable
	private Long id;
	
	private String nombre;
	private String email;
	private String pass;
	
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	
	
	//CONSTRUCTORES
	public Usuario() {
		super();
	}


	public Usuario(Long id, String nombre, String email, String pass) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.pass = pass;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", email=" + email + ", pass=" + pass + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	
	
	
	
	

}
