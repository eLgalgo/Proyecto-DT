package com.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: FUNCIONALIDADES
 *
 */
@Entity
public class FUNCIONALIDADES implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
    @SequenceGenerator(name="SEQ_ID_FUNCIONALIDAD",initialValue=1, allocationSize=1)
    @GeneratedValue(strategy= GenerationType.AUTO, generator="SEQ_ID_FUNCIONALIDAD")
    private int id_func;
	
	@Column(length=50)
	private String nombre;
	
	@Column(length=50)
	private String descripcion;
	
	public FUNCIONALIDADES() {
		super();
	}

	public int getId() {
		return id_func;
	}

	public void setId(int id) {
		this.id_func = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDesc() {
		return descripcion;
	}

	public void setDesc(String desc) {
		this.descripcion = desc;
	}

	@Override
	public String toString() {
		return "FUNCIONALIDADES [id_func=" + id_func + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	} 
	
	
}
