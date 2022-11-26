package com.gui;

import java.awt.EventQueue;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
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

import com.entities.ACCIONANALISTACONSTANCIA;
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
import com.enums.TipoUser;
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
		
		
		JComboBox comboBoxEstado = new JComboBox();
		comboBoxEstado.setBounds(552, 18, 126, 28);
		comboBoxEstado.setModel(new DefaultComboBoxModel(EstadoSolicitud.values()));
		comboBoxEstado.setSelectedIndex(3);
		getContentPane().add(comboBoxEstado);
		
		final ItemListener changeClick = new ItemListener()
	    {
	        public void itemStateChanged(ItemEvent e) 
	        {
	            if(comboBoxEstado.getSelectedItem().equals(e.getItem()))
	            {
	            	try {
						agregarDatosListaEstado(EstadoSolicitud.valueOf(comboBoxEstado.getSelectedItem().toString()));
					} catch (NamingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            }
	        }
	    };
	    
	    comboBoxEstado.addItemListener(changeClick);
		
		
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
				if (tabla.getSelectedRow() != -1) {
					try {
						SOLICITUD sol = solicitudBean
								.findSol(Integer.parseInt(tabla.getValueAt(tabla.getSelectedRow(), 0).toString()))
								.get(0);
						if (sol.getEstado() == EstadoSolicitud.FINALIZADO) {
							JOptionPane.showMessageDialog(null, "¡Error! constancia ya finalizada");
						} else {
							EmitirConstancia emitirW = new EmitirConstancia(usuario, sol);
							emitirW.setVisible(true);
							dispose();
						}
					} catch (ServiciosException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NamingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null, "Debe seleccionar una constancia para emitir");
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
			
						if(sol.getEstado() == EstadoSolicitud.INGRESADO) {
							sol.setAnalist(usuario);
							solicitudBean.cambiarEstado(sol, EstadoSolicitud.INGRESADO);
							try {
								agregarDatosLista(modelo);
							} catch (NamingException e1) {
								e1.printStackTrace();
							}
							
							ACCIONANALISTACONSTANCIA acc = new ACCIONANALISTACONSTANCIA();
							acc.setAnalista(usuario);
							acc.setFecha(LocalDate.now());
							acc.setDetalle("Cambio a Solicitud En Proceso");
							acc.setSolicitud(sol);
							
							accionBean.addAccion(acc);
							JOptionPane.showMessageDialog(null, "Estado cambiado con exito");
							SOLICITUD sol2 = solicitudBean.findSol(sol.getId_solicitud()).get(0);
							
							MandarEmail(sol2);
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
					if(detalle != null) {
						if(detalle.equals("")) {
							JOptionPane.showMessageDialog(null, "Debe ingresar detalle de accion");
						}else {
								ACCIONANALISTACONSTANCIA acc = new ACCIONANALISTACONSTANCIA();
								acc.setAnalista(usuario);
								acc.setDetalle(detalle);
								acc.setFecha(LocalDate.now());
								SOLICITUD sol = null;
								try {
									sol = solicitudBean
											.findSol(Integer.parseInt(tabla.getValueAt(tabla.getSelectedRow(), 0).toString()))
											.get(0);
									sol.setAnalist(usuario);
									solicitudBean.cambiarEstado(sol, EstadoSolicitud.INGRESADO);
								} catch (NumberFormatException | ServiciosException e2) {
									e2.printStackTrace();
								}
								
								try {
									SOLICITUD sol2 = solicitudBean.findSol(sol.getId_solicitud()).get(0);
									acc.setSolicitud(sol2);
									accionBean.addAccion(acc);
									JOptionPane.showMessageDialog(null, "Accion registrada con exito");
									MandarEmailAccion(sol2, acc);
									try {
										agregarDatosLista(modelo);
									} catch (NamingException e1) {
										e1.printStackTrace();
									}
								} catch (ServiciosException e1) {
									e1.printStackTrace();
								}
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
	
	public void MandarEmail(SOLICITUD sol) {
		Properties properties = new Properties();

	      properties.put("mail.smtp.auth", true);
	      properties.put("mail.smtp.host", "smtp.gmail.com");
	      properties.put("mail.smtp.port", 587);
	      properties.put("mail.smtp.starttls.enable", true);
	      properties.put("mail.transport.protocl", "smtp");
	      properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	      
	      Session session = Session.getInstance(properties, new Authenticator() {
	    	  @Override
	    	  protected PasswordAuthentication getPasswordAuthentication() {
	    		  return new PasswordAuthentication("cristofer.cabrera@estudiantes.utec.edu.uy","_.CL5315841c");
	    	  }
	      });

	      
	      try {
	    	Message message = new MimeMessage(session);
			message.setSubject("Cambio de Estado |  " + sol.getEstado() + " | " + sol.getEstSol().getNombre());
			
			 Address addressTo = new InternetAddress(sol.getEstSol().getMail());
		      message.setRecipient(Message.RecipientType.TO, addressTo);
		      
		      MimeMultipart multipart = new MimeMultipart();
		      
		      MimeBodyPart messageBodyPart = new MimeBodyPart();
		      messageBodyPart.setContent("<h1> SU SOLICITUD HA CAMBIADO DE ESTADO A </h1> " + sol.getEstado(), "text/html");
		      
		      multipart.addBodyPart(messageBodyPart);
		      
		      message.setContent(multipart);
		      
		      Transport.send(message);
	     } catch (MessagingException e) {
			e.printStackTrace();
	     }
	      
	}
	
	public void MandarEmailAccion(SOLICITUD sol, ACCIONANALISTACONSTANCIA a) {
		Properties properties = new Properties();

	      properties.put("mail.smtp.auth", true);
	      properties.put("mail.smtp.host", "smtp.gmail.com");
	      properties.put("mail.smtp.port", 587);
	      properties.put("mail.smtp.starttls.enable", true);
	      properties.put("mail.transport.protocl", "smtp");
	      properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	      
	      Session session = Session.getInstance(properties, new Authenticator() {
	    	  @Override
	    	  protected PasswordAuthentication getPasswordAuthentication() {
	    		  return new PasswordAuthentication("cristofer.cabrera@estudiantes.utec.edu.uy","_.CL5315841c");
	    	  }
	      });

	      
	      try {
	    	Message message = new MimeMessage(session);
			message.setSubject("ACCION SOBRE TU RECIENTE SOLICITUD DE CONSTANCIA");
			
			 Address addressTo = new InternetAddress(sol.getEstSol().getMail());
		      message.setRecipient(Message.RecipientType.TO, addressTo);
		      
		      MimeMultipart multipart = new MimeMultipart();
		      
		      MimeBodyPart messageBodyPart = new MimeBodyPart();
		      messageBodyPart.setContent("<h1> Accion del Analista "+ sol.getAnalist().getNombre()+ " sobre tu solicitud de constancia </h1></br>"
		    		  + " <h3> Detalle de la accion: " + a.getDetalle() + "</h3></br>"
		    		  + "<h2> Su solicitud de constancia pasa a estado de " + sol.getEstado() + "</h2>", "text/html");
		      
		      multipart.addBodyPart(messageBodyPart);
		      
		      message.setContent(multipart);
		      
		      Transport.send(message);
	     } catch (MessagingException e) {
			e.printStackTrace();
	     }
	      
	}
	
	private void agregarDatosListaEstado(EstadoSolicitud estadoSolicitud) throws NamingException {
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
		Object[] datosFila = { "", "", "", "", "", "", ""};
		List<SOLICITUD> list = null;
		try {
			list = solicitudBean.listAll();
		} catch (ServiciosException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// Agregamos MUCHOS mas datos
		for (SOLICITUD p : list) {
			if(p.getEstado().equals(estadoSolicitud) || estadoSolicitud.equals(EstadoSolicitud.SIN_FILTRO)) {
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