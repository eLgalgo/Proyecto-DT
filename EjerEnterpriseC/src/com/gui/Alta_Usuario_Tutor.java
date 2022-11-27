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
import com.entities.ITR;
import com.entities.TUTOR;
import com.entities.USUARIO;
import com.enums.Departamento;

import com.enums.EstadoUsuario;
import com.enums.Localidad;
import com.enums.RolTutor;
import com.exception.ServiciosException;
import com.services.ItrBeanRemote;
import com.services.TutorBeanRemote;
import com.services.UsuarioBeanRemote;
import com.toedter.calendar.JDateChooser;

import validations.Validate;

import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
	public Alta_Usuario_Tutor(USUARIO usuario) throws NamingException {
		initialize(usuario);
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws NamingException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize(USUARIO usuario) throws NamingException {
		TutorBeanRemote tutorBean = (TutorBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/TutorBean!com.services.TutorBeanRemote");
		ItrBeanRemote itrBean = (ItrBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/ItrBean!com.services.ItrBeanRemote");

		frmAltaDeUsuarioT = new JFrame();
		frmAltaDeUsuarioT.setTitle("Alta de Usuario Tutor");
		frmAltaDeUsuarioT.setResizable(false);
		frmAltaDeUsuarioT.setIconImage(
				Toolkit.getDefaultToolkit().getImage("Z:\\ONE DRIVE\\OneDrive\\Escritorio\\PNG\\logoUtec.png"));
		frmAltaDeUsuarioT.getContentPane().setBackground(SystemColor.control);
		frmAltaDeUsuarioT.getContentPane().setLayout(null);
		frmAltaDeUsuarioT.setLocationRelativeTo(null);

		JLabel lblNewLabel_2 = new JLabel("ALTA DE TUTOR");
		lblNewLabel_2.setBounds(10, 21, 131, 34);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("SimSun", Font.BOLD, 16));
		frmAltaDeUsuarioT.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("Tel\u00E9fono");
		lblNewLabel_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 138, 64, 14);
		frmAltaDeUsuarioT.getContentPane().add(lblNewLabel_1);

		JLabel lblCorreo = new JLabel("Email");
		lblCorreo.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblCorreo.setBounds(151, 138, 64, 14);
		frmAltaDeUsuarioT.getContentPane().add(lblCorreo);

		JLabel lblNewLabel_1_2_1 = new JLabel("Departamento");
		lblNewLabel_1_2_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_2_1.setBounds(151, 194, 91, 14);
		frmAltaDeUsuarioT.getContentPane().add(lblNewLabel_1_2_1);

		JLabel lblUsuario = new JLabel("Mail Institucional");
		lblUsuario.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblUsuario.setBounds(293, 138, 131, 14);
		frmAltaDeUsuarioT.getContentPane().add(lblUsuario);

		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("ITR");
		lblNewLabel_1_2_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_2_1_1_1.setBounds(151, 252, 42, 14);
		frmAltaDeUsuarioT.getContentPane().add(lblNewLabel_1_2_1_1_1);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblContrasea.setBounds(293, 194, 70, 14);
		frmAltaDeUsuarioT.getContentPane().add(lblContrasea);

		JLabel lblNewLabel_1_1 = new JLabel("Nombre");
		lblNewLabel_1_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(10, 82, 64, 14);
		frmAltaDeUsuarioT.getContentPane().add(lblNewLabel_1_1);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblApellido.setBounds(151, 82, 64, 14);
		frmAltaDeUsuarioT.getContentPane().add(lblApellido);

		JLabel lblDocumento = new JLabel("Documento");
		lblDocumento.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblDocumento.setBounds(293, 82, 64, 14);
		frmAltaDeUsuarioT.getContentPane().add(lblDocumento);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblEstado.setBounds(10, 252, 64, 14);
		frmAltaDeUsuarioT.getContentPane().add(lblEstado);

		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
		lblFechaDeNacimiento.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblFechaDeNacimiento.setBounds(293, 252, 141, 14);
		frmAltaDeUsuarioT.getContentPane().add(lblFechaDeNacimiento);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("Localidad");
		lblNewLabel_1_2_1_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_2_1_1.setBounds(10, 194, 91, 14);
		frmAltaDeUsuarioT.getContentPane().add(lblNewLabel_1_2_1_1);

		JLabel lblNewLabel = new JLabel("DE");
		lblNewLabel.setBounds(127, 223, 22, 14);
		frmAltaDeUsuarioT.getContentPane().add(lblNewLabel);

		JLabel lblTipo = new JLabel("Rol");
		lblTipo.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblTipo.setBounds(10, 310, 64, 14);
		frmAltaDeUsuarioT.getContentPane().add(lblTipo);

		JLabel lblArea = new JLabel("Area");
		lblArea.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblArea.setBounds(151, 310, 119, 14);
		frmAltaDeUsuarioT.getContentPane().add(lblArea);
		frmAltaDeUsuarioT.setBounds(100, 100, 452, 465);
		frmAltaDeUsuarioT.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

				if (tfDocumento.getText().trim().length() == 9) {
					evt.consume();
					Toolkit.getDefaultToolkit().beep();
				}
			}
		});
		tfTelefono.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfTelefono.setColumns(10);
		tfTelefono.setBounds(10, 163, 131, 20);
		frmAltaDeUsuarioT.getContentPane().add(tfTelefono);

		tfEmail = new JTextField();
		tfEmail.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfEmail.setColumns(10);
		tfEmail.setBounds(152, 163, 131, 20);
		frmAltaDeUsuarioT.getContentPane().add(tfEmail);

		tfMailInsti = new JTextField();
		tfMailInsti.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfMailInsti.setColumns(10);
		tfMailInsti.setBounds(293, 163, 131, 20);
		frmAltaDeUsuarioT.getContentPane().add(tfMailInsti);

		tfContraseña = new JPasswordField();
		tfContraseña.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfContraseña.setBounds(293, 221, 132, 20);
		frmAltaDeUsuarioT.getContentPane().add(tfContraseña);

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
		tfNombre.setBounds(10, 107, 131, 20);
		frmAltaDeUsuarioT.getContentPane().add(tfNombre);

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
		tfApellido.setBounds(151, 107, 131, 20);
		frmAltaDeUsuarioT.getContentPane().add(tfApellido);

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
		tfDocumento.setBounds(293, 107, 131, 20);
		frmAltaDeUsuarioT.getContentPane().add(tfDocumento);

		textFieldArea = new JTextField();
		textFieldArea.setBounds(151, 336, 131, 20);
		frmAltaDeUsuarioT.getContentPane().add(textFieldArea);
		textFieldArea.setColumns(10);

		// Comboboxes Dates

		JComboBox<Departamento> comboBoxDep = new javax.swing.JComboBox<>();
		comboBoxDep.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxDep.setBounds(151, 219, 131, 22);
		comboBoxDep.setModel(new DefaultComboBoxModel(Departamento.values()));
		frmAltaDeUsuarioT.getContentPane().add(comboBoxDep);

		JComboBox<ITR> comboBoxItr = new JComboBox<>();
		comboBoxItr.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxItr.setBounds(151, 277, 131, 22);

		// ITRS activos
		List<ITR> itrs = itrBean.findAll(true);

		// Declaring Array with Equal Size to the List
		String[] itrNombres = new String[itrs.size()];

		// Converting List to Array
		for (int i = 0; i < itrs.size(); i++) {
			itrNombres[i] = itrs.get(i).getNombre();
		}

		comboBoxItr.setModel(new DefaultComboBoxModel(itrNombres));

		frmAltaDeUsuarioT.getContentPane().add(comboBoxItr);

		JComboBox<EstadoUsuario> comboBoxEstado = new javax.swing.JComboBox<>();
		comboBoxEstado.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxEstado.setBounds(10, 277, 131, 22);
		comboBoxEstado.setModel(new DefaultComboBoxModel(EstadoUsuario.values()));
		frmAltaDeUsuarioT.getContentPane().add(comboBoxEstado);

		JComboBox<Localidad> comboBoxLoc = new JComboBox<Localidad>();
		comboBoxLoc.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxLoc.setBounds(10, 219, 107, 22);
		comboBoxLoc.setModel(new DefaultComboBoxModel(Localidad.values()));
		frmAltaDeUsuarioT.getContentPane().add(comboBoxLoc);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(293, 279, 131, 20);
		Calendar today = Calendar.getInstance();
		today.clear(Calendar.HOUR);
		today.clear(Calendar.MINUTE);
		today.clear(Calendar.SECOND);
		Date todayDate = today.getTime();
		dateChooser.setMaxSelectableDate(todayDate);
		@SuppressWarnings("unused")
		ZoneId defaultZoneId = ZoneId.systemDefault();
		frmAltaDeUsuarioT.getContentPane().add(dateChooser);

		JComboBox<EstadoUsuario> comboBoxRolT = new JComboBox<EstadoUsuario>();
		comboBoxRolT.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxRolT.setBounds(10, 335, 131, 22);
		comboBoxRolT.setModel(new DefaultComboBoxModel(RolTutor.values()));
		frmAltaDeUsuarioT.getContentPane().add(comboBoxRolT);

		// Botones

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					Validate v = new Validate();
					TUTOR tutor = new TUTOR();
					if (v.nameAndLast(tfApellido.getText()))
						tutor.setApellido(tfApellido.getText());
					if (v.nameAndLast(tfNombre.getText()))
						tutor.setNombre(tfNombre.getText());
					if (v.pass(tfContraseña.getText()))
						tutor.setContrasena(tfContraseña.getText());
					if (v.documento(tfDocumento.getText()))
						tutor.setDocumento(Integer.parseInt(tfDocumento.getText()));
					if (v.email(tfEmail.getText()))
						tutor.setMail(tfEmail.getText());
					if (v.telefono(tfTelefono.getText()))
						tutor.setTelefono(tfTelefono.getText());
					if (v.mailInsti(tfMailInsti.getText()))
						tutor.setMail_insti(tfMailInsti.getText());
					tutor.setDepartamento(Departamento.valueOf(comboBoxDep.getSelectedItem().toString()));
					tutor.setEstado(EstadoUsuario.valueOf(comboBoxEstado.getSelectedItem().toString()));
					tutor.setLocalidad(Localidad.valueOf(comboBoxLoc.getSelectedItem().toString()));

					tutor.setItr(itrBean.findItr(comboBoxItr.getSelectedItem().toString()).get(0));

					tutor.setFechaNac(dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
					if (v.area(textFieldArea.getText()))
						tutor.setArea(textFieldArea.getText());
					tutor.setTipo(RolTutor.valueOf(comboBoxRolT.getSelectedItem().toString()));

					tutorBean.addTutor(tutor);
					JOptionPane.showMessageDialog(null, "Alta exitosa!");
				} catch (ServiciosException | NumberFormatException | NamingException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}

				
			}
		});
		btnGuardar.setFont(new Font("SimSun", Font.BOLD, 14));
		btnGuardar.setBounds(206, 392, 97, 23);
		frmAltaDeUsuarioT.getContentPane().add(btnGuardar);

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
		btnCancelar.setBounds(327, 392, 97, 23);
		frmAltaDeUsuarioT.getContentPane().add(btnCancelar);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Alta_Usuario_Tutor.class.getResource("/PNG/logoUtec.png")));
		lblNewLabel_3.setBounds(354, 11, 70, 65);
		frmAltaDeUsuarioT.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Alta_Usuario_Tutor.class.getResource("/PNG/NC 100.jpg")));
		lblNewLabel_4.setBounds(0, 404, 107, 22);
		frmAltaDeUsuarioT.getContentPane().add(lblNewLabel_4);

	}

	public Window getFrame() {
		// TODO Auto-generated method stub
		return this.frmAltaDeUsuarioT;
	}
}
