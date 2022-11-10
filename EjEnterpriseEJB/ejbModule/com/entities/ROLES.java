package com.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ROLES
 *
 */
@Entity
public class ROLES implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
    @SequenceGenerator(name="SEQ_ID_ROL",initialValue=1, allocationSize=1)
    @GeneratedValue(strategy= GenerationType.AUTO, generator="SEQ_ID_ROL")
    private int id_rol;
	
	@Column(length=50)
	private String nombre;
	
	@Column(length=100)
	private String descripcion;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<FUNCIONALIDADES> func;
	
	public ROLES() {
		super();
	}
	
	

	public ROLES(String nombre, String descripcion, List<FUNCIONALIDADES> func) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.func = func;
	}



	public int getId() {
		return id_rol;
	}

	public void setId(int id) {
		this.id_rol = id;
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

	public List<FUNCIONALIDADES> getFunc() {
		return func;
	}

	public void setFunc(List<FUNCIONALIDADES> func) {
		this.func = func;
	}



	@Override
	public String toString() {
		return "ROLES [id_rol=" + id_rol + ", nombre=" + nombre + ", descripcion=" + descripcion + ", func=" + func
				+ "]";
	}
	
	
}
