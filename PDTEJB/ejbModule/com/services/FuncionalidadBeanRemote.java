package com.services;

import java.util.List;


import javax.ejb.Remote;

import com.entities.FUNCIONALIDADES;
import com.exception.ServiciosException;

@Remote
public interface FuncionalidadBeanRemote {

	public List<FUNCIONALIDADES> listAllFuncionalidad();

	public FUNCIONALIDADES findFuncById(int id) throws ServiciosException;

	public void addFuncionalidad(FUNCIONALIDADES material) throws ServiciosException;

	public void deleteFuncionalidad(int id) throws ServiciosException;

	public void editFuncionalidad(int id, String nombre) throws ServiciosException;

}
