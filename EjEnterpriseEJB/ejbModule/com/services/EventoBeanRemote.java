package com.services;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Remote;

import com.entities.ANALISTA;
import com.entities.ESTUDIANTE;
import com.entities.EVENTO;
import com.exception.ServiciosException;

@Remote
public interface EventoBeanRemote {
	public void addEvento(EVENTO event) throws ServiciosException;

	public void editEvento(EVENTO event) throws ServiciosException;

	public void deleteEvento(int documento) throws ServiciosException;
	
	public List<EVENTO> listarEventosEstu(int es) throws ServiciosException;
	
	public List<EVENTO> listarAll() throws ServiciosException;
	
	public List<EVENTO> findEvento(LocalDate fechaFin) throws ServiciosException;
	
	public void asignEstToEvent(int idEst, int idEvent) throws ServiciosException;

	public List<EVENTO> findEvento(int id) throws ServiciosException;
}
