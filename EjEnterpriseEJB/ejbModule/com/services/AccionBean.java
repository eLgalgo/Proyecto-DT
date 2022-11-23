package com.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.ACCION;
import com.entities.RECLAMO;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class AccionBean
 */
@Stateless
public class AccionBean implements AccionBeanRemote {

	@PersistenceContext
	private EntityManager em;
	
    public AccionBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addAccion(ACCION accion) throws ServiciosException {
		try{
			em.persist(accion);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo crear la accion");
		}
		
	}

	@Override
	public List<ACCION> listAllAccion() throws ServiciosException {
		TypedQuery<ACCION> query = em.createQuery("SELECT m FROM ACCION m",ACCION.class); 
		return query.getResultList();
	}

}
