package com.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;

import com.entities.USUARIO;
import com.exception.ServiciosException;
import com.services.AnalistaBeanRemote;
import com.services.EstudianteBeanRemote;
import com.services.TutorBeanRemote;
import com.services.UsuarioBeanRemote;

import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import java.awt.Toolkit;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mod_Usuario {

	private JFrame frmModificacionDeUsuario;
	private JTextField tfTelefono;
	private JTextField tfEmail;
	private JTextField tfUsuario;
	private JPasswordField tfContraseña;
	private JTextField tfNombre;
	private JTextField tfApellido;

	/**
	 * Create the application.
	 */
	public Mod_Usuario(USUARIO usuario) throws NamingException{
		initialize(usuario);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws NamingException 
	 */
	private void initialize(USUARIO usuario) throws NamingException {
		frmModificacionDeUsuario = new JFrame();
		frmModificacionDeUsuario.setTitle("Modificacion de Usuario");
		frmModificacionDeUsuario.setResizable(false);
		frmModificacionDeUsuario.setIconImage(Toolkit.getDefaultToolkit().getImage("Z:\\ONE DRIVE\\OneDrive\\Escritorio\\PNG\\logoUtec.png"));
		frmModificacionDeUsuario.getContentPane().setBackground(Color.WHITE);
		frmModificacionDeUsuario.getContentPane().setLayout(null);
		frmModificacionDeUsuario.setLocationRelativeTo(null);
		
		JLabel lblNewLabel_2 = new JLabel("MODIFICACI\u00D3N DE USUARIO");
		lblNewLabel_2.setBounds(10, 11, 203, 34);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("SimSun", Font.BOLD, 16));
		frmModificacionDeUsuario.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Tel\u00E9fono");
		lblNewLabel_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 101, 64, 14);
		frmModificacionDeUsuario.getContentPane().add(lblNewLabel_1);
		
		tfTelefono = new JTextField();
		tfTelefono.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfTelefono.setColumns(10);
		tfTelefono.setBounds(10, 125, 131, 20);
		frmModificacionDeUsuario.getContentPane().add(tfTelefono);
		
		JLabel lblCorreo = new JLabel("Email");
		lblCorreo.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblCorreo.setBounds(10, 154, 64, 14);
		frmModificacionDeUsuario.getContentPane().add(lblCorreo);
		
		tfEmail = new JTextField();
		tfEmail.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfEmail.setColumns(10);
		tfEmail.setBounds(10, 177, 131, 20);
		frmModificacionDeUsuario.getContentPane().add(tfEmail);
		
		JLabel lblNewLabel_1_2 = new JLabel("Localidad");
		lblNewLabel_1_2.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(10, 208, 64, 14);
		frmModificacionDeUsuario.getContentPane().add(lblNewLabel_1_2);
		
		JComboBox comboBoxLocal = new JComboBox();
		comboBoxLocal.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxLocal.setBounds(10, 228, 131, 22);
		frmModificacionDeUsuario.getContentPane().add(comboBoxLocal);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Departamento");
		lblNewLabel_1_2_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_2_1.setBounds(151, 100, 91, 14);
		frmModificacionDeUsuario.getContentPane().add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("G\u00E9nero");
		lblNewLabel_1_2_1_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_2_1_1.setBounds(151, 154, 52, 14);
		frmModificacionDeUsuario.getContentPane().add(lblNewLabel_1_2_1_1);
		
		JComboBox comboBoxDep = new JComboBox();
		comboBoxDep.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxDep.setBounds(151, 124, 131, 22);
		frmModificacionDeUsuario.getContentPane().add(comboBoxDep);
		
		JComboBox comboBoxGen = new JComboBox();
		comboBoxGen.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxGen.setBounds(151, 176, 62, 22);
		frmModificacionDeUsuario.getContentPane().add(comboBoxGen);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("ITR");
		lblNewLabel_1_2_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_2_1_1_1.setBounds(218, 154, 42, 14);
		frmModificacionDeUsuario.getContentPane().add(lblNewLabel_1_2_1_1_1);
		
		JComboBox comboBoxItr = new JComboBox();
		comboBoxItr.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxItr.setBounds(218, 176, 64, 22);
		frmModificacionDeUsuario.getContentPane().add(comboBoxItr);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblUsuario.setBounds(293, 101, 64, 14);
		frmModificacionDeUsuario.getContentPane().add(lblUsuario);
		
		tfUsuario = new JTextField();
		tfUsuario.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfUsuario.setColumns(10);
		tfUsuario.setBounds(293, 125, 131, 20);
		frmModificacionDeUsuario.getContentPane().add(tfUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblContrasea.setBounds(293, 154, 70, 14);
		frmModificacionDeUsuario.getContentPane().add(lblContrasea);
		
		tfContraseña = new JPasswordField();
		tfContraseña.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfContraseña.setBounds(292, 177, 132, 20);
		frmModificacionDeUsuario.getContentPane().add(tfContraseña);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("SimSun", Font.BOLD, 14));
		btnGuardar.setBounds(327, 223, 97, 23);
		frmModificacionDeUsuario.getContentPane().add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("SimSun", Font.BOLD, 13));
		btnCancelar.setBounds(327, 255, 97, 23);
		frmModificacionDeUsuario.getContentPane().add(btnCancelar);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("Z:\\ONE DRIVE\\OneDrive\\Escritorio\\PNG\\modUser.png"));
		lblNewLabel_3.setBounds(258, 235, 46, 43);
		frmModificacionDeUsuario.getContentPane().add(lblNewLabel_3);
		frmModificacionDeUsuario.setBounds(100, 100, 450, 325);
		frmModificacionDeUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tfNombre = new JTextField();
		tfNombre.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfNombre.setColumns(10);
		tfNombre.setBounds(10, 70, 131, 20);
		frmModificacionDeUsuario.getContentPane().add(tfNombre);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre");
		lblNewLabel_1_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(10, 46, 64, 14);
		frmModificacionDeUsuario.getContentPane().add(lblNewLabel_1_1);
		
		tfApellido = new JTextField();
		tfApellido.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfApellido.setColumns(10);
		tfApellido.setBounds(293, 70, 131, 20);
		frmModificacionDeUsuario.getContentPane().add(tfApellido);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblApellido.setBounds(293, 46, 64, 14);
		frmModificacionDeUsuario.getContentPane().add(lblApellido);
		
		tfContraseña.setText(usuario.getContrasena());
		tfNombre.setText(usuario.getNombre());
		tfApellido.setText(usuario.getApellido());
		tfTelefono.setText(usuario.getTelefono());
		tfEmail.setText(usuario.getMail());
		tfUsuario.setText(usuario.getNom_usuario());
		
		//Logica
		
        EstudianteBeanRemote estudianteBean = (EstudianteBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/EstudianteBean!com.services.EstudianteBeanRemote");
		
		TutorBeanRemote tutorBean = (TutorBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/TutorBean!com.services.TutorBeanRemote");
		
		AnalistaBeanRemote analistaBean = (AnalistaBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/AnalistaBean!com.services.AnalistaBeanRemote");
		
		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/UsuarioBean!com.services.UsuarioBeanRemote");
		
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListUsers list = null;
				try {
					list = new ListUsers(usuarioBean.listAllUsers());
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				list.getFrame().setVisible(true);
				list.getFrame().setLocationRelativeTo(null);
				getFrame().dispose();
			}
		});
	}
	
	JFrame getFrame() {
		return this.frmModificacionDeUsuario;
	}
}
