package com.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import com.entities.ITR;
import com.entities.USUARIO;
import com.enums.Departamento;

import com.enums.EstadoUsuario;
import com.enums.Localidad;
import com.exception.ServiciosException;
import com.services.EstudianteBeanRemote;
import com.services.ItrBeanRemote;
import com.services.UsuarioBeanRemote;
import com.toedter.calendar.JDateChooser;

import validations.Validate;

import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Alta_Usuario_Estudiante {

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
	public Alta_Usuario_Estudiante(USUARIO usuario) throws NamingException {
		initialize(usuario);
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws NamingException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize(USUARIO usuario) throws NamingException {
		EstudianteBeanRemote estudianteBean = (EstudianteBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/EstudianteBean!com.services.EstudianteBeanRemote");
		ItrBeanRemote itrBean = (ItrBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/ItrBean!com.services.ItrBeanRemote");

		frmAltaDeUsuarioA = new JFrame();
		frmAltaDeUsuarioA.setTitle("Alta de Usuario Estudiante");
		frmAltaDeUsuarioA.setResizable(false);
		frmAltaDeUsuarioA.setIconImage(
				Toolkit.getDefaultToolkit().getImage("Z:\\ONE DRIVE\\OneDrive\\Escritorio\\PNG\\logoUtec.png"));
		frmAltaDeUsuarioA.getContentPane().setBackground(SystemColor.control);
		frmAltaDeUsuarioA.getContentPane().setLayout(null);
		frmAltaDeUsuarioA.setLocationRelativeTo(null);

		JLabel lblNewLabel_2 = new JLabel("ALTA DE ESTUDIANTE");
		lblNewLabel_2.setBounds(8, 27, 273, 34);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("SimSun", Font.BOLD, 16));
		frmAltaDeUsuarioA.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("Tel\u00E9fono");
		lblNewLabel_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 135, 64, 14);
		frmAltaDeUsuarioA.getContentPane().add(lblNewLabel_1);

		JLabel lblCorreo = new JLabel("Email");
		lblCorreo.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblCorreo.setBounds(150, 135, 64, 14);
		frmAltaDeUsuarioA.getContentPane().add(lblCorreo);

		JLabel lblNewLabel_1_2_1 = new JLabel("Departamento");
		lblNewLabel_1_2_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_2_1.setBounds(150, 191, 91, 14);
		frmAltaDeUsuarioA.getContentPane().add(lblNewLabel_1_2_1);

		JLabel lblUsuario = new JLabel("Mail Institucional");
		lblUsuario.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblUsuario.setBounds(293, 135, 131, 14);
		frmAltaDeUsuarioA.getContentPane().add(lblUsuario);

		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("ITR");
		lblNewLabel_1_2_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_2_1_1_1.setBounds(150, 249, 42, 14);
		frmAltaDeUsuarioA.getContentPane().add(lblNewLabel_1_2_1_1_1);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblContrasea.setBounds(293, 191, 70, 14);
		frmAltaDeUsuarioA.getContentPane().add(lblContrasea);

		JLabel lblNewLabel_1_1 = new JLabel("Nombre");
		lblNewLabel_1_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(8, 79, 64, 14);
		frmAltaDeUsuarioA.getContentPane().add(lblNewLabel_1_1);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblApellido.setBounds(150, 79, 64, 14);
		frmAltaDeUsuarioA.getContentPane().add(lblApellido);

		JLabel lblDocumento = new JLabel("Documento");
		lblDocumento.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblDocumento.setBounds(293, 79, 64, 14);
		frmAltaDeUsuarioA.getContentPane().add(lblDocumento);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblEstado.setBounds(10, 249, 64, 14);
		frmAltaDeUsuarioA.getContentPane().add(lblEstado);

		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
		lblFechaDeNacimiento.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblFechaDeNacimiento.setBounds(293, 249, 143, 14);
		frmAltaDeUsuarioA.getContentPane().add(lblFechaDeNacimiento);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("Localidad");
		lblNewLabel_1_2_1_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_2_1_1.setBounds(10, 191, 91, 14);
		frmAltaDeUsuarioA.getContentPane().add(lblNewLabel_1_2_1_1);

		JLabel lblNewLabel = new JLabel("DE");
		lblNewLabel.setBounds(127, 220, 22, 14);
		frmAltaDeUsuarioA.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_3 = new JLabel("A\u00F1o de ingreso");
		lblNewLabel_3.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(10, 307, 107, 14);
		frmAltaDeUsuarioA.getContentPane().add(lblNewLabel_3);
		frmAltaDeUsuarioA.setBounds(100, 100, 453, 445);
		frmAltaDeUsuarioA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// TextFields

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
		tfTelefono.setBounds(10, 160, 131, 20);
		frmAltaDeUsuarioA.getContentPane().add(tfTelefono);

		tfEmail = new JTextField();
		tfEmail.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfEmail.setColumns(10);
		tfEmail.setBounds(150, 160, 131, 20);
		frmAltaDeUsuarioA.getContentPane().add(tfEmail);

		tfMailInsti = new JTextField();
		tfMailInsti.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfMailInsti.setColumns(10);
		tfMailInsti.setBounds(293, 160, 131, 20);
		frmAltaDeUsuarioA.getContentPane().add(tfMailInsti);

		tfContraseña = new JPasswordField();
		tfContraseña.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfContraseña.setBounds(293, 218, 132, 20);
		frmAltaDeUsuarioA.getContentPane().add(tfContraseña);

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
		tfNombre.setBounds(8, 104, 131, 20);
		frmAltaDeUsuarioA.getContentPane().add(tfNombre);

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
		tfApellido.setBounds(150, 104, 131, 20);
		frmAltaDeUsuarioA.getContentPane().add(tfApellido);

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
		tfDocumento.setBounds(293, 104, 131, 20);
		frmAltaDeUsuarioA.getContentPane().add(tfDocumento);

		// Comboboxes Dates

		JComboBox<Departamento> comboBoxDep = new javax.swing.JComboBox<>();
		comboBoxDep.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxDep.setBounds(150, 216, 131, 22);
		comboBoxDep.setModel(new DefaultComboBoxModel(Departamento.values()));
		frmAltaDeUsuarioA.getContentPane().add(comboBoxDep);

		JComboBox<ITR> comboBoxItr = new JComboBox<>();
		comboBoxItr.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxItr.setBounds(150, 274, 131, 22);

		// ITRS activos
		List<ITR> itrs = itrBean.findAll(true);

		// Declaring Array with Equal Size to the List
		String[] itrNombres = new String[itrs.size()];

		// Converting List to Array
		for (int i = 0; i < itrs.size(); i++) {
			itrNombres[i] = itrs.get(i).getNombre();
		}

		comboBoxItr.setModel(new DefaultComboBoxModel(itrNombres));

		frmAltaDeUsuarioA.getContentPane().add(comboBoxItr);

		JComboBox<EstadoUsuario> comboBoxEstado = new javax.swing.JComboBox<>();
		comboBoxEstado.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxEstado.setBounds(10, 274, 131, 22);
		comboBoxEstado.setModel(new DefaultComboBoxModel(EstadoUsuario.values()));
		frmAltaDeUsuarioA.getContentPane().add(comboBoxEstado);

		JComboBox<Localidad> comboBoxLoc = new JComboBox<Localidad>();
		comboBoxLoc.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxLoc.setBounds(10, 216, 107, 22);
		comboBoxLoc.setModel(new DefaultComboBoxModel(Localidad.values()));
		frmAltaDeUsuarioA.getContentPane().add(comboBoxLoc);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(293, 276, 131, 20);
		Calendar today = Calendar.getInstance();
		today.clear(Calendar.HOUR);
		today.clear(Calendar.MINUTE);
		today.clear(Calendar.SECOND);
		Date todayDate = today.getTime();
		dateChooser.setMaxSelectableDate(todayDate);
		@SuppressWarnings("unused")
		ZoneId defaultZoneId = ZoneId.systemDefault();
		frmAltaDeUsuarioA.getContentPane().add(dateChooser);

		JComboBox comboBoxIngreso = new JComboBox();
		comboBoxIngreso.setBounds(10, 332, 107, 22);
		for (int i = 2012; i <= LocalDate.now().getYear(); i += 1) {
			comboBoxIngreso.addItem(i);
		}
		frmAltaDeUsuarioA.getContentPane().add(comboBoxIngreso);

		// Botones

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					Validate v = new Validate();
					ESTUDIANTE estudiante = new ESTUDIANTE();
					if (v.nameAndLast(tfApellido.getText()))
						estudiante.setApellido(tfApellido.getText());
					if (v.nameAndLast(tfNombre.getText()))
						estudiante.setNombre(tfNombre.getText());
					if (v.pass(tfContraseña.getText()))
						estudiante.setContrasena(tfContraseña.getText());
					if (v.documento(tfDocumento.getText()))
						estudiante.setDocumento(Integer.parseInt(tfDocumento.getText()));
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
					estudiante.setGeneracion(comboBoxIngreso.getSelectedItem().toString());

					estudianteBean.addStudent(estudiante);
					JOptionPane.showMessageDialog(null, "Alta exitosa!");
				} catch (ServiciosException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}

			}
		});
		btnGuardar.setFont(new Font("SimSun", Font.BOLD, 14));
		btnGuardar.setBounds(209, 372, 97, 23);
		frmAltaDeUsuarioA.getContentPane().add(btnGuardar);
		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/UsuarioBean!com.services.UsuarioBeanRemote");

		JButton btnCancelar = new JButton("Volver");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ppal_Analista pAnalist = null;
				try {
					ANALISTA usuario2 = (ANALISTA) usuarioBean.findUser(usuario.getDocumento()).get(0);
					pAnalist = new Ppal_Analista(usuario2);
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pAnalist.setVisible(true);
				pAnalist.setLocationRelativeTo(null);
				getFrame().dispose();
			}
		});
		btnCancelar.setFont(new Font("SimSun", Font.BOLD, 13));
		btnCancelar.setBounds(329, 372, 97, 23);
		frmAltaDeUsuarioA.getContentPane().add(btnCancelar);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Alta_Usuario_Estudiante.class.getResource("/PNG/logoUtec.png")));
		lblNewLabel_4.setBounds(367, 8, 64, 65);
		frmAltaDeUsuarioA.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(Alta_Usuario_Estudiante.class.getResource("/PNG/NC 100.jpg")));
		lblNewLabel_5.setBounds(0, 386, 107, 20);
		frmAltaDeUsuarioA.getContentPane().add(lblNewLabel_5);

	}

	public Window getFrame() {
		// TODO Auto-generated method stub
		return this.frmAltaDeUsuarioA;
	}
}
