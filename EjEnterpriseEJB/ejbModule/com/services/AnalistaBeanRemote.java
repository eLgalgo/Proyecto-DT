package com.services;

import javax.ejb.Remote;

import com.entities.ANALISTA;
import com.exception.ServiciosException;

@Remote
public interface AnalistaBeanRemote {
	
	public void addAnalista(ANALISTA user) throws ServiciosException;

	public void editAnalista(ANALISTA user) throws ServiciosException;

	public void deleteUsuario(int documento) throws ServiciosException;
	
}
