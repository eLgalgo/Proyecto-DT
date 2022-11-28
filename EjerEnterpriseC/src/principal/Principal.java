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
		user1.setGeneracion("2020");
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
		user2.setGeneracion("2018");
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
		user3.setMail_insti("gabriel.jorge@utec.edu.uy");
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
		user4.setGeneracion("2020");
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
		
		ANALISTA analista2 = new ANALISTA();
		
		analista2.setNombre("Simone");
		analista2.setApellido("DaSilva");
		analista2.setDocumento(13412341);
		analista2.setMail("simone@gmail.com");
		analista2.setContrasena("simonedasilva5");
		analista2.setDepartamento(Departamento.COLONIA);
		analista2.setLocalidad(Localidad.CAPITAL);
		analista2.setTelefono("098121251");
		analista2.setItr(itrBean.findItr(1).get(0));
		analista2.setMail_insti("simone.dasilva@utec.edu.uy");
		analista2.setEstado(EstadoUsuario.ACTIVO);
		analista2.setFechaNac(LocalDate.of(1985, Month.OCTOBER, 3));
		
		analistaBean.addAnalista(analista2);
		
		TIPOCONSTANCIA tp1 = new TIPOCONSTANCIA();
		tp1.setTipo("ESTUDIANTE ACTIVO");
		tp1.setEstado(true);
		tp1.setModelo("Se deja constancia que el estudiante &nombre& &apellido& de cedula &cedula& se encuentra realizando la carrera Licenciatura en Tecnologias de la Informacion desde el dia 1/1/2020"
				+ "en la Universidad Tecnologica del Uruguay");
		
		TIPOCONSTANCIA tp2 = new TIPOCONSTANCIA();
		tp2.setTipo("EXAMEN");
		tp2.setEstado(true);
		tp2.setModelo("Se deja constancia que el estudiante &nombre& &apellido& de cedula &cedula& asistio al examen &evento&.");
		
		TIPOCONSTANCIA tp3 = new TIPOCONSTANCIA();
		tp3.setTipo("TRANSPORTE");
		tp3.setEstado(true);
		tp3.setModelo("Se deja constancia que el estudiante &nombre& &apellido& de cedula &cedula& se encuentra realizando la carrera de Licenciatura en tecnologias de la Informacion en el semestre 1.");
		
		TIPOCONSTANCIA tp4 = new TIPOCONSTANCIA();
		tp4.setTipo("PRESENCIAL PRUEBA");
		tp4.setEstado(true);
		tp4.setModelo("Se deja constancia que el estudiante &nombre& &apellido& de cedula &cedula& asistio al a la presencial &evento& en el horario de 09hrs a 17hrs donde realizo la prueba de la materia Aplicaciones Enterprise.");
		
		TIPOCONSTANCIA tp5 = new TIPOCONSTANCIA();
		tp5.setTipo("PRESENCIAL COMUN");
		tp5.setEstado(true);
		tp5.setModelo("Se deja constancia que el estudiante &nombre& &apellido& de cedula &cedula& asistio al a la presencial &evento& en el horario de 09hrs a 17hrs.");
		
		TIPOCONSTANCIA tp6 = new TIPOCONSTANCIA();
		tp6.setTipo("CREDITOS");
		tp6.setEstado(true);
		tp6.setModelo("Se deja constancia que el estudiante &nombre& &apellido& de cedula &cedula& cuenta con la cantidad total de 5 creditos en la materia Vinculacion con el Medio.");
		
		modeloBean.addMoldeo(tp1);
		modeloBean.addMoldeo(tp2);
		modeloBean.addMoldeo(tp3);
		modeloBean.addMoldeo(tp4);
		modeloBean.addMoldeo(tp5);
		modeloBean.addMoldeo(tp6);
		
		EVENTO e3 = new EVENTO();
		e3.setTitulo("Estudiante Activo");
		e3.setInformacion("Estudiante super activo");
		e3.setFechaInicio(LocalDate.of(2021, Month.FEBRUARY, 15));
		e3.setFechaFinal(LocalDate.of(2022, Month.DECEMBER, 20));
		e3.setTutor((TUTOR) usuarioBean.findUser(tutor.getDocumento()).get(0));
		
		EVENTO e4 = new EVENTO();
		e4.setTitulo("Presencial Prueba");
		e4.setInformacion("Prueba de Aplicaciones Enterprise");
		e4.setFechaInicio(LocalDate.of(2022, Month.JANUARY, 25));
		e4.setFechaFinal(LocalDate.of(2022, Month.AUGUST, 20));
		e4.setTutor((TUTOR) usuarioBean.findUser(tutor.getDocumento()).get(0));
		
		EVENTO e5 = new EVENTO();
		e5.setTitulo("Creditos");
		e5.setInformacion("Creditos de VME");
		e5.setFechaInicio(LocalDate.of(2022, Month.JULY, 3));
		e5.setFechaFinal(LocalDate.of(2022, Month.DECEMBER, 5));
		e5.setTutor((TUTOR) usuarioBean.findUser(tutor2.getDocumento()).get(0));
		
		EVENTO e6 = new EVENTO();
		e6.setTitulo("Transporte");
		e6.setInformacion("Para transporte");
		e6.setFechaInicio(LocalDate.of(2022, Month.FEBRUARY, 18));
		e6.setFechaFinal(LocalDate.of(2022, Month.AUGUST, 15));
		e6.setTutor((TUTOR) usuarioBean.findUser(tutor.getDocumento()).get(0));
		
		EVENTO e1 = new EVENTO();
		e1.setTitulo("Presencial Comun");
		e1.setInformacion("Ultima presencial S5");
		e1.setFechaInicio(LocalDate.of(2022, Month.AUGUST, 3));
		e1.setFechaFinal(LocalDate.of(2022, Month.DECEMBER, 20));
		e1.setTutor((TUTOR) usuarioBean.findUser(tutor2.getDocumento()).get(0));
		
		EVENTO e2 = new EVENTO();
		e2.setTitulo("Examen PDT 2022");
		e2.setInformacion("Instancia Diciembre 2022");
		e2.setFechaInicio(LocalDate.of(2022, Month.AUGUST, 3));
		e2.setFechaFinal(LocalDate.of(2022, Month.AUGUST, 10));
		e2.setTutor((TUTOR) usuarioBean.findUser(tutor2.getDocumento()).get(0));
		
		eventoBean.addEvento(e2);
		eventoBean.addEvento(e1);
		eventoBean.addEvento(e3);
		eventoBean.addEvento(e4);
		eventoBean.addEvento(e5);
		eventoBean.addEvento(e6);
		
		eventoBean.asignEstToEvent(1, 1);
		eventoBean.asignEstToEvent(1, 2);
		eventoBean.asignEstToEvent(1, 3);
		eventoBean.asignEstToEvent(1, 4);
		
		eventoBean.asignEstToEvent(2, 2);
		eventoBean.asignEstToEvent(2, 4);
		eventoBean.asignEstToEvent(2, 6);
		
		eventoBean.asignEstToEvent(3, 2);
		eventoBean.asignEstToEvent(3, 4);
		eventoBean.asignEstToEvent(3, 5);
		
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
