package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.enums.RolTutor;

/**
 * Entity implementation class for Entity: ESTUDIANTE
 *
 */
@Entity
public class TUTOR extends USUARIO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String area;
	
	private RolTutor tipo;
	
	
	public TUTOR() {
		super();
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public RolTutor getTipo() {
		return tipo;
	}


	public void setTipo(RolTutor tipo) {
		this.tipo = tipo;
	}

	
	
   
}
