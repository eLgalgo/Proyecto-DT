package validations;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.USUARIO;
import com.exception.ServiciosException;
import com.services.UsuarioBeanRemote;

public class Validate {

	//Valida que el email ingresado sea
	//de dominio @utec.edu.uy
	public boolean mailInsti(String email) throws ServiciosException {
		UsuarioBeanRemote usuarioBean = null;
		try {
			usuarioBean = (UsuarioBeanRemote) InitialContext
					.doLookup("EjEnterpriseEJB/UsuarioBean!com.services.UsuarioBeanRemote");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(usuarioBean.findUserByEmail(email).isEmpty()) {
			final String dom = "@utec.edu.uy";

			if (email.contains(dom)) {
				String usuario = email.substring(0, email.indexOf("@"));
				if (usuario.contains(".") && usuario.length() >= 7) {
					return true;
				}
			}
			throw new ServiciosException("Formato de email institucional incorrecto");
		}else {
			throw new ServiciosException("El email institucional ya existe");
		}
		
	}

	//Controla que el email ingresado sea válido
	//Mediante una expresión regular
	public boolean email(String email) throws ServiciosException {

		Pattern pattern = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

		Matcher mather = pattern.matcher(email);

		if (mather.find() == true) {
			return true;
		} else {
			throw new ServiciosException("Formato de email incorrecto");
		}

	}
	
	
	//Valida que la contraseña tenga largo 8 o +
	//y que contenga al menos un número #
	public boolean pass(String pass) throws ServiciosException {

		if (pass.length() >= 8 && !pass.isBlank()) {
			char[] chars = pass.toCharArray();

			for (char c : chars) {
				if (Character.isDigit(c)) {
					return true;
				}
			}
		}
		throw new ServiciosException("La contraseña debe tener 8 caracteres alfanuméricos");
	}

	//Valida que nombre y apellido tengan entre 3 y 21 caracteres
	public boolean nameAndLast(String dato) throws ServiciosException {

		if (dato.length() >= 3 && dato.length() <= 21 && !dato.isBlank())
			return true;
		
		throw new ServiciosException("El nombre y apellido deben tener entre 3 y 21 caracteres");

	}

	//Genera un mail institucional con dominio @utec.edu.uy
	//En caso de que el mail exista le añade un dígito numérico
	public String genUserMail(String nombre, String apellido) throws NamingException, ServiciosException {
		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/UsuarioBean!com.services.UsuarioBeanRemote");

		String email = "";
		final String dominio = "@utec.edu.uy";

		List<USUARIO> u = usuarioBean.findUserByNom(nombre, apellido);

		if (u.size() > 0) {
			return email = nombre + "." + apellido + "." + u.size() + dominio;
		}

		return email = nombre + "." + apellido + dominio;

	}
	
	//Genera nombre de usuario a partir de mail institucional
	public String getUserName(String email) {
		
		String username="";
		
		username.substring(0, email.indexOf("@"));
		
		return username;
		
	}
	
	public boolean documento(String documento) throws ServiciosException, NamingException {
		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/UsuarioBean!com.services.UsuarioBeanRemote");

		if(usuarioBean.findUser(Integer.parseInt(documento)).isEmpty()) {
			if(documento.length() < 7 || documento.length() > 9) {
				throw new ServiciosException("El documento debe contener entre 7 y 9 caracteres numéricos");
			}
			return true;
		}
		throw new ServiciosException("Documento ya ingeresado en el sistema");
	}
	
	public boolean documentoMod(String documento) throws ServiciosException, NamingException {
		if(documento.length() < 7 || documento.length() > 9) {
			throw new ServiciosException("El documento debe contener entre 7 y 9 caracteres numéricos");
		}
		return true;
	}
	
	public boolean telefono(String telefono) throws ServiciosException {
		if(telefono.length() < 8 || telefono.length() > 11) {
			throw new ServiciosException("El teléfono debe contener entre 8 y 11 caracteres numéricos");
		}
		return true;
		
	}
	
	public boolean area(String area) throws ServiciosException {
		if (area.isBlank()) {
			throw new ServiciosException("El área no puede estar vacía");
		}
		return true;
	}

}
