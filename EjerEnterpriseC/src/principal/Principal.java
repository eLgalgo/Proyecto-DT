package principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;


import javax.naming.NamingException;
import javax.swing.JOptionPane;

import com.entities.FUNCIONALIDADES;
import com.entities.ROLES;
import com.entities.USUARIOS;
import com.exception.ServiciosException;
import com.gui.GUI;
import com.gui.GUser;
import com.gui.Login;
import com.services.FuncionalidadBeanRemote;
import com.services.RolBeanRemote;
import com.services.UsuarioBeanRemote;

public class Principal{
	
	public static void main(String[] args) throws NamingException, ServiciosException {
		// TODO Auto-generated method stub
		
		RolBeanRemote rolBean = (RolBeanRemote)
				//Nombre de EJB Project/NombreBean!NombrePaqueteServicios.NombreDeBeanRemote del Bean inicial
				InitialContext.doLookup("EjEnterpriseEJB/RolBean!com.services.RolBeanRemote");
		
		UsuarioBeanRemote userBean = (UsuarioBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/UsuarioBean!com.services.UsuarioBeanRemote");
		
		FuncionalidadBeanRemote funcBean = (FuncionalidadBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/FuncionalidadBean!com.services.FuncionalidadBeanRemote");
		
		Login login = new Login();
		login.getFrame().setVisible(true);
		
		USUARIOS user1 = new USUARIOS();
		user1.setNombre("Cristofer");
		user1.setApellido("Cabrera");
		user1.setDocumento("53158941");
		user1.setEmail("c");
		user1.setClave("c");
		
		userBean.addUser(user1);
		
		List<USUARIOS> user1DB = userBean.findUser(user1.getEmail(), user1.getClave());
		
		FUNCIONALIDADES func1 = new FUNCIONALIDADES();
		func1.setNombre("ABM");
		func1.setDesc("ABM de Usuario");
		funcBean.addFuncionalidad(func1);
		
		FUNCIONALIDADES func2 = new FUNCIONALIDADES();
		func2.setNombre("Listado de Roles");
		func2.setDesc("Listado de Roles");
		funcBean.addFuncionalidad(func2);
		
		FUNCIONALIDADES func3 = new FUNCIONALIDADES();
		func3.setNombre("Asignar Funcionalidad a Rol");
		func3.setDesc("Asignar");
		funcBean.addFuncionalidad(func3);
		
		FUNCIONALIDADES func4 = new FUNCIONALIDADES();
		func4.setNombre("Crear nuevo Dios");
		func4.setDesc("Crear nuevo Dios");
		funcBean.addFuncionalidad(func4);
		
		ROLES r1 = new ROLES();
		r1.setNombre("Dios");
		r1.setDesc("GOOOOOD");
		rolBean.addRol(r1);
		
		ROLES r2 = new ROLES();
		r2.setNombre("Estudiante");
		r2.setDesc("Estudy");
		rolBean.addRol(r2);
		
		ROLES r3 = new ROLES();
		r3.setNombre("Profesor");
		r3.setDesc("Estudy");
		rolBean.addRol(r3);
		
		rolBean.asignFunctoRol(1, 1);
		rolBean.asignFunctoRol(2, 1);
		rolBean.asignFunctoRol(3, 1);
		rolBean.asignFunctoRol(4, 1);
		
		rolBean.asignFunctoRol(2, 2);
		rolBean.asignFunctoRol(4, 2);
		
		rolBean.asignFunctoRol(2, 3);
		rolBean.asignFunctoRol(3, 3);
		rolBean.asignFunctoRol(4, 3);
		
		userBean.asignRoltoUser(1, 1);
	System.out.println("patata");
	System.out.println("Patataaaasdas");

	System.out.println("Tremebundo");
	System.out.println("Casas");
	}

}
