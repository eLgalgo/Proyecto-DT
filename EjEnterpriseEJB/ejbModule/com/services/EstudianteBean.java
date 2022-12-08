package com.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.ANALISTA;
import com.entities.ESTUDIANTE;
import com.entities.USUARIO;
import com.enums.EstadoUsuario;
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
	public List<String> listAllGen() throws ServiciosException{
		List<String> query = em.createQuery("SELECT DISTINCT m.generacion FROM ESTUDIANTE m").getResultList(); 
		return query;
	}

	@Override
	public List<ESTUDIANTE> findUser(String email, String clave) throws ServiciosException{
		TypedQuery<ESTUDIANTE> query = em.createQuery("SELECT u FROM ESTUDIANTE u WHERE u.mail_insti = :email and u.contrasena= '" +clave+"'",ESTUDIANTE.class).setParameter("email", email); 
		return query.getResultList();
	}
	
	@Override
	public List<ESTUDIANTE> findUser(int doc) throws ServiciosException{
		TypedQuery<ESTUDIANTE> query = em.createQuery("SELECT u FROM ESTUDIANTE u WHERE u.documento = :doc",ESTUDIANTE.class).setParameter("doc", doc); 
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
	public void deleteUser(int doc) throws ServiciosException{
		try{
			USUARIO a = this.findUser(doc).get(0);
			em.remove(a);
			em.flush();
		}catch(PersistenceException e){
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void editEstudiante(ESTUDIANTE user) throws ServiciosException {
		try{
			
			ESTUDIANTE user2 = em.find(ESTUDIANTE.class, user.getId_usuario());
			user2.setNombre(user.getNombre());
			user2.setApellido(user.getApellido());
			user2.setDocumento(user.getDocumento());
			user2.setMail(user.getMail());
			user2.setContrasena(user.getContrasena());
			user2.setDepartamento(user.getDepartamento());
			user2.setLocalidad(user.getLocalidad());
			user2.setTelefono(user.getTelefono());
			user2.setMail_insti(user.getMail_insti());
			user2.setGeneracion(user.getGeneracion());
			user2.setItr(user.getItr());
			user2.setEstado(user.getEstado());
			user2.setFechaNac(user.getFechaNac());
			
			em.merge(user2);
			em.flush();
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
	
	@Override
	public void logicDelete(int doc) throws ServiciosException {
		List<ESTUDIANTE> usuarios = this.findUser(doc);
		usuarios.get(0).setEstado(EstadoUsuario.ELIMINADO);
		em.merge(usuarios.get(0));
		em.flush();
	}

}
