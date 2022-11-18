package com.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.entities.ANALISTA;
import com.entities.USUARIO;
import com.enums.Departamento;
import com.enums.EITRs;
import com.enums.EstadoUsuario;
import com.enums.Localidad;
import com.exception.ServiciosException;
import com.services.AnalistaBeanRemote;
import com.services.UsuarioBeanRemote;
import com.toedter.calendar.JDateChooser;

public class Alta_Usuario_Analista {

	private JFrame frmAltaDeUsuarioA;
	private JTextField tfTelefono;
	private JTextField tfEmail;
	private JTextField tfMailInsti;
	private JPasswordField tfContraseña;
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfDocumento;

	/**
	 * Create the application.
	 */
	public Alta_Usuario_Analista(USUARIO usuario) throws NamingException {
		initialize(usuario);
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws NamingException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize(USUARIO usuario) throws NamingException {
		AnalistaBeanRemote analistaBean = (AnalistaBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/AnalistaBean!com.services.AnalistaBeanRemote");
		frmAltaDeUsuarioA = new JFrame();
		frmAltaDeUsuarioA.setTitle("Alta de Usuario Analista");
		frmAltaDeUsuarioA.setResizable(false);
		frmAltaDeUsuarioA.setIconImage(
				Toolkit.getDefaultToolkit().getImage("Z:\\ONE DRIVE\\OneDrive\\Escritorio\\PNG\\logoUtec.png"));
		frmAltaDeUsuarioA.getContentPane().setBackground(Color.WHITE);
		frmAltaDeUsuarioA.getContentPane().setLayout(null);
		frmAltaDeUsuarioA.setLocationRelativeTo(null);

		JLabel lblNewLabel_2 = new JLabel("ALTA DE ANALISTA");
		lblNewLabel_2.setBounds(10, 11, 273, 34);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("SimSun", Font.BOLD, 16));
		frmAltaDeUsuarioA.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("Tel\u00E9fono");
		lblNewLabel_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 101, 64, 14);
		frmAltaDeUsuarioA.getContentPane().add(lblNewLabel_1);

		JLabel lblCorreo = new JLabel("Email");
		lblCorreo.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblCorreo.setBounds(151, 101, 64, 14);
		frmAltaDeUsuarioA.getContentPane().add(lblCorreo);

		JLabel lblNewLabel_1_2_1 = new JLabel("Departamento");
		lblNewLabel_1_2_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_2_1.setBounds(151, 158, 91, 14);
		frmAltaDeUsuarioA.getContentPane().add(lblNewLabel_1_2_1);
		
		JLabel lblUsuario = new JLabel("Mail Institucional");
		lblUsuario.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblUsuario.setBounds(293, 101, 131, 14);
		frmAltaDeUsuarioA.getContentPane().add(lblUsuario);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("ITR");
		lblNewLabel_1_2_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_2_1_1_1.setBounds(151, 212, 42, 14);
		frmAltaDeUsuarioA.getContentPane().add(lblNewLabel_1_2_1_1_1);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblContrasea.setBounds(293, 154, 70, 14);
		frmAltaDeUsuarioA.getContentPane().add(lblContrasea);

		JLabel lblNewLabel_1_1 = new JLabel("Nombre");
		lblNewLabel_1_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(10, 46, 64, 14);
		frmAltaDeUsuarioA.getContentPane().add(lblNewLabel_1_1);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblApellido.setBounds(151, 45, 64, 14);
		frmAltaDeUsuarioA.getContentPane().add(lblApellido);

		JLabel lblDocumento = new JLabel("Documento");
		lblDocumento.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblDocumento.setBounds(293, 46, 64, 14);
		frmAltaDeUsuarioA.getContentPane().add(lblDocumento);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblEstado.setBounds(10, 212, 64, 14);
		frmAltaDeUsuarioA.getContentPane().add(lblEstado);

		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
		lblFechaDeNacimiento.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblFechaDeNacimiento.setBounds(293, 208, 131, 14);
		frmAltaDeUsuarioA.getContentPane().add(lblFechaDeNacimiento);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Localidad");
		lblNewLabel_1_2_1_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_2_1_1.setBounds(10, 158, 91, 14);
		frmAltaDeUsuarioA.getContentPane().add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel = new JLabel("DE");
		lblNewLabel.setBounds(127, 186, 22, 14);
		frmAltaDeUsuarioA.getContentPane().add(lblNewLabel);
		
		
		
		//TextFields
		
		tfTelefono = new JTextField();
		tfTelefono.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfTelefono.setColumns(10);
		tfTelefono.setBounds(10, 125, 131, 20);
		frmAltaDeUsuarioA.getContentPane().add(tfTelefono);

		tfEmail = new JTextField();
		tfEmail.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfEmail.setColumns(10);
		tfEmail.setBounds(151, 124, 131, 20);
		frmAltaDeUsuarioA.getContentPane().add(tfEmail);


		tfMailInsti = new JTextField();
		tfMailInsti.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfMailInsti.setColumns(10);
		tfMailInsti.setBounds(293, 125, 131, 20);
		frmAltaDeUsuarioA.getContentPane().add(tfMailInsti);

		tfContraseña = new JPasswordField();
		tfContraseña.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfContraseña.setBounds(292, 177, 132, 20);
		frmAltaDeUsuarioA.getContentPane().add(tfContraseña);

		
		tfNombre = new JTextField();
		tfNombre.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfNombre.setColumns(10);
		tfNombre.setBounds(10, 70, 131, 20);
		frmAltaDeUsuarioA.getContentPane().add(tfNombre);

		tfApellido = new JTextField();
		tfApellido.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfApellido.setColumns(10);
		tfApellido.setBounds(151, 69, 131, 20);
		frmAltaDeUsuarioA.getContentPane().add(tfApellido);

		tfDocumento = new JTextField();
		tfDocumento.setText((String) null);
		tfDocumento.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfDocumento.setColumns(10);
		tfDocumento.setBounds(293, 70, 131, 20);
		frmAltaDeUsuarioA.getContentPane().add(tfDocumento);


		
		//Comboboxes Dates
		
		
		
		JComboBox<Departamento> comboBoxDep = new javax.swing.JComboBox<>();
		comboBoxDep.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxDep.setBounds(151, 182, 131, 22);
     	comboBoxDep.setModel(new DefaultComboBoxModel(Departamento.values()));
		frmAltaDeUsuarioA.getContentPane().add(comboBoxDep);



		JComboBox<EITRs> comboBoxItr = new JComboBox<>();
		comboBoxItr.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxItr.setBounds(151, 234, 131, 22);
		comboBoxItr.setModel(new DefaultComboBoxModel(EITRs.values()));
		frmAltaDeUsuarioA.getContentPane().add(comboBoxItr);

	
		JComboBox<EstadoUsuario> comboBoxEstado = new javax.swing.JComboBox<>();
		comboBoxEstado.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxEstado.setBounds(10, 234, 131, 22);
		comboBoxEstado.setModel(new DefaultComboBoxModel(EstadoUsuario.values()));
		frmAltaDeUsuarioA.getContentPane().add(comboBoxEstado);

		JComboBox<Localidad> comboBoxLoc = new JComboBox<Localidad>();
		comboBoxLoc.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxLoc.setBounds(10, 182, 107, 22);
		comboBoxLoc.setModel(new DefaultComboBoxModel(Localidad.values()));
		frmAltaDeUsuarioA.getContentPane().add(comboBoxLoc);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(293, 229, 131, 20);
		Calendar today = Calendar.getInstance();
		today.clear(Calendar.HOUR);
		today.clear(Calendar.MINUTE);
		today.clear(Calendar.SECOND);
		Date todayDate = today.getTime();
		dateChooser.setMaxSelectableDate(todayDate);
		@SuppressWarnings("unused")
		ZoneId defaultZoneId = ZoneId.systemDefault();
		frmAltaDeUsuarioA.getContentPane().add(dateChooser);

		
		
		
		//Botones
		
		
		
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
			
				ANALISTA Analista=new ANALISTA();
				Analista.setApellido(tfApellido.getText());
				Analista.setNombre(tfNombre.getText());
				Analista.setContrasena(tfContraseña.getText());
				Analista.setDocumento(Integer.parseInt(tfDocumento.getText()));
				Analista.setMail(tfEmail.getText());
				Analista.setTelefono(tfTelefono.getText());
				Analista.setMail_insti(tfMailInsti.getText());
				Analista.setDepartamento(Departamento.valueOf(comboBoxDep.getSelectedItem().toString()));
				Analista.setEstado(EstadoUsuario.valueOf(comboBoxEstado.getSelectedItem().toString()));
				Analista.setLocalidad(Localidad.valueOf(comboBoxLoc.getSelectedItem().toString()));
				Analista.setItr(EITRs.valueOf(comboBoxItr.getSelectedItem().toString()));
			Analista.setFechaNac(dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		
				try {
					
					analistaBean.addAnalista(Analista);
				} catch (ServiciosException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnGuardar.setFont(new Font("SimSun", Font.BOLD, 14));
		btnGuardar.setBounds(187, 267, 97, 23);
		frmAltaDeUsuarioA.getContentPane().add(btnGuardar);
		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/UsuarioBean!com.services.UsuarioBeanRemote");
		JButton btnCancelar = new JButton("Volver");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ppal_Analista pAnalist = null;
				try {
					ANALISTA usuario2 = null;
					try {
						usuario2 = (ANALISTA) usuarioBean.findUser(usuario.getDocumento()).get(0);
					} catch (ServiciosException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					pAnalist = new Ppal_Analista(usuario2);
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pAnalist.setVisible(true);
				pAnalist.setLocationRelativeTo(null);
				getFrame().dispose();
			}
		});
		btnCancelar.setFont(new Font("SimSun", Font.BOLD, 13));
		btnCancelar.setBounds(327, 267, 97, 23);
		frmAltaDeUsuarioA.getContentPane().add(btnCancelar);
		frmAltaDeUsuarioA.setBounds(100, 100, 450, 340);
		frmAltaDeUsuarioA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	
		
	}

	public Window getFrame() {
		// TODO Auto-generated method stub
		return this.frmAltaDeUsuarioA;
	}
	}
