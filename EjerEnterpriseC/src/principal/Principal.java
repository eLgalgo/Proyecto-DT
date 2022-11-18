package principal;

import java.time.LocalDate;
import java.time.Month;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.ANALISTA;
import com.entities.ESTUDIANTE;
import com.entities.EVENTO;
import com.entities.TUTOR;
import com.enums.Departamento;
import com.enums.EITRs;
import com.enums.EstadoUsuario;
import com.enums.Localidad;
import com.enums.RolTutor;
import com.exception.ServiciosException;
import com.gui.Login;
import com.services.AnalistaBeanRemote;
import com.services.EstudianteBeanRemote;
import com.services.EventoBeanRemote;
import com.services.TutorBeanRemote;
import com.services.UsuarioBeanRemote;

import org.hibernate.type.LocalDateType;

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
		
		EventoBeanRemote eventoBean = (EventoBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/EventoBean!com.services.EventoBeanRemote");

		Login loginWindow = new Login();
		loginWindow.getFrame().setVisible(true);
		
		ESTUDIANTE user1 = new ESTUDIANTE();
		user1.setNombre("Cristofer");
		user1.setApellido("Cabrera");
		user1.setDocumento(1);
		user1.setMail("c");
		user1.setContrasena("c");
		user1.setItr(EITRs.NORTE);
		user1.setDepartamento(Departamento.ARTIGAS);
		user1.setLocalidad(Localidad.CAPITAL);
		user1.setTelefono("tele");
		user1.setMail_insti("c");
		user1.setGeneracion("2022");
		user1.setEstado(EstadoUsuario.ACTIVO);
		user1.setFechaNac(LocalDate.of(1999, Month.JANUARY, 10));
		
		estudianteBean.addStudent(user1);
		
		ESTUDIANTE user2 = new ESTUDIANTE();
		user2.setNombre("Lucas");
		user2.setApellido("Sergio");
		user2.setDocumento(5);
		user2.setMail("q");
		user2.setContrasena("q");
		user2.setDepartamento(Departamento.CERRO_LARGO);
		user2.setLocalidad(Localidad.INTERIOR);
		user2.setTelefono("+59891231");
		user2.setMail_insti("q");
		user2.setItr(EITRs.NORTE);
		user2.setGeneracion("2022");
		user2.setEstado(EstadoUsuario.ACTIVO);
		user2.setFechaNac(LocalDate.of(1999, Month.JANUARY, 10));
		
		estudianteBean.addStudent(user2);
		
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
		tutor.setTipo(RolTutor.TUTOR);
		tutor.setItr(EITRs.NORTE);
		tutor.setEstado(EstadoUsuario.ACTIVO);
		tutor.setFechaNac(LocalDate.of(1999, Month.JANUARY, 10));
		
		tutorBean.addTutor(tutor);
		
		TUTOR tutor2 = new TUTOR();
		tutor2.setNombre("Tutor2");
		tutor2.setApellido("Ap");
		tutor2.setDocumento(120);
		tutor2.setMail("l");
		tutor2.setContrasena("l");
		tutor2.setItr(EITRs.NORTE);
		tutor2.setDepartamento(Departamento.DURAZNO);
		tutor2.setLocalidad(Localidad.CAPITAL);
		tutor2.setTelefono("1241241");
		tutor2.setMail_insti("l");
		tutor2.setArea("Area2");
		tutor2.setTipo(RolTutor.ENCARGADO);
		tutor2.setEstado(EstadoUsuario.ACTIVO);
		tutor2.setFechaNac(LocalDate.of(1999, Month.JANUARY, 10));
		
		tutorBean.addTutor(tutor2);
		
		ANALISTA analista = new ANALISTA();
		analista.setNombre("fasgasa");
		analista.setApellido("casasfas");
		analista.setDocumento(3);
		analista.setMail("m");
		analista.setContrasena("m");
		analista.setDepartamento(Departamento.CANELONES);
		analista.setLocalidad(Localidad.CAPITAL);
		analista.setTelefono("tele");
		analista.setItr(EITRs.NORTE);
		analista.setMail_insti("m");
		analista.setEstado(EstadoUsuario.ACTIVO);
		analista.setFechaNac(LocalDate.of(1999, Month.JANUARY, 10));
		
		analistaBean.addAnalista(analista);
		
		EVENTO e1 = new EVENTO();
		e1.setTitulo("Presencial 1");
		e1.setInformacion("Ultima presencial S5");
		e1.setTutor((TUTOR) usuarioBean.findUser(tutor.getDocumento()).get(0));
		
		EVENTO e2 = new EVENTO();
		e2.setTitulo("Examen PDT 2022");
		e2.setInformacion("Instancia Febrero");
		e2.setTutor((TUTOR) usuarioBean.findUser(tutor2.getDocumento()).get(0));
		
		eventoBean.addEvento(e2);
		eventoBean.addEvento(e1);
		
		eventoBean.asignEstToEvent(1, 1);
		eventoBean.asignEstToEvent(1, 2);
		eventoBean.asignEstToEvent(2, 2);
		
		System.out.println("Maria la mejor profe <3");
	}

}
