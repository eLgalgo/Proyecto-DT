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
import com.entities.SOLICITUD;
import com.entities.TIPOCONSTANCIA;
import com.entities.TUTOR;
import com.entities.USUARIO;
import com.enums.Departamento;
import com.enums.EstadoSolicitud;
import com.enums.EstadoUsuario;
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

public class Listar_SConstanciasAnalista extends JFrame implements ActionListener {
	private JTable tabla;
	private DefaultTableModel modelo;

	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
	}

	public Listar_SConstanciasAnalista(ANALISTA usuario) throws NamingException, ServiciosException {
		super("Administración Secretaría");
		setResizable(false);
		setBackground(Color.WHITE);
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(704, 365);
		setLocationRelativeTo(null);
		setVisible(true);
		getContentPane().setLayout(null);

		JButton btnCancelar = new JButton("Volver");
		btnCancelar.setBounds(10, 293, 97, 23);
		btnCancelar.setFont(new Font("SimSun", Font.BOLD, 13));
		getContentPane().add(btnCancelar);

		JButton btnSolicitar = new JButton("Cambiar Estado");
		btnSolicitar.setBounds(352, 293, 158, 23);
		btnSolicitar.setFont(new Font("SimSun", Font.BOLD, 14));
		getContentPane().add(btnSolicitar);

		JLabel lblNewLabel_2 = new JLabel("Solicitudes");
		lblNewLabel_2.setBounds(10, 11, 448, 34);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("SimSun", Font.BOLD, 16));
		getContentPane().add(lblNewLabel_2);
		setTitle("Solicitudes de Constancia");

		JButton btnRegistrarAccion = new JButton("Registrar Accion");
		btnRegistrarAccion.setFont(new Font("SimSun", Font.BOLD, 14));
		btnRegistrarAccion.setBounds(184, 293, 158, 23);
		getContentPane().add(btnRegistrarAccion);
		
		JButton btnEmitir = new JButton("Emitir");
		btnEmitir.setFont(new Font("SimSun", Font.BOLD, 14));
		btnEmitir.setBounds(520, 293, 158, 23);
		getContentPane().add(btnEmitir);
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
		btnEmitir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TIPOCONSTANCIA tipo = modeloBean.findTipo(tabla.getValueAt(tabla.getSelectedRow(), 1).toString()).get(0);
				} catch (ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSolicitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (tabla.getSelectedRow() != -1) {
						SOLICITUD sol = solicitudBean
								.findSol(Integer.parseInt(tabla.getValueAt(tabla.getSelectedRow(), 0).toString()))
								.get(0);
						if (sol.getEstado() == EstadoSolicitud.FINALIZADO) {
							JOptionPane.showMessageDialog(null, "¡Error! constancia ya finalizada");
						} else if(sol.getEstado() == EstadoSolicitud.EN_PROCESO){
							sol.setAnalist(usuario);
							solicitudBean.cambiarEstado(sol, EstadoSolicitud.EN_PROCESO);
							try {
								agregarDatosLista(modelo);
							} catch (NamingException e1) {
								e1.printStackTrace();
							}
							
							ACCION acc = new ACCION();
							acc.setAnalista(usuario);
							acc.setFecha(LocalDate.now());
							acc.setDetalle("Cambio a Solicitud Finalizada");
							acc.setSolicitud(sol);
							
							accionBean.addAccion(acc);
							JOptionPane.showMessageDialog(null, "Estado cambiado con exito");
						} else if(sol.getEstado() == EstadoSolicitud.INGRESADO) {
							sol.setAnalist(usuario);
							solicitudBean.cambiarEstado(sol, EstadoSolicitud.INGRESADO);
							try {
								agregarDatosLista(modelo);
							} catch (NamingException e1) {
								e1.printStackTrace();
							}
							
							ACCION acc = new ACCION();
							acc.setAnalista(usuario);
							acc.setFecha(LocalDate.now());
							acc.setDetalle("Cambio a Solicitud En Proceso");
							acc.setSolicitud(sol);
							
							accionBean.addAccion(acc);
							JOptionPane.showMessageDialog(null, "Estado cambiado con exito");
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
		
		btnRegistrarAccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tabla.getSelectedRow() != -1) {
					String detalle = JOptionPane.showInputDialog("Aclare detalle de accion");
					if(detalle.equals("")) {
						JOptionPane.showMessageDialog(null, "Debe ingresar detalle de accion");
					}else {
							ACCION acc = new ACCION();
							acc.setAnalista(usuario);
							acc.setDetalle(detalle);
							acc.setFecha(LocalDate.now());
							SOLICITUD sol = null;
							try {
								sol = solicitudBean
										.findSol(Integer.parseInt(tabla.getValueAt(tabla.getSelectedRow(), 0).toString()))
										.get(0);
							} catch (NumberFormatException | ServiciosException e2) {
								e2.printStackTrace();
							}
							acc.setSolicitud(sol);
							try {
								accionBean.addAccion(acc);
								JOptionPane.showMessageDialog(null, "Accion registrada con exito");
							} catch (ServiciosException e1) {
								e1.printStackTrace();
							}
					}
				}else {
					JOptionPane.showMessageDialog(null, "Debe seleccionar una solicitud");
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
		desplazamiento.setBounds(10, 48, 668, 234);
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
			datosFila[1] = p.getTipo().getTipo();
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