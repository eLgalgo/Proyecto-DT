package principal;

import java.time.LocalDate;
import java.time.Month;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.ACCION;
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
		ITR itr4 = new ITR();
		
		itr1.setNombre("NORTE1");
		itr1.setEstado(true);
		itr2.setNombre("SURESTE1");
		itr2.setEstado(true);
		itr3.setNombre("CENTROSUR1");
		itr3.setEstado(true);
		itr4.setNombre("CENTROSUR2");
		itr4.setEstado(true);
		
		itrBean.addItr(itr1);
		itrBean.addItr(itr2);
		itrBean.addItr(itr3);
		itrBean.addItr(itr4);
		
		
		ESTUDIANTE user1 = new ESTUDIANTE();
		user1.setNombre("Cristofer");
		user1.setApellido("Cabrera");
		user1.setDocumento(1);
		user1.setMail("c");
		user1.setContrasena("c");
		user1.setItr(itrBean.findItr(1).get(0));
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
		user2.setApellido("Mansilla");
		user2.setDocumento(5);
		user2.setMail("q");
		user2.setContrasena("q");
		user2.setDepartamento(Departamento.CERRO_LARGO);
		user2.setLocalidad(Localidad.INTERIOR);
		user2.setTelefono("+59891231");
		user2.setMail_insti("q");
		user2.setItr(itrBean.findItr(2).get(0));
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
		tutor.setItr(itrBean.findItr(3).get(0));
		tutor.setEstado(EstadoUsuario.ACTIVO);
		tutor.setFechaNac(LocalDate.of(1999, Month.JANUARY, 10));
		
		tutorBean.addTutor(tutor);
		
		TUTOR tutor2 = new TUTOR();
		tutor2.setNombre("Guillermo");
		tutor2.setApellido("Uscudun");
		tutor2.setDocumento(120);
		tutor2.setMail("t2");
		tutor2.setContrasena("t2");
		tutor2.setItr(itrBean.findItr(4).get(0));
		tutor2.setDepartamento(Departamento.DURAZNO);
		tutor2.setLocalidad(Localidad.CAPITAL);
		tutor2.setTelefono("1241241");
		tutor2.setMail_insti("t2");
		tutor2.setArea("Area2");
		tutor2.setTipo(RolTutor.ENCARGADO);
		tutor2.setEstado(EstadoUsuario.ACTIVO);
		tutor2.setFechaNac(LocalDate.of(1999, Month.JANUARY, 10));
		
		tutorBean.addTutor(tutor2);
	
		ANALISTA analista = new ANALISTA();
		
		analista.setNombre("Jimena");
		analista.setApellido("Goytiño");
		analista.setDocumento(3);
		analista.setMail("JIMENA");
		analista.setContrasena("JIMENA");
		analista.setDepartamento(Departamento.CANELONES);
		analista.setLocalidad(Localidad.CAPITAL);
		analista.setTelefono("tele");
		analista.setItr(itrBean.findItr(1).get(0));
		analista.setMail_insti("JIMENA");
		analista.setEstado(EstadoUsuario.ACTIVO);
		analista.setFechaNac(LocalDate.of(1999, Month.JANUARY, 10));
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
		e2.setInformacion("Instancia Febrero");
		e2.setTutor((TUTOR) usuarioBean.findUser(tutor2.getDocumento()).get(0));
		
		eventoBean.addEvento(e2);
		eventoBean.addEvento(e1);
		
		eventoBean.asignEstToEvent(1, 1);
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
