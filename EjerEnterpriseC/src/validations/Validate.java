package validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {

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
	
	public boolean nameAndLast(String nombre) {
		
		if (nombre.length() >= 3 && nombre.length() <= 21)
			return true;
		return false;
		
	}

}
