package com.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import com.entities.ANALISTA;
import com.entities.TUTOR;
import com.entities.USUARIO;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class AnalistaBean
 */
@Stateless
public class AnalistaBean implements AnalistaBeanRemote {

	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public AnalistaBean() {
        // TODO Auto-generated constructor stub
    }

    @Override
	public void addAnalista(ANALISTA user) throws ServiciosException {
		try{
			em.persist(user);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo crear el analista");
		}
		
	}
    
    @Override
	public void editUser(ANALISTA user) throws ServiciosException{
    	try{
			
			ANALISTA user2 = em.find(ANALISTA.class, user.getId_usuario());
			user2.setNombre(user.getNombre());
			user2.setApellido(user.getApellido());
			user2.setMail(user.getMail());
			user2.setDepartamento(user.getDepartamento());
			user2.setTelefono(user.getTelefono());
			
			em.merge(user2);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo actualizar el usario");
		}
    }
}
