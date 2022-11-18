package com.services;

import java.util.List;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.ANALISTA;
import com.entities.ESTUDIANTE;
import com.entities.EVENTO;
import com.entities.TUTOR;
import com.entities.USUARIO;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class EventoBean
 */
@Stateless
@LocalBean
public class EventoBean implements EventoBeanRemote {

	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public EventoBean() {
        // TODO Auto-generated constructor stub
    }

    @Override
	public void addEvento(EVENTO event) throws ServiciosException {
		try{
			em.persist(event);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo crear el analista");
		}
	}

	@Override
	public void editEvento(EVENTO event) throws ServiciosException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEvento(int documento) throws ServiciosException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EVENTO> listarEventosEstu(int doc) throws ServiciosException{
		TypedQuery<EVENTO> query = em.createQuery("SELECT e FROM EVENTO e INNER JOIN e.estudiantesConv t where t.documento= :doc",EVENTO.class).setParameter("doc", doc); 
		return query.getResultList();
	}
	
	@Override
	public List<EVENTO> listarAll() throws ServiciosException{
		TypedQuery<EVENTO> query = em.createQuery("SELECT u FROM EVENTO u",EVENTO.class); 
		return query.getResultList();
	}

	@Override
	public void asignEstToEvent(int idEst, int idEvent) throws ServiciosException{
		try{
			EVENTO r = em.find(EVENTO.class, idEvent);
			ESTUDIANTE es = em.find(ESTUDIANTE.class, idEst);
			
			List<ESTUDIANTE> listEsts = r.getEstudiantesConv();
			listEsts.add(es);
			r.setEstudiantesConv(listEsts);
			
			em.merge(r);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo actualizar el Evento");
		}
	}
	
	@Override
	public List<EVENTO> findEvento(int id) throws ServiciosException {
		TypedQuery<EVENTO> query = em.createQuery("SELECT u FROM EVENTO u WHERE u.id_evento = :id", EVENTO.class)
				.setParameter("id", id);
		return query.getResultList();
	}
}
