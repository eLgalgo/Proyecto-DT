package com.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.ACCIONANALISTACONSTANCIA;
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
	public void addAccion(ACCIONANALISTACONSTANCIA accionanalistaconstancia) throws ServiciosException {
		try{
			em.persist(accionanalistaconstancia);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo crear la accion");
		}
		
	}

	@Override
	public List<ACCIONANALISTACONSTANCIA> listAllAccion() throws ServiciosException {
		TypedQuery<ACCIONANALISTACONSTANCIA> query = em.createQuery("SELECT m FROM ACCION_ANALISTA_CONSTANCIA m",ACCIONANALISTACONSTANCIA.class); 
		return query.getResultList();
	}

}
