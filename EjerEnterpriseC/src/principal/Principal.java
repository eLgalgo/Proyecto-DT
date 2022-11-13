package principal;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.naming.InitialContext;


import javax.naming.NamingException;
import javax.swing.JOptionPane;

import com.entities.ANALISTA;
import com.entities.ESTUDIANTE;
import com.entities.TUTOR;
import com.entities.USUARIO;
import com.exception.ServiciosException;
import com.gui.Login;
import com.gui.Ppal_Analista;
import com.services.AnalistaBeanRemote;
import com.services.EstudianteBeanRemote;
import com.services.TutorBeanRemote;
import com.services.UsuarioBeanRemote;

public class Principal{
	
	public static void main(String[] args) throws NamingException, ServiciosException {
		// TODO Auto-generated method stub
		
		EstudianteBeanRemote estudianteBean = (EstudianteBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/EstudianteBean!com.services.EstudianteBeanRemote");
		
		TutorBeanRemote tutorBean = (TutorBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/TutorBean!com.services.TutorBeanRemote");
		
		AnalistaBeanRemote analistaBean = (AnalistaBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/AnalistaBean!com.services.AnalistaBeanRemote");
		
		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/UsuarioBean!com.services.UsuarioBeanRemote");
		
		Login loginWindow = new Login();
		loginWindow.getFrame().setVisible(true);
		
		ESTUDIANTE user1 = new ESTUDIANTE();
		user1.setNombre("Cristofer");
		user1.setApellido("Cabrera");
		user1.setDocumento(53158416);
		user1.setMail("c");
		user1.setContrasena("c");
		user1.setDepartamento("Dep");
		user1.setLocalidad("Loc");
		user1.setGenero("Gen");
		user1.setTelefono("tele");
		user1.setNom_usuario("c");
		user1.setGeneracion("2022");
		user1.setGenero("Macho");
		user1.setSemestre(1);
		
		estudianteBean.addStudent(user1);
		
		TUTOR tutor = new TUTOR();
		tutor.setNombre("fasgasa");
		tutor.setApellido("casasfas");
		tutor.setDocumento(53123);
		tutor.setMail("m");
		tutor.setContrasena("t");
		tutor.setDepartamento("Dep");
		tutor.setTelefono("tele");
		tutor.setNom_usuario("t");
		tutor.setArea("Area1");
		tutor.setTipo("Tipo1");
		
		tutorBean.addTutor(tutor);
		
		ANALISTA analista = new ANALISTA();
		analista.setNombre("fasgasa");
		analista.setApellido("casasfas");
		analista.setDocumento(2315123);
		analista.setMail("m");
		analista.setContrasena("m");
		analista.setDepartamento("Dep");
		analista.setTelefono("tele");
		analista.setNom_usuario("m");
		
		analistaBean.addAnalista(analista);
	}

}
