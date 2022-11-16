package com.services;

import java.util.List;




import javax.ejb.Remote;
import javax.persistence.TypedQuery;

import com.entities.ESTUDIANTE;
import com.entities.USUARIO;
import com.exception.ServiciosException;

@Remote
public interface EstudianteBeanRemote {

	public List<USUARIO> listAllUsers() throws ServiciosException;
	
	public List<USUARIO> obtenerTodos(String filtr);
	
	public List<USUARIO> findUser(String email, String clave) throws ServiciosException;
	
	public List<ESTUDIANTE> findUser(int doc) throws ServiciosException;
	
	public void addStudent(ESTUDIANTE user) throws ServiciosException;
	
	public void deleteUser(int doc) throws ServiciosException;
	
	public void editEstudiante(ESTUDIANTE user) throws ServiciosException;
	
	public void asignRoltoUser(int idRol, int idUser)throws ServiciosException;
}
