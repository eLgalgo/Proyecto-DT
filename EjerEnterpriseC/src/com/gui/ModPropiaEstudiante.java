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
import javax.swing.JSpinner;
import javax.swing.JTextField;

import com.entities.ANALISTA;
import com.entities.ESTUDIANTE;
import com.entities.USUARIO;
import com.enums.Departamento;
import com.enums.EstadoUsuario;
import com.enums.Localidad;
import com.exception.ServiciosException;
import com.services.AnalistaBeanRemote;
import com.services.EstudianteBeanRemote;
import com.services.TutorBeanRemote;
import com.services.UsuarioBeanRemote;
import com.toedter.calendar.JDateChooser;

public class ModPropiaEstudiante {

	private JFrame frmModificacionDeUsuario;
	private JTextField tfTelefono;
	private JTextField tfEmail;
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfDocumento;
	private JTextField tfGeneracion;

	/**
	 * Create the application.
	 */
	public ModPropiaEstudiante(USUARIO usuario) throws NamingException{
		initialize(usuario);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws NamingException 
	 */
	private void initialize(USUARIO usuario) throws NamingException {
		frmModificacionDeUsuario = new JFrame();
		frmModificacionDeUsuario.setTitle("Modificacion de Estudiante");
		frmModificacionDeUsuario.setResizable(false);
		frmModificacionDeUsuario.setIconImage(Toolkit.getDefaultToolkit().getImage("Z:\\ONE DRIVE\\OneDrive\\Escritorio\\PNG\\logoUtec.png"));
		frmModificacionDeUsuario.getContentPane().setBackground(Color.WHITE);
		frmModificacionDeUsuario.getContentPane().setLayout(null);
		frmModificacionDeUsuario.setLocationRelativeTo(null);
		
		JLabel lblNewLabel_2 = new JLabel("MODIFICACI\u00D3N DE ESTUDIANTE");
		lblNewLabel_2.setBounds(10, 11, 414, 34);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("SimSun", Font.BOLD, 16));
		frmModificacionDeUsuario.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Tel\u00E9fono");
		lblNewLabel_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 101, 64, 14);
		frmModificacionDeUsuario.getContentPane().add(lblNewLabel_1);
		
		tfTelefono = new JTextField();
		tfTelefono.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfTelefono.setColumns(10);
		tfTelefono.setBounds(10, 125, 131, 20);
		frmModificacionDeUsuario.getContentPane().add(tfTelefono);
		
		JLabel lblCorreo = new JLabel("Email");
		lblCorreo.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblCorreo.setBounds(10, 154, 64, 14);
		frmModificacionDeUsuario.getContentPane().add(lblCorreo);
		
		tfEmail = new JTextField();
		tfEmail.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfEmail.setColumns(10);
		tfEmail.setBounds(10, 177, 131, 20);
		frmModificacionDeUsuario.getContentPane().add(tfEmail);
		
		JLabel lblNewLabel_1_2 = new JLabel("Localidad");
		lblNewLabel_1_2.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(151, 155, 64, 14);
		frmModificacionDeUsuario.getContentPane().add(lblNewLabel_1_2);
		
		JComboBox<Localidad> comboBoxLocal = new javax.swing.JComboBox<>();
		comboBoxLocal.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxLocal.setBounds(151, 175, 131, 22);
		comboBoxLocal.setModel(new DefaultComboBoxModel(Localidad.values()));
		frmModificacionDeUsuario.getContentPane().add(comboBoxLocal);
		
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Departamento");
		lblNewLabel_1_2_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_2_1.setBounds(151, 100, 91, 14);
		frmModificacionDeUsuario.getContentPane().add(lblNewLabel_1_2_1);
		
