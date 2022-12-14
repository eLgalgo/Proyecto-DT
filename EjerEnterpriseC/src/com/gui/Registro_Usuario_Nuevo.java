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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.entities.ANALISTA;
import com.entities.ESTUDIANTE;
import com.entities.EVENTO;
import com.entities.ITR;
import com.entities.TIPOCONSTANCIA;
import com.entities.TUTOR;
import com.enums.Departamento;
import com.enums.EstadoUsuario;
import com.enums.Localidad;
import com.enums.RolTutor;
import com.enums.TipoUser;
import com.exception.ServiciosException;
import com.services.AnalistaBeanRemote;
import com.services.EstudianteBeanRemote;
import com.services.EventoBeanRemote;
import com.services.ItrBeanRemote;
import com.services.ModeloBeanRemote;
import com.services.TutorBeanRemote;
import com.services.UsuarioBeanRemote;
import com.toedter.calendar.JDateChooser;

import validations.Validate;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Registro_Usuario_Nuevo {

	private JFrame frmRegistroUsuarioNuevo;
	private JTextField tfTelefono;
	private JTextField tfEmail;
	private JTextField tfMailInsti;
	private JPasswordField tfContrase?a;
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
		frmRegistroUsuarioNuevo.setIconImage(
				Toolkit.getDefaultToolkit().getImage(Registro_Usuario_Nuevo.class.getResource("/PNG/logoUtec.png")));
		frmRegistroUsuarioNuevo.setResizable(false);
		frmRegistroUsuarioNuevo.getContentPane().setBackground(SystemColor.control);
		frmRegistroUsuarioNuevo.setTitle("Registro Usuario Nuevo");
		frmRegistroUsuarioNuevo.setBounds(100, 100, 456, 474);
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
		lblNewLabel_1.setBounds(10, 123, 64, 14);
		frmRegistroUsuarioNuevo.getContentPane().add(lblNewLabel_1);

		JLabel lblCorreo = new JLabel("Email");
		lblCorreo.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblCorreo.setBounds(151, 123, 64, 14);
		frmRegistroUsuarioNuevo.getContentPane().add(lblCorreo);

		JLabel lblNewLabel_1_2_1 = new JLabel("Departamento");
		lblNewLabel_1_2_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_2_1.setBounds(151, 190, 91, 14);
		frmRegistroUsuarioNuevo.getContentPane().add(lblNewLabel_1_2_1);

		JLabel lblUsuario = new JLabel("Mail Institucional");
		lblUsuario.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblUsuario.setBounds(293, 123, 131, 14);
		frmRegistroUsuarioNuevo.getContentPane().add(lblUsuario);

		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("ITR");
		lblNewLabel_1_2_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_2_1_1_1.setBounds(151, 258, 42, 14);
		frmRegistroUsuarioNuevo.getContentPane().add(lblNewLabel_1_2_1_1_1);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblContrasea.setBounds(293, 190, 70, 14);
		frmRegistroUsuarioNuevo.getContentPane().add(lblContrasea);

		JLabel lblNewLabel_1_1 = new JLabel("Nombre");
		lblNewLabel_1_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(10, 67, 64, 14);
		frmRegistroUsuarioNuevo.getContentPane().add(lblNewLabel_1_1);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblApellido.setBounds(151, 67, 64, 14);
		frmRegistroUsuarioNuevo.getContentPane().add(lblApellido);

		JLabel lblDocumento = new JLabel("Documento");
		lblDocumento.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblDocumento.setBounds(293, 67, 64, 14);
		frmRegistroUsuarioNuevo.getContentPane().add(lblDocumento);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblEstado.setBounds(10, 258, 64, 14);
		frmRegistroUsuarioNuevo.getContentPane().add(lblEstado);

		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
		lblFechaDeNacimiento.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblFechaDeNacimiento.setBounds(293, 258, 147, 14);
		frmRegistroUsuarioNuevo.getContentPane().add(lblFechaDeNacimiento);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("Localidad");
		lblNewLabel_1_2_1_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_2_1_1.setBounds(10, 190, 91, 14);
		frmRegistroUsuarioNuevo.getContentPane().add(lblNewLabel_1_2_1_1);

		JLabel lblNewLabel2 = new JLabel("DE");

		tfTelefono = new JTextField();
		tfTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				int key = evt.getKeyChar();

				boolean numeros = key >= 48 && key <= 57;

				if (!numeros) {
					evt.consume();
				}

				if (tfTelefono.getText().trim().length() == 9) {
					evt.consume();
					Toolkit.getDefaultToolkit().beep();
				}
			}
		});
		tfTelefono.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfTelefono.setColumns(10);
		tfTelefono.setBounds(10, 148, 131, 20);
		frmRegistroUsuarioNuevo.getContentPane().add(tfTelefono);

		tfEmail = new JTextField();
		tfEmail.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfEmail.setColumns(10);
		tfEmail.setBounds(151, 148, 131, 20);
		frmRegistroUsuarioNuevo.getContentPane().add(tfEmail);

		tfMailInsti = new JTextField();
		tfMailInsti.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfMailInsti.setColumns(10);
		tfMailInsti.setBounds(293, 148, 131, 20);
		frmRegistroUsuarioNuevo.getContentPane().add(tfMailInsti);

		tfContrase?a = new JPasswordField();
		tfContrase?a.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfContrase?a.setBounds(293, 215, 132, 20);
		frmRegistroUsuarioNuevo.getContentPane().add(tfContrase?a);

		tfNombre = new JTextField();
		tfNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				int key = evt.getKeyChar();

				boolean mayusculas = key >= 65 && key <= 90;
				boolean minusculas = key >= 97 && key <= 122;
				boolean espacio = key == 32;
				boolean borrar = key == 8;

				if (!(minusculas || mayusculas || espacio || borrar)) {
					evt.consume();
					Toolkit.getDefaultToolkit().beep();
				}
			}
		});
		tfNombre.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfNombre.setColumns(10);
		tfNombre.setBounds(10, 92, 131, 20);
		frmRegistroUsuarioNuevo.getContentPane().add(tfNombre);

		tfApellido = new JTextField();
		tfApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				int key = evt.getKeyChar();

				boolean mayusculas = key >= 65 && key <= 90;
				boolean minusculas = key >= 97 && key <= 122;
				boolean espacio = key == 32;
				boolean borrar = key == 8;

				if (!(minusculas || mayusculas || espacio || borrar)) {
					evt.consume();
					Toolkit.getDefaultToolkit().beep();
				}
			}
		});
		tfApellido.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfApellido.setColumns(10);
		tfApellido.setBounds(151, 92, 131, 20);
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

				if (tfDocumento.getText().trim().length() == 9) {
					evt.consume();
					Toolkit.getDefaultToolkit().beep();
				}
			}
		});
		tfDocumento.setText((String) null);
		tfDocumento.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfDocumento.setColumns(10);
		tfDocumento.setBounds(293, 92, 131, 20);
		frmRegistroUsuarioNuevo.getContentPane().add(tfDocumento);

		JComboBox<Departamento> comboBoxDep = new javax.swing.JComboBox<>();
		comboBoxDep.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxDep.setBounds(151, 214, 131, 22);
		comboBoxDep.setModel(new DefaultComboBoxModel(Departamento.values()));
		frmRegistroUsuarioNuevo.getContentPane().add(comboBoxDep);

		JComboBox<RolTutor> comboBoxRol = new JComboBox();
		comboBoxRol.setFont(new Font("SimSun", Font.PLAIN, 11));
		comboBoxRol.setBounds(151, 347, 131, 22);
		comboBoxRol.setModel(new DefaultComboBoxModel(RolTutor.values()));
		frmRegistroUsuarioNuevo.getContentPane().add(comboBoxRol);

		JComboBox<ITR> comboBoxItr = new JComboBox<>();
		comboBoxItr.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxItr.setBounds(151, 283, 131, 22);

		// ITRS activos
		List<ITR> itrs = itrBean.findAll(true);

		// Declaring Array with Equal Size to the List
		String[] itrNombres = new String[itrs.size()];

		// Converting List to Array
		for (int i = 0; i < itrs.size(); i++) {
			itrNombres[i] = itrs.get(i).getNombre();
		}

		comboBoxItr.setModel(new DefaultComboBoxModel(itrNombres));

		frmRegistroUsuarioNuevo.getContentPane().add(comboBoxItr);

		JComboBox<EstadoUsuario> comboBoxEstado = new javax.swing.JComboBox<>();
		comboBoxEstado.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxEstado.setBounds(10, 283, 131, 22);
		comboBoxEstado.setModel(new DefaultComboBoxModel(EstadoUsuario.values()));

		comboBoxEstado.setSelectedIndex(1);
		comboBoxEstado.setEnabled(false);
		frmRegistroUsuarioNuevo.getContentPane().add(comboBoxEstado);

		JComboBox<Localidad> comboBoxLoc = new JComboBox<Localidad>();
		comboBoxLoc.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxLoc.setBounds(10, 214, 107, 22);
		comboBoxLoc.setModel(new DefaultComboBoxModel(Localidad.values()));
		frmRegistroUsuarioNuevo.getContentPane().add(comboBoxLoc);

		JComboBox comboBoxFecIng = new JComboBox();
		comboBoxFecIng.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxFecIng.setBounds(10, 346, 131, 22);
		for (int i = 2012; i <= LocalDate.now().getYear(); i += 1) {
			comboBoxFecIng.addItem(i);
		}
		frmRegistroUsuarioNuevo.getContentPane().add(comboBoxFecIng);

		JComboBox<TipoUser> comboBoxTipo = new JComboBox();
		comboBoxTipo.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxTipo.setBounds(292, 18, 132, 22);
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
		tfArea.setBounds(293, 347, 131, 20);
		frmRegistroUsuarioNuevo.getContentPane().add(tfArea);
		tfArea.setColumns(10);

		comboBoxFecIng.setEnabled(false);
		comboBoxRol.setEnabled(false);
		tfArea.setEnabled(false);

		comboBoxTipo.addItemListener(changeClick);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(293, 285, 131, 20);
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
		lblNewLabel_1_1_1.setBounds(248, 22, 36, 14);
		frmRegistroUsuarioNuevo.getContentPane().add(lblNewLabel_1_1_1);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxTipo.getSelectedItem().equals(TipoUser.ANALISTA)) {
					try {
						Validate v = new Validate();
						ANALISTA Analista = new ANALISTA();
						if (v.documento(tfDocumento.getText()))
							Analista.setDocumento(Integer.parseInt(tfDocumento.getText()));
						if(!analistaBean.findUser(Integer.parseInt(tfDocumento.getText())).isEmpty()) {
							JOptionPane.showMessageDialog(null, "Ya existe un analista con ese documento");
						}else {
							if (v.nameAndLast(tfApellido.getText()))
								Analista.setApellido(tfApellido.getText());
							if (v.nameAndLast(tfNombre.getText()))
								Analista.setNombre(tfNombre.getText());
							if (v.pass(tfContrase?a.getText()))
								Analista.setContrasena(tfContrase?a.getText());
							if (v.email(tfEmail.getText()))
								Analista.setMail(tfEmail.getText());
							if (v.telefono(tfTelefono.getText()))
								Analista.setTelefono(tfTelefono.getText());
							if (v.mailInsti(tfMailInsti.getText()))
								Analista.setMail_insti(tfMailInsti.getText());
							Analista.setDepartamento(Departamento.valueOf(comboBoxDep.getSelectedItem().toString()));
							Analista.setEstado(EstadoUsuario.valueOf(comboBoxEstado.getSelectedItem().toString()));
							Analista.setLocalidad(Localidad.valueOf(comboBoxLoc.getSelectedItem().toString()));
	
							Analista.setItr(itrBean.findItr(comboBoxItr.getSelectedItem().toString()).get(0));
	
							Analista.setFechaNac(
									dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
	
							analistaBean.addAnalista(Analista);
							JOptionPane.showMessageDialog(null, "Registrado exitosamente, espere a ser habilitado.");
						}
					} catch (ServiciosException | NumberFormatException | NamingException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				} else if (comboBoxTipo.getSelectedItem().equals(TipoUser.TUTOR)) {
					try {
						Validate v = new Validate();
						TUTOR tutor = new TUTOR();
						if (v.documento(tfDocumento.getText()))
							tutor.setDocumento(Integer.parseInt(tfDocumento.getText()));
						if(!tutorBean.findUser(Integer.parseInt(tfDocumento.getText())).isEmpty()) {
							JOptionPane.showMessageDialog(null, "Ya existe un tutor con ese documento");
						}else {
							if (v.nameAndLast(tfApellido.getText()))
								tutor.setApellido(tfApellido.getText());
							if (v.nameAndLast(tfNombre.getText()))
								tutor.setNombre(tfNombre.getText());
							if (v.pass(tfContrase?a.getText()))
								tutor.setContrasena(tfContrase?a.getText());
							if (v.email(tfEmail.getText()))
								tutor.setMail(tfEmail.getText());
							if (v.telefono(tfTelefono.getText()))
								tutor.setTelefono(tfTelefono.getText());
							if (v.mailInsti(tfMailInsti.getText()))
								tutor.setMail_insti(tfMailInsti.getText());
							tutor.setDepartamento(Departamento.valueOf(comboBoxDep.getSelectedItem().toString()));
							tutor.setEstado(EstadoUsuario.valueOf(comboBoxEstado.getSelectedItem().toString()));
							tutor.setLocalidad(Localidad.valueOf(comboBoxLoc.getSelectedItem().toString()));
							tutor.setTipo(RolTutor.valueOf(comboBoxRol.getSelectedItem().toString()));
							tutor.setItr(itrBean.findItr(comboBoxItr.getSelectedItem().toString()).get(0));
	
							tutor.setFechaNac(
									dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
							tutor.setArea(tfArea.getText());
	
							tutorBean.addTutor(tutor);
							JOptionPane.showMessageDialog(null, "Registrado exitosamente, espere a ser habilitado.");
						}	
					} catch (ServiciosException | NumberFormatException | NamingException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}

				} else if (comboBoxTipo.getSelectedItem().equals(TipoUser.ESTUDIANTE)) {
					try {
						Validate v = new Validate();
						ESTUDIANTE estudiante = new ESTUDIANTE();
						if (v.documento(tfDocumento.getText()))
							estudiante.setDocumento(Integer.parseInt(tfDocumento.getText()));
						if(!estudianteBean.findUser(Integer.parseInt(tfDocumento.getText())).isEmpty()) {
							JOptionPane.showMessageDialog(null, "Ya existe un estudiante con ese documento");
						}else {
							if (v.nameAndLast(tfApellido.getText()))
								estudiante.setApellido(tfApellido.getText());
							if (v.nameAndLast(tfNombre.getText()))
								estudiante.setNombre(tfNombre.getText());
							if (v.pass(tfContrase?a.getText()))
								estudiante.setContrasena(tfContrase?a.getText());
							if (v.email(tfEmail.getText()))
								estudiante.setMail(tfEmail.getText());
							if (v.telefono(tfTelefono.getText()))
								estudiante.setTelefono(tfTelefono.getText());
							if (v.mailInsti(tfMailInsti.getText()))
								estudiante.setMail_insti(tfMailInsti.getText());
							estudiante.setDepartamento(Departamento.valueOf(comboBoxDep.getSelectedItem().toString()));
							estudiante.setEstado(EstadoUsuario.valueOf(comboBoxEstado.getSelectedItem().toString()));
							estudiante.setLocalidad(Localidad.valueOf(comboBoxLoc.getSelectedItem().toString()));
	
							estudiante.setItr(itrBean.findItr(comboBoxItr.getSelectedItem().toString()).get(0));
	
							estudiante.setFechaNac(
									dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
							estudiante.setGeneracion(comboBoxFecIng.getSelectedItem().toString());
	
							estudianteBean.addStudent(estudiante);
							JOptionPane.showMessageDialog(null, "Registrado exitosamente, espere a ser habilitado.");
						}
					} catch (ServiciosException | NumberFormatException | NamingException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}

			}
		});
		btnGuardar.setFont(new Font("SimSun", Font.BOLD, 13));
		btnGuardar.setBounds(222, 401, 89, 23);
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
		btnVolver.setFont(new Font("SimSun", Font.BOLD, 13));
		btnVolver.setBounds(335, 401, 89, 23);
		frmRegistroUsuarioNuevo.getContentPane().add(btnVolver);

		JLabel lblArea = new JLabel("Area");
		lblArea.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblArea.setBounds(293, 322, 131, 14);
		frmRegistroUsuarioNuevo.getContentPane().add(lblArea);

		JLabel lblFechaIngreso = new JLabel("Fecha Ingreso");
		lblFechaIngreso.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblFechaIngreso.setBounds(10, 321, 91, 14);
		frmRegistroUsuarioNuevo.getContentPane().add(lblFechaIngreso);

		JLabel lblRol = new JLabel("Rol");
		lblRol.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblRol.setBounds(151, 322, 91, 14);
		frmRegistroUsuarioNuevo.getContentPane().add(lblRol);
	}

	public boolean validarMailInsti(String mail) {
		final String dominio = "@utec.edu.uy";
		if (mail.contains(dominio)) {
			return true;
		} else {
			return false;
		}

	}

	public Window getFrame() {
		return frmRegistroUsuarioNuevo;

	}
}
