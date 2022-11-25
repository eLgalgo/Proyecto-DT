package com.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.enums.EstadoSolicitud;


/**
 * Entity implementation class for Entity: SOLICITUD
 *
 */
@Entity
public class SOLICITUD implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "SEQ_ID_SOLICITUD", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ID_SOLICITUD")
	private int id_solicitud;
	
	private Date fecha;
	
	@ManyToOne
	private TIPOCONSTANCIA tipo;
	
	@OneToOne
	private EVENTO eventoAsis;
	
	private String infoAdj;
	
	@Enumerated(value = EnumType.STRING)
	private EstadoSolicitud estado;
	
	@OneToOne
	private ESTUDIANTE estSol;
	
	@OneToOne
	private ANALISTA analist;
	
	public SOLICITUD() {
		super();
	}
	
	public int getId_solicitud() {
		return id_solicitud;
	}

	public void setId_solicitud(int id_solicitud) {
		this.id_solicitud = id_solicitud;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public TIPOCONSTANCIA getTipo() {
		return tipo;
	}

	public void setTipo(TIPOCONSTANCIA tipo) {
		this.tipo = tipo;
	}

	public String getInfoAdj() {
		return infoAdj;
	}

	public void setInfoAdj(String infoAdj) {
		this.infoAdj = infoAdj;
	}

	public EstadoSolicitud getEstado() {
		return estado;
	}

	public void setEstado(EstadoSolicitud estado) {
		this.estado = estado;
	}

	public EVENTO getEventoAsis() {
		return eventoAsis;
	}

	public void setEventoAsis(EVENTO eventoAsis) {
		this.eventoAsis = eventoAsis;
	}

	public ESTUDIANTE getEstSol() {
		return estSol;
	}

	public void setEstSol(ESTUDIANTE estSol) {
		this.estSol = estSol;
	}

	public ANALISTA getAnalist() {
		return analist;
	}

	public void setAnalist(ANALISTA analist) {
		this.analist = analist;
	}
	
	
	
   
}
