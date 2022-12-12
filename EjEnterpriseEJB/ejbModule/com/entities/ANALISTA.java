package com.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ESTUDIANTE
 *
 */
@Entity
public class ANALISTA extends USUARIO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//Atributos
	@Column(nullable = false)
	private boolean dios = false;
	
	//Constructor
	public ANALISTA() {
		super();
	}
	
	//Setters & Getters
	public boolean getDios() {
		return dios;
	}

	public void setDios(boolean dios) {
		this.dios = dios;
	}
	
   
}
