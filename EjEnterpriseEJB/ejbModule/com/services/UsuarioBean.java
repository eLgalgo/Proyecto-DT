package com.services;

import java.util.List;



import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.ROLES;
import com.entities.USUARIOS;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class AreaBean
 */
@Stateless
public class UsuarioBean implements UsuarioBeanRemote {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext
	private EntityManager em;
	
	
    public UsuarioBean() {
        // TODO Auto-generated constructor stub
    }
    
    

	@Override
	public List<USUARIOS> listAllUsers() throws ServiciosException{
		TypedQuery<USUARIOS> query = em.createQuery("SELECT m FROM USUARIOS m",USUARIOS.class); 
		return query.getResultList();
	}

	@Override
	public List<USUARIOS> findUser(String email, String clave) throws ServiciosException{
		TypedQuery<USUARIOS> query = em.createQuery("SELECT u FROM USUARIOS u WHERE u.email = :email and u.clave= '" +clave+"'",USUARIOS.class).setParameter("email", email); 
		return query.getResultList();
	}
	
	@Override
	public List<USUARIOS> findUser(String doc) throws ServiciosException{
		TypedQuery<USUARIOS> query = em.createQuery("SELECT u FROM USUARIOS u WHERE u.documento = :doc",USUARIOS.class).setParameter("doc", doc); 
		return query.getResultList();
	}

	@Override
	public void addUser(USUARIOS user) throws ServiciosException {
		// TODO Auto-generated method stub
		try{
			em.persist(user);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo crear el usuario");
		}
	}

	@Override
	public void deleteUser(String doc) throws ServiciosException{
		try{
			USUARIOS a = this.findUser(doc).get(0);
			em.remove(a);
			em.flush();
		}catch(PersistenceException e){
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void editUser(USUARIOS user) throws ServiciosException {
		try{
			System.out.println(user);
			
			USUARIOS user2 = em.find(USUARIOS.class, user.getId());
			user2.setNombre(user.getNombre());
			user2.setApellido(user.getApellido());
			user2.setEmail(user.getEmail());
			user2.setClave(user.getClave());
			user2.setRol(user.getRol());
			
			System.out.println(user2);
			

			em.merge(user2);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo actualizar el usario");
		}
		
	}

	@Override
	public List<USUARIOS> obtenerTodos(String filtro) {
		TypedQuery<USUARIOS> query = em.createQuery("SELECT d FROM USUARIOS d WHERE d.nombre LIKE :nombre",USUARIOS.class)
				.setParameter("nombre", filtro); 
		return query.getResultList();
	}
	
	public void asignRoltoUser(int idRol, int idUser) throws ServiciosException{
		try{
			ROLES r = em.find(ROLES.class, idRol);
			USUARIOS user = em.find(USUARIOS.class, idUser);
			
			user.setRol(r);

			em.merge(user);
			em.flush();
			System.out.println("Se actualizo el rol del usuario");
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo actualizar el usuario");
		}
	}

}
