package com.services;

import java.util.List;




import javax.ejb.Remote;
import javax.persistence.TypedQuery;

import com.entities.USUARIO;
import com.exception.ServiciosException;

@Remote
public interface UsuarioBeanRemote {

	public List<USUARIO> listAllUsers() throws ServiciosException;
	
	public List<USUARIO> obtenerTodos(String filtr);
	
	public List<USUARIO> findUser(String email, String clave) throws ServiciosException;
	
	public List<USUARIO> findUser(int doc) throws ServiciosException;
	
	public void addUser(USUARIO user) throws ServiciosException;
	
	public void deleteUser(int doc) throws ServiciosException;
	
	public void editUser(USUARIO user) throws ServiciosException;
	
	public void logicDelete(int doc) throws ServiciosException;

	List<USUARIO> findUserByNom(String nombre, String apellido) throws ServiciosException;
}
