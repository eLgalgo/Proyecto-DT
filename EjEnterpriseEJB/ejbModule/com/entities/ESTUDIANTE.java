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
	
	@Column (nullable = false)
	private String generacion;
	


	
	public ESTUDIANTE() {
		super();
	}

	public String getGeneracion() {
		return generacion;
	}

	public void setGeneracion(String generacion) {
		this.generacion = generacion;
	}






	

	
	
	
   
}
