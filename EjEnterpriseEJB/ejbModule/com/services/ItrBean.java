package com.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.ITR;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class ItrBean
 */
@Stateless
@LocalBean
public class ItrBean implements ItrBeanRemote {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public void addItr(ITR itr) throws ServiciosException {
		try{
			em.persist(itr);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo crear el ITR");
		}
	}
	
	@Override
	public List<ITR> listAllItrs() throws ServiciosException {
		TypedQuery<ITR> query = em.createQuery("SELECT i FROM ITR i", ITR.class);
		return query.getResultList();
	}

	@Override
	public List<ITR> findItr(String nombre) throws ServiciosException {
		TypedQuery<ITR> query = em.createQuery(
				"SELECT i FROM ITR i WHERE i.nombre = :nombre",
				ITR.class).setParameter("nombre", nombre);
		return query.getResultList();
	}
	
	@Override
	public List<ITR> findItr(int id) throws ServiciosException {
		TypedQuery<ITR> query = em.createQuery(
				"SELECT i FROM ITR i WHERE i.id_itr = :id",
				ITR.class).setParameter("id", id);
		return query.getResultList();
	}


	@Override
	public void editItr(ITR itr, String nombre) throws ServiciosException {
		try{
			ITR itr2 = em.find(ITR.class, itr.getId_itr());
			itr2.setNombre(nombre);
			em.merge(itr2);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo modificar ITR");
		}
	}

	@Override
	public void activeItr(ITR itr, boolean estado) throws ServiciosException{
		ITR itr2 = em.find(ITR.class, itr.getId_itr());
		itr2.setEstado(estado);
		em.merge(itr2);
		em.flush();	
	}
	
	@Override
	public List<ITR> findAll(boolean estado) {
		TypedQuery<ITR> query = em
				.createQuery("SELECT i FROM ITR i WHERE i.estado = :estado", ITR.class)
				.setParameter("estado", estado);
		return query.getResultList();
	}

	@Override
	public void logicDelete(String nombre) throws ServiciosException {
		List<ITR> itrs = this.findItr(nombre);
		itrs.get(0).setEstado(false);
		em.merge(itrs.get(0));
		em.flush();
	}
	
	@Override
	public void logicDelete(int id) throws ServiciosException {
		List<ITR> itrs = this.findItr(id);
		itrs.get(0).setEstado(false);
		em.merge(itrs.get(0));
		em.flush();
	}

}
