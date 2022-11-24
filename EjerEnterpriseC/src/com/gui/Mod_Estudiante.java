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
import com.enums.Departamento;
import com.enums.EstadoUsuario;
import com.enums.Localidad;
import com.exception.ServiciosException;
import com.services.AnalistaBeanRemote;
import com.services.EstudianteBeanRemote;
import com.services.TutorBeanRemote;
import com.services.UsuarioBeanRemote;
import com.toedter.calendar.JDateChooser;
import java.awt.SystemColor;

public class Mod_Estudiante {

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
	public Mod_Estudiante(ESTUDIANTE usuario, ANALISTA analista) throws NamingException{
		initialize(usuario, analista);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws NamingException 
	 */
	private void initialize(ESTUDIANTE usuario, ANALISTA analista) throws NamingException {
		frmModificacionDeUsuario = new JFrame();
		frmModificacionDeUsuario.setTitle("Modificacion de Estudiante");
		frmModificacionDeUsuario.setResizable(false);
		frmModificacionDeUsuario.setIconImage(Toolkit.getDefaultToolkit().getImage("Z:\\ONE DRIVE\\OneDrive\\Escritorio\\PNG\\logoUtec.png"));
		frmModificacionDeUsuario.getContentPane().setBackground(SystemColor.control);
		frmModificacionDeUsuario.getContentPane().setLayout(null);
		frmModificacionDeUsuario.setLocationRelativeTo(null);
		
		JLabel lblNewLabel_2 = new JLabel("MODIFICACI\u00D3N DE ESTUDIANTE");
		lblNewLabel_2.setBounds(11, 22, 414, 34);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("SimSun", Font.BOLD, 16));
		frmModificacionDeUsuario.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Tel\u00E9fono");
		lblNewLabel_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 131, 64, 14);
		frmModificacionDeUsuario.getContentPane().add(lblNewLabel_1);
		
		tfTelefono = new JTextField();
		tfTelefono.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfTelefono.setColumns(10);
		tfTelefono.setBounds(10, 156, 131, 20);
		frmModificacionDeUsuario.getContentPane().add(tfTelefono);
		
		JLabel lblCorreo = new JLabel("Email");
		lblCorreo.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblCorreo.setBounds(10, 187, 64, 14);
		frmModificacionDeUsuario.getContentPane().add(lblCorreo);
		
		tfEmail = new JTextField();
		tfEmail.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfEmail.setColumns(10);
		tfEmail.setBounds(10, 212, 131, 20);
		frmModificacionDeUsuario.getContentPane().add(tfEmail);
		
		JLabel lblNewLabel_1_2 = new JLabel("Localidad");
		lblNewLabel_1_2.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(151, 186, 64, 14);
		frmModificacionDeUsuario.getContentPane().add(lblNewLabel_1_2);
		
		JComboBox<Localidad> comboBoxLocal = new javax.swing.JComboBox<>();
		comboBoxLocal.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxLocal.setBounds(151, 211, 131, 22);
		comboBoxLocal.setModel(new DefaultComboBoxModel(Localidad.values()));
		frmModificacionDeUsuario.getContentPane().add(comboBoxLocal);
		
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Departamento");
		lblNewLabel_1_2_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_2_1.setBounds(153, 130, 91, 14);
		frmModificacionDeUsuario.getContentPane().add(lblNewLabel_1_2_1);
		
		JComboBox<Departamento> comboBoxDep = new javax.swing.JComboBox<>();
		comboBoxDep.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxDep.setBounds(151, 155, 131, 22);
		comboBoxDep.setModel(new DefaultComboBoxModel(Departamento.values()));
		frmModificacionDeUsuario.getContentPane().add(comboBoxDep);
		
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("ITR");
		lblNewLabel_1_2_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_2_1_1_1.setBounds(10, 244, 42, 14);
		frmModificacionDeUsuario.getContentPane().add(lblNewLabel_1_2_1_1_1);
		
