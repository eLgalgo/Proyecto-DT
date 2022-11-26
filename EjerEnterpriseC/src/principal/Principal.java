package principal;

import java.time.LocalDate;
import java.time.Month;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.ACCIONANALISTACONSTANCIA;
import com.entities.ANALISTA;
import com.entities.ESTUDIANTE;
import com.entities.EVENTO;
import com.entities.ITR;
import com.entities.TIPOCONSTANCIA;
import com.entities.RECLAMO;
import com.entities.TUTOR;
import com.enums.Departamento;

import com.enums.EstadoUsuario;
import com.enums.Localidad;
import com.enums.RolTutor;
import com.enums.TipoReclamo;
import com.exception.ServiciosException;
import com.gui.CrearModelosConstancia;
import com.gui.Login;
import com.services.AccionBeanRemote;
import com.services.AnalistaBeanRemote;
import com.services.EstudianteBeanRemote;
import com.services.EventoBeanRemote;
import com.services.ItrBeanRemote;
import com.services.ModeloBeanRemote;
import com.services.ReclamoBeanRemote;
import com.services.TutorBeanRemote;
import com.services.UsuarioBeanRemote;

import org.hibernate.type.LocalDateType;

public class Principal{
	
	public static void main(String[] args) throws NamingException, ServiciosException {
		
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

		ReclamoBeanRemote reclamoBean = (ReclamoBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/ReclamoBean!com.services.ReclamoBeanRemote");
		
		AccionBeanRemote accionBean = (AccionBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/AccionBean!com.services.AccionBeanRemote");
		
		ItrBeanRemote itrBean = (ItrBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/ItrBean!com.services.ItrBeanRemote");

		ModeloBeanRemote modeloBean = (ModeloBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/ModeloBean!com.services.ModeloBeanRemote");
		
		Login loginWindow = new Login();
		loginWindow.getFrame().setVisible(true);
		
		
		ITR itr1 = new ITR();
		ITR itr2 = new ITR();
		ITR itr3 = new ITR();

		
		itr1.setNombre("NORTE");
		itr1.setEstado(true);
		itr2.setNombre("SURESTE");
		itr2.setEstado(true);
		itr3.setNombre("CENTROSUR");
		itr3.setEstado(true);

		
		itrBean.addItr(itr1);
		itrBean.addItr(itr2);
		itrBean.addItr(itr3);
		
		
		ESTUDIANTE user1 = new ESTUDIANTE();
		user1.setNombre("Cristofer");
		user1.setApellido("Cabrera");
		user1.setDocumento(11111111);
		user1.setMail("cristofer.cabrera@estudiantes.utec.edu.uy");
		user1.setContrasena("cristofer1");
		user1.setItr(itrBean.findItr(1).get(0));
		user1.setDepartamento(Departamento.ARTIGAS);
		user1.setLocalidad(Localidad.CAPITAL);
		user1.setTelefono("099111222");
		user1.setMail_insti("cristofer.cabrera@utec.edu.uy");
		user1.setGeneracion("2022");
		user1.setEstado(EstadoUsuario.ACTIVO);
		user1.setFechaNac(LocalDate.of(2002, Month.JANUARY, 24));
		
		estudianteBean.addStudent(user1);
		
		ESTUDIANTE user2 = new ESTUDIANTE();
		user2.setNombre("Lucas");
		user2.setApellido("Mansilla");
		user2.setDocumento(12222222);
		user2.setMail("luquitas.mansi@gmail.com");
		user2.setContrasena("luquitas1");
		user2.setDepartamento(Departamento.CERRO_LARGO);
		user2.setLocalidad(Localidad.INTERIOR);
		user2.setTelefono("099111233");
		user2.setMail_insti("luquitas.mansi@utec.edu.uy");
		user2.setItr(itrBean.findItr(2).get(0));
		user2.setGeneracion("2022");
		user2.setEstado(EstadoUsuario.ACTIVO);
		user2.setFechaNac(LocalDate.of(2002, Month.MARCH, 23));
		
		estudianteBean.addStudent(user2);
		
		ESTUDIANTE user3 = new ESTUDIANTE();
		user3.setNombre("Gabriel");
		user3.setApellido("Jorge");
		user3.setDocumento(1234567);
		user3.setMail("gabriel.jorge@estudiantes.utec.edu.uy");
		user3.setContrasena("c");
		user3.setItr(itrBean.findItr(1).get(0));
		user3.setDepartamento(Departamento.FLORIDA);
		user3.setLocalidad(Localidad.CAPITAL);
		user3.setTelefono("092769259");
		user3.setMail_insti("c.c@utec.edu.uy");
		user3.setGeneracion("2022");
		user3.setEstado(EstadoUsuario.ACTIVO);
		user3.setFechaNac(LocalDate.of(1993, Month.JANUARY, 26));
		
		estudianteBean.addStudent(user3);
		
		ESTUDIANTE user4 = new ESTUDIANTE();
		user4.setNombre("Heber");
		user4.setApellido("Zagami");
		user4.setDocumento(12134538);
		user4.setMail("heber.zagami@estudiantes.utec.edu.uy");
		user4.setContrasena("heberzagami1");
		user4.setItr(itrBean.findItr(1).get(0));
		user4.setDepartamento(Departamento.TACUAREMBO);
		user4.setLocalidad(Localidad.INTERIOR);
		user4.setTelefono("099990077");
		user4.setMail_insti("heber.zagami@utec.edu.uy");
		user4.setGeneracion("2022");
		user4.setEstado(EstadoUsuario.ACTIVO);
		user4.setFechaNac(LocalDate.of(1993, Month.JANUARY, 26));
		
		estudianteBean.addStudent(user4);
		
		TUTOR tutor = new TUTOR();
		tutor.setNombre("Michael");
		tutor.setApellido("Jackson");
		tutor.setDocumento(13344445);
		tutor.setMail("michael.jackson@gmail.com");
		tutor.setContrasena("michael1");
		tutor.setDepartamento(Departamento.DURAZNO);
		tutor.setLocalidad(Localidad.CAPITAL);
		tutor.setTelefono("22923344");
		tutor.setMail_insti("michael.jackson@utec.edu.uy");
		tutor.setArea("Area 1");
		tutor.setTipo(RolTutor.TUTOR);
		tutor.setItr(itrBean.findItr(3).get(0));
		tutor.setEstado(EstadoUsuario.ACTIVO);
		tutor.setFechaNac(LocalDate.of(1960, Month.JULY, 23));
		
		tutorBean.addTutor(tutor);
		
		TUTOR tutor2 = new TUTOR();
		tutor2.setNombre("Elon");
		tutor2.setApellido("Musk");
		tutor2.setDocumento(66666666);
		tutor2.setMail("elon.musk@tesla.com");
		tutor2.setContrasena("elonmusk1");
		tutor2.setItr(itrBean.findItr(2).get(0));
		tutor2.setDepartamento(Departamento.MONTEVIDEO);
		tutor2.setLocalidad(Localidad.CAPITAL);
		tutor2.setTelefono("124124133");
		tutor2.setMail_insti("elon.musk@utec.edu.uy");
		tutor2.setArea("Area 2");
		tutor2.setTipo(RolTutor.ENCARGADO);
		tutor2.setEstado(EstadoUsuario.ACTIVO);
		tutor2.setFechaNac(LocalDate.of(1966, Month.JUNE, 6));
		
		tutorBean.addTutor(tutor2);
	
		ANALISTA analista = new ANALISTA();
		
		analista.setNombre("Jimena");
		analista.setApellido("Goytiño");
		analista.setDocumento(39988776);
		analista.setMail("jimena.goytino@gmail.com");
		analista.setContrasena("m");
		analista.setDepartamento(Departamento.CANELONES);
		analista.setLocalidad(Localidad.CAPITAL);
		analista.setTelefono("092334445");
		analista.setItr(itrBean.findItr(1).get(0));
		analista.setMail_insti("m.m@utec.edu.uy");
		analista.setEstado(EstadoUsuario.ACTIVO);
		analista.setFechaNac(LocalDate.of(1985, Month.OCTOBER, 3));
		analista.setDios(true);
		
		analistaBean.addAnalista(analista);
		
		TIPOCONSTANCIA tp1 = new TIPOCONSTANCIA();
		tp1.setTipo("ESTUDIANTE ACTIVO");
		tp1.setEstado(true);
		tp1.setModelo("SE DEJA CONSTANCIA DE QUE EL ESTUDIANTE &nombre& ESTA ACTIVO");
		
		TIPOCONSTANCIA tp2 = new TIPOCONSTANCIA();
		tp2.setTipo("EXAMEN");
		tp2.setEstado(true);
		tp2.setModelo("SE DEJA CONSTANCIA DE QUE EL ESTUDIANTE &nombre& ASISTIO AL EXAMEN");
		
		modeloBean.addMoldeo(tp1);
		modeloBean.addMoldeo(tp2);
		
		EVENTO e1 = new EVENTO();
		e1.setTitulo("Presencial 1");
		e1.setInformacion("Ultima presencial S5");
		e1.setTutor((TUTOR) usuarioBean.findUser(tutor.getDocumento()).get(0));
		
		EVENTO e2 = new EVENTO();
		e2.setTitulo("Examen PDT 2022");
		e2.setInformacion("Instancia Diciembre 2022");
		e2.setTutor((TUTOR) usuarioBean.findUser(tutor2.getDocumento()).get(0));
		
		eventoBean.addEvento(e2);
		eventoBean.addEvento(e1);
		
		eventoBean.asignEstToEvent(1, 1);
		eventoBean.asignEstToEvent(3, 1);
		eventoBean.asignEstToEvent(3, 2);
		eventoBean.asignEstToEvent(4, 1);
		eventoBean.asignEstToEvent(4, 2);
		eventoBean.asignEstToEvent(1, 2);
		eventoBean.asignEstToEvent(2, 2);
		
		RECLAMO r1 = new RECLAMO();
		r1.setTitulo("Reclamo 1");
		r1.setDetalle("Detalle de Reclamo 1");
		r1.setTipo(TipoReclamo.APE);
		r1.setFecha(LocalDate.now());
		r1.setEs((ESTUDIANTE) usuarioBean.findUser(user1.getDocumento()).get(0));
		
		RECLAMO r2 = new RECLAMO();
		r2.setTitulo("Reclamo 2");
		r2.setDetalle("Detalle de Reclamo 2");
		r2.setTipo(TipoReclamo.Optativas);
		r2.setFecha(LocalDate.now());
		r2.setEs((ESTUDIANTE) usuarioBean.findUser(user2.getDocumento()).get(0));
		
		reclamoBean.addReclamo(r1);
		reclamoBean.addReclamo(r2);
	}

}
