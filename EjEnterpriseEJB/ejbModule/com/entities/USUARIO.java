package com.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import com.enums.Departamento;
import com.enums.Estado;

/**
 * Entity implementation class for Entity: USUARIOS
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class USUARIO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SEQ_ID_USUARIO", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ID_USUARIO")
	private int id_usuario;
	@Column (unique = true)
	private int documento;

	private String nombre;

	private String apellido;

	private String telefono;
	@Column (unique = true)
	private String mail;

	@Column (unique = true)
	private String mail_insti;

	private String contrasena;

	private LocalDate fecha_nac;

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
		this.localidad = localidad.toUpperCase();

	}

	public LocalDate getFechaNac() {
		return fecha_nac;

	}

	public void setFechaNac(LocalDate fechaNac) {
		
		this.fecha_nac = fechaNac;
	}

	public String getMail_insti() {
		return mail_insti;

	}

	public void setMail_insti(String mail_insti) {
		this.mail_insti = mail_insti.toUpperCase();

	}

	@Override
	public String toString() {
		return id_usuario + " " + documento + " " + nombre + " " + apellido + " " + telefono + " " + mail + " "
				+ mail_insti + " " + fecha_nac + " " + departamento + " " + estado + " " + localidad + " " + itr_s;
	}

}
