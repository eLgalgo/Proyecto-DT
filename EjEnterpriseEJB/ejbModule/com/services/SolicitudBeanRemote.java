package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.SOLICITUD;
import com.enums.EstadoSolicitud;
import com.exception.ServiciosException;

@Remote
public interface SolicitudBeanRemote {

	public void addSolicitud(SOLICITUD sol) throws ServiciosException;

	public void cambiarEstado(SOLICITUD sol, EstadoSolicitud estado) throws ServiciosException;
	
	public void editSolicitud(SOLICITUD sol) throws ServiciosException;

	public void deleteSolicitud(SOLICITUD sol) throws ServiciosException;
	
	public List<SOLICITUD> listarSolicitudEstu(int doc) throws ServiciosException;
	
	public List<SOLICITUD> listAll() throws ServiciosException;
	
	public List<SOLICITUD> findSol(int id) throws ServiciosException;
}
