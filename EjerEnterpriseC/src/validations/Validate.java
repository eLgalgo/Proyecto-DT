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
	public boolean mailInsti(String email) {

		final String dom = "@utec.edu.uy";

		if (email.contains(dom)) {
			String usuario = email.substring(0, email.indexOf("@"));
			if (usuario.contains(".") && usuario.length() >= 7) {
				return true;
			}
		}
		return false;
	}

	//Controla que el email ingresado sea válido
	//Mediante una expresión regular
	public boolean email(String email) {

		Pattern pattern = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

		Matcher mather = pattern.matcher(email);

		if (mather.find() == true) {
			return true;
		} else {
			return false;
		}

	}
	
	//Valida que la contraseña tenga largo 8 o +
	//y que contenga al menos un número #
	public boolean pass(String pass) {

		if (pass.length() >= 8) {
			char[] chars = pass.toCharArray();

			for (char c : chars) {
				if (Character.isDigit(c)) {
					return true;
				}
			}
		}
		return false;
	}

	//Valida que nombre y apellido tengan entre 3 y 21 caracteres
	public boolean nameAndLast(String dato) {

		if (dato.length() >= 3 && dato.length() <= 21)
			return true;
		return false;

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

}
