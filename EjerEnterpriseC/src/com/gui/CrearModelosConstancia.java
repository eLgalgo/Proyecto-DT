package com.gui;

import java.awt.EventQueue;
import java.awt.event.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.*;
import java.awt.Font;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Label;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.entities.ACCION;
import com.entities.ANALISTA;
import com.entities.ESTUDIANTE;
import com.entities.EVENTO;
import com.entities.MODELOCONSTANCIA;
import com.entities.SOLICITUD;
import com.entities.TUTOR;
import com.entities.USUARIO;
import com.enums.Departamento;
import com.enums.EstadoSolicitud;
import com.enums.EstadoUsuario;
import com.enums.TipoConstancia;
import com.exception.ServiciosException;
import com.services.AccionBeanRemote;
import com.services.AnalistaBeanRemote;
import com.services.EstudianteBeanRemote;
import com.services.EventoBeanRemote;
import com.services.ModeloBeanRemote;
import com.services.SolicitudBeanRemote;
import com.services.TutorBeanRemote;
import com.services.UsuarioBeanRemote;

import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;

public class CrearModelosConstancia extends JFrame implements ActionListener {
	private DefaultTableModel modelo;
	private JTextField textField;

	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
	}

	public CrearModelosConstancia(ANALISTA usuario, MODELOCONSTANCIA modelo) throws NamingException, ServiciosException {
		super("Administración Secretaría");
		setResizable(false);
		setBackground(Color.WHITE);
		getContentPane().setBackground(SystemColor.activeCaption);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(550, 471);
		setLocationRelativeTo(null);
		setVisible(true);
		getContentPane().setLayout(null);

		JButton btnCancelar = new JButton("Volver");
		btnCancelar.setBounds(10, 398, 97, 23);
		btnCancelar.setFont(new Font("SimSun", Font.BOLD, 13));
		getContentPane().add(btnCancelar);

		JButton btnSolicitar = new JButton("Modificar Modelo");
		btnSolicitar.setBounds(366, 398, 158, 23);
		btnSolicitar.setFont(new Font("SimSun", Font.BOLD, 14));
		getContentPane().add(btnSolicitar);

		JLabel lblNewLabel_2 = new JLabel("Crear Modelo");
		lblNewLabel_2.setBounds(10, 11, 448, 34);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("SimSun", Font.BOLD, 20));
		getContentPane().add(lblNewLabel_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 19));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setBackground(Color.WHITE);
		textArea.setBounds(10, 192, 514, 133);
		getContentPane().add(textArea);
		textArea.setText(modelo.getModelo());
		
		JLabel lblNewLabel_2_1 = new JLabel("Header");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(SystemColor.window);
		lblNewLabel_2_1.setFont(new Font("SimSun", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(10, 137, 514, 44);
		getContentPane().add(lblNewLabel_2_1);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(190, 100, 158, 28);
		getContentPane().add(textField);
		textField.setColumns(10);
		textField.setText(modelo.getTipo().toString());
		
		JLabel lblNewLabel_2_2 = new JLabel("Tipo de Constancia");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setForeground(SystemColor.window);
		lblNewLabel_2_2.setFont(new Font("SimSun", Font.BOLD, 17));
		lblNewLabel_2_2.setBounds(10, 68, 514, 34);
		getContentPane().add(lblNewLabel_2_2);
		setTitle("Modelos de Plantillas");
		
		// Logica botones

		EstudianteBeanRemote estudianteBean = (EstudianteBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/EstudianteBean!com.services.EstudianteBeanRemote");

		TutorBeanRemote tutorBean = (TutorBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/TutorBean!com.services.TutorBeanRemote");

		AnalistaBeanRemote analistaBean = (AnalistaBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/AnalistaBean!com.services.AnalistaBeanRemote");

		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/UsuarioBean!com.services.UsuarioBeanRemote");

		EventoBeanRemote eventoBean = (EventoBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/EventoBean!com.services.EventoBeanRemote");

		SolicitudBeanRemote solicitudBean = (SolicitudBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/SolicitudBean!com.services.SolicitudBeanRemote");

		AccionBeanRemote accionBean = (AccionBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/AccionBean!com.services.AccionBeanRemote");
		
		ModeloBeanRemote modeloBean = (ModeloBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/ModeloBean!com.services.ModeloBeanRemote");
		
		

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarTiposDeConstancia pAnalistaW = null;
				try {
					pAnalistaW = new ListarTiposDeConstancia(usuario);
					pAnalistaW.setVisible(true);
					dispose();
				} catch (NamingException | ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pAnalistaW.setVisible(true);
				pAnalistaW.setLocationRelativeTo(null);
				dispose();
			}
		});

		btnSolicitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MODELOCONSTANCIA m = null;
				try {
					m = modeloBean.findSol(modelo.getId_modelo()).get(0);
				} catch (ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				m.setModelo(textArea.getText());
				m.setTipo(modelo.getTipo());
				
				try {
					modeloBean.editModelo(m);
				} catch (ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
	}
}