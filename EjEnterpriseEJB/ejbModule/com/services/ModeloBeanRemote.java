package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.ACCIONANALISTACONSTANCIA;
import com.entities.ITR;
import com.entities.TIPOCONSTANCIA;
import com.exception.ServiciosException;

@Remote
public interface ModeloBeanRemote {

	void addMoldeo(TIPOCONSTANCIA reclamo) throws ServiciosException;

	List<TIPOCONSTANCIA> listAllModelo() throws ServiciosException;
	
	public void editModelo(TIPOCONSTANCIA sol) throws ServiciosException;
	
	public List<TIPOCONSTANCIA> findSol(int id) throws ServiciosException;
	
	void logicDelete(String nombre) throws ServiciosException;
	
	public List<TIPOCONSTANCIA> findTipo(String nombre) throws ServiciosException;
	
	public void activarTipo(String nombre) throws ServiciosException;
}
