package com.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import com.entities.RECLAMO;
import com.exception.ServiciosException;


/**
 * Session Bean implementation class ReclamoBean
 */
@Stateless
public class ReclamoBean implements ReclamoBeanRemote {
	
	@PersistenceContext
	private EntityManager em;
   
	public ReclamoBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addReclamo(RECLAMO reclamo) throws ServiciosException {
		try{
			em.persist(reclamo);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo crear el reclamo");
		}
	}
    
    @Override
	public List<RECLAMO> listAllReclamo() throws ServiciosException{
		TypedQuery<RECLAMO> query = em.createQuery("SELECT m FROM RECLAMO m",RECLAMO.class); 
		return query.getResultList();
	}

}

