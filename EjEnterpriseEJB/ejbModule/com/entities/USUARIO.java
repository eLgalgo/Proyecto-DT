package com.entities;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: USUARIOS
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class USUARIO implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
    @SequenceGenerator(name="SEQ_ID_USUARIO",initialValue=1, allocationSize=1)
    @GeneratedValue(strategy= GenerationType.AUTO, generator="SEQ_ID_USUARIO")
    private int id_usuario;
	
	private int documento;
	
	private String nombre;
	
	private String apellido;

	private String telefono;
	
	private String mail;
	
	private String nom_usuario;
	
	private String contrasena;
	
	private String departamento;
	
	public USUARIO() {
		super();
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNom_usuario() {
		return nom_usuario;
	}

	public void setNom_usuario(String nom_usuario) {
		this.nom_usuario = nom_usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	
	
	
}
