package com.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.ACCION;
import com.entities.MODELOCONSTANCIA;
import com.entities.SOLICITUD;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class ModeloBean
 */
@Stateless
@LocalBean
public class ModeloBean implements ModeloBeanRemote {

	@PersistenceContext
	private EntityManager em;
	
    public ModeloBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addMoldeo(MODELOCONSTANCIA modelo) throws ServiciosException {
		try{
			em.persist(modelo);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo crear el modelo");
		}
		
	}

	@Override
	public List<MODELOCONSTANCIA> listAllModelo() throws ServiciosException {
		TypedQuery<MODELOCONSTANCIA> query = em.createQuery("SELECT m FROM MODELOCONSTANCIA m",MODELOCONSTANCIA.class); 
		return query.getResultList();
	}
	
	@Override
	public void editModelo(MODELOCONSTANCIA sol) throws ServiciosException {
		// TODO Auto-generated method stub
		MODELOCONSTANCIA sol2 = em.find(MODELOCONSTANCIA.class, sol.getId_modelo());
		sol2.setModelo(sol.getModelo());
		em.merge(sol2);
		em.flush();
	}
	
	@Override
	public List<MODELOCONSTANCIA> findSol(int id) throws ServiciosException {
		try{
			TypedQuery<MODELOCONSTANCIA> query = em.createQuery(
					"SELECT u FROM MODELOCONSTANCIA u WHERE u.id_modelo = :id ",
					MODELOCONSTANCIA.class).setParameter("id", id);
			return query.getResultList();
		}catch(PersistenceException e){
			throw new ServiciosException("No se encontro ningun modelo");
		}
	}

}
