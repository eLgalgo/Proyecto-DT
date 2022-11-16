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

import com.entities.TUTOR;
import com.enums.Departamento;
import com.enums.EITRs;
import com.enums.Estado;
import com.enums.Localidad;
import com.enums.RolTutor;
import com.exception.ServiciosException;
import com.services.TutorBeanRemote;
import com.toedter.calendar.JDateChooser;

public class Alta_Usuario_Tutor {

	private JFrame frmAltaDeUsuarioT;
	private JTextField tfTelefono;
	private JTextField tfEmail;
	private JTextField tfMailInsti;
	private JPasswordField tfContraseña;
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfDocumento;
	private JTextField textFieldArea;

	/**
	 * Create the application.
	 */
	public Alta_Usuario_Tutor() throws NamingException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws NamingException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() throws NamingException {
		TutorBeanRemote tutorBean = (TutorBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/TutorBean!com.services.TutorBeanRemote");
		
		frmAltaDeUsuarioT = new JFrame();
		frmAltaDeUsuarioT.setTitle("Alta de Usuario Tutor");
		frmAltaDeUsuarioT.setResizable(false);
		frmAltaDeUsuarioT.setIconImage(
				Toolkit.getDefaultToolkit().getImage("Z:\\ONE DRIVE\\OneDrive\\Escritorio\\PNG\\logoUtec.png"));
		frmAltaDeUsuarioT.getContentPane().setBackground(Color.WHITE);
		frmAltaDeUsuarioT.getContentPane().setLayout(null);
		frmAltaDeUsuarioT.setLocationRelativeTo(null);

		JLabel lblNewLabel_2 = new JLabel("ALTA DE TUTOR");
		lblNewLabel_2.setBounds(10, 0, 131, 34);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("SimSun", Font.BOLD, 16));
		frmAltaDeUsuarioT.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("Tel\u00E9fono");
		lblNewLabel_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 90, 64, 14);
		frmAltaDeUsuarioT.getContentPane().add(lblNewLabel_1);

		JLabel lblCorreo = new JLabel("Email");
		lblCorreo.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblCorreo.setBounds(151, 90, 64, 14);
		frmAltaDeUsuarioT.getContentPane().add(lblCorreo);

		JLabel lblNewLabel_1_2_1 = new JLabel("Departamento");
		lblNewLabel_1_2_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_2_1.setBounds(151, 147, 91, 14);
		frmAltaDeUsuarioT.getContentPane().add(lblNewLabel_1_2_1);
		
		JLabel lblUsuario = new JLabel("Mail Institucional");
		lblUsuario.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblUsuario.setBounds(293, 90, 131, 14);
		frmAltaDeUsuarioT.getContentPane().add(lblUsuario);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("ITR");
		lblNewLabel_1_2_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_2_1_1_1.setBounds(151, 201, 42, 14);
		frmAltaDeUsuarioT.getContentPane().add(lblNewLabel_1_2_1_1_1);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblContrasea.setBounds(293, 143, 70, 14);
		frmAltaDeUsuarioT.getContentPane().add(lblContrasea);

		JLabel lblNewLabel_1_1 = new JLabel("Nombre");
		lblNewLabel_1_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(10, 35, 64, 14);
		frmAltaDeUsuarioT.getContentPane().add(lblNewLabel_1_1);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblApellido.setBounds(151, 34, 64, 14);
		frmAltaDeUsuarioT.getContentPane().add(lblApellido);

		JLabel lblDocumento = new JLabel("Documento");
		lblDocumento.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblDocumento.setBounds(293, 35, 64, 14);
		frmAltaDeUsuarioT.getContentPane().add(lblDocumento);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblEstado.setBounds(10, 201, 64, 14);
		frmAltaDeUsuarioT.getContentPane().add(lblEstado);

		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
		lblFechaDeNacimiento.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblFechaDeNacimiento.setBounds(293, 197, 131, 14);
		frmAltaDeUsuarioT.getContentPane().add(lblFechaDeNacimiento);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Localidad");
		lblNewLabel_1_2_1_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_2_1_1.setBounds(10, 147, 91, 14);
		frmAltaDeUsuarioT.getContentPane().add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel = new JLabel("DE");
		lblNewLabel.setBounds(127, 175, 22, 14);
		frmAltaDeUsuarioT.getContentPane().add(lblNewLabel);
		
		JLabel lblTipo = new JLabel("Rol");
		lblTipo.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblTipo.setBounds(10, 246, 64, 14);
		frmAltaDeUsuarioT.getContentPane().add(lblTipo);
		
		JLabel lblArea = new JLabel("Area");
		lblArea.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblArea.setBounds(96, 249, 119, 14);
		frmAltaDeUsuarioT.getContentPane().add(lblArea);
		frmAltaDeUsuarioT.setBounds(100, 100, 450, 340);
		frmAltaDeUsuarioT.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		//TextFields
		
		tfTelefono = new JTextField();
		tfTelefono.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfTelefono.setColumns(10);
		tfTelefono.setBounds(10, 114, 131, 20);
		frmAltaDeUsuarioT.getContentPane().add(tfTelefono);

		tfEmail = new JTextField();
		tfEmail.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfEmail.setColumns(10);
		tfEmail.setBounds(151, 113, 131, 20);
		frmAltaDeUsuarioT.getContentPane().add(tfEmail);


