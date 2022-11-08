package com.services;

import java.util.ArrayList;
import java.util.List;



import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.FUNCIONALIDADES;
import com.entities.ROLES;
import com.entities.USUARIOS;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class SalonBean
 */
@Stateless
public class RolBean implements RolBeanRemote {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	private EntityManager em;
	
    public RolBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<ROLES> listAllRoles() {
		TypedQuery<ROLES> query = em.createQuery("SELECT d FROM ROLES d",ROLES.class); 
		return query.getResultList();
	}

	@Override
	public ROLES findRolById(int id) throws ServiciosException {
		ROLES obj = em.find(ROLES.class, id);
		if (obj == null)
			throw new ServiciosException("No existe Rol con ID: " + id);
		return obj;
	}

	@Override
	public void addRol(ROLES rol) throws ServiciosException {
        try {
            em.persist(rol);
            em.flush();
            System.out.println("Se ha agregado el rol: " + rol.getNombre());
        } catch (PersistenceException e) {
            throw new ServiciosException("No se pudo agregar el rol: " + rol.getNombre());
        }
    }

	@Override
	public void deleteRol(int idSalon) throws ServiciosException{
		try{
			ROLES s = em.find(ROLES.class, idSalon);
			em.remove(s);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo borrar el salon");
		}
	
	}

	@Override
	public void editRol(int idRol, String nombre, String desc) throws ServiciosException{
		try{
			ROLES rol = this.findRolById(idRol);
			rol.setNombre(nombre);
			rol.setDesc(desc);
			em.merge(rol);
			em.flush();
			System.out.println("Se ha actualizado el rol");
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo actualizar el rol");
		}
	}
	@Override
	public void asignFunctoRol(int idFunc, int idRol) throws ServiciosException{
		try{
			ROLES r = em.find(ROLES.class, idRol);
			FUNCIONALIDADES func = em.find(FUNCIONALIDADES.class, idFunc);
			
			List<FUNCIONALIDADES> listfunc = r.getFunc();
			listfunc.add(func);
			r.setFunc(listfunc);
			
			em.merge(r);
			em.flush();
			System.out.println("Se actualizo el rol del usuario");
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo actualizar el usuario");
		}
	}
	@Override
	public List<FUNCIONALIDADES> findFuncsById(int idRol) throws ServiciosException{
		try{
			ROLES r = em.find(ROLES.class, idRol);
			return r.getFunc();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo actualizar el usuario");
		}
	}
	@Override
	public List<FUNCIONALIDADES> findFuncs(int id_rol) throws ServiciosException  {
		TypedQuery<FUNCIONALIDADES> query = em.createQuery("SELECT d FROM ROLES_FUNCIONALIDADES d WHERE d.ROLES_ID_ROL = :id_rol",FUNCIONALIDADES.class)
				.setParameter("id_rol", id_rol); 
		return query.getResultList();
	}
}
