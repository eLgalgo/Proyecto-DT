package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.ACCIONANALISTACONSTANCIA;
import com.exception.ServiciosException;

@Remote
public interface AccionBeanRemote {

	void addAccion(ACCIONANALISTACONSTANCIA reclamo) throws ServiciosException;

	List<ACCIONANALISTACONSTANCIA> listAllAccion() throws ServiciosException;
}
