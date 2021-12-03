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
import javax.persistence.Transient;

@Entity	//representcion de la entidad modelo (entidad = tablas)
@Table(name="usuarios")//nombre de la tabla en la bd
public class Usuario {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY) //auto incrementable
	private Long id;
	
	private String nombre;
	private String email;
	private String pass;
	@Transient
	private String passConfirmation;
	
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	
	
	//----------------------------------------------------
	//relacion many to many
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
	name="roles_usuarios",//tabla intermedia
	joinColumns = @JoinColumn(name="usuario_id"),
	inverseJoinColumns = @JoinColumn(name="role_id")
	)
	
	private List<Role>roles;

	//----------------------------------------------------
	
	
	//CONSTRUCTORES
	public Usuario() {
		super();
	}
	
	


	public Usuario(Long id, String nombre, String email, String pass, String passConfirmation, List<Role> roles) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.pass = pass;
		this.passConfirmation = passConfirmation;
		this.roles = roles;
	}




	public Usuario(Long id, String nombre, String email, String pass, String passConfirmation) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.pass = pass;
		this.passConfirmation = passConfirmation;
	}


	public Usuario(Long id, String nombre, String email, String pass) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.pass = pass;
	}

	
	
	

	public List<Role> getRoles() {
		return roles;
	}


	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}


	public String getPassConfirmation() {
		return passConfirmation;
	}


	public void setPassConfirmation(String passConfirmation) {
		this.passConfirmation = passConfirmation;
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
