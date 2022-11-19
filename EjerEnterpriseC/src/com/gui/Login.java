package com.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.entities.ANALISTA;
import com.entities.ESTUDIANTE;
import com.entities.TUTOR;
import com.entities.USUARIO;
import com.exception.ServiciosException;
import com.services.AnalistaBeanRemote;
import com.services.EstudianteBeanRemote;
import com.services.TutorBeanRemote;
import com.services.UsuarioBeanRemote;

import org.wildfly.security.sasl.util.DisposedCallbackSaslClientFactory;
import javax.swing.SwingConstants;

public class Login {

	private JFrame frmProgramaIncreible;
	public JTextField tfUser;
	public JPasswordField tfContra;
	public JButton btnIngresar;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Login() throws NamingException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws NamingException
	 */
	private void initialize() throws NamingException {
		frmProgramaIncreible = new JFrame();
		frmProgramaIncreible.setResizable(false);
		frmProgramaIncreible.setTitle("Programa Increible");
		frmProgramaIncreible.setBackground(Color.WHITE);
		frmProgramaIncreible.getContentPane().setFont(new Font("SimSun", Font.PLAIN, 11));
		frmProgramaIncreible.getContentPane().setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));
		frmProgramaIncreible.getContentPane().setForeground(Color.WHITE);
		frmProgramaIncreible.setBounds(100, 100, 306, 332);
		frmProgramaIncreible.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProgramaIncreible.getContentPane().setLayout(null);
		frmProgramaIncreible.setLocationRelativeTo(null);

		tfUser = new JTextField();
		tfUser.setBounds(65, 76, 157, 27);
		frmProgramaIncreible.getContentPane().add(tfUser);
		tfUser.setColumns(10);

		btnIngresar = new JButton("Ingresar");
		btnIngresar.setFont(new Font("SimSun", Font.BOLD, 13));
		btnIngresar.setBounds(91, 182, 106, 33);
		frmProgramaIncreible.getContentPane().add(btnIngresar);

		JLabel lblNewLabel = new JLabel("USUARIO");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("SimSun", Font.BOLD, 16));
		lblNewLabel.setBounds(65, 58, 157, 14);
		frmProgramaIncreible.getContentPane().add(lblNewLabel);

		JLabel lblContrasea = new JLabel("CONTRASE\u00D1A");
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setFont(new Font("SimSun", Font.BOLD, 16));
		lblContrasea.setBounds(65, 123, 157, 20);
		frmProgramaIncreible.getContentPane().add(lblContrasea);

		tfContra = new JPasswordField();
		tfContra.setBounds(65, 144, 157, 27);
		frmProgramaIncreible.getContentPane().add(tfContra);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmProgramaIncreible.dispose();
				Registro_Usuario_Nuevo reg = null;
				try {
					reg = new Registro_Usuario_Nuevo();
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				reg.getFrame().setVisible(true);
			}
		});
		btnRegistrar.setFont(new Font("SimSun", Font.BOLD, 13));
		btnRegistrar.setBounds(91, 228, 106, 33);
		frmProgramaIncreible.getContentPane().add(btnRegistrar);
		
		JLabel lblInicioDeSesion = new JLabel("Inicio de Sesion");
		lblInicioDeSesion.setHorizontalAlignment(SwingConstants.CENTER);
		lblInicioDeSesion.setFont(new Font("SimSun", Font.BOLD, 24));
		lblInicioDeSesion.setBounds(10, 11, 270, 27);
		frmProgramaIncreible.getContentPane().add(lblInicioDeSesion);
		frmProgramaIncreible.setLocationRelativeTo(null);

		// Logica botones
		EstudianteBeanRemote estudianteBean = (EstudianteBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/EstudianteBean!com.services.EstudianteBeanRemote");

		TutorBeanRemote tutorBean = (TutorBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/TutorBean!com.services.TutorBeanRemote");

		AnalistaBeanRemote analistaBean = (AnalistaBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/AnalistaBean!com.services.AnalistaBeanRemote");

		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/UsuarioBean!com.services.UsuarioBeanRemote");

		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom_usuario = tfUser.getText().toUpperCase();
				String clave = tfContra.getText();

				try {
					List<USUARIO> usuario = usuarioBean.findUser(nom_usuario, clave);
					if (usuario.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Usuario o Contraseña Incorrecta");
					} else if (usuario.get(0).getEstado().name() == "ACTIVO") {
						if (usuario.get(0) instanceof ESTUDIANTE) {
							ESTUDIANTE usuario2 = (ESTUDIANTE) usuarioBean.findUser(nom_usuario, clave).get(0);
							Ppal_Estudiante principalStudentW = new Ppal_Estudiante(usuario2);
							principalStudentW.setVisible(true);
							principalStudentW.setLocationRelativeTo(null);
							getFrame().dispose();
						} else if (usuario.get(0) instanceof TUTOR) {
							TUTOR usuario2 = (TUTOR) usuarioBean.findUser(nom_usuario, clave).get(0);
							Ppal_Tutor principalTutorW = new Ppal_Tutor(usuario2);
							principalTutorW.setVisible(true);
							principalTutorW.setLocationRelativeTo(null);
							getFrame().dispose();
						} else if (usuario.get(0) instanceof ANALISTA) {
							ANALISTA usuario2 = (ANALISTA) usuarioBean.findUser(nom_usuario, clave).get(0);
							Ppal_Analista principalanalistaW = new Ppal_Analista(usuario2);
							principalanalistaW.setVisible(true);
							principalanalistaW.setLocationRelativeTo(null);
							getFrame().dispose();
						}
					} else if (usuario.get(0).getEstado().name() == "SIN_CHEQUEAR") {
						JOptionPane.showMessageDialog(null, "Usuario inactivo");
					} else {
						JOptionPane.showMessageDialog(null, "¡Error! Usuario eliminado");
					}
				} catch (ServiciosException | NamingException e1) {
					e1.printStackTrace();
				}

			}
		});
	}

	public JFrame getFrame() {
		return this.frmProgramaIncreible;
	}
}
