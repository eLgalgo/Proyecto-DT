package principal;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.ANALISTA;
import com.entities.ESTUDIANTE;
import com.entities.ITR;
import com.entities.TUTOR;
import com.enums.Departamento;
import com.enums.Genero;
import com.enums.Localidad;
import com.exception.ServiciosException;
import com.gui.Login;
import com.services.AnalistaBeanRemote;
import com.services.EstudianteBeanRemote;
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
		
		Login loginWindow = new Login();
		loginWindow.getFrame().setVisible(true);
		
//		ITR itr1 = new ITR();
//		itr1.setDepartamento(Departamento.DURAZNO);
//		itr1.setNombre("ITR_CS");
//		itrBean.addItr(itr1);
//		
//		ITR itr2 = new ITR();
//		itr2.setDepartamento(Departamento.ARTIGAS);
//		itr2.setNombre("ITR_N");
//		itrBean.addItr(itr2);
//		
//		ITR itr3 = new ITR();
//		itr3.setDepartamento(Departamento.CANELONES);
//		itr3.setNombre("ITR_SO");
//		itrBean.addItr(itr3);
//		List<ITR> itrS = itrBean.listAllItr();
//		
//		ESTUDIANTE user1 = new ESTUDIANTE();
//		user1.setNombre("Cristofer");
//		user1.setApellido("Cabrera");
//		user1.setDocumento(53158416);
//		user1.setMail("c");
//		user1.setContrasena("c");
//		user1.setDepartamento(Departamento.ARTIGAS);
//		user1.setLocalidad("UNA");
//		user1.setTelefono("tele");
//		user1.setNom_usuario("c");
//		user1.setGeneracion("2022");
//		user1.setGenero(Genero.MACHO);
//		user1.setSemestre(1);
//		user1.setItr_s(itrS);
//		
//		estudianteBean.addStudent(user1);
//		
//		TUTOR tutor = new TUTOR();
//		tutor.setNombre("fasgasa");
//		tutor.setApellido("casasfas");
//		tutor.setDocumento(53123);
//		tutor.setMail("m");
//		tutor.setContrasena("t");
//		tutor.setDepartamento(Departamento.DURAZNO);
//		tutor.setTelefono("tele");
//		tutor.setNom_usuario("t");
//		tutor.setArea("Area1");
//		tutor.setTipo("Tipo1");
//		tutor.setItr_s(itrS);
//		
//		tutorBean.addTutor(tutor);
//		
//		ANALISTA analista = new ANALISTA();
//		analista.setNombre("fasgasa");
//		analista.setApellido("casasfas");
//		analista.setDocumento(2315123);
//		analista.setMail("m");
//		analista.setContrasena("m");
//		analista.setDepartamento(Departamento.CANELONES);
//		analista.setTelefono("tele");
//		analista.setNom_usuario("m");
//		analista.setItr_s(itrS);
//		
//		analistaBean.addAnalista(analista);
		
		
	}

}
