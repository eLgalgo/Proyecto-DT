package com.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;

import com.entities.ANALISTA;
import com.entities.ESTUDIANTE;
import com.entities.ITR;
import com.entities.TUTOR;
import com.entities.USUARIO;
import com.enums.Departamento;
import com.enums.Estado;
import com.enums.Genero;
import com.enums.Localidad;
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
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;

public class Mod_Analista {

	private JFrame frmModificacionDeUsuario;
	private JTextField tfTelefono;
	private JTextField tfEmail;
	private JTextField tfMailInsti;
	private JPasswordField tfContrase�a;
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfDocumento;

	/**
	 * Create the application.
	 */
	public Mod_Analista(ANALISTA usuario) throws NamingException{
		initialize(usuario);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws NamingException 
	 */
	private void initialize(ANALISTA usuario) throws NamingException {
		frmModificacionDeUsuario = new JFrame();
		frmModificacionDeUsuario.setTitle("Modificacion de Analista");
		frmModificacionDeUsuario.setResizable(false);
		frmModificacionDeUsuario.setIconImage(Toolkit.getDefaultToolkit().getImage("Z:\\ONE DRIVE\\OneDrive\\Escritorio\\PNG\\logoUtec.png"));
		frmModificacionDeUsuario.getContentPane().setBackground(Color.WHITE);
		frmModificacionDeUsuario.getContentPane().setLayout(null);
		frmModificacionDeUsuario.setLocationRelativeTo(null);
		
		JLabel lblNewLabel_2 = new JLabel("MODIFICACI\u00D3N DE ANALISTA");
		lblNewLabel_2.setBounds(10, 11, 273, 34);
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
		
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Departamento");
		lblNewLabel_1_2_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_2_1.setBounds(151, 100, 91, 14);
		frmModificacionDeUsuario.getContentPane().add(lblNewLabel_1_2_1);
		
		JComboBox<Departamento> comboBoxDep = new javax.swing.JComboBox<>();
		comboBoxDep.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxDep.setBounds(151, 124, 131, 22);
		comboBoxDep.setModel(new DefaultComboBoxModel(Departamento.values()));
		frmModificacionDeUsuario.getContentPane().add(comboBoxDep);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("ITR");
		lblNewLabel_1_2_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_2_1_1_1.setBounds(151, 154, 42, 14);
		frmModificacionDeUsuario.getContentPane().add(lblNewLabel_1_2_1_1_1);
		
		JComboBox<String> comboBoxItr = new JComboBox<>();
		comboBoxItr.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxItr.setBounds(151, 176, 131, 22);
		List<ITR> listItr = usuario.getItr_s();
		for(ITR elemento : listItr) {
		    comboBoxItr.addItem(elemento.getNombre());
		}
		frmModificacionDeUsuario.getContentPane().add(comboBoxItr);
		
		JLabel lblUsuario = new JLabel("Mail Institucional");
		lblUsuario.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblUsuario.setBounds(293, 101, 131, 14);
		frmModificacionDeUsuario.getContentPane().add(lblUsuario);
		
		tfMailInsti = new JTextField();
		tfMailInsti.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfMailInsti.setColumns(10);
		tfMailInsti.setBounds(293, 125, 131, 20);
		frmModificacionDeUsuario.getContentPane().add(tfMailInsti);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblContrasea.setBounds(293, 154, 70, 14);
		frmModificacionDeUsuario.getContentPane().add(lblContrasea);
		
		tfContrase�a = new JPasswordField();
		tfContrase�a.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfContrase�a.setBounds(292, 177, 132, 20);
		frmModificacionDeUsuario.getContentPane().add(tfContrase�a);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("SimSun", Font.BOLD, 14));
		btnGuardar.setBounds(187, 267, 97, 23);
		frmModificacionDeUsuario.getContentPane().add(btnGuardar);
		
		JButton btnCancelar = new JButton("Volver");
		btnCancelar.setFont(new Font("SimSun", Font.BOLD, 13));
		btnCancelar.setBounds(327, 267, 97, 23);
		frmModificacionDeUsuario.getContentPane().add(btnCancelar);
		frmModificacionDeUsuario.setBounds(100, 100, 450, 340);
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
		tfApellido.setBounds(151, 69, 131, 20);
		frmModificacionDeUsuario.getContentPane().add(tfApellido);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblApellido.setBounds(151, 45, 64, 14);
		frmModificacionDeUsuario.getContentPane().add(lblApellido);
		
		tfDocumento = new JTextField();
		tfDocumento.setText((String) null);
		tfDocumento.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfDocumento.setColumns(10);
		tfDocumento.setBounds(293, 70, 131, 20);
		frmModificacionDeUsuario.getContentPane().add(tfDocumento);
		
		JLabel lblDocumento = new JLabel("Documento");
		lblDocumento.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblDocumento.setBounds(293, 46, 64, 14);
		frmModificacionDeUsuario.getContentPane().add(lblDocumento);
		
		tfContrase�a.setText(usuario.getContrasena());
		tfNombre.setText(usuario.getNombre());
		tfApellido.setText(usuario.getApellido());
		tfTelefono.setText(usuario.getTelefono());
		tfEmail.setText(usuario.getMail());
		tfMailInsti.setText(usuario.getMail_insti());
		tfDocumento.setText(Integer.toString(usuario.getDocumento()));
		tfMailInsti.setText(usuario.getMail_insti());
		comboBoxDep.setSelectedIndex(usuario.getDepartamento().ordinal());
		
		JComboBox<Estado> comboBoxEstado = new javax.swing.JComboBox<>();
		comboBoxEstado.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxEstado.setBounds(10, 240, 131, 22);
		comboBoxEstado.setModel(new DefaultComboBoxModel(Estado.values()));
		comboBoxEstado.setSelectedIndex(usuario.getEstado().ordinal());
		frmModificacionDeUsuario.getContentPane().add(comboBoxEstado);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblEstado.setBounds(10, 215, 64, 14);
		frmModificacionDeUsuario.getContentPane().add(lblEstado);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(293, 229, 131, 20);
		frmModificacionDeUsuario.getContentPane().add(dateChooser);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
		lblFechaDeNacimiento.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblFechaDeNacimiento.setBounds(293, 208, 131, 14);
		frmModificacionDeUsuario.getContentPane().add(lblFechaDeNacimiento);
		
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
					usuario.setApellido(tfApellido.getText());
					usuario.setNombre(tfNombre.getText());
					usuario.setContrasena(tfContrase�a.getText());
					usuario.setDocumento(Integer.parseInt(tfDocumento.getText()));
					usuario.setMail(tfEmail.getText());
					usuario.setTelefono(tfTelefono.getText());
					usuario.setMail_insti(tfMailInsti.getText());
					usuario.setDepartamento(Departamento.valueOf(comboBoxDep.getSelectedItem().toString()));
					usuario.setEstado(Estado.valueOf(comboBoxEstado.getSelectedItem().toString()));
					
					try {
						analistaBean.editAnalista((ANALISTA) usuario);
					} catch (ServiciosException e1) {
						e1.printStackTrace();
					}
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
