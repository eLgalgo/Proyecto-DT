package com.services;

import java.util.List;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.ACCION;
import com.entities.ITR;
import com.entities.TIPOCONSTANCIA;
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
	public void addMoldeo(TIPOCONSTANCIA modelo) throws ServiciosException {
		try{
			em.persist(modelo);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo crear el modelo");
		}
		
	}

	@Override
	public List<TIPOCONSTANCIA> listAllModelo() throws ServiciosException {
		TypedQuery<TIPOCONSTANCIA> query = em.createQuery("SELECT m FROM TIPOCONSTANCIA m",TIPOCONSTANCIA.class); 
		return query.getResultList();
	}
	
	@Override
	public void editModelo(TIPOCONSTANCIA sol) throws ServiciosException {
		// TODO Auto-generated method stub
		TIPOCONSTANCIA sol2 = em.find(TIPOCONSTANCIA.class, sol.getId_modelo());
		sol2.setModelo(sol.getModelo());
		sol2.setEstado(sol.isEstado());
		sol2.setTipo(sol.getTipo());
		em.merge(sol2);
		em.flush();
	}
	
	@Override
	public List<TIPOCONSTANCIA> findSol(int id) throws ServiciosException {
		try{
			TypedQuery<TIPOCONSTANCIA> query = em.createQuery(
					"SELECT u FROM TIPOCONSTANCIA u WHERE u.id_modelo = :id ",
					TIPOCONSTANCIA.class).setParameter("id", id);
			return query.getResultList();
		}catch(PersistenceException e){
			throw new ServiciosException("No se encontro ningun modelo");
		}
	}

	@Override
	public void logicDelete(String nombre) throws ServiciosException {
		List<TIPOCONSTANCIA> itrs = this.findTipo(nombre);
		itrs.get(0).setEstado(false);
		em.merge(itrs.get(0));
		em.flush();
	}
	
	@Override
	public void activarTipo(String nombre) throws ServiciosException {
		List<TIPOCONSTANCIA> itrs = this.findTipo(nombre);
		itrs.get(0).setEstado(true);
		em.merge(itrs.get(0));
		em.flush();
	}
	
	@Override
	public List<TIPOCONSTANCIA> findTipo(String tipo) throws ServiciosException {
		TypedQuery<TIPOCONSTANCIA> query = em.createQuery(
				"SELECT i FROM TIPOCONSTANCIA i WHERE i.tipo = :tipo",
				TIPOCONSTANCIA.class).setParameter("tipo", tipo);
		return query.getResultList();
	}

}
