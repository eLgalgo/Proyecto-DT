package com.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
<<<<<<< Updated upstream

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.WindowStateListener;
import java.lang.constant.Constable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

=======
>>>>>>> Stashed changes
import javax.swing.JTextField;

import com.entities.ANALISTA;
import com.entities.ESTUDIANTE;
import com.entities.EVENTO;
import com.entities.ITR;
import com.entities.TUTOR;
import com.enums.Departamento;
import com.enums.EstadoUsuario;
import com.enums.Localidad;
import com.enums.RolTutor;
import com.enums.TipoConstancia;
import com.enums.TipoUser;
import com.exception.ServiciosException;
import com.services.AnalistaBeanRemote;
import com.services.EstudianteBeanRemote;
import com.services.EventoBeanRemote;
import com.services.ItrBeanRemote;
import com.services.TutorBeanRemote;
import com.services.UsuarioBeanRemote;
import com.toedter.calendar.JDateChooser;
<<<<<<< Updated upstream
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
=======
>>>>>>> Stashed changes

public class Registro_Usuario_Nuevo {

	private JFrame frmRegistroUsuarioNuevo;
	private JTextField tfTelefono;
	private JTextField tfEmail;
	private JTextField tfMailInsti;
	private JPasswordField tfContrasena;
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfDocumento;
	private JTextField tfArea;

	public Registro_Usuario_Nuevo() throws NamingException {
		initialize();
	}
	
	public boolean isValidEmailAddress(String email) {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}
	
	public boolean validUtecMail(String mailInsti) {
		final String dom = "@utec.edu.uy";
		if (mailInsti.contains(dom)) {
			return true;
		}
		return false;
	}


	private void initialize() throws NamingException {
		AnalistaBeanRemote analistaBean = (AnalistaBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/AnalistaBean!com.services.AnalistaBeanRemote");

		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/UsuarioBean!com.services.UsuarioBeanRemote");

		TutorBeanRemote tutorBean = (TutorBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/TutorBean!com.services.TutorBeanRemote");

		EstudianteBeanRemote estudianteBean = (EstudianteBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/EstudianteBean!com.services.EstudianteBeanRemote");

		EventoBeanRemote eventoBean = (EventoBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/EventoBean!com.services.EventoBeanRemote");

		ItrBeanRemote itrBean = (ItrBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/ItrBean!com.services.ItrBeanRemote");

		frmRegistroUsuarioNuevo = new JFrame();
<<<<<<< Updated upstream
		frmRegistroUsuarioNuevo.getContentPane().setBackground(Color.WHITE);
=======
		frmRegistroUsuarioNuevo.setIconImage(
				Toolkit.getDefaultToolkit().getImage(Registro_Usuario_Nuevo.class.getResource("/PNG/logoUtec.png")));
		frmRegistroUsuarioNuevo.setResizable(false);
		frmRegistroUsuarioNuevo.getContentPane().setBackground(SystemColor.control);
>>>>>>> Stashed changes
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
		tfTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				int key = evt.getKeyChar();

				boolean numeros = key >= 48 && key <= 57;

				if (!numeros)
					evt.consume();

				if (tfTelefono.getText().length() < 7)
					tfTelefono.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				else
					tfTelefono.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

				if (tfTelefono.getText().trim().length() > 10) {
					evt.consume();
					Toolkit.getDefaultToolkit().beep();
				}
			}
		});
		tfTelefono.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfTelefono.setColumns(10);
		tfTelefono.setBounds(10, 125, 131, 20);
		frmRegistroUsuarioNuevo.getContentPane().add(tfTelefono);

		tfEmail = new JTextField();
		tfEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (!isValidEmailAddress(tfEmail.getText())) {
					tfEmail.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				} else {
					tfEmail.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
				}
			}
		});
		tfEmail.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfEmail.setColumns(10);
		tfEmail.setBounds(151, 124, 131, 20);
		frmRegistroUsuarioNuevo.getContentPane().add(tfEmail);

