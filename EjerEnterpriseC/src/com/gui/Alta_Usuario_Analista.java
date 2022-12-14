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
import com.entities.USUARIO;
import com.enums.Departamento;

import com.enums.EstadoUsuario;
import com.enums.Localidad;
import com.exception.ServiciosException;
import com.services.AnalistaBeanRemote;
import com.services.ItrBeanRemote;
import com.services.UsuarioBeanRemote;
import com.toedter.calendar.JDateChooser;

import org.apache.commons.collections.functors.IfClosure;

import validations.Validate;

import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Alta_Usuario_Analista {

	private JFrame frmAltaDeUsuarioA;
	private JTextField tfTelefono;
	private JTextField tfEmail;
	private JTextField tfMailInsti;
	private JPasswordField tfContrase?a;
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
		AnalistaBeanRemote analistaBean = (AnalistaBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/AnalistaBean!com.services.AnalistaBeanRemote");
		ItrBeanRemote itrBean = (ItrBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/ItrBean!com.services.ItrBeanRemote");

		frmAltaDeUsuarioA = new JFrame();
		frmAltaDeUsuarioA.setTitle("Alta de Usuario Analista");
		frmAltaDeUsuarioA.setIconImage(
				Toolkit.getDefaultToolkit().getImage("Z:\\ONE DRIVE\\OneDrive\\Escritorio\\PNG\\logoUtec.png"));
		frmAltaDeUsuarioA.getContentPane().setBackground(SystemColor.control);
		frmAltaDeUsuarioA.getContentPane().setLayout(null);
		frmAltaDeUsuarioA.setLocationRelativeTo(null);

		JLabel lblNewLabel_2 = new JLabel("ALTA DE ANALISTA");
		lblNewLabel_2.setBounds(10, 24, 189, 34);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("SimSun", Font.BOLD, 16));
		frmAltaDeUsuarioA.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("Tel\u00E9fono");
		lblNewLabel_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 142, 64, 14);
		frmAltaDeUsuarioA.getContentPane().add(lblNewLabel_1);

		JLabel lblCorreo = new JLabel("Email");
		lblCorreo.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblCorreo.setBounds(151, 142, 64, 14);
		frmAltaDeUsuarioA.getContentPane().add(lblCorreo);

		JLabel lblNewLabel_1_2_1 = new JLabel("Departamento");
		lblNewLabel_1_2_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_2_1.setBounds(151, 198, 91, 14);
		frmAltaDeUsuarioA.getContentPane().add(lblNewLabel_1_2_1);

		JLabel lblUsuario = new JLabel("Mail Institucional");
		lblUsuario.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblUsuario.setBounds(293, 142, 131, 14);
		frmAltaDeUsuarioA.getContentPane().add(lblUsuario);

		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("ITR");
		lblNewLabel_1_2_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_2_1_1_1.setBounds(151, 256, 42, 14);
		frmAltaDeUsuarioA.getContentPane().add(lblNewLabel_1_2_1_1_1);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblContrasea.setBounds(293, 198, 70, 14);
		frmAltaDeUsuarioA.getContentPane().add(lblContrasea);

		JLabel lblNewLabel_1_1 = new JLabel("Nombre");
		lblNewLabel_1_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(10, 86, 64, 14);
		frmAltaDeUsuarioA.getContentPane().add(lblNewLabel_1_1);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblApellido.setBounds(151, 86, 64, 14);
		frmAltaDeUsuarioA.getContentPane().add(lblApellido);

		JLabel lblDocumento = new JLabel("Documento");
		lblDocumento.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblDocumento.setBounds(293, 86, 64, 14);
		frmAltaDeUsuarioA.getContentPane().add(lblDocumento);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblEstado.setBounds(10, 256, 64, 14);
		frmAltaDeUsuarioA.getContentPane().add(lblEstado);

		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
		lblFechaDeNacimiento.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblFechaDeNacimiento.setBounds(292, 256, 144, 14);
		frmAltaDeUsuarioA.getContentPane().add(lblFechaDeNacimiento);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("Localidad");
		lblNewLabel_1_2_1_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_2_1_1.setBounds(10, 198, 91, 14);
		frmAltaDeUsuarioA.getContentPane().add(lblNewLabel_1_2_1_1);

		JLabel lblNewLabel = new JLabel("DE");
		lblNewLabel.setBounds(119, 228, 22, 14);
		frmAltaDeUsuarioA.getContentPane().add(lblNewLabel);

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
		tfTelefono.setBounds(10, 167, 131, 20);
		frmAltaDeUsuarioA.getContentPane().add(tfTelefono);

		tfEmail = new JTextField();
		tfEmail.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfEmail.setColumns(10);
		tfEmail.setBounds(152, 167, 131, 20);
		frmAltaDeUsuarioA.getContentPane().add(tfEmail);

		tfMailInsti = new JTextField();
		tfMailInsti.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfMailInsti.setColumns(10);
		tfMailInsti.setBounds(293, 167, 131, 20);
		frmAltaDeUsuarioA.getContentPane().add(tfMailInsti);

		tfContrase?a = new JPasswordField();
		tfContrase?a.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfContrase?a.setBounds(292, 225, 132, 20);
		frmAltaDeUsuarioA.getContentPane().add(tfContrase?a);

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
		tfNombre.setBounds(10, 111, 131, 20);
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
		tfApellido.setBounds(152, 111, 131, 20);
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
		tfDocumento.setBounds(293, 111, 131, 20);
		frmAltaDeUsuarioA.getContentPane().add(tfDocumento);

		// Comboboxes Dates

		JComboBox<Departamento> comboBoxDep = new javax.swing.JComboBox<>();
		comboBoxDep.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxDep.setBounds(151, 223, 131, 22);
		comboBoxDep.setModel(new DefaultComboBoxModel(Departamento.values()));
		frmAltaDeUsuarioA.getContentPane().add(comboBoxDep);

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

		frmAltaDeUsuarioA.getContentPane().add(comboBoxItr);

		JComboBox<EstadoUsuario> comboBoxEstado = new javax.swing.JComboBox<>();
		comboBoxEstado.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxEstado.setBounds(10, 281, 131, 22);
		comboBoxEstado.setModel(new DefaultComboBoxModel(EstadoUsuario.values()));
		frmAltaDeUsuarioA.getContentPane().add(comboBoxEstado);

		JComboBox<Localidad> comboBoxLoc = new JComboBox<Localidad>();
		comboBoxLoc.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxLoc.setBounds(10, 223, 107, 22);
		comboBoxLoc.setModel(new DefaultComboBoxModel(Localidad.values()));
		frmAltaDeUsuarioA.getContentPane().add(comboBoxLoc);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(293, 283, 131, 20);
		Calendar today = Calendar.getInstance();
		today.clear(Calendar.HOUR);
		today.clear(Calendar.MINUTE);
		today.clear(Calendar.SECOND);
		Date todayDate = today.getTime();
		dateChooser.setMaxSelectableDate(todayDate);
		dateChooser.setDate(todayDate);
		ZoneId defaultZoneId = ZoneId.systemDefault();
		frmAltaDeUsuarioA.getContentPane().add(dateChooser);

		// Botones

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				try {

					Validate v = new Validate();
					ANALISTA Analista = new ANALISTA();
					if (v.nameAndLast(tfNombre.getText()))
						Analista.setNombre(tfNombre.getText());
					if (v.nameAndLast(tfApellido.getText()))
						Analista.setApellido(tfApellido.getText());
					if (v.pass(tfContrase?a.getText()))
						Analista.setContrasena(tfContrase?a.getText());
					if (v.documento(tfDocumento.getText()))
						Analista.setDocumento(Integer.parseInt(tfDocumento.getText()));
					if (v.email(tfEmail.getText()))
						Analista.setMail(tfEmail.getText());
					if (v.telefono(tfTelefono.getText()))
						Analista.setTelefono(tfTelefono.getText());
					if (v.mailInsti(tfMailInsti.getText()))
						Analista.setMail_insti(tfMailInsti.getText());
					Analista.setDepartamento(Departamento.valueOf(comboBoxDep.getSelectedItem().toString()));
					Analista.setEstado(EstadoUsuario.valueOf(comboBoxEstado.getSelectedItem().toString()));
					Analista.setLocalidad(Localidad.valueOf(comboBoxLoc.getSelectedItem().toString()));
					Analista.setFechaNac(
							dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

					Analista.setItr(itrBean.findItr(comboBoxItr.getSelectedItem().toString()).get(0));
					analistaBean.addAnalista(Analista);
					JOptionPane.showMessageDialog(null, "Alta exitosa!");
				} catch (NumberFormatException | ServiciosException | NamingException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}

			}
		});
		btnGuardar.setFont(new Font("SimSun", Font.BOLD, 14));
		btnGuardar.setBounds(203, 336, 97, 23);
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
		btnCancelar.setBounds(329, 336, 97, 23);
		frmAltaDeUsuarioA.getContentPane().add(btnCancelar);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Alta_Usuario_Analista.class.getResource("/PNG/NC 100.jpg")));
		lblNewLabel_3.setBounds(0, 346, 105, 24);
		frmAltaDeUsuarioA.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Alta_Usuario_Analista.class.getResource("/PNG/logoUtec.png")));
		lblNewLabel_4.setBounds(361, 11, 63, 65);
		frmAltaDeUsuarioA.getContentPane().add(lblNewLabel_4);
		frmAltaDeUsuarioA.setBounds(100, 100, 452, 408);
		frmAltaDeUsuarioA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public Window getFrame() {
		// TODO Auto-generated method stub
		return this.frmAltaDeUsuarioA;
	}
}