		JComboBox<Departamento> comboBoxDep = new javax.swing.JComboBox<>();
		comboBoxDep.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxDep.setBounds(151, 124, 131, 22);
		comboBoxDep.setModel(new DefaultComboBoxModel(Departamento.values()));
		frmModificacionDeUsuario.getContentPane().add(comboBoxDep);
		
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("ITR");
		lblNewLabel_1_2_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_2_1_1_1.setBounds(10, 208, 42, 14);
		frmModificacionDeUsuario.getContentPane().add(lblNewLabel_1_2_1_1_1);
		
		JComboBox<String> comboBoxItr = new JComboBox<>();
		comboBoxItr.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxItr.setBounds(10, 230, 131, 22);
		comboBoxItr.addItem(usuario.getItr().name());
		frmModificacionDeUsuario.getContentPane().add(comboBoxItr);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("SimSun", Font.BOLD, 14));
		btnGuardar.setBounds(220, 307, 97, 23);
		frmModificacionDeUsuario.getContentPane().add(btnGuardar);
		
		JButton btnCancelar = new JButton("Volver");
		btnCancelar.setFont(new Font("SimSun", Font.BOLD, 13));
		btnCancelar.setBounds(327, 307, 97, 23);
		frmModificacionDeUsuario.getContentPane().add(btnCancelar);
		frmModificacionDeUsuario.setBounds(100, 100, 450, 380);
		frmModificacionDeUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tfNombre = new JTextField();
		tfNombre.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfNombre.setColumns(10);
		tfNombre.setBounds(10, 70, 131, 20);
		frmModificacionDeUsuario.getContentPane().add(tfNombre);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre");
		lblNewLabel_1_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(10, 46, 64, 14);
		frmModificacionDeUsuario.getContentPane().add(lblNewLabel_1_1);
		
		tfApellido = new JTextField();
		tfApellido.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfApellido.setColumns(10);
		tfApellido.setBounds(151, 69, 131, 20);
		frmModificacionDeUsuario.getContentPane().add(tfApellido);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblApellido.setBounds(151, 45, 64, 14);
		frmModificacionDeUsuario.getContentPane().add(lblApellido);
		
		tfDocumento = new JTextField();
		tfDocumento.setText((String) null);
		tfDocumento.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfDocumento.setColumns(10);
		tfDocumento.setBounds(293, 70, 131, 20);
		frmModificacionDeUsuario.getContentPane().add(tfDocumento);
		
		JLabel lblDocumento = new JLabel("Documento");
		lblDocumento.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblDocumento.setBounds(293, 46, 64, 14);
		frmModificacionDeUsuario.getContentPane().add(lblDocumento);
		
		tfGeneracion = new JTextField();
		tfGeneracion.setText((String) null);
		tfGeneracion.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfGeneracion.setColumns(10);
		tfGeneracion.setBounds(292, 175, 52, 22);
		frmModificacionDeUsuario.getContentPane().add(tfGeneracion);
		
		JLabel lblGen = new JLabel("Gen");
		lblGen.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblGen.setBounds(294, 153, 52, 14);
		frmModificacionDeUsuario.getContentPane().add(lblGen);
		ESTUDIANTE estudiante = (ESTUDIANTE) usuario;
		JSpinner tfSemestre = new JSpinner();
		tfSemestre.setBounds(354, 177, 70, 20);
		frmModificacionDeUsuario.getContentPane().add(tfSemestre);
		JLabel lblSemestre = new JLabel("Semestre");
		lblSemestre.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblSemestre.setBounds(356, 154, 68, 14);
		frmModificacionDeUsuario.getContentPane().add(lblSemestre);
		tfNombre.setText(estudiante.getNombre());
		tfApellido.setText(estudiante.getApellido());
		tfTelefono.setText(estudiante.getTelefono());
		tfEmail.setText(estudiante.getMail());
		tfGeneracion.setText(estudiante.getGeneracion());
		tfDocumento.setText(Integer.toString(estudiante.getDocumento()));
		comboBoxDep.setSelectedIndex(estudiante.getDepartamento().ordinal());
		
		JComboBox comboBoxEstado = new JComboBox();
		comboBoxEstado.setBounds(151, 230, 131, 22);
		comboBoxEstado.setModel(new DefaultComboBoxModel(EstadoUsuario.values()));
		comboBoxEstado.setSelectedIndex(usuario.getEstado().ordinal());
		frmModificacionDeUsuario.getContentPane().add(comboBoxEstado);
		
		JLabel lblNewLabel_1_2_1_1_2 = new JLabel("Estado");
		lblNewLabel_1_2_1_1_2.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_2_1_1_2.setBounds(151, 208, 52, 14);
		frmModificacionDeUsuario.getContentPane().add(lblNewLabel_1_2_1_1_2);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
		lblFechaDeNacimiento.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblFechaDeNacimiento.setBounds(292, 101, 132, 14);
		frmModificacionDeUsuario.getContentPane().add(lblFechaDeNacimiento);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(292, 125, 132, 20);
		Calendar today = Calendar.getInstance();
		today.clear(Calendar.HOUR); today.clear(Calendar.MINUTE); today.clear(Calendar.SECOND);
		Date todayDate = today.getTime();
		dateChooser.setMaxSelectableDate(todayDate);
		
		//Cargar en dateChoser la fecha del usuario, recibe como argumento tipo fecha DATE
		//convierte la fecha desde LocalDate a Date
		ZoneId defaultZoneId = ZoneId.systemDefault();
		dateChooser.setDate(Date.from(usuario.getFechaNac().atStartOfDay(defaultZoneId).toInstant()));
		frmModificacionDeUsuario.getContentPane().add(dateChooser);
		
		JButton btnVerSolicitudes = new JButton("Solicitudes");
		btnVerSolicitudes.setFont(new Font("SimSun", Font.BOLD, 14));
		btnVerSolicitudes.setBounds(90, 307, 120, 23);
		frmModificacionDeUsuario.getContentPane().add(btnVerSolicitudes);
		
		//Logica
		
        EstudianteBeanRemote estudianteBean = (EstudianteBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/EstudianteBean!com.services.EstudianteBeanRemote");
		
		TutorBeanRemote tutorBean = (TutorBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/TutorBean!com.services.TutorBeanRemote");
		
		AnalistaBeanRemote analistaBean = (AnalistaBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/AnalistaBean!com.services.AnalistaBeanRemote");
		
		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/UsuarioBean!com.services.UsuarioBeanRemote");
		
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				estudiante.setApellido(tfApellido.getText());
				estudiante.setNombre(tfNombre.getText());
				estudiante.setDocumento(Integer.parseInt(tfDocumento.getText()));
				estudiante.setMail(tfEmail.getText());
				estudiante.setTelefono(tfTelefono.getText());
				estudiante.setDepartamento(Departamento.valueOf(comboBoxDep.getSelectedItem().toString()));
				estudiante.setLocalidad(null);
				estudiante.setGeneracion(tfGeneracion.getText());
				estudiante.setEstado(EstadoUsuario.valueOf(comboBoxEstado.getSelectedItem().toString()));
				estudiante.setFechaNac(dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
				
				try {
					estudianteBean.editEstudiante(estudiante);
					JOptionPane.showMessageDialog(null, "Estudiante modificado con exito");
				} catch (ServiciosException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ppal_Estudiante list = new Ppal_Estudiante(estudiante);
				list.setVisible(true);
				list.setLocationRelativeTo(null);
				getFrame().dispose();
			}
		});
		
		btnVerSolicitudes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Listar_SConstancias listSW = new Listar_SConstancias(estudiante, usuario, 0);
					listSW.setVisible(true);
					getFrame().dispose();
				} catch (NamingException e1) {
					e1.printStackTrace();
				} catch (ServiciosException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
	
	JFrame getFrame() {
		return this.frmModificacionDeUsuario;
	}
}