		JComboBox<String> comboBoxItr = new JComboBox<>();
		comboBoxItr.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxItr.setBounds(10, 269, 131, 22);
		comboBoxItr.addItem(usuario.getItr().toString());
		frmModificacionDeUsuario.getContentPane().add(comboBoxItr);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("SimSun", Font.BOLD, 14));
		btnGuardar.setBounds(221, 344, 97, 23);
		frmModificacionDeUsuario.getContentPane().add(btnGuardar);
		
		JButton btnCancelar = new JButton("Volver");
		btnCancelar.setFont(new Font("SimSun", Font.BOLD, 13));
		btnCancelar.setBounds(328, 344, 97, 23);
		frmModificacionDeUsuario.getContentPane().add(btnCancelar);
		frmModificacionDeUsuario.setBounds(100, 100, 451, 417);
		frmModificacionDeUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tfNombre = new JTextField();
		tfNombre.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfNombre.setColumns(10);
		tfNombre.setBounds(10, 100, 131, 20);
		frmModificacionDeUsuario.getContentPane().add(tfNombre);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre");
		lblNewLabel_1_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(10, 75, 64, 14);
		frmModificacionDeUsuario.getContentPane().add(lblNewLabel_1_1);
		
		tfApellido = new JTextField();
		tfApellido.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfApellido.setColumns(10);
		tfApellido.setBounds(151, 99, 131, 20);
		frmModificacionDeUsuario.getContentPane().add(tfApellido);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblApellido.setBounds(151, 75, 64, 14);
		frmModificacionDeUsuario.getContentPane().add(lblApellido);
		
		tfDocumento = new JTextField();
		tfDocumento.setText((String) null);
		tfDocumento.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfDocumento.setColumns(10);
		tfDocumento.setBounds(293, 100, 131, 20);
		frmModificacionDeUsuario.getContentPane().add(tfDocumento);
		
		JLabel lblDocumento = new JLabel("Documento");
		lblDocumento.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblDocumento.setBounds(293, 75, 64, 14);
		frmModificacionDeUsuario.getContentPane().add(lblDocumento);
		
		tfGeneracion = new JTextField();
		tfGeneracion.setText((String) null);
		tfGeneracion.setFont(new Font("SimSun", Font.PLAIN, 13));
		tfGeneracion.setColumns(10);
		tfGeneracion.setBounds(292, 211, 132, 22);
		frmModificacionDeUsuario.getContentPane().add(tfGeneracion);
		
		JLabel lblGen = new JLabel("Generaci\u00F3n");
		lblGen.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblGen.setBounds(293, 186, 91, 14);
		frmModificacionDeUsuario.getContentPane().add(lblGen);
		
		JSpinner tfSemestre = new JSpinner();
		tfSemestre.setBounds(293, 270, 133, 20);
		frmModificacionDeUsuario.getContentPane().add(tfSemestre);
		
		JLabel lblSemestre = new JLabel("Semestre");
		lblSemestre.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblSemestre.setBounds(293, 244, 68, 14);
		frmModificacionDeUsuario.getContentPane().add(lblSemestre);
		tfNombre.setText(usuario.getNombre());
		tfApellido.setText(usuario.getApellido());
		tfTelefono.setText(usuario.getTelefono());
		tfEmail.setText(usuario.getMail());
		tfGeneracion.setText(usuario.getGeneracion());
		tfDocumento.setText(Integer.toString(usuario.getDocumento()));
		comboBoxDep.setSelectedIndex(usuario.getDepartamento().ordinal());
		
		JComboBox comboBoxEstado = new JComboBox();
		comboBoxEstado.setBounds(151, 269, 131, 22);
		comboBoxEstado.setModel(new DefaultComboBoxModel(EstadoUsuario.values()));
		comboBoxEstado.setSelectedIndex(usuario.getEstado().ordinal());
		frmModificacionDeUsuario.getContentPane().add(comboBoxEstado);
		
		JLabel lblNewLabel_1_2_1_1_2 = new JLabel("Estado");
		lblNewLabel_1_2_1_1_2.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_2_1_1_2.setBounds(151, 244, 52, 14);
		frmModificacionDeUsuario.getContentPane().add(lblNewLabel_1_2_1_1_2);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
		lblFechaDeNacimiento.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblFechaDeNacimiento.setBounds(293, 131, 143, 14);
		frmModificacionDeUsuario.getContentPane().add(lblFechaDeNacimiento);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(292, 156, 132, 20);
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
		btnVerSolicitudes.setBounds(90, 344, 120, 23);
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
				
				usuario.setApellido(tfApellido.getText());
				usuario.setNombre(tfNombre.getText());
				usuario.setDocumento(Integer.parseInt(tfDocumento.getText()));
				usuario.setMail(tfEmail.getText());
				usuario.setTelefono(tfTelefono.getText());
				usuario.setDepartamento(Departamento.valueOf(comboBoxDep.getSelectedItem().toString()));
				usuario.setLocalidad(null);
				usuario.setGeneracion(tfGeneracion.getText());
				usuario.setEstado(EstadoUsuario.valueOf(comboBoxEstado.getSelectedItem().toString()));
				usuario.setFechaNac(dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
				
				try {
					estudianteBean.editEstudiante((ESTUDIANTE) usuario);
					JOptionPane.showMessageDialog(null, "Estudiante modificado con exito");
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
		
		btnVerSolicitudes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Listar_SConstancias listSW = new Listar_SConstancias(usuario, analista, 1);
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
