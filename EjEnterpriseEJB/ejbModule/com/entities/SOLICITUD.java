package com.entities;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.*;

import com.enums.TipoConstancia;


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
	
	@Enumerated(value = EnumType.STRING)
	private TipoConstancia tipo;
	
	@OneToOne
	private EVENTO eventoAsis;
	
	private String infoAdj;
	
	private String estado;
	
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

	public TipoConstancia getTipo() {
		return tipo;
	}

	public void setTipo(TipoConstancia tipo) {
		this.tipo = tipo;
	}

	public String getInfoAdj() {
		return infoAdj;
	}

	public void setInfoAdj(String infoAdj) {
		this.infoAdj = infoAdj;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
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
