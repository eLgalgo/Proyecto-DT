package com.entities;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.enums.Departamento;
import com.enums.Estado;
import com.enums.Localidad;

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
	
	private Date fechaNac;
	
	@Enumerated(value = EnumType.STRING)
	private Departamento departamento;
	
	@Enumerated(value = EnumType.STRING)
	private Estado estado;
	
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	private String localidad;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<ITR> itr_s;
	
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
		this.nombre = nombre.toUpperCase();
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido.toUpperCase();
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
		this.mail = mail.toUpperCase();
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

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<ITR> getItr_s() {
		return itr_s;
	}

	public void setItr_s(List<ITR> itr_s) {
		this.itr_s = itr_s;
	}

	public String getLocalidad() {
		return localidad;
		
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
		
	}

	public Date getFechaNac() {
		return fechaNac;
		
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
		
	}

	@Override
	public String toString() {
		return "USUARIO [id_usuario=" + id_usuario + ", documento=" + documento + ", nombre=" + nombre + ", apellido="
				+ apellido + ", telefono=" + telefono + ", mail=" + mail + ", nom_usuario=" + nom_usuario
				+ ", fechaNac=" + fechaNac + ", departamento=" + departamento + ", estado=" + estado + ", localidad="
				+ localidad + ", itr_s=" + itr_s + "]";
	}

	
	
	
}
