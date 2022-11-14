package com.services;

import java.util.List;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.ESTUDIANTE;
import com.entities.ITR;
import com.entities.USUARIO;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class ItrBean
 */
@Stateless
@LocalBean
public class ItrBean implements ItrBeanRemote {

	@PersistenceContext
	private EntityManager em;
	
    public ItrBean() {
        // TODO Auto-generated constructor stub
    }

    @Override
	public void addItr(ITR itr) throws ServiciosException {
		try{
			em.persist(itr);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo crear el itr");
		}
	}
    
    @Override
	public List<ITR> listAllItr() throws ServiciosException{
		TypedQuery<ITR> query = em.createQuery("SELECT m FROM ITR m",ITR.class); 
		return query.getResultList();
	}
}