		tfMailInsti = new JTextField();
		tfMailInsti.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!validUtecMail(tfMailInsti.getText())) {
					tfMailInsti.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				}
				else {
					tfMailInsti.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
				}
			}
		});
		tfMailInsti.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfMailInsti.setColumns(10);
		tfMailInsti.setBounds(293, 125, 131, 20);
		frmRegistroUsuarioNuevo.getContentPane().add(tfMailInsti);

		tfContrasena = new JPasswordField();
		tfContrasena.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				if (tfContrasena.getText().length() < 8)
					tfContrasena.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				else
					tfContrasena.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			}
		});
		tfContrasena.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfContrasena.setBounds(292, 181, 132, 20);
		frmRegistroUsuarioNuevo.getContentPane().add(tfContrasena);

		tfNombre = new JTextField();
		tfNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				
				String nombre = tfNombre.getText();
				
				int key = evt.getKeyChar();

				if (nombre.length() > 21) {
					evt.consume();
					Toolkit.getDefaultToolkit().beep();
				}

				boolean mayusculas = key >= 65 && key <= 90;
				boolean minusculas = key >= 97 && key <= 122;
				boolean espacio = key == 32;

				if (!(minusculas || mayusculas || espacio))
					evt.consume();

				if (nombre.length() <= 2)
					tfNombre.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				else
					tfNombre.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			}
		});
		tfNombre.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfNombre.setColumns(10);
		tfNombre.setBounds(10, 70, 131, 20);
		frmRegistroUsuarioNuevo.getContentPane().add(tfNombre);

		tfApellido = new JTextField();
		tfApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {

				int key = evt.getKeyChar();

				if (tfApellido.getText().length() > 21) {
					evt.consume();
					Toolkit.getDefaultToolkit().beep();
				}

				boolean mayusculas = key >= 65 && key <= 90;
				boolean minusculas = key >= 97 && key <= 122;
				boolean espacio = key == 32;

				if (!(minusculas || mayusculas || espacio))
					evt.consume();

				if (tfApellido.getText().length() <= 2)
					tfApellido.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				else
					tfApellido.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			}
		});
		tfApellido.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfApellido.setColumns(10);
		tfApellido.setBounds(151, 69, 131, 20);
		frmRegistroUsuarioNuevo.getContentPane().add(tfApellido);

		tfDocumento = new JTextField();
		tfDocumento.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				int key = evt.getKeyChar();

				boolean numeros = key >= 48 && key <= 57;

				if (!numeros) {
					evt.consume();
				}

				if (tfDocumento.getText().length() < 7)
					tfDocumento.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				else
					tfDocumento.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

				if (tfDocumento.getText().length() > 9) {
					evt.consume();
					Toolkit.getDefaultToolkit().beep();
				}

			}
		});
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

		JComboBox<ITR> comboBoxItr = new JComboBox<>();
		comboBoxItr.setFont(new Font("SimSun", Font.PLAIN, 13));
<<<<<<< Updated upstream
		comboBoxItr.setBounds(151, 234, 131, 22);
		comboBoxItr.setModel(new DefaultComboBoxModel(EITRs.values()));
=======
		comboBoxItr.setBounds(151, 283, 131, 22);

		//ITRS activos
		List<ITR> itrs = itrBean.findAll(true);

		// Declaring Array with Equal Size to the List
		String[] itrNombres = new String[itrs.size()];

		// Converting List to Array
		for (int i = 0; i < itrs.size(); i++) {
			itrNombres[i] = itrs.get(i).getNombre();
		}

		comboBoxItr.setModel(new DefaultComboBoxModel(itrNombres));

