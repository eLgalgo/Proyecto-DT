package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.ITR;
import com.entities.USUARIO;
import com.exception.ServiciosException;

@Remote
public interface ItrBeanRemote {

	List<ITR> listAllItrs() throws ServiciosException;
	
	public void addItr(ITR itr) throws ServiciosException;

	List<ITR> findItr(String nombre) throws ServiciosException;

	List<ITR> findItr(int id) throws ServiciosException;

	public void editItr(ITR itr, String nombre) throws ServiciosException;

	List<ITR> findAll(boolean estado);

	void logicDelete(String nombre) throws ServiciosException;

	void logicDelete(int id) throws ServiciosException;

}
