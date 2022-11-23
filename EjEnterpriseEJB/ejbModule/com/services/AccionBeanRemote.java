package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.ACCION;
import com.exception.ServiciosException;

@Remote
public interface AccionBeanRemote {

	void addAccion(ACCION reclamo) throws ServiciosException;

	List<ACCION> listAllAccion() throws ServiciosException;
}