>>>>>>> Stashed changes
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
					Analista.setContrasena(tfContrasena.getText());
					Analista.setDocumento(Integer.parseInt(tfDocumento.getText()));
					Analista.setMail(tfEmail.getText());
					Analista.setTelefono(tfTelefono.getText());
					Analista.setMail_insti(tfMailInsti.getText());
					Analista.setDepartamento(Departamento.valueOf(comboBoxDep.getSelectedItem().toString()));
					Analista.setEstado(EstadoUsuario.valueOf(comboBoxEstado.getSelectedItem().toString()));
					Analista.setLocalidad(Localidad.valueOf(comboBoxLoc.getSelectedItem().toString()));
					try {
						Analista.setItr(itrBean.findItr(comboBoxItr.getSelectedItem().toString()).get(0));
					} catch (ServiciosException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					Analista.setFechaNac(
							dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
					try {
						analistaBean.addAnalista(Analista);
						JOptionPane.showMessageDialog(null, "Registrado exitosamente, espere a ser habilitado.");
					} catch (ServiciosException e1) {
						e1.printStackTrace();
					}
				} else if (comboBoxTipo.getSelectedItem().equals(TipoUser.TUTOR)) {
					TUTOR tutor = new TUTOR();
					tutor.setApellido(tfApellido.getText());
					tutor.setNombre(tfNombre.getText());
					tutor.setContrasena(tfContrasena.getText());
					tutor.setDocumento(Integer.parseInt(tfDocumento.getText()));
					tutor.setMail(tfEmail.getText());
					tutor.setTelefono(tfTelefono.getText());
					tutor.setMail_insti(tfMailInsti.getText());
					tutor.setDepartamento(Departamento.valueOf(comboBoxDep.getSelectedItem().toString()));
					tutor.setEstado(EstadoUsuario.valueOf(comboBoxEstado.getSelectedItem().toString()));
					tutor.setLocalidad(Localidad.valueOf(comboBoxLoc.getSelectedItem().toString()));
					try {
						tutor.setItr(itrBean.findItr(comboBoxItr.getSelectedItem().toString()).get(0));
					} catch (ServiciosException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					tutor.setFechaNac(dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
					tutor.setArea(tfArea.getText());
					tutor.setTipo(RolTutor.valueOf(comboBoxRol.getSelectedItem().toString()));
					try {

						tutorBean.addTutor(tutor);
						JOptionPane.showMessageDialog(null, "Registrado exitosamente, espere a ser habilitado.");
					} catch (ServiciosException e1) {
						e1.printStackTrace();
					}

				} else if (comboBoxTipo.getSelectedItem().equals(TipoUser.ESTUDIANTE)) {

					ESTUDIANTE estudiante = new ESTUDIANTE();
					estudiante.setApellido(tfApellido.getText());
					estudiante.setNombre(tfNombre.getText());
					estudiante.setContrasena(tfContrasena.getText());
					estudiante.setDocumento(Integer.parseInt(tfDocumento.getText()));
					estudiante.setMail(tfEmail.getText());
					estudiante.setTelefono(tfTelefono.getText());
					estudiante.setMail_insti(tfMailInsti.getText());
					estudiante.setDepartamento(Departamento.valueOf(comboBoxDep.getSelectedItem().toString()));
					estudiante.setEstado(EstadoUsuario.valueOf(comboBoxEstado.getSelectedItem().toString()));
					estudiante.setLocalidad(Localidad.valueOf(comboBoxLoc.getSelectedItem().toString()));
					try {
						estudiante.setItr(itrBean.findItr(comboBoxItr.getSelectedItem().toString()).get(0));
					} catch (ServiciosException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}
					estudiante.setFechaNac(
							dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
					estudiante.setGeneracion(comboBoxFecIng.getSelectedItem().toString());

					try {

						estudianteBean.addStudent(estudiante);
						JOptionPane.showMessageDialog(null, "Registrado exitosamente, espere a ser habilitado.");
					} catch (ServiciosException e1) {
						e1.printStackTrace();
					}
					ESTUDIANTE eActivo = null;
					try {
						eActivo = estudianteBean.findUser(estudiante.getDocumento()).get(0);
					} catch (ServiciosException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					EVENTO evActivo = new EVENTO();
					evActivo.setFechaInicio(LocalDate.now());
					try {
						evActivo.setTutor((TUTOR) usuarioBean.findUser(120).get(0));
					} catch (ServiciosException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					evActivo.setTipo(TipoConstancia.ESTUDIANTE_ACTIVO);
					evActivo.setTitulo("Estudiante activo");

					try {
						eventoBean.addEvento(evActivo);
					} catch (ServiciosException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					try {
						EVENTO eActivo2 = eventoBean.findEvento(evActivo.getFechaInicio()).get(0);
						eventoBean.asignEstToEvent(eActivo.getId_usuario(), eActivo2.getId_evento());
					} catch (ServiciosException e1) {
						// TODO Auto-generated catch block
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
