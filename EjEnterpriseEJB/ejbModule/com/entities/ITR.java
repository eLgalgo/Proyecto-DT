package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.enums.Departamento;

/**
 * Entity implementation class for Entity: ITR
 *
 */
@Entity
public class ITR implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @SequenceGenerator(name="SEQ_ID_ITR",initialValue=1, allocationSize=1)
    @GeneratedValue(strategy= GenerationType.AUTO, generator="SEQ_ID_ITR")
	private int id;
	
	private String nombre;
	
	@Enumerated(value = EnumType.STRING)
	private Departamento departamento;
	
	public ITR() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	} 
	
	
   
}