		tfMailInsti = new JTextField();
		tfMailInsti.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfMailInsti.setColumns(10);
		tfMailInsti.setBounds(293, 114, 131, 20);
		frmAltaDeUsuarioT.getContentPane().add(tfMailInsti);

		tfContraseña = new JPasswordField();
		tfContraseña.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfContraseña.setBounds(292, 166, 132, 20);
		frmAltaDeUsuarioT.getContentPane().add(tfContraseña);

		
		tfNombre = new JTextField();
		tfNombre.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfNombre.setColumns(10);
		tfNombre.setBounds(10, 59, 131, 20);
		frmAltaDeUsuarioT.getContentPane().add(tfNombre);

		tfApellido = new JTextField();
		tfApellido.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfApellido.setColumns(10);
		tfApellido.setBounds(151, 58, 131, 20);
		frmAltaDeUsuarioT.getContentPane().add(tfApellido);

		tfDocumento = new JTextField();
		tfDocumento.setText((String) null);
		tfDocumento.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfDocumento.setColumns(10);
		tfDocumento.setBounds(293, 59, 131, 20);
		frmAltaDeUsuarioT.getContentPane().add(tfDocumento);
		
		
		textFieldArea = new JTextField();
		textFieldArea.setBounds(96, 269, 119, 20);
		frmAltaDeUsuarioT.getContentPane().add(textFieldArea);
		textFieldArea.setColumns(10);

		
		//Comboboxes Dates
		
		
		
		JComboBox<Departamento> comboBoxDep = new javax.swing.JComboBox<>();
		comboBoxDep.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxDep.setBounds(151, 171, 131, 22);
     	comboBoxDep.setModel(new DefaultComboBoxModel(Departamento.values()));
		frmAltaDeUsuarioT.getContentPane().add(comboBoxDep);



		JComboBox<EITRs> comboBoxItr = new JComboBox<>();
		comboBoxItr.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxItr.setBounds(151, 216, 131, 22);
		comboBoxItr.setModel(new DefaultComboBoxModel(EITRs.values()));
		frmAltaDeUsuarioT.getContentPane().add(comboBoxItr);

	
		JComboBox<Estado> comboBoxEstado = new javax.swing.JComboBox<>();
		comboBoxEstado.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxEstado.setBounds(10, 216, 131, 22);
		comboBoxEstado.setModel(new DefaultComboBoxModel(Estado.values()));
		frmAltaDeUsuarioT.getContentPane().add(comboBoxEstado);

		JComboBox<Localidad> comboBoxLoc = new JComboBox<Localidad>();
		comboBoxLoc.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxLoc.setBounds(10, 171, 107, 22);
		comboBoxLoc.setModel(new DefaultComboBoxModel(Localidad.values()));
		frmAltaDeUsuarioT.getContentPane().add(comboBoxLoc);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(293, 218, 131, 20);
		Calendar today = Calendar.getInstance();
		today.clear(Calendar.HOUR);
		today.clear(Calendar.MINUTE);
		today.clear(Calendar.SECOND);
		Date todayDate = today.getTime();
		dateChooser.setMaxSelectableDate(todayDate);
		@SuppressWarnings("unused")
		ZoneId defaultZoneId = ZoneId.systemDefault();
		frmAltaDeUsuarioT.getContentPane().add(dateChooser);

		JComboBox<Estado> comboBoxRolT = new JComboBox<Estado>();
		comboBoxRolT.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxRolT.setBounds(10, 268, 76, 22);
		comboBoxRolT.setModel(new DefaultComboBoxModel(RolTutor.values()));
		frmAltaDeUsuarioT.getContentPane().add(comboBoxRolT);
		
		
		
		
		//Botones
		
		
		
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
			
				TUTOR tutor=new TUTOR();
				tutor.setApellido(tfApellido.getText());
				tutor.setNombre(tfNombre.getText());
				tutor.setContrasena(tfContraseña.getText());
				tutor.setDocumento(Integer.parseInt(tfDocumento.getText()));
				tutor.setMail(tfEmail.getText());
				tutor.setTelefono(tfTelefono.getText());
				tutor.setMail_insti(tfMailInsti.getText());
				tutor.setDepartamento(Departamento.valueOf(comboBoxDep.getSelectedItem().toString()));
				tutor.setEstado(Estado.valueOf(comboBoxEstado.getSelectedItem().toString()));
				tutor.setLocalidad(Localidad.valueOf(comboBoxLoc.getSelectedItem().toString()));
				tutor.setItr(EITRs.valueOf(comboBoxItr.getSelectedItem().toString()));
				tutor.setFechaNac(dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
				tutor.setArea(textFieldArea.getText());
				tutor.setTipo(RolTutor.valueOf(comboBoxRolT.getSelectedItem().toString()));
				try {
					
					tutorBean.addTutor(tutor);
				} catch (ServiciosException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnGuardar.setFont(new Font("SimSun", Font.BOLD, 14));
		btnGuardar.setBounds(225, 268, 97, 23);
		frmAltaDeUsuarioT.getContentPane().add(btnGuardar);

		JButton btnCancelar = new JButton("Volver");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ppal_Analista pAnalist = null;
				try {
					pAnalist = new Ppal_Analista();
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
		btnCancelar.setBounds(332, 268, 97, 23);
		frmAltaDeUsuarioT.getContentPane().add(btnCancelar);
		
	
		
		
		

	
		
	}

	public Window getFrame() {
		// TODO Auto-generated method stub
		return this.frmAltaDeUsuarioT;
	}
	}

