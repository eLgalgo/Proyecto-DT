package com.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Entity implementation class for Entity: ACCION
 *
 */
@Entity
public class ACCIONANALISTACONSTANCIA implements Serializable {

	
	private static final long serialVersionUID = 1L;
	//Atributos
	@Id
	@SequenceGenerator(name = "SEQ_ID_ACCION", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ID_ACCION")
	private int id_accion;
	
	@Column(nullable = false)
	private LocalDate fecha;

	@Column(nullable = false)
	private String detalle;
	
	@ManyToOne
	@NotNull
	private ANALISTA analista;
	
	@OneToOne
	@NotNull
	private SOLICITUD solicitud;
	
	//Constructor
	
	public ACCIONANALISTACONSTANCIA() {
		super();
	}

	//Setters & Getters
	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public String getDetalle() {
		return detalle;
	}


	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}


	public ANALISTA getAnalista() {
		return analista;
	}


	public void setAnalista(ANALISTA analista) {
		this.analista = analista;
	}


	public int getId_accion() {
		return id_accion;
	}


	public void setId_accion(int id_accion) {
		this.id_accion = id_accion;
	}


	public SOLICITUD getSolicitud() {
		return solicitud;
	}


	public void setSolicitud(SOLICITUD solicitud) {
		this.solicitud = solicitud;
	} 
	
	
   
}
