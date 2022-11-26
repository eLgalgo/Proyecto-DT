package com.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
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
import com.services.EstudianteBeanRemote;
import com.services.ItrBeanRemote;
import com.services.TutorBeanRemote;
import com.services.UsuarioBeanRemote;
import com.toedter.calendar.JDateChooser;

import validations.Validate;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ModPropiaAnalista {

	private JFrame frmModificacionDeUsuario;
	private JTextField tfTelefono;
	private JTextField tfEmail;
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfDocumento;
	private JTextField tfContrasena;

	/**
	 * Create the application.
	 */
	public ModPropiaAnalista(USUARIO analista) throws NamingException {
		initialize(analista);
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws NamingException
	 */
	private void initialize(USUARIO analista) throws NamingException {
		frmModificacionDeUsuario = new JFrame();
		frmModificacionDeUsuario.setTitle("Modificacion de Analista");
		frmModificacionDeUsuario.setResizable(false);
		frmModificacionDeUsuario.setIconImage(
				Toolkit.getDefaultToolkit().getImage("Z:\\ONE DRIVE\\OneDrive\\Escritorio\\PNG\\logoUtec.png"));
		frmModificacionDeUsuario.getContentPane().setBackground(Color.WHITE);
		frmModificacionDeUsuario.getContentPane().setLayout(null);
		frmModificacionDeUsuario.setLocationRelativeTo(null);

		JLabel lblNewLabel_2 = new JLabel("MODIFICACI\u00D3N DE ANALISTA");
		lblNewLabel_2.setBounds(9, 21, 273, 34);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("SimSun", Font.BOLD, 16));
		frmModificacionDeUsuario.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("Tel\u00E9fono");
		lblNewLabel_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 132, 64, 14);
		frmModificacionDeUsuario.getContentPane().add(lblNewLabel_1);

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
		tfTelefono.setBounds(10, 156, 131, 20);
		frmModificacionDeUsuario.getContentPane().add(tfTelefono);

		JLabel lblCorreo = new JLabel("Email");
		lblCorreo.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblCorreo.setBounds(10, 185, 64, 14);
		frmModificacionDeUsuario.getContentPane().add(lblCorreo);

		tfEmail = new JTextField();
		tfEmail.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfEmail.setColumns(10);
		tfEmail.setBounds(10, 208, 131, 20);
		frmModificacionDeUsuario.getContentPane().add(tfEmail);

		JLabel lblNewLabel_1_2_1 = new JLabel("Departamento");
		lblNewLabel_1_2_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_2_1.setBounds(151, 131, 91, 14);
		frmModificacionDeUsuario.getContentPane().add(lblNewLabel_1_2_1);

		JComboBox<Departamento> comboBoxDep = new javax.swing.JComboBox<>();
		comboBoxDep.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxDep.setBounds(151, 155, 131, 22);
		comboBoxDep.setModel(new DefaultComboBoxModel(Departamento.values()));
		frmModificacionDeUsuario.getContentPane().add(comboBoxDep);

		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("ITR");
		lblNewLabel_1_2_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_2_1_1_1.setBounds(9, 239, 42, 14);
		frmModificacionDeUsuario.getContentPane().add(lblNewLabel_1_2_1_1_1);
		
		ItrBeanRemote itrBean = (ItrBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/ItrBean!com.services.ItrBeanRemote");

		JComboBox<String> comboBoxItr = new JComboBox<>();
		comboBoxItr.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxItr.setBounds(9, 261, 131, 22);
		// ITRS activos
		List<ITR> itrs = itrBean.findAll(true);

		// Declaring Array with Equal Size to the List
		String[] itrNombres = new String[itrs.size()];

		// Converting List to Array
		for (int i = 0; i < itrs.size(); i++) {
			itrNombres[i] = itrs.get(i).getNombre();
		}

		comboBoxItr.setModel(new DefaultComboBoxModel(itrNombres));		

		frmModificacionDeUsuario.getContentPane().add(comboBoxItr);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("SimSun", Font.BOLD, 14));
		btnGuardar.setBounds(212, 288, 97, 23);
		frmModificacionDeUsuario.getContentPane().add(btnGuardar);

		JButton btnCancelar = new JButton("Volver");
		btnCancelar.setFont(new Font("SimSun", Font.BOLD, 13));
		btnCancelar.setBounds(325, 288, 97, 23);
		frmModificacionDeUsuario.getContentPane().add(btnCancelar);
		frmModificacionDeUsuario.setBounds(100, 100, 448, 361);
		frmModificacionDeUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
		tfNombre.setBounds(10, 101, 131, 20);
		frmModificacionDeUsuario.getContentPane().add(tfNombre);

		JLabel lblNewLabel_1_1 = new JLabel("Nombre");
		lblNewLabel_1_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(10, 77, 64, 14);
		frmModificacionDeUsuario.getContentPane().add(lblNewLabel_1_1);

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
		tfApellido.setBounds(151, 100, 131, 20);
		frmModificacionDeUsuario.getContentPane().add(tfApellido);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblApellido.setBounds(151, 76, 64, 14);
		frmModificacionDeUsuario.getContentPane().add(lblApellido);

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
		tfDocumento.setBounds(293, 101, 131, 20);
		frmModificacionDeUsuario.getContentPane().add(tfDocumento);

		JLabel lblDocumento = new JLabel("Documento");
		lblDocumento.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblDocumento.setBounds(293, 77, 64, 14);
		frmModificacionDeUsuario.getContentPane().add(lblDocumento);
		tfNombre.setText(analista.getNombre());
		tfApellido.setText(analista.getApellido());
		tfTelefono.setText(analista.getTelefono());
		tfEmail.setText(analista.getMail());
		tfDocumento.setText(Integer.toString(analista.getDocumento()));
		comboBoxDep.setSelectedIndex(analista.getDepartamento().ordinal());

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(293, 156, 131, 20);

		Calendar today = Calendar.getInstance();
		today.clear(Calendar.HOUR);
		today.clear(Calendar.MINUTE);
		today.clear(Calendar.SECOND);
		Date todayDate = today.getTime();
		dateChooser.setMaxSelectableDate(todayDate);

		ZoneId defaultZoneId = ZoneId.systemDefault();
		dateChooser.setDate(Date.from(analista.getFechaNac().atStartOfDay(defaultZoneId).toInstant()));
		frmModificacionDeUsuario.getContentPane().add(dateChooser);

		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
		lblFechaDeNacimiento.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblFechaDeNacimiento.setBounds(293, 132, 131, 14);
		frmModificacionDeUsuario.getContentPane().add(lblFechaDeNacimiento);
		
		tfContrasena = new JTextField();
		tfContrasena.setText((String) null);
		tfContrasena.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfContrasena.setColumns(10);
		tfContrasena.setBounds(293, 209, 131, 20);
		frmModificacionDeUsuario.getContentPane().add(tfContrasena);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblContrasea.setBounds(293, 185, 131, 14);
		frmModificacionDeUsuario.getContentPane().add(lblContrasea);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblLocalidad.setBounds(151, 184, 64, 14);
		frmModificacionDeUsuario.getContentPane().add(lblLocalidad);
		
		JComboBox<String> comboBoxLocal = new JComboBox<String>();
		comboBoxLocal.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxLocal.setBounds(151, 207, 131, 22);
		comboBoxLocal.setModel(new DefaultComboBoxModel(Localidad.values()));
		frmModificacionDeUsuario.getContentPane().add(comboBoxLocal);

		// Logica

		EstudianteBeanRemote estudianteBean = (EstudianteBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/EstudianteBean!com.services.EstudianteBeanRemote");

		TutorBeanRemote tutorBean = (TutorBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/TutorBean!com.services.TutorBeanRemote");

		AnalistaBeanRemote analistaBean = (AnalistaBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/AnalistaBean!com.services.AnalistaBeanRemote");

		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/UsuarioBean!com.services.UsuarioBeanRemote");

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Validate v = new Validate();
					if (v.nameAndLast(tfApellido.getText()))
						analista.setApellido(tfApellido.getText());
					if (v.nameAndLast(tfNombre.getText()))
						analista.setNombre(tfNombre.getText());
					if (v.documento(tfDocumento.getText()))
						analista.setDocumento(Integer.parseInt(tfDocumento.getText()));
					if (v.email(tfEmail.getText()))
						analista.setMail(tfEmail.getText());
					if (v.telefono(tfTelefono.getText()))
						analista.setTelefono(tfTelefono.getText());
					if (v.pass(tfContrasena.getText()))
						analista.setContrasena(tfContrasena.getText());
					analista.setDepartamento(Departamento.valueOf(comboBoxDep.getSelectedItem().toString()));
					analista.setLocalidad(Localidad.valueOf(comboBoxLocal.getSelectedItem().toString()));
					analista.setItr(itrBean.findItr(comboBoxItr.getSelectedItem().toString()).get(0));
					
					analista.setFechaNac(
							dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

					analistaBean.editAnalista((ANALISTA) analista);
					JOptionPane.showMessageDialog(null, "Analista modificado con exito");

				} catch (ServiciosException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
			}
		});

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ANALISTA analist;
				try {
					analist = (ANALISTA) usuarioBean.findUser(analista.getDocumento()).get(0);
					Ppal_Analista pAnalistW = new Ppal_Analista(analist);
					pAnalistW.setVisible(true);
					pAnalistW.setLocationRelativeTo(null);
					getFrame().dispose();
				} catch (ServiciosException | NamingException e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	JFrame getFrame() {
		return this.frmModificacionDeUsuario;
	}
}
