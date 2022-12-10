package com.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: ESTUDIANTE
 *
 */
@Entity
public class ESTUDIANTE extends USUARIO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//Atributos
	@Column (nullable = false)
	private String generacion;
	
	//Construcotr
	public ESTUDIANTE() {
		super();
	}

	//Setters & Getters
	public String getGeneracion() {
		return generacion;
	}

	public void setGeneracion(String generacion) {
		this.generacion = generacion;
	}






	

	
	
	
   
}
