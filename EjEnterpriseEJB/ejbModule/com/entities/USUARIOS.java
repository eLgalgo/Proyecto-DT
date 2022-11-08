package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: USUARIOS
 *
 */
@Entity
public class USUARIOS implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
    @SequenceGenerator(name="SEQ_ID_USUARIO",initialValue=1, allocationSize=1)
    @GeneratedValue(strategy= GenerationType.AUTO, generator="SEQ_ID_USUARIO")
    private int id;
	
	@Column(length=30)
	private String nombre;
	
	@Column(length=30)
	private String apellido;
	
	@Column(length=20, unique = true)
	private String documento;
	
	@Column(length=50)
	private String clave;
	
	@OneToOne
	private ROLES Rol;
	
	@Column(length=50, unique = true)
	private String email;
	
	public USUARIOS() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public ROLES getRol() {
		return Rol;
	}

	public void setRol(ROLES rol) {
		Rol = rol;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "USUARIOS [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", documento=" + documento
				+ ", clave=" + clave + ", Rol=" + Rol + ", email=" + email + "]";
	}
	
	
	
   
}
