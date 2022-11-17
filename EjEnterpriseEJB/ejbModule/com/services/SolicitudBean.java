package com.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.EVENTO;
import com.entities.SOLICITUD;
import com.entities.USUARIO;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class SolicitudBean
 */
@Stateless
@LocalBean
public class SolicitudBean implements SolicitudBeanRemote {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	private EntityManager em;
	
    public SolicitudBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addSolicitud(SOLICITUD sol) throws ServiciosException {
		try{
			em.persist(sol);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo crear el tutor");
		}
	}

	@Override
	public void editSolicitud(SOLICITUD sol) throws ServiciosException {
		// TODO Auto-generated method stub
		SOLICITUD sol2 = em.find(SOLICITUD.class, sol.getId_solicitud());
		sol2.setEstado("EMITIDA");
		sol2.setAnalist(sol.getAnalist());
		em.merge(sol2);
		em.flush();
	}

	@Override
	public void deleteSolicitud(int documento) throws ServiciosException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<SOLICITUD> listarSolicitudEstu(int doc) throws ServiciosException{
		TypedQuery<SOLICITUD> query = em.createQuery("SELECT e FROM SOLICITUD e INNER JOIN e.estSol t where t.documento= :doc",SOLICITUD.class).setParameter("doc", doc); 
		return query.getResultList();
	}
	
	@Override
	public List<SOLICITUD> listAll() throws ServiciosException{
		TypedQuery<SOLICITUD> query = em.createQuery("SELECT e FROM SOLICITUD e",SOLICITUD.class); 
		return query.getResultList();
	}
	
	@Override
	public List<SOLICITUD> findSol(int id) throws ServiciosException {
		try{
			TypedQuery<SOLICITUD> query = em.createQuery(
					"SELECT u FROM SOLICITUD u WHERE u.id_solicitud = :id ",
					SOLICITUD.class).setParameter("id", id);
			return query.getResultList();
		}catch(PersistenceException e){
			throw new ServiciosException("No se encontro ninguna solicitud");
		}
	}

}
