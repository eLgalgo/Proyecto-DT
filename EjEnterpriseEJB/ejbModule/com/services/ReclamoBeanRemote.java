package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.RECLAMO;
import com.exception.ServiciosException;

@Remote
public interface ReclamoBeanRemote {


	void addReclamo(RECLAMO reclamo) throws ServiciosException;

	List<RECLAMO> listAllReclamo() throws ServiciosException;

}
