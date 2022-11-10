package com.services;

import java.util.List;


import javax.ejb.Remote;

import com.entities.FUNCIONALIDADES;
import com.entities.ROLES;

import com.exception.ServiciosException;

@Remote
public interface RolBeanRemote {
	
	public List<ROLES> listAllRoles();

	public ROLES findRolById(int id) throws ServiciosException  ;
	
	public List<FUNCIONALIDADES> findFuncsById(int id) throws ServiciosException  ;
	
	public List<FUNCIONALIDADES> findFuncs(int id) throws ServiciosException  ;

	public void addRol(ROLES r) throws ServiciosException;

	public void deleteRol(int idRol) throws ServiciosException;

	public void editRol(int idRol, String nombre, String desc) throws ServiciosException;
	
	public void asignFunctoRol(int idRol, int idFunc) throws ServiciosException;

}
