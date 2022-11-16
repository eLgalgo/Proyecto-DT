package principal;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.ANALISTA;
import com.entities.ESTUDIANTE;
import com.entities.EVENTO;
import com.entities.ITR;
import com.entities.TUTOR;
import com.enums.Departamento;
import com.enums.Estado;
import com.enums.Genero;
import com.enums.Localidad;
import com.exception.ServiciosException;
import com.gui.Login;
import com.services.AnalistaBeanRemote;
import com.services.EstudianteBeanRemote;
import com.services.EventoBeanRemote;
import com.services.ItrBeanRemote;
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
		
		ItrBeanRemote itrBean = (ItrBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/ItrBean!com.services.ItrBeanRemote");
		
		EventoBeanRemote eventoBean = (EventoBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/EventoBean!com.services.EventoBeanRemote");
		
		Login loginWindow = new Login();
		loginWindow.getFrame().setVisible(true);
		
		ITR itr1 = new ITR();
		itr1.setDepartamento(Departamento.DURAZNO);
		itr1.setNombre("ITR_CS");
		itrBean.addItr(itr1);
		
		ITR itr2 = new ITR();
		itr2.setDepartamento(Departamento.ARTIGAS);
		itr2.setNombre("ITR_N");
		itrBean.addItr(itr2);
		
		ITR itr3 = new ITR();
		itr3.setDepartamento(Departamento.CANELONES);
		itr3.setNombre("ITR_SO");
		itrBean.addItr(itr3);
		List<ITR> itrS = itrBean.listAllItr();
		
		ESTUDIANTE user1 = new ESTUDIANTE();
		user1.setNombre("Cristofer");
		user1.setApellido("Cabrera");
		user1.setDocumento(1);
		user1.setMail("c");
		user1.setContrasena("c");
		user1.setDepartamento(Departamento.ARTIGAS);
		user1.setLocalidad("UNA");
		user1.setTelefono("tele");
		user1.setMail_insti("c");
		user1.setGeneracion("2022");
		user1.setGenero(Genero.MACHO);
		user1.setSemestre(1);
		user1.setItr_s(itrS);
		user1.setEstado(Estado.ACTIVO);
		user1.setFechaNac(LocalDate.of(1999, Month.JANUARY, 10));
		
		estudianteBean.addStudent(user1);
		
		TUTOR tutor = new TUTOR();
		tutor.setNombre("Tutor1");
		tutor.setApellido("casasfas");
		tutor.setDocumento(2);
		tutor.setMail("t");
		tutor.setContrasena("t");
		tutor.setDepartamento(Departamento.DURAZNO);
		tutor.setTelefono("tele");
		tutor.setMail_insti("t");
		tutor.setArea("Area1");
		tutor.setTipo("Tipo1");
		tutor.setItr_s(itrS);
		tutor.setEstado(Estado.ACTIVO);
		tutor.setFechaNac(LocalDate.of(1999, Month.JANUARY, 10));
		
		tutorBean.addTutor(tutor);
		
		TUTOR tutor2 = new TUTOR();
		tutor2.setNombre("Tutor2");
		tutor2.setApellido("casasfas");
		tutor2.setDocumento(1251);
		tutor2.setMail("v");
		tutor2.setContrasena("v");
		tutor2.setDepartamento(Departamento.DURAZNO);
		tutor2.setTelefono("fasfas");
		tutor2.setMail_insti("mafas");
		tutor2.setArea("Area21");
		tutor2.setTipo("Tipo412");
		tutor2.setItr_s(itrS);
		tutor2.setEstado(Estado.ACTIVO);
		tutor2.setFechaNac(LocalDate.of(1999, Month.JANUARY, 10));
		
		tutorBean.addTutor(tutor2);
		
		ANALISTA analista = new ANALISTA();
		analista.setNombre("fasgasa");
		analista.setApellido("casasfas");
		analista.setDocumento(3);
		analista.setMail("m");
		analista.setContrasena("m");
		analista.setDepartamento(Departamento.CANELONES);
		analista.setTelefono("tele");
		analista.setMail_insti("m");
		analista.setItr_s(itrS);
		analista.setEstado(Estado.ACTIVO);
		analista.setFechaNac(LocalDate.of(1999, Month.JANUARY, 10));
		
		analistaBean.addAnalista(analista);
		
		//Jardcodeo un evento
		
		ESTUDIANTE user2 = new ESTUDIANTE();
		user2.setNombre("Agustina");
		user2.setApellido("Ana");
		user2.setDocumento(5);
		user2.setMail("s");
		user2.setContrasena("s");
		user2.setDepartamento(Departamento.ARTIGAS);
		user2.setLocalidad("UNA");
		user2.setTelefono("tele");
		user2.setMail_insti("s");
		user2.setGeneracion("2022");
		user2.setGenero(Genero.HEMBRA);
		user2.setSemestre(1);
		user2.setItr_s(itrS);
		user2.setEstado(Estado.ACTIVO);
		user2.setFechaNac(LocalDate.of(1999, Month.JANUARY, 10));
		
		estudianteBean.addStudent(user2);
		
		ESTUDIANTE user3 = new ESTUDIANTE();
		user3.setNombre("Monica");
		user3.setApellido("Cabrera");
		user3.setDocumento(6);
		user3.setMail("a");
		user3.setContrasena("a");
		user3.setDepartamento(Departamento.ARTIGAS);
		user3.setLocalidad("UNA");
		user3.setTelefono("tele");
		user3.setMail_insti("a");
		user3.setGeneracion("2022");
		user3.setGenero(Genero.MACHO);
		user3.setSemestre(1);
		user3.setItr_s(itrS);
		user3.setEstado(Estado.ACTIVO);
		user3.setFechaNac(LocalDate.of(1999, Month.JANUARY, 10));
		
		estudianteBean.addStudent(user3);
		
		EVENTO ev1 = new EVENTO();
		ev1.setTitulo("CUTI FORUM");
		TUTOR t = tutorBean.findUser(tutor.getDocumento()).get(0);
		ev1.setTutor(t);
		
		eventoBean.addEvento(ev1);
		
		EVENTO ev2 = new EVENTO();
		ev2.setTitulo("Cumple de Nico");
		TUTOR t2 = tutorBean.findUser(tutor2.getDocumento()).get(0);
		ev2.setTutor(t2);
		
		eventoBean.addEvento(ev2);
		
		eventoBean.asignEstToEvent(1, 1);
		eventoBean.asignEstToEvent(4, 1);
		eventoBean.asignEstToEvent(5, 1);
		
		eventoBean.asignEstToEvent(1, 2);
	}

}
