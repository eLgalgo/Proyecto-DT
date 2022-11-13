package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ESTUDIANTE
 *
 */
@Entity
public class TUTOR extends USUARIO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String area;
	
	private String tipo;
	
	
	public TUTOR() {
		super();
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
	
   
}
