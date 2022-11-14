package com.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;

import com.enums.Genero;
import com.enums.Localidad;

/**
 * Entity implementation class for Entity: ESTUDIANTE
 *
 */
@Entity
public class ESTUDIANTE extends USUARIO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String generacion;
	
	private LocalDate fec_nac;
	
	@Enumerated(value = EnumType.STRING)
	private Genero genero;
	
	private int semestre;
	
	public ESTUDIANTE() {
		super();
	}

	public String getGeneracion() {
		return generacion;
	}

	public void setGeneracion(String generacion) {
		this.generacion = generacion;
	}


	public LocalDate getFec_nac() {
		return fec_nac;
	}

	public void setFec_nac(LocalDate fec_nac) {
		this.fec_nac = fec_nac;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	

	
	
	
   
}
