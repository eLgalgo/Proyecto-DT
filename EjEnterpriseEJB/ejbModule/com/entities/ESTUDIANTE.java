package com.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: ESTUDIANTE
 *
 */
@Entity
public class ESTUDIANTE extends USUARIO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String generacion;
	
	private LocalDate fec_nac;
	


	
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





	

	
	
	
   
}
