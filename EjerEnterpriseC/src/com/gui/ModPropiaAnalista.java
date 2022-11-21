package com.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.entities.ANALISTA;
import com.entities.USUARIO;
import com.enums.Departamento;
import com.enums.EstadoUsuario;
import com.exception.ServiciosException;
import com.services.AnalistaBeanRemote;
import com.services.EstudianteBeanRemote;
import com.services.TutorBeanRemote;
import com.services.UsuarioBeanRemote;
import com.toedter.calendar.JDateChooser;

public class ModPropiaAnalista {

	private JFrame frmModificacionDeUsuario;
	private JTextField tfTelefono;
	private JTextField tfEmail;
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfDocumento;

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
		lblNewLabel_1_2_1_1_1.setBounds(151, 185, 42, 14);
		frmModificacionDeUsuario.getContentPane().add(lblNewLabel_1_2_1_1_1);

		JComboBox<String> comboBoxItr = new JComboBox<>();
		comboBoxItr.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxItr.setBounds(151, 207, 131, 22);
		comboBoxItr.addItem(analista.getItr().name());

		frmModificacionDeUsuario.getContentPane().add(comboBoxItr);

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
		tfNombre.setBounds(10, 101, 131, 20);
		frmModificacionDeUsuario.getContentPane().add(tfNombre);

		JLabel lblNewLabel_1_1 = new JLabel("Nombre");
		lblNewLabel_1_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(10, 77, 64, 14);
		frmModificacionDeUsuario.getContentPane().add(lblNewLabel_1_1);

		tfApellido = new JTextField();
		tfApellido.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfApellido.setColumns(10);
		tfApellido.setBounds(151, 100, 131, 20);
		frmModificacionDeUsuario.getContentPane().add(tfApellido);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblApellido.setBounds(151, 76, 64, 14);
		frmModificacionDeUsuario.getContentPane().add(lblApellido);

		tfDocumento = new JTextField();
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

		JComboBox<EstadoUsuario> comboBoxEstado = new javax.swing.JComboBox<>();
		comboBoxEstado.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxEstado.setBounds(293, 206, 131, 22);
		comboBoxEstado.setModel(new DefaultComboBoxModel(EstadoUsuario.values()));
		comboBoxEstado.setSelectedIndex(analista.getEstado().ordinal());
		frmModificacionDeUsuario.getContentPane().add(comboBoxEstado);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblEstado.setBounds(293, 181, 64, 14);
		frmModificacionDeUsuario.getContentPane().add(lblEstado);

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
				analista.setApellido(tfApellido.getText());
				analista.setNombre(tfNombre.getText());
				analista.setDocumento(Integer.parseInt(tfDocumento.getText()));
				analista.setMail(tfEmail.getText());
				analista.setTelefono(tfTelefono.getText());
				analista.setDepartamento(Departamento.valueOf(comboBoxDep.getSelectedItem().toString()));
				analista.setEstado(EstadoUsuario.valueOf(comboBoxEstado.getSelectedItem().toString()));
				analista.setFechaNac(dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

				try {
					analistaBean.editAnalista((ANALISTA) analista);
					JOptionPane.showMessageDialog(null, "Analista modificado con exito");
				} catch (ServiciosException e1) {
					e1.printStackTrace();
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