package com.entities;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.enums.TipoReclamo;


@Entity
public class RECLAMO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "SEQ_ID_RECLAMO", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ID_RECLAMO")
	private int id_reclamo;
	
	private String detalle;
	
	private String titulo;
	
	private LocalDate fecha;
	
	@Enumerated(value = EnumType.STRING)
	private TipoReclamo tipo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private ESTUDIANTE es;
	
	public TipoReclamo getTipo() {
		return tipo;
	}

	public void setTipo(TipoReclamo tipo) {
		this.tipo = tipo;
	}
	public int getId_reclamo() {
		return id_reclamo;
	}

	public void setId_reclamo(int id_reclamo) {
		this.id_reclamo = id_reclamo;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public ESTUDIANTE getEs() {
		return es;
	}

	public void setEs(ESTUDIANTE es) {
		this.es = es;
	}
	
	
	
}
