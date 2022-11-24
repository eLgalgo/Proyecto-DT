package com.gui;

import java.awt.EventQueue;
import java.awt.event.*;
import java.time.Instant;
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

import com.entities.ANALISTA;
import com.entities.ESTUDIANTE;
import com.entities.EVENTO;
import com.entities.SOLICITUD;
import com.entities.TUTOR;
import com.entities.USUARIO;
import com.enums.Departamento;
import com.enums.EstadoSolicitud;
import com.enums.EstadoUsuario;
import com.enums.TipoConstancia;
import com.exception.ServiciosException;
import com.services.AnalistaBeanRemote;
import com.services.EstudianteBeanRemote;
import com.services.EventoBeanRemote;
import com.services.SolicitudBeanRemote;
import com.services.TutorBeanRemote;
import com.services.UsuarioBeanRemote;

import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class Listar_SConstanciasAnalista extends JFrame implements ActionListener {
	private JTable tabla;
	private DefaultTableModel modelo;

	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
	}

	public Listar_SConstanciasAnalista(ANALISTA usuario) throws NamingException, ServiciosException {
		super("Administración Secretaría");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Listar_SConstanciasAnalista.class.getResource("/PNG/logoUtec.png")));
		setResizable(false);
		setBackground(Color.WHITE);
		getContentPane().setBackground(SystemColor.control);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(550, 395);
		setLocationRelativeTo(null);
		setVisible(true);
		getContentPane().setLayout(null);

		JButton btnCancelar = new JButton("Volver");
		btnCancelar.setBounds(10, 322, 97, 23);
		btnCancelar.setFont(new Font("SimSun", Font.BOLD, 13));
		getContentPane().add(btnCancelar);

		JButton btnSolicitar = new JButton("Emitir");
		btnSolicitar.setBounds(408, 322, 113, 23);
		btnSolicitar.setFont(new Font("SimSun", Font.BOLD, 14));
		getContentPane().add(btnSolicitar);

		JLabel lblNewLabel_2 = new JLabel("Solicitudes");
		lblNewLabel_2.setBounds(10, 23, 448, 34);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("SimSun", Font.BOLD, 16));
		getContentPane().add(lblNewLabel_2);
		setTitle("Solicitudes de Constancia");

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

		// Tabla
		crearTablaPersona();
		// Agregamos datos
		agregarDatosLista(modelo);

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ppal_Analista pAnalistaW = null;
				try {
					pAnalistaW = new Ppal_Analista(usuario);
				} catch (NamingException e1) {
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
				try {
					if (tabla.getSelectedRow() != -1) {
						SOLICITUD sol = solicitudBean
								.findSol(Integer.parseInt(tabla.getValueAt(tabla.getSelectedRow(), 0).toString()))
								.get(0);
						if (sol.getEstado() == EstadoSolicitud.EMITIDA) {
							JOptionPane.showMessageDialog(null, "¡Error! constancia ya emitida");
						} else {
							sol.setAnalist(usuario);
							solicitudBean.emitirSolicitud(sol);
							try {
								agregarDatosLista(modelo);
							} catch (NamingException e1) {
								e1.printStackTrace();
							}
							JOptionPane.showMessageDialog(null, "Constancia emitida con exito");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Seleccione la constacia que desea emitir");
					}
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
	}

	private void crearTablaPersona() {
		String[] columnas = { "ID", "Tipo", "Fecha", "Evento", "Estudiante", "Analista", "Estado" };
		tabla = new JTable();
		modelo = new DefaultTableModel() {
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return false;
			}
		};

		JButton btnNewButton_2 = new JButton("Modificar");
		btnNewButton_2.setBounds(411, 300, 110, 25);
		btnNewButton_2.setFont(new Font("SimSun", Font.BOLD, 13));
		JScrollPane desplazamiento = new JScrollPane(tabla);
		desplazamiento.setBounds(10, 68, 511, 234);
		desplazamiento.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		desplazamiento.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		// Modelo de la tabla
		modelo.setColumnIdentifiers(columnas);

		tabla.setModel(modelo);
		getContentPane().add(desplazamiento);
	}

	private void agregarDatosLista(DefaultTableModel modelo) throws NamingException {
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

		// Borramos todas las filas en la tabla
		modelo.setRowCount(0);

		// Creamos los datos de una fila de la tabla
		Object[] datosFila = { "", "", "", "", "", "", "" };
		List<SOLICITUD> list = null;
		try {
			list = solicitudBean.listAll();
		} catch (ServiciosException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Agregamos MUCHOS mas datos
		for (SOLICITUD p : list) {
			datosFila[0] = p.getId_solicitud();
			datosFila[1] = p.getTipo();
			datosFila[2] = p.getFecha();
			datosFila[3] = p.getEventoAsis().getTitulo();
			datosFila[4] = p.getEstSol().getDocumento();
			if (p.getAnalist() == null) {
				datosFila[5] = "N/T";
			} else {
				datosFila[5] = p.getAnalist().getNombre();
			}
			datosFila[6] = p.getEstado();

			modelo.addRow(datosFila);
		}
		tabla.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evnt) {
				if (evnt.getClickCount() == 2) {
					try {
						System.out.println("Existo");
					} catch (NumberFormatException e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
}