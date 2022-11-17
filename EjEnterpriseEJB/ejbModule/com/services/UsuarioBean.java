package com.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.USUARIO;
import com.enums.Estado;
import com.exception.ServiciosException;

import org.hibernate.validator.internal.constraintvalidators.hv.ISBNValidator;

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
	public List<USUARIO> listAllUsers() throws ServiciosException {
		TypedQuery<USUARIO> query = em.createQuery("SELECT m FROM USUARIO m", USUARIO.class);
		return query.getResultList();
	}

	@Override
	public List<USUARIO> findUser(String mail_insti, String clave) throws ServiciosException {
		TypedQuery<USUARIO> query = em.createQuery(
				"SELECT u FROM USUARIO u WHERE u.mail_insti = :mail_insti and u.contrasena= '" + clave + "'",
				USUARIO.class).setParameter("mail_insti", mail_insti);
		return query.getResultList();
	}
	

	@Override
	public List<USUARIO> findUser(int doc) throws ServiciosException {
		TypedQuery<USUARIO> query = em.createQuery("SELECT u FROM USUARIO u WHERE u.documento = :doc", USUARIO.class)
				.setParameter("doc", doc);
		return query.getResultList();
	}

	@Override
	public void addUser(USUARIO user) throws ServiciosException {
		// TODO Auto-generated method stub
		try {
			em.persist(user);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo crear el usuario");
		}
	}

	@Override
	public void deleteUser(int doc) throws ServiciosException {
		try {
			USUARIO a = this.findUser(doc).get(0);
			em.remove(a);
			em.flush();
		} catch (PersistenceException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void editUser(USUARIO user) throws ServiciosException {
		try {
//			System.out.println(user);
//			
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
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo actualizar el usario");
		}

	}

	@Override
	public List<USUARIO> obtenerTodos(String filtro) {
		TypedQuery<USUARIO> query = em
				.createQuery("SELECT d FROM USUARIOS d WHERE d.nombre LIKE :nombre", USUARIO.class)
				.setParameter("nombre", filtro);
		return query.getResultList();
	}

	public void asignRoltoUser(int idRol, int idUser) throws ServiciosException {
		try {
//			ROLES r = em.find(ROLES.class, idRol);
//			USUARIOS user = em.find(USUARIOS.class, idUser);
//			
//			user.setRol(r);
//
//			em.merge(user);
//			em.flush();
//			System.out.println("Se actualizo el rol del usuario");
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo actualizar el usuario");
		}
	}

	@Override
	public void logicDelete(int doc) throws ServiciosException {
		List<USUARIO> usuarios = this.findUser(doc);
		usuarios.get(0).setEstado(Estado.ELIMINADO);
		em.merge(usuarios.get(0));
		em.flush();
	}

}
