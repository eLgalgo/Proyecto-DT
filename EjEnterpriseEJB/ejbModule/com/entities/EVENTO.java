package com.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

/**
 * Entity implementation class for Entity: Evento
 *
 */
@Entity
public class EVENTO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	//Atributos
	@Id
	@SequenceGenerator(name = "SEQ_ID_EVENTO", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ID_EVENTO")
	private int id_evento;
	@Column(nullable = false)
	private String titulo;
	@Column(nullable = false)
	private LocalDate fechaInicio;
	@Column(nullable = false)
	private LocalDate fechaFinal;
	@Column(nullable = false)
	private String informacion;
	
	@OneToOne
	@NotNull
	private TUTOR tutor;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<ESTUDIANTE> estudiantesConv;
	
	//Constructor
	public EVENTO() {
		super();
	}

	//Setters & Getters
	public int getId_evento() {
		return id_evento;
	}

	public void setId_evento(int id_evento) {
		this.id_evento = id_evento;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(LocalDate fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public String getInformacion() {
		return informacion;
	}

	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}

	public TUTOR getTutor() {
		return tutor;
	}

	public void setTutor(TUTOR tutor) {
		this.tutor = tutor;
	}

	public List<ESTUDIANTE> getEstudiantesConv() {
		return estudiantesConv;
	}

	public void setEstudiantesConv(List<ESTUDIANTE> estudiantesConv) {
		this.estudiantesConv = estudiantesConv;
	}
	
   
}
