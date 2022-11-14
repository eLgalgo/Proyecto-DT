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

public class Login{

	private JFrame frmProgramaIncreible;
	public JTextField tfUser;
	public JPasswordField tfContra;
	public JButton btnNewButton;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Login()throws NamingException  {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws NamingException 
	 */
	private void initialize() throws NamingException {
		frmProgramaIncreible = new JFrame();
		frmProgramaIncreible.setTitle("Programa Increible");
		frmProgramaIncreible.setBackground(Color.WHITE);
		frmProgramaIncreible.setResizable(false);
		frmProgramaIncreible.getContentPane().setFont(new Font("SimSun", Font.PLAIN, 11));
		frmProgramaIncreible.getContentPane().setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));
		frmProgramaIncreible.getContentPane().setForeground(Color.WHITE);
		frmProgramaIncreible.setBounds(100, 100, 293, 332);
		frmProgramaIncreible.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProgramaIncreible.getContentPane().setLayout(null);
		frmProgramaIncreible.setLocationRelativeTo(null);
		
		tfUser = new JTextField();
		tfUser.setBounds(58, 62, 157, 27);
		frmProgramaIncreible.getContentPane().add(tfUser);
		tfUser.setColumns(10);
		
		btnNewButton = new JButton("Ingresar");
		btnNewButton.setFont(new Font("SimSun", Font.BOLD, 13));
		btnNewButton.setBounds(84, 168, 106, 33);
		frmProgramaIncreible.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("USUARIO");
		lblNewLabel.setFont(new Font("SimSun", Font.BOLD, 16));
		lblNewLabel.setBounds(58, 44, 82, 14);
		frmProgramaIncreible.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Registrarme");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("SimSun", Font.BOLD, 13));
		btnNewButton_1.setBounds(84, 212, 106, 33);
		frmProgramaIncreible.getContentPane().add(btnNewButton_1);
		
		JLabel lblContrasea = new JLabel("CONTRASE\u00D1A");
		lblContrasea.setFont(new Font("SimSun", Font.BOLD, 16));
		lblContrasea.setBounds(58, 109, 106, 20);
		frmProgramaIncreible.getContentPane().add(lblContrasea);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("Z:\\ONE DRIVE\\OneDrive\\Escritorio\\PNG\\NC 100.jpg"));
		lblNewLabel_1.setBounds(161, 11, 106, 33);
		frmProgramaIncreible.getContentPane().add(lblNewLabel_1);
		
		tfContra = new JPasswordField();
		tfContra.setBounds(58, 130, 157, 27);
		frmProgramaIncreible.getContentPane().add(tfContra);
		frmProgramaIncreible.setLocationRelativeTo(null);
		
		//Logica botones
		EstudianteBeanRemote estudianteBean = (EstudianteBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/EstudianteBean!com.services.EstudianteBeanRemote");
		
		TutorBeanRemote tutorBean = (TutorBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/TutorBean!com.services.TutorBeanRemote");
		
		AnalistaBeanRemote analistaBean = (AnalistaBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/AnalistaBean!com.services.AnalistaBeanRemote");
		
		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/UsuarioBean!com.services.UsuarioBeanRemote");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom_usuario = tfUser.getText();
				String clave = tfContra.getText();
				
				try {
					List<USUARIO> usuario = usuarioBean.findUser(nom_usuario, clave);
					if(usuario.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Usuario o Contraseña Incorrecta");
					}else {
						if(usuario.get(0) instanceof ESTUDIANTE) {
							Ppal_Estudiante principalStudentW = new Ppal_Estudiante();
							principalStudentW.setVisible(true);
							principalStudentW.setLocationRelativeTo(null);
							getFrame().dispose();
						}else if(usuario.get(0) instanceof TUTOR) {
							Ppal_Analista principalTutorW = new Ppal_Analista();
							principalTutorW.setVisible(true);
							principalTutorW.setLocationRelativeTo(null);
							getFrame().dispose();
						}else if(usuario.get(0) instanceof ANALISTA) {
							Ppal_Tutor principalAnalistW = new Ppal_Tutor();
							principalAnalistW.setVisible(true);
							principalAnalistW.setLocationRelativeTo(null);
							getFrame().dispose();
						}
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
