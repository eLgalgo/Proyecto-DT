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
import java.awt.SystemColor;

public class Mod_Analista {

	private JFrame frmModificacionDeUsuario;
	private JTextField tfTelefono;
	private JTextField tfEmail;
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfDocumento;
	private JTextField tfMailInsti;

	/**
	 * Create the application.
	 */
	public Mod_Analista(ANALISTA usuario, ANALISTA analista) throws NamingException {
		initialize(usuario, analista);
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws NamingException
	 */
	private void initialize(ANALISTA usuario, ANALISTA analista) throws NamingException {

		EstudianteBeanRemote estudianteBean = (EstudianteBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/EstudianteBean!com.services.EstudianteBeanRemote");

		TutorBeanRemote tutorBean = (TutorBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/TutorBean!com.services.TutorBeanRemote");

		AnalistaBeanRemote analistaBean = (AnalistaBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/AnalistaBean!com.services.AnalistaBeanRemote");

		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/UsuarioBean!com.services.UsuarioBeanRemote");
		ItrBeanRemote itrBean = (ItrBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/ItrBean!com.services.ItrBeanRemote");

		frmModificacionDeUsuario = new JFrame();
		frmModificacionDeUsuario.setResizable(false);
		frmModificacionDeUsuario.setTitle("Modificacion de Analista");
		frmModificacionDeUsuario.setIconImage(
				Toolkit.getDefaultToolkit().getImage("Z:\\ONE DRIVE\\OneDrive\\Escritorio\\PNG\\logoUtec.png"));
		frmModificacionDeUsuario.getContentPane().setBackground(SystemColor.control);
		frmModificacionDeUsuario.getContentPane().setLayout(null);
		frmModificacionDeUsuario.setLocationRelativeTo(null);

		JLabel lblNewLabel_2 = new JLabel("MODIFICACI\u00D3N DE ANALISTA");
		lblNewLabel_2.setBounds(9, 28, 273, 34);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("SimSun", Font.BOLD, 16));
		frmModificacionDeUsuario.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("Tel\u00E9fono");
		lblNewLabel_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(9, 151, 64, 14);
		frmModificacionDeUsuario.getContentPane().add(lblNewLabel_1);

		tfTelefono = new JTextField();
		tfTelefono.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfTelefono.setColumns(10);
		tfTelefono.setBounds(9, 176, 131, 20);
		frmModificacionDeUsuario.getContentPane().add(tfTelefono);

		JLabel lblCorreo = new JLabel("Email");
		lblCorreo.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblCorreo.setBounds(151, 151, 64, 14);
		frmModificacionDeUsuario.getContentPane().add(lblCorreo);

		tfEmail = new JTextField();
		tfEmail.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfEmail.setColumns(10);
		tfEmail.setBounds(150, 176, 131, 20);
		frmModificacionDeUsuario.getContentPane().add(tfEmail);

		JLabel lblNewLabel_1_2_1 = new JLabel("Departamento");
		lblNewLabel_1_2_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_2_1.setBounds(151, 218, 91, 14);
		frmModificacionDeUsuario.getContentPane().add(lblNewLabel_1_2_1);

		JComboBox<Departamento> comboBoxDep = new javax.swing.JComboBox<>();
		comboBoxDep.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxDep.setBounds(151, 237, 131, 22);
		comboBoxDep.setModel(new DefaultComboBoxModel(Departamento.values()));
		frmModificacionDeUsuario.getContentPane().add(comboBoxDep);

		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("ITR");
		lblNewLabel_1_2_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_2_1_1_1.setBounds(84, 274, 42, 14);
		frmModificacionDeUsuario.getContentPane().add(lblNewLabel_1_2_1_1_1);

		JComboBox<String> comboBoxItr = new JComboBox<>();
		comboBoxItr.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxItr.setBounds(84, 299, 131, 22);
		// ITRS activos
		List<ITR> itrs = itrBean.findAll(true);

		// Declaring Array with Equal Size to the List
		String[] itrNombres = new String[itrs.size()];

		// Converting List to Array
		for (int i = 0; i < itrs.size(); i++) {
			itrNombres[i] = itrs.get(i).getNombre();
			comboBoxItr.addItem(itrNombres[i]);
		}
		comboBoxItr.setSelectedItem(usuario.getItr().getNombre());

		frmModificacionDeUsuario.getContentPane().add(comboBoxItr);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("SimSun", Font.BOLD, 14));
		btnGuardar.setBounds(204, 353, 97, 23);
		frmModificacionDeUsuario.getContentPane().add(btnGuardar);

		JButton btnCancelar = new JButton("Volver");
		btnCancelar.setFont(new Font("SimSun", Font.BOLD, 13));
		btnCancelar.setBounds(327, 353, 97, 23);
		frmModificacionDeUsuario.getContentPane().add(btnCancelar);
		frmModificacionDeUsuario.setBounds(100, 100, 450, 431);
		frmModificacionDeUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		tfNombre = new JTextField();
		tfNombre.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfNombre.setColumns(10);
		tfNombre.setBounds(9, 120, 131, 20);
		frmModificacionDeUsuario.getContentPane().add(tfNombre);

		JLabel lblNewLabel_1_1 = new JLabel("Nombre");
		lblNewLabel_1_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(9, 95, 64, 14);
		frmModificacionDeUsuario.getContentPane().add(lblNewLabel_1_1);

		tfApellido = new JTextField();
		tfApellido.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfApellido.setColumns(10);
		tfApellido.setBounds(151, 120, 131, 20);
		frmModificacionDeUsuario.getContentPane().add(tfApellido);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblApellido.setBounds(152, 95, 64, 14);
		frmModificacionDeUsuario.getContentPane().add(lblApellido);

		tfDocumento = new JTextField();
		tfDocumento.setText((String) null);
		tfDocumento.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfDocumento.setColumns(10);
		tfDocumento.setBounds(293, 120, 131, 20);
		frmModificacionDeUsuario.getContentPane().add(tfDocumento);

		JLabel lblDocumento = new JLabel("Documento");
		lblDocumento.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblDocumento.setBounds(293, 95, 64, 14);
		frmModificacionDeUsuario.getContentPane().add(lblDocumento);
		tfNombre.setText(usuario.getNombre());
		tfApellido.setText(usuario.getApellido());
		tfTelefono.setText(usuario.getTelefono());
		tfEmail.setText(usuario.getMail());
		tfDocumento.setText(Integer.toString(usuario.getDocumento()));
		comboBoxDep.setSelectedIndex(usuario.getDepartamento().ordinal());

		JComboBox<EstadoUsuario> comboBoxEstado = new javax.swing.JComboBox<>();
		comboBoxEstado.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxEstado.setBounds(293, 237, 131, 22);
		comboBoxEstado.setModel(new DefaultComboBoxModel(EstadoUsuario.values()));
		comboBoxEstado.setSelectedIndex(usuario.getEstado().ordinal());
		frmModificacionDeUsuario.getContentPane().add(comboBoxEstado);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblEstado.setBounds(293, 218, 64, 14);
		frmModificacionDeUsuario.getContentPane().add(lblEstado);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(225, 299, 131, 20);

		Calendar today = Calendar.getInstance();
		today.clear(Calendar.HOUR);
		today.clear(Calendar.MINUTE);
		today.clear(Calendar.SECOND);
		Date todayDate = today.getTime();
		dateChooser.setMaxSelectableDate(todayDate);

		ZoneId defaultZoneId = ZoneId.systemDefault();
		dateChooser.setDate(Date.from(usuario.getFechaNac().atStartOfDay(defaultZoneId).toInstant()));
		frmModificacionDeUsuario.getContentPane().add(dateChooser);

		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
		lblFechaDeNacimiento.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblFechaDeNacimiento.setBounds(226, 270, 131, 14);
		frmModificacionDeUsuario.getContentPane().add(lblFechaDeNacimiento);
		
		tfMailInsti = new JTextField();
		tfMailInsti.setText((String) null);
		tfMailInsti.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfMailInsti.setColumns(10);
		tfMailInsti.setBounds(293, 176, 131, 20);
		tfMailInsti.setText(usuario.getMail_insti());
		frmModificacionDeUsuario.getContentPane().add(tfMailInsti);
		
		JLabel lblMail = new JLabel("Mail Institucional");
		lblMail.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblMail.setBounds(293, 151, 131, 14);
		frmModificacionDeUsuario.getContentPane().add(lblMail);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Localidad");
		lblNewLabel_1_2_1_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_2_1_1.setBounds(10, 218, 91, 14);
		frmModificacionDeUsuario.getContentPane().add(lblNewLabel_1_2_1_1);
		
		JComboBox comboBoxLoc = new JComboBox();
		comboBoxLoc.setBounds(9, 237, 107, 22);
		comboBoxLoc.setModel(new DefaultComboBoxModel(Localidad.values()));
		comboBoxLoc.setSelectedIndex(usuario.getLocalidad().ordinal());
		frmModificacionDeUsuario.getContentPane().add(comboBoxLoc);
		
		JLabel lblNewLabel = new JLabel("DE");
		lblNewLabel.setBounds(118, 241, 22, 14);
		frmModificacionDeUsuario.getContentPane().add(lblNewLabel);

		// Logica

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usuario.setApellido(tfApellido.getText());
				usuario.setNombre(tfNombre.getText());
				usuario.setDocumento(Integer.parseInt(tfDocumento.getText()));
				usuario.setMail(tfEmail.getText());
				usuario.setMail_insti(tfMailInsti.getText());
				usuario.setTelefono(tfTelefono.getText());
				usuario.setDepartamento(Departamento.valueOf(comboBoxDep.getSelectedItem().toString()));
				usuario.setEstado(EstadoUsuario.valueOf(comboBoxEstado.getSelectedItem().toString()));
				usuario.setFechaNac(dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
				usuario.setLocalidad(Localidad.valueOf(comboBoxLoc.getSelectedItem().toString()));
				try {
					usuario.setItr(itrBean.findItr(comboBoxItr.getSelectedItem().toString()).get(0));
				} catch (ServiciosException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				try {
					analistaBean.editAnalista((ANALISTA) usuario);
					JOptionPane.showMessageDialog(null, "Analista modificado con exito");
				} catch (ServiciosException e1) {
					e1.printStackTrace();
				}
			}
		});

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarUsuarios list = null;
				try {
					list = new ListarUsuarios(analista);
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				list.getFrame().setVisible(true);
				list.getFrame().setLocationRelativeTo(null);
				getFrame().dispose();
			}
		});
	}

	JFrame getFrame() {
		return this.frmModificacionDeUsuario;
	}
}
