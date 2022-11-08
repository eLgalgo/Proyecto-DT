package com.services;

import java.util.List;



import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.FUNCIONALIDADES;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class MateriaBean
 */
@Stateless
public class FuncionalidadBean implements FuncionalidadBeanRemote {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	private EntityManager em;
	
    public FuncionalidadBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<FUNCIONALIDADES> listAllFuncionalidad() {
		TypedQuery<FUNCIONALIDADES> query = em.createQuery("SELECT m FROM FUNCIONALIDADES m",FUNCIONALIDADES.class); 
		return query.getResultList();
	}

	@Override
	public FUNCIONALIDADES findFuncById(int id) throws ServiciosException {
		FUNCIONALIDADES obj = em.find(FUNCIONALIDADES.class, id);
		if (obj == null)
			throw new ServiciosException("No existe Departamento con ID: " + id);
		return obj;
	}

	@Override
	public void addFuncionalidad(FUNCIONALIDADES material)throws ServiciosException {
		// TODO Auto-generated method stub
		try {
			em.persist(material);
			em.flush();
		}catch(PersistenceException e) {
			throw new ServiciosException("No se pudo crear el material");
		}
		
		
	}

	@Override
	public void deleteFuncionalidad(int id) throws ServiciosException {
		// TODO Auto-generated method stub
		try {
			FUNCIONALIDADES mat = em.find(FUNCIONALIDADES.class, id);
			em.remove(mat);
			em.flush();
		}catch(PersistenceException e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void editFuncionalidad(int id, String nombre)throws ServiciosException {
		try{
			FUNCIONALIDADES mat = this.findFuncById(id);
			String nombreAnterior = mat.getNombre();
			mat.setNombre(nombre);
			em.merge(mat);
			em.flush();
			System.out.println("Se ha actualizado el material con nombre anterior: "+ nombreAnterior + " por " + mat.getNombre());
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo actualizar el material");
		}
		
	}

}
