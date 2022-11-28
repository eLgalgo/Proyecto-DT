package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ITR
 *
 */
@Entity
public class ITR implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "SEQ_ID_ITR", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ID_ITR")
	private int id_itr;
	@Column(unique= true, nullable=false)
	private String nombre;
	@Column(nullable=false)
	private boolean estado;
	
	
	
	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre.toUpperCase();
	}



	public boolean isEstado() {
		return estado;
	}



	public void setEstado(boolean estado) {
		this.estado = estado;
	}



	public int getId_itr() {
		return id_itr;
	}



	public void setId_itr(int id_itr) {
		this.id_itr = id_itr;
	}

	@Override
	public String toString() {
		return nombre;
	}

	public ITR() {
		super();
	}
	
   
}
