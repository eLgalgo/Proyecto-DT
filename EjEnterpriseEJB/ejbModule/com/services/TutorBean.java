package com.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import com.entities.TUTOR;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class TutorBean
 */
@Stateless
public class TutorBean implements TutorBeanRemote {
	
	@PersistenceContext
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public TutorBean() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public void addTutor(TUTOR user) throws ServiciosException {
		try{
			em.persist(user);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo crear el tutor");
		}
	}
	
	@Override
	public void editTutor(TUTOR user) throws ServiciosException {
		try{
			
			TUTOR user2 = em.find(TUTOR.class, user.getId_usuario());
			user2.setNombre(user.getNombre());
			user2.setApellido(user.getApellido());
			user2.setDocumento(user.getDocumento());
			user2.setMail(user.getMail());
			user2.setContrasena(user.getContrasena());
			user2.setDepartamento(user.getDepartamento());
			user2.setTelefono(user.getTelefono());
			user2.setMail_insti(user.getMail_insti());
			user2.setItr_s(user.getItr_s());
			user2.setArea(user.getArea());
			user2.setTipo(user.getTipo());
			user2.setEstado(user.getEstado());
			
			em.merge(user2);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo actualizar el usario");
		}
		
	}

}
