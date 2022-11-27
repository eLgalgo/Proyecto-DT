package com.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import com.entities.ANALISTA;
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
	public void editAnalista(ANALISTA user) throws ServiciosException{
    	try{
			
			ANALISTA user2 = em.find(ANALISTA.class, user.getId_usuario());
			user2.setNombre(user.getNombre());
			user2.setApellido(user.getApellido());
			user2.setDocumento(user.getDocumento());
			user2.setMail(user.getMail());
			user2.setContrasena(user.getContrasena());
			user2.setDepartamento(user.getDepartamento());
			user2.setTelefono(user.getTelefono());
			user2.setMail_insti(user.getMail_insti());
			user2.setItr(user.getItr());
			user2.setLocalidad(user.getLocalidad());
			user2.setEstado(user.getEstado());
			user2.setFechaNac(user.getFechaNac());
			
			em.merge(user2);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo actualizar el analista");
		}
    }

	@Override
	public void deleteUsuario(int documento) throws ServiciosException {
		// TODO Auto-generated method stub
		
	}

}
