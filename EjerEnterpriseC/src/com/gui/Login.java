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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class Login {

	private JFrame frmProgramaIncreible;
	public JTextField tfUser;
	public JPasswordField tfContra;
	public JButton btnIngresar;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1;

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
		frmProgramaIncreible.setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/PNG/logoUtec.png")));
		frmProgramaIncreible.setResizable(false);
		frmProgramaIncreible.setTitle("Programa Incre\u00EDble");
		frmProgramaIncreible.setBackground(Color.WHITE);
		frmProgramaIncreible.getContentPane().setFont(new Font("SimSun", Font.PLAIN, 11));
		frmProgramaIncreible.getContentPane().setBackground(Color.WHITE);
		frmProgramaIncreible.getContentPane().setForeground(UIManager.getColor("Button.light"));
		frmProgramaIncreible.setBounds(100, 100, 476, 404);
		frmProgramaIncreible.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProgramaIncreible.setLocationRelativeTo(null);
				
				JLabel lblInicioDeSesion = new JLabel("Inicio de Sesi\u00F3n");
				lblInicioDeSesion.setBounds(10, 26, 203, 28);
				lblInicioDeSesion.setHorizontalAlignment(SwingConstants.CENTER);
				lblInicioDeSesion.setFont(new Font("SimSun", Font.BOLD, 24));
		
				JLabel lblNewLabel = new JLabel("USUARIO");
				lblNewLabel.setBounds(53, 100, 60, 19);
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setFont(new Font("SimSun", Font.BOLD, 16));
		
				tfUser = new JTextField();
				tfUser.setToolTipText("Ej: nombre.apellido");
				tfUser.setBounds(168, 100, 136, 20);
				tfUser.setColumns(10);
		
				JLabel lblContrasea = new JLabel("CONTRASE\u00D1A");
				lblContrasea.setBounds(53, 141, 85, 19);
				lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
				lblContrasea.setFont(new Font("SimSun", Font.BOLD, 16));
				
						tfContra = new JPasswordField();
						tfContra.setBounds(168, 141, 136, 20);
		
				btnIngresar = new JButton("Ingresar");
				btnIngresar.setBounds(336, 293, 114, 25);
				btnIngresar.setFont(new Font("SimSun", Font.BOLD, 13));
				
					
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(336, 329, 114, 25);
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
		frmProgramaIncreible.getContentPane().setLayout(null);
		frmProgramaIncreible.getContentPane().add(btnRegistrar);
		frmProgramaIncreible.getContentPane().add(lblContrasea);
		frmProgramaIncreible.getContentPane().add(tfContra);
		frmProgramaIncreible.getContentPane().add(btnIngresar);
		frmProgramaIncreible.getContentPane().add(lblInicioDeSesion);
		frmProgramaIncreible.getContentPane().add(lblNewLabel);
		frmProgramaIncreible.getContentPane().add(tfUser);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/PNG/logoUtec.png")));
		lblNewLabel_2.setBounds(390, 11, 60, 65);
		frmProgramaIncreible.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/PNG/UtecF.png")));
		lblNewLabel_1.setBounds(-13, 11, 483, 366);
		frmProgramaIncreible.getContentPane().add(lblNewLabel_1);
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
				if(!tfUser.getText().isBlank() || !tfContra.getText().isBlank()) {
					String nom_usuario1 = tfUser.getText().toUpperCase();
					String clave = tfContra.getText();
					String nom_usuario = (nom_usuario1 + "@utec.edu.uy").toUpperCase();

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
				}else {
					JOptionPane.showMessageDialog(null, "Debe ingresar nombre de usuario y contraseña");
				}
				

			}
		});
	}

	public JFrame getFrame() {
		return this.frmProgramaIncreible;
	}
}
