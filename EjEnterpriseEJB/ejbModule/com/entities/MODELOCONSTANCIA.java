package com.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

import com.enums.TipoConstancia;

/**
 * Entity implementation class for Entity: MODELOCONSTANCIA
 *
 */
@Entity
public class MODELOCONSTANCIA implements Serializable {

	
	private static final long serialVersionUID = 1L;	
	public MODELOCONSTANCIA() {
		super();
	} 
	
	@Id
	@SequenceGenerator(name = "SEQ_ID_MODELO", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ID_MODELO")
	private int id_modelo;
	
	private String modelo;
	
	@Enumerated(value = EnumType.STRING)
	private TipoConstancia tipo;
	
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

	public TipoConstancia getTipo() {
		return tipo;
	}

	public void setTipo(TipoConstancia tipo) {
		this.tipo = tipo;
	}
	
	
   
}
