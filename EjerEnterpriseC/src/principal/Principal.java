package principal;

import java.time.LocalDate;
import java.time.Month;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.ANALISTA;
import com.entities.ESTUDIANTE;
import com.entities.TUTOR;
import com.enums.Departamento;
import com.enums.Estado;
import com.enums.Localidad;
import com.exception.ServiciosException;
import com.gui.Login;
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
		user1.setDocumento(1);
		user1.setMail("c");
		user1.setContrasena("c");
		user1.setDepartamento(Departamento.ARTIGAS);
		user1.setLocalidad(Localidad.CAPITAL);
		user1.setTelefono("tele");
		user1.setMail_insti("c");
		user1.setGeneracion("2022");
		user1.setItr(null);
		user1.setEstado(Estado.ACTIVO);
		user1.setFechaNac(LocalDate.of(1999, Month.JANUARY, 10));
		
		estudianteBean.addStudent(user1);
		
		TUTOR tutor = new TUTOR();
		tutor.setNombre("fasgasa");
		tutor.setApellido("casasfas");
		tutor.setDocumento(2);
		tutor.setMail("t");
		tutor.setContrasena("t");
		tutor.setDepartamento(Departamento.DURAZNO);
		tutor.setLocalidad(Localidad.CAPITAL);
		tutor.setTelefono("tele");
		tutor.setMail_insti("t");
		tutor.setArea("Area1");
		tutor.setTipo(null);
		tutor.setItr(null);
		tutor.setEstado(Estado.ACTIVO);
		tutor.setFechaNac(LocalDate.of(1999, Month.JANUARY, 10));
		
		tutorBean.addTutor(tutor);
		
		ANALISTA analista = new ANALISTA();
		analista.setNombre("fasgasa");
		analista.setApellido("casasfas");
		analista.setDocumento(3);
		analista.setMail("m");
		analista.setContrasena("m");
		analista.setDepartamento(Departamento.CANELONES);
		analista.setLocalidad(Localidad.CAPITAL);
		analista.setTelefono("tele");
		analista.setMail_insti("m");
		analista.setItr(null);
		analista.setEstado(Estado.ACTIVO);
		analista.setFechaNac(LocalDate.of(1999, Month.JANUARY, 10));
		
		analistaBean.addAnalista(analista);
		
		System.out.println("Maria, la mejor profe <3");
	}

}
