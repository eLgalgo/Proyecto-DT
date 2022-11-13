package com.services;

import javax.ejb.Remote;

import com.entities.ANALISTA;
import com.entities.ESTUDIANTE;
import com.entities.USUARIO;
import com.exception.ServiciosException;

@Remote
public interface AnalistaBeanRemote {
	
	public void addAnalista(ANALISTA user) throws ServiciosException;

	void editAnalista(ANALISTA user) throws ServiciosException;
}
