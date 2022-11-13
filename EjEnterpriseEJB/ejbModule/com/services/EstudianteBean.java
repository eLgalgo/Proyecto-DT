package com.services;

import java.util.List;




import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.ESTUDIANTE;
import com.entities.USUARIO;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class AreaBean
 */
@Stateless
public class EstudianteBean implements EstudianteBeanRemote {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext
	private EntityManager em;
	
	
    public EstudianteBean() {
        // TODO Auto-generated constructor stub
    }
    
    

	@Override
	public List<USUARIO> listAllUsers() throws ServiciosException{
		TypedQuery<USUARIO> query = em.createQuery("SELECT m FROM ESTUDIANTE m",USUARIO.class); 
		return query.getResultList();
	}

	@Override
	public List<USUARIO> findUser(String email, String clave) throws ServiciosException{
		TypedQuery<USUARIO> query = em.createQuery("SELECT u FROM USUARIOS u WHERE u.email = :email and u.clave= '" +clave+"'",USUARIO.class).setParameter("email", email); 
		return query.getResultList();
	}
	
	@Override
	public List<USUARIO> findUser(String doc) throws ServiciosException{
		TypedQuery<USUARIO> query = em.createQuery("SELECT u FROM USUARIOS u WHERE u.documento = :doc",USUARIO.class).setParameter("doc", doc); 
		return query.getResultList();
	}

	@Override
	public void addStudent(ESTUDIANTE user) throws ServiciosException {
		try{
			em.persist(user);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo crear el estudiante");
		}
	}

	@Override
	public void deleteUser(String doc) throws ServiciosException{
		try{
			USUARIO a = this.findUser(doc).get(0);
			em.remove(a);
			em.flush();
		}catch(PersistenceException e){
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void editUser(USUARIO user) throws ServiciosException {
		try{
			System.out.println(user);
			
//			USUARIO user2 = em.find(USUARIO.class, user.getId());
//			user2.setNombre(user.getNombre());
//			user2.setApellido(user.getApellido());
//			user2.setEmail(user.getEmail());
//			user2.setClave(user.getClave());
//			user2.setRol(user.getRol());
//			
//			System.out.println(user2);
//			
//
//			em.merge(user2);
//			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo actualizar el usario");
		}
		
	}

	@Override
	public List<USUARIO> obtenerTodos(String filtro) {
		TypedQuery<USUARIO> query = em.createQuery("SELECT d FROM USUARIOS d WHERE d.nombre LIKE :nombre",USUARIO.class)
				.setParameter("nombre", filtro); 
		return query.getResultList();
	}
	
	public void asignRoltoUser(int idRol, int idUser) throws ServiciosException{
		try{
//			ROLES r = em.find(ROLES.class, idRol);
//			USUARIO user = em.find(USUARIO.class, idUser);
//			
//			user.setRol(r);
//
//			em.merge(user);
//			em.flush();
//			System.out.println("Se actualizo el rol del usuario");
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo actualizar el usuario");
		}
	}

}
