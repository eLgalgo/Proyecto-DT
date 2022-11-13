package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.ITR;
import com.exception.ServiciosException;

@Remote
public interface ItrBeanRemote {

	void addItr(ITR itr) throws ServiciosException;

	List<ITR> listAllItr() throws ServiciosException;

}
