package com.gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.Window;
import java.awt.event.WindowStateListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JTextField;

import com.entities.ANALISTA;
import com.entities.ESTUDIANTE;
import com.entities.TUTOR;
import com.entities.USUARIO;
import com.enums.Departamento;
import com.enums.EITRs;
import com.enums.EstadoSolicitud;
import com.enums.EstadoUsuario;
import com.enums.Localidad;
import com.enums.RolTutor;
import com.enums.TipoUser;
import com.exception.ServiciosException;
import com.services.AnalistaBean;
import com.services.AnalistaBeanRemote;
import com.services.EstudianteBeanRemote;
import com.services.TutorBeanRemote;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registro_Usuario_Nuevo {

	private JFrame frmRegistroUsuarioNuevo;
	private JTextField tfTelefono;
	private JTextField tfEmail;
	private JTextField tfMailInsti;
	private JPasswordField tfContraseña;
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfDocumento;
	private JTextField tfArea;

	public Registro_Usuario_Nuevo() throws NamingException {
		initialize();
	}

	private void initialize() throws NamingException {
		AnalistaBeanRemote analistaBean = (AnalistaBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/AnalistaBean!com.services.AnalistaBeanRemote");

		TutorBeanRemote tutorBean = (TutorBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/TutorBean!com.services.TutorBeanRemote");
		
		EstudianteBeanRemote estudianteBean = (EstudianteBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/EstudianteBean!com.services.EstudianteBeanRemote");
		
		frmRegistroUsuarioNuevo = new JFrame();
		frmRegistroUsuarioNuevo.getContentPane().setBackground(Color.WHITE);
		frmRegistroUsuarioNuevo.setTitle("Registro Usuario Nuevo");
		frmRegistroUsuarioNuevo.setBounds(100, 100, 450, 399);
		frmRegistroUsuarioNuevo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistroUsuarioNuevo.getContentPane().setLayout(null);
		frmRegistroUsuarioNuevo.setLocationRelativeTo(null);

		JLabel lblNewLabel_2 = new JLabel("NUEVO USUARIO");
		lblNewLabel_2.setBounds(10, 11, 131, 34);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("SimSun", Font.BOLD, 16));
		frmRegistroUsuarioNuevo.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("Tel\u00E9fono");
		lblNewLabel_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 101, 64, 14);
		frmRegistroUsuarioNuevo.getContentPane().add(lblNewLabel_1);

		JLabel lblCorreo = new JLabel("Email");
		lblCorreo.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblCorreo.setBounds(151, 101, 64, 14);
		frmRegistroUsuarioNuevo.getContentPane().add(lblCorreo);

		JLabel lblNewLabel_1_2_1 = new JLabel("Departamento");
		lblNewLabel_1_2_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_2_1.setBounds(151, 158, 91, 14);
		frmRegistroUsuarioNuevo.getContentPane().add(lblNewLabel_1_2_1);

		JLabel lblUsuario = new JLabel("Mail Institucional");
		lblUsuario.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblUsuario.setBounds(293, 101, 131, 14);
		frmRegistroUsuarioNuevo.getContentPane().add(lblUsuario);

		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("ITR");
		lblNewLabel_1_2_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_2_1_1_1.setBounds(151, 212, 42, 14);
		frmRegistroUsuarioNuevo.getContentPane().add(lblNewLabel_1_2_1_1_1);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblContrasea.setBounds(293, 158, 70, 14);
		frmRegistroUsuarioNuevo.getContentPane().add(lblContrasea);

		JLabel lblNewLabel_1_1 = new JLabel("Nombre");
		lblNewLabel_1_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(10, 46, 64, 14);
		frmRegistroUsuarioNuevo.getContentPane().add(lblNewLabel_1_1);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblApellido.setBounds(151, 45, 64, 14);
		frmRegistroUsuarioNuevo.getContentPane().add(lblApellido);

		JLabel lblDocumento = new JLabel("Documento");
		lblDocumento.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblDocumento.setBounds(293, 46, 64, 14);
		frmRegistroUsuarioNuevo.getContentPane().add(lblDocumento);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblEstado.setBounds(10, 212, 64, 14);
		frmRegistroUsuarioNuevo.getContentPane().add(lblEstado);

		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
		lblFechaDeNacimiento.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblFechaDeNacimiento.setBounds(293, 212, 131, 14);
		frmRegistroUsuarioNuevo.getContentPane().add(lblFechaDeNacimiento);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("Localidad");
		lblNewLabel_1_2_1_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_2_1_1.setBounds(10, 158, 91, 14);
		frmRegistroUsuarioNuevo.getContentPane().add(lblNewLabel_1_2_1_1);

		JLabel lblNewLabel2 = new JLabel("DE");

		tfTelefono = new JTextField();
		tfTelefono.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfTelefono.setColumns(10);
		tfTelefono.setBounds(10, 125, 131, 20);
		frmRegistroUsuarioNuevo.getContentPane().add(tfTelefono);

		tfEmail = new JTextField();
		tfEmail.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfEmail.setColumns(10);
		tfEmail.setBounds(151, 124, 131, 20);
		frmRegistroUsuarioNuevo.getContentPane().add(tfEmail);

		tfMailInsti = new JTextField();
		tfMailInsti.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfMailInsti.setColumns(10);
		tfMailInsti.setBounds(293, 125, 131, 20);
		frmRegistroUsuarioNuevo.getContentPane().add(tfMailInsti);

		tfContraseña = new JPasswordField();
		tfContraseña.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfContraseña.setBounds(292, 181, 132, 20);
		frmRegistroUsuarioNuevo.getContentPane().add(tfContraseña);

		tfNombre = new JTextField();
		tfNombre.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfNombre.setColumns(10);
		tfNombre.setBounds(10, 70, 131, 20);
		frmRegistroUsuarioNuevo.getContentPane().add(tfNombre);

		tfApellido = new JTextField();
		tfApellido.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfApellido.setColumns(10);
		tfApellido.setBounds(151, 69, 131, 20);
		frmRegistroUsuarioNuevo.getContentPane().add(tfApellido);

		tfDocumento = new JTextField();
		tfDocumento.setText((String) null);
		tfDocumento.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfDocumento.setColumns(10);
		tfDocumento.setBounds(293, 70, 131, 20);
		frmRegistroUsuarioNuevo.getContentPane().add(tfDocumento);

		JComboBox<Departamento> comboBoxDep = new javax.swing.JComboBox<>();
		comboBoxDep.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxDep.setBounds(151, 182, 131, 22);
		comboBoxDep.setModel(new DefaultComboBoxModel(Departamento.values()));
		frmRegistroUsuarioNuevo.getContentPane().add(comboBoxDep);

		JComboBox<RolTutor> comboBoxRol = new JComboBox();
		comboBoxRol.setFont(new Font("SimSun", Font.PLAIN, 11));
		comboBoxRol.setBounds(151, 286, 131, 22);
		comboBoxRol.setModel(new DefaultComboBoxModel(RolTutor.values()));
		frmRegistroUsuarioNuevo.getContentPane().add(comboBoxRol);

		JComboBox<EITRs> comboBoxItr = new JComboBox<>();
		comboBoxItr.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxItr.setBounds(151, 234, 131, 22);
		comboBoxItr.setModel(new DefaultComboBoxModel(EITRs.values()));
		frmRegistroUsuarioNuevo.getContentPane().add(comboBoxItr);

		JComboBox<EstadoUsuario> comboBoxEstado = new javax.swing.JComboBox<>();
		comboBoxEstado.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxEstado.setBounds(10, 234, 131, 22);
		comboBoxEstado.setModel(new DefaultComboBoxModel(EstadoUsuario.values()));
		comboBoxEstado.setSelectedIndex(1);
		comboBoxEstado.setEnabled(false);
		frmRegistroUsuarioNuevo.getContentPane().add(comboBoxEstado);

		JComboBox<Localidad> comboBoxLoc = new JComboBox<Localidad>();
		comboBoxLoc.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxLoc.setBounds(10, 182, 107, 22);
		comboBoxLoc.setModel(new DefaultComboBoxModel(Localidad.values()));
		frmRegistroUsuarioNuevo.getContentPane().add(comboBoxLoc);

		JComboBox comboBoxFecIng = new JComboBox();
		comboBoxFecIng.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxFecIng.setBounds(10, 286, 131, 22);
		for (int i = 2012; i <= LocalDate.now().getYear(); i += 1) {
			comboBoxFecIng.addItem(i);
		}
		frmRegistroUsuarioNuevo.getContentPane().add(comboBoxFecIng);

		JComboBox<TipoUser> comboBoxTipo = new JComboBox();
		comboBoxTipo.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxTipo.setBounds(151, 18, 132, 22);
		comboBoxTipo.setModel(new DefaultComboBoxModel(TipoUser.values()));
		frmRegistroUsuarioNuevo.getContentPane().add(comboBoxTipo);

		final ItemListener changeClick = new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (comboBoxTipo.getSelectedItem().equals(TipoUser.ANALISTA)) {
					comboBoxFecIng.setEnabled(false);
					comboBoxRol.setEnabled(false);
					tfArea.setEnabled(false);
				} else if (comboBoxTipo.getSelectedItem().equals(TipoUser.TUTOR)) {
					comboBoxRol.setEnabled(true);
					tfArea.setEnabled(true);
					comboBoxFecIng.setEnabled(false);

				} else if (comboBoxTipo.getSelectedItem().equals(TipoUser.ESTUDIANTE)) {
					comboBoxFecIng.setEnabled(true);
					comboBoxRol.setEnabled(false);
					tfArea.setEnabled(false);
				}
			}
		};

		tfArea = new JTextField();
		tfArea.setBounds(293, 287, 113, 20);
		frmRegistroUsuarioNuevo.getContentPane().add(tfArea);
		tfArea.setColumns(10);

		comboBoxFecIng.setEnabled(false);
		comboBoxRol.setEnabled(false);
		tfArea.setEnabled(false);

		comboBoxTipo.addItemListener(changeClick);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(293, 236, 131, 20);
		Calendar today = Calendar.getInstance();
		today.clear(Calendar.HOUR);
		today.clear(Calendar.MINUTE);
		today.clear(Calendar.SECOND);
		Date todayDate = today.getTime();
		dateChooser.setMaxSelectableDate(todayDate);

		ZoneId defaultZoneId = ZoneId.systemDefault();
		dateChooser.setDate(Date.from(LocalDate.now().atStartOfDay(defaultZoneId).toInstant()));
		frmRegistroUsuarioNuevo.getContentPane().add(dateChooser);

		JLabel lblNewLabel_1_1_1 = new JLabel("Tipo");
		lblNewLabel_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(293, 22, 64, 14);
		frmRegistroUsuarioNuevo.getContentPane().add(lblNewLabel_1_1_1);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxTipo.getSelectedItem().equals(TipoUser.ANALISTA)) {
					ANALISTA Analista = new ANALISTA();
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
					Analista.setFechaNac(
							dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
					try {
						analistaBean.addAnalista(Analista);
						JOptionPane.showMessageDialog(null, "Registrado exitosamente, espere a ser habilitado.");
					} catch (ServiciosException e1) {
						e1.printStackTrace();
					}
				} else if (comboBoxTipo.getSelectedItem().equals(TipoUser.TUTOR)) {
					TUTOR tutor=new TUTOR();
					tutor.setApellido(tfApellido.getText());
					tutor.setNombre(tfNombre.getText());
					tutor.setContrasena(tfContraseña.getText());
					tutor.setDocumento(Integer.parseInt(tfDocumento.getText()));
					tutor.setMail(tfEmail.getText());
					tutor.setTelefono(tfTelefono.getText());
					tutor.setMail_insti(tfMailInsti.getText());
					tutor.setDepartamento(Departamento.valueOf(comboBoxDep.getSelectedItem().toString()));
					tutor.setEstado(EstadoUsuario.valueOf(comboBoxEstado.getSelectedItem().toString()));
					tutor.setLocalidad(Localidad.valueOf(comboBoxLoc.getSelectedItem().toString()));
					tutor.setItr(EITRs.valueOf(comboBoxItr.getSelectedItem().toString()));
					tutor.setFechaNac(dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
					tutor.setArea(tfArea.getText());
					tutor.setTipo(RolTutor.valueOf(comboBoxRol.getSelectedItem().toString()));
					try {
						
						tutorBean.addTutor(tutor);
					} catch (ServiciosException e1) {
						e1.printStackTrace();
					}

				} else if (comboBoxTipo.getSelectedItem().equals(TipoUser.ESTUDIANTE)) {
	
					ESTUDIANTE estudiante=new ESTUDIANTE();
					estudiante.setApellido(tfApellido.getText());
					estudiante.setNombre(tfNombre.getText());
					estudiante.setContrasena(tfContraseña.getText());
					estudiante.setDocumento(Integer.parseInt(tfDocumento.getText()));
					estudiante.setMail(tfEmail.getText());
					estudiante.setTelefono(tfTelefono.getText());
					estudiante.setMail_insti(tfMailInsti.getText());
					estudiante.setDepartamento(Departamento.valueOf(comboBoxDep.getSelectedItem().toString()));
					estudiante.setEstado(EstadoUsuario.valueOf(comboBoxEstado.getSelectedItem().toString()));
					estudiante.setLocalidad(Localidad.valueOf(comboBoxLoc.getSelectedItem().toString()));
					estudiante.setItr(EITRs.valueOf(comboBoxItr.getSelectedItem().toString()));
					estudiante.setFechaNac(dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
					estudiante.setGeneracion(comboBoxFecIng.getSelectedItem().toString());
					try {
						
						estudianteBean.addStudent(estudiante);
					} catch (ServiciosException e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		btnGuardar.setFont(new Font("SimSun", Font.PLAIN, 11));
		btnGuardar.setBounds(228, 326, 89, 23);
		frmRegistroUsuarioNuevo.getContentPane().add(btnGuardar);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = null;
				try {
					login = new Login();
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				login.getFrame().setVisible(true);
				getFrame().dispose();
			}
		});
		btnVolver.setFont(new Font("SimSun", Font.PLAIN, 11));
		btnVolver.setBounds(335, 326, 89, 23);
		frmRegistroUsuarioNuevo.getContentPane().add(btnVolver);

		JLabel lblArea = new JLabel("Area");
		lblArea.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblArea.setBounds(293, 262, 131, 14);
		frmRegistroUsuarioNuevo.getContentPane().add(lblArea);

		JLabel lblFechaIngreso = new JLabel("Fecha Ingreso");
		lblFechaIngreso.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblFechaIngreso.setBounds(10, 262, 91, 14);
		frmRegistroUsuarioNuevo.getContentPane().add(lblFechaIngreso);

		JLabel lblRol = new JLabel("Rol");
		lblRol.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblRol.setBounds(151, 262, 91, 14);
		frmRegistroUsuarioNuevo.getContentPane().add(lblRol);
	}

	public Window getFrame() {
		return frmRegistroUsuarioNuevo;

	}
}
