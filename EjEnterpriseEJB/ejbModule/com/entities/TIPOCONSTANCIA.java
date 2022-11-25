package com.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * Entity implementation class for Entity: MODELOCONSTANCIA
 *
 */
@Entity
public class TIPOCONSTANCIA implements Serializable {

	
	private static final long serialVersionUID = 1L;	
	public TIPOCONSTANCIA() {
		super();
	} 
	
	@Id
	@SequenceGenerator(name = "SEQ_ID_MODELO", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ID_MODELO")
	private int id_modelo;
	
	private String modelo;

	@Column(unique = true)
	private String tipo;
	
	private boolean estado;
	
	public int getId_modelo() {
		return id_modelo;
	}

	public void setId_modelo(int id_modelo) {
		this.id_modelo = id_modelo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
   
}
