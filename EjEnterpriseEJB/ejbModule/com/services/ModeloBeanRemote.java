package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.ACCION;
import com.entities.MODELOCONSTANCIA;
import com.exception.ServiciosException;

@Remote
public interface ModeloBeanRemote {

	void addMoldeo(MODELOCONSTANCIA reclamo) throws ServiciosException;

	List<MODELOCONSTANCIA> listAllModelo() throws ServiciosException;
	
	public void editModelo(MODELOCONSTANCIA sol) throws ServiciosException;
	
	public List<MODELOCONSTANCIA> findSol(int id) throws ServiciosException;
}
