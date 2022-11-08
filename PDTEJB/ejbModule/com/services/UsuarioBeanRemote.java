package com.services;

import java.util.List;



import javax.ejb.Remote;
import javax.persistence.TypedQuery;

import com.entities.ROLES;
import com.entities.USUARIOS;
import com.exception.ServiciosException;

@Remote
public interface UsuarioBeanRemote {

	public List<USUARIOS> listAllUsers() throws ServiciosException;
	
	public List<USUARIOS> obtenerTodos(String filtr);
	
	public List<USUARIOS> findUser(String email, String clave) throws ServiciosException;
	
	public List<USUARIOS> findUser(String doc) throws ServiciosException;
	
	public void addUser(USUARIOS user) throws ServiciosException;
	
	public void deleteUser(String doc) throws ServiciosException;
	
	public void editUser(USUARIOS user) throws ServiciosException;
	
	public void asignRoltoUser(int idRol, int idUser)throws ServiciosException;
}
