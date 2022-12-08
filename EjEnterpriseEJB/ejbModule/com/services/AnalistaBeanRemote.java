package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.ANALISTA;
import com.exception.ServiciosException;

@Remote
public interface AnalistaBeanRemote {
	
	public void addAnalista(ANALISTA user) throws ServiciosException;

	public void editAnalista(ANALISTA user) throws ServiciosException;

	List<ANALISTA> findUser(int doc) throws ServiciosException;

	List<ANALISTA> findUser(String email, String clave) throws ServiciosException;

	void logicDelete(int doc) throws ServiciosException;
	
}
