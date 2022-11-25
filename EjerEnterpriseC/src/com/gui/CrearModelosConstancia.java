package com.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.entities.ANALISTA;
import com.entities.TIPOCONSTANCIA;
import com.exception.ServiciosException;
import com.services.AccionBeanRemote;
import com.services.AnalistaBeanRemote;
import com.services.EstudianteBeanRemote;
import com.services.EventoBeanRemote;
import com.services.ModeloBeanRemote;
import com.services.SolicitudBeanRemote;
import com.services.TutorBeanRemote;
import com.services.UsuarioBeanRemote;

public class CrearModelosConstancia extends JFrame implements ActionListener {
	private DefaultTableModel modelo;
	private JTextField textField;

	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
	}

	public CrearModelosConstancia(ANALISTA usuario) throws NamingException, ServiciosException {
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

		JButton btnSolicitar = new JButton("Grabar");
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
		
		JLabel lblNewLabel_2_1 = new JLabel("Header");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(SystemColor.window);
		lblNewLabel_2_1.setFont(new Font("SimSun", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(10, 155, 514, 44);
		getContentPane().add(lblNewLabel_2_1);
		
		textField = new JTextField();
		textField.setBounds(190, 100, 158, 28);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2_2 = new JLabel("Tipo de Constancia");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setForeground(SystemColor.window);
		lblNewLabel_2_2.setFont(new Font("SimSun", Font.BOLD, 17));
		lblNewLabel_2_2.setBounds(10, 68, 514, 34);
		getContentPane().add(lblNewLabel_2_2);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("SimSun", Font.BOLD, 14));
		btnBuscar.setBounds(190, 131, 158, 23);
		getContentPane().add(btnBuscar);
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
		
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					List<TIPOCONSTANCIA> tipo = modeloBean.findTipo(textField.getText());
					if(tipo.isEmpty()) {
						JOptionPane.showMessageDialog(null, "No se encuentra");
					}else {
						textArea.setText(tipo.get(0).getModelo());
					}
				} catch (ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
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
				List<TIPOCONSTANCIA> tipo = null;
				try {
					tipo = modeloBean.findTipo(textField.getText());
				} catch (ServiciosException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				if(tipo.isEmpty()) {
					TIPOCONSTANCIA tipo2 = new TIPOCONSTANCIA();
					
					tipo2.setEstado(true);
					tipo2.setModelo(textArea.getText());
					tipo2.setTipo(textField.getText());
					
					try {
						modeloBean.addMoldeo(tipo2);
						JOptionPane.showMessageDialog(null, "Agregado con exito");
					} catch (ServiciosException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					tipo.get(0).setModelo(textArea.getText());
					tipo.get(0).setTipo(textField.getText());
					
					try {
						modeloBean.editModelo(tipo.get(0));
						JOptionPane.showMessageDialog(null, "Actualizado con exito");
					} catch (ServiciosException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
	}
}