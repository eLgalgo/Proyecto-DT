package com.services;

import javax.ejb.Remote;
import javax.persistence.PersistenceException;

import com.entities.ESTUDIANTE;
import com.entities.TUTOR;
import com.exception.ServiciosException;

@Remote
public interface TutorBeanRemote {

	
	public void addTutor(TUTOR user) throws ServiciosException;

	void editTutor(TUTOR user) throws ServiciosException;
}
