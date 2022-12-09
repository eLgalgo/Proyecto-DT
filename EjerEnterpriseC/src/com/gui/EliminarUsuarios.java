package com.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.entities.ANALISTA;
import com.entities.ESTUDIANTE;
import com.entities.SOLICITUD;
import com.entities.TUTOR;
import com.entities.USUARIO;
import com.enums.EstadoSolicitud;
import com.enums.EstadoUsuario;
import com.enums.TipoUser;
import com.exception.ServiciosException;
import com.services.AnalistaBeanRemote;
import com.services.EstudianteBeanRemote;
import com.services.EventoBeanRemote;
import com.services.TutorBeanRemote;
import com.services.UsuarioBeanRemote;

public class EliminarUsuarios {

	private JFrame frmListadoDeUsuarios;
	private JTable tabla;
	private DefaultTableModel modelo;
	private JButton btnVolver;
	private JLabel lblNewLabel;
	private JLabel lblListadoDeUsuarios;
	private JTextField txtFiltro;
	private TableRowSorter trs;
	private JComboBox comboBoxEstado;
	private JButton btnActivar;
	/**
	 * Create the application.
	 * 
	 * @throws NamingException
	 */
	public EliminarUsuarios(ANALISTA usuario) throws NamingException {
		initialize(usuario);
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws NamingException
	 */
	private void initialize(ANALISTA usuario) throws NamingException {
		frmListadoDeUsuarios = new JFrame();
		frmListadoDeUsuarios.setTitle("Eliminado de Usuarios");
		frmListadoDeUsuarios.setIconImage(
				Toolkit.getDefaultToolkit().getImage("Z:\\ONE DRIVE\\OneDrive\\Escritorio\\PNG\\logoUtec.png"));
		frmListadoDeUsuarios.getContentPane().setBackground(Color.WHITE);
		frmListadoDeUsuarios.setResizable(false);
		frmListadoDeUsuarios.setBounds(100, 100, 688, 430);
		frmListadoDeUsuarios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 356, 110, 25);
		btnVolver.setFont(new Font("SimSun", Font.BOLD, 13));

		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(228, 17, 0, 0);
		lblNewLabel.setIcon(new ImageIcon("Z:\\ONE DRIVE\\OneDrive\\Escritorio\\PNG\\deleteUser.png"));
		
		String[] columnas = { "ID", "Nombre", "Apellido", "Departamento", "Documento", "Telefono", "Email", "Tipo",
		"Estado" };
		
		tabla = new JTable();
		modelo = new DefaultTableModel() {
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return false;
			}
		};

		JScrollPane desplazamiento = new JScrollPane(tabla);
		desplazamiento.setBounds(10, 97, 652, 248);
		desplazamiento.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		desplazamiento.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		tabla.setModel(modelo);
		
		frmListadoDeUsuarios.getContentPane().setLayout(null);
		frmListadoDeUsuarios.getContentPane().add(btnVolver);
		frmListadoDeUsuarios.getContentPane().add(lblNewLabel);
		frmListadoDeUsuarios.getContentPane().add(desplazamiento);

		lblListadoDeUsuarios = new JLabel("Eliminado de Usuario");
		lblListadoDeUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblListadoDeUsuarios.setFont(new Font("SimSun", Font.PLAIN, 18));
		lblListadoDeUsuarios.setBounds(10, 14, 652, 15);
		frmListadoDeUsuarios.getContentPane().add(lblListadoDeUsuarios);
		
		modelo.setColumnIdentifiers(columnas);
		// Agregamos datos
		agregarDatosLista(usuario);
		
		AnalistaBeanRemote analistaBean = (AnalistaBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/AnalistaBean!com.services.AnalistaBeanRemote");

		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/UsuarioBean!com.services.UsuarioBeanRemote");

		TutorBeanRemote tutorBean = (TutorBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/TutorBean!com.services.TutorBeanRemote");

		EstudianteBeanRemote estudianteBean = (EstudianteBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/EstudianteBean!com.services.EstudianteBeanRemote");

		EventoBeanRemote eventoBean = (EventoBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/EventoBean!com.services.EventoBeanRemote");

		comboBoxEstado = new JComboBox();

		comboBoxEstado.setBounds(531, 61, 131, 25);
		comboBoxEstado.setModel(new DefaultComboBoxModel(EstadoUsuario.values()));
		comboBoxEstado.addItem("SIN FILTRO");
		frmListadoDeUsuarios.getContentPane().add(comboBoxEstado);
		
		comboBoxEstado.setSelectedIndex(3);
		txtFiltro = new JTextField();
		txtFiltro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				txtFiltro.addKeyListener(new KeyAdapter() {
					public void keyReleased(final KeyEvent e) {
						String s = txtFiltro.getText();
						txtFiltro.setText(s);
						FiltroCi();
					}
				});
				trs = new TableRowSorter(tabla.getModel());
				tabla.setRowSorter(trs);
			}
		});
		txtFiltro.setBounds(108, 61, 131, 25);
		frmListadoDeUsuarios.getContentPane().add(txtFiltro);
		txtFiltro.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Filtrar x CI");
		lblNewLabel_1.setFont(new Font("SimSun", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(22, 67, 80, 14);
		frmListadoDeUsuarios.getContentPane().add(lblNewLabel_1);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("SimSun", Font.BOLD, 13));
		btnEliminar.setBounds(552, 357, 110, 25);
		frmListadoDeUsuarios.getContentPane().add(btnEliminar);
		
		btnActivar = new JButton("Activar");
		btnActivar.setFont(new Font("SimSun", Font.BOLD, 13));
		btnActivar.setBounds(432, 357, 110, 25);
		frmListadoDeUsuarios.getContentPane().add(btnActivar);
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(tabla.getSelectedRow() != -1) {
						if(tabla.getValueAt(tabla.getSelectedRow(), 7).toString().equals("ANALISTA")) {
							ANALISTA user = analistaBean
									.findUser(Integer.parseInt(tabla.getValueAt(tabla.getSelectedRow(), 4).toString()))
									.get(0);
							if(user.getEstado()!= EstadoUsuario.ELIMINADO) {
								int res = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea borrar el Usuario?");
								if (res == JOptionPane.YES_OPTION) {
									analistaBean.logicDelete(user.getDocumento());
									try {
										agregarDatosLista(usuario);
									} catch (NamingException e1) {
										e1.printStackTrace();
									}
									JOptionPane.showMessageDialog(null, "Usuario dado de baja lógica.");
								}
							}else {
								JOptionPane.showMessageDialog(null, "Usuario ya eliminado");
							}
						}else if(tabla.getValueAt(tabla.getSelectedRow(), 7).toString().equals("ESTUDIANTE")) {
							ESTUDIANTE user = estudianteBean
									.findUser(Integer.parseInt(tabla.getValueAt(tabla.getSelectedRow(), 4).toString()))
									.get(0);
							if(user.getEstado()!= EstadoUsuario.ELIMINADO) {
								int res = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea borrar el Usuario?");
								if (res == JOptionPane.YES_OPTION) {
									estudianteBean.logicDelete(user.getDocumento());
									try {
										agregarDatosLista(usuario);
									} catch (NamingException e1) {
										e1.printStackTrace();
									}
									JOptionPane.showMessageDialog(null, "Usuario dado de baja lógica.");
								}
							}else {
								JOptionPane.showMessageDialog(null, "Usuario ya eliminado");
							}
						}else if(tabla.getValueAt(tabla.getSelectedRow(), 7).toString().equals("TUTOR")) {
							TUTOR user = tutorBean
									.findUser(Integer.parseInt(tabla.getValueAt(tabla.getSelectedRow(), 4).toString()))
									.get(0);
							if(user.getEstado()!= EstadoUsuario.ELIMINADO) {
								int res = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea borrar el Usuario?");
								if (res == JOptionPane.YES_OPTION) {
									tutorBean.logicDelete(user.getDocumento());
									try {
										agregarDatosLista(usuario);
									} catch (NamingException e1) {
										e1.printStackTrace();
									}
									JOptionPane.showMessageDialog(null, "Usuario dado de baja lógica.");
								}
							}else {
								JOptionPane.showMessageDialog(null, "Usuario ya eliminado");
							}
						}
					}else {
						JOptionPane.showMessageDialog(null, "Debe seleccionar un usuario en la tabla");
					}
					
				} catch (NumberFormatException | ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnActivar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(tabla.getSelectedRow() != -1) {
						if(tabla.getValueAt(tabla.getSelectedRow(), 7).toString().equals("ANALISTA")){
							ANALISTA user = analistaBean
									.findUser(Integer.parseInt(tabla.getValueAt(tabla.getSelectedRow(), 4).toString()))
									.get(0);
							if(user.getEstado()!= EstadoUsuario.ACTIVO) {
								int res = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea activar el Usuario?");
								if (res == JOptionPane.YES_OPTION) {
									user.setEstado(EstadoUsuario.ACTIVO);
									usuarioBean.editUser(user);
									try {
										agregarDatosLista(usuario);
									} catch (NamingException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									JOptionPane.showMessageDialog(null, "Usuario activado con exito.");
								}
							}else {
								JOptionPane.showMessageDialog(null, "Usuario ya activado");
							}
						}else if(tabla.getValueAt(tabla.getSelectedRow(), 7).toString().equals("ESTUDIANTE")) {
							ESTUDIANTE user = estudianteBean
									.findUser(Integer.parseInt(tabla.getValueAt(tabla.getSelectedRow(), 4).toString()))
									.get(0);
							if(user.getEstado()!= EstadoUsuario.ACTIVO) {
								int res = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea activar el Usuario?");
								if (res == JOptionPane.YES_OPTION) {
									user.setEstado(EstadoUsuario.ACTIVO);
									usuarioBean.editUser(user);
									try {
										agregarDatosLista(usuario);
									} catch (NamingException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									JOptionPane.showMessageDialog(null, "Usuario activado con exito.");
								}
							}else {
								JOptionPane.showMessageDialog(null, "Usuario ya activado");
							}
						}else if(tabla.getValueAt(tabla.getSelectedRow(), 7).toString().equals("TUTOR")) {
							TUTOR user = tutorBean
									.findUser(Integer.parseInt(tabla.getValueAt(tabla.getSelectedRow(), 4).toString()))
									.get(0);
							if(user.getEstado()!= EstadoUsuario.ACTIVO) {
								int res = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea activar el Usuario?");
								if (res == JOptionPane.YES_OPTION) {
									user.setEstado(EstadoUsuario.ACTIVO);
									usuarioBean.editUser(user);
									try {
										agregarDatosLista(usuario);
									} catch (NamingException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									JOptionPane.showMessageDialog(null, "Usuario activado con exito.");
								}
							}else {
								JOptionPane.showMessageDialog(null, "Usuario ya activado");
							}
						}
					}else {
						JOptionPane.showMessageDialog(null, "Debe seleccionar un usuario en la tabla");
					}
					
				} catch (NumberFormatException | ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		final ItemListener changeClick = new ItemListener()
	    {
	        public void itemStateChanged(ItemEvent e) 
	        {
	            if(comboBoxEstado.getSelectedItem().equals(e.getItem()))
	            {
	            	if(e.getItem().toString().equals("ELIMINADO")){
	            		try {
							agregarDatosLista(usuario, EstadoUsuario.ELIMINADO);
						} catch (NamingException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	            	}else if(e.getItem().toString().equals("ACTIVO")) {
	            		try {
							agregarDatosLista(usuario, EstadoUsuario.ACTIVO);
						} catch (NamingException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	            	}else if(e.getItem().toString().equals("SIN_CHEQUEAR")) {
	            		try {
							agregarDatosLista(usuario, EstadoUsuario.SIN_CHEQUEAR);
						} catch (NamingException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	            	}else if(e.getItem().toString().equals("SIN FILTRO")) {
	            		try {
							agregarDatosLista(usuario);
						} catch (NamingException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	            	}
	            }
	        }
	    };
	    
	    comboBoxEstado.addItemListener(changeClick);
	    
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ppal_Analista pAnalist = null;
				try {
					ANALISTA usuario2 = (ANALISTA) usuarioBean.findUser(usuario.getDocumento()).get(0);
					pAnalist = new Ppal_Analista(usuario2);
				} catch (NamingException | ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pAnalist.setLocationRelativeTo(null);
				getFrame().dispose();
			}
		});
	}

	private void agregarDatosLista(ANALISTA usuario, EstadoUsuario filtro) throws NamingException {
		EstudianteBeanRemote estudianteBean = (EstudianteBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/EstudianteBean!com.services.EstudianteBeanRemote");

		TutorBeanRemote tutorBean = (TutorBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/TutorBean!com.services.TutorBeanRemote");

		AnalistaBeanRemote analistaBean = (AnalistaBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/AnalistaBean!com.services.AnalistaBeanRemote");

		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/UsuarioBean!com.services.UsuarioBeanRemote");
		String[] columnas = { "ID", "Nombre", "Apellido", "Departamento", "Documento", "Telefono", "Email", "Tipo",
		"Estado"};
		modelo.setColumnIdentifiers(columnas);
		// Borramos todas las filas en la tabla
		modelo.setRowCount(0);
		List<USUARIO> list = null;
		try {
			list = usuarioBean.listAllUsers();
		} catch (ServiciosException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// Creamos los datos de una fila de la tabla
		Object[] datosFila = { "", "", "", "", "", "", "", "", "" };
		
		// Agregamos MUCHOS mas datos
		for (USUARIO p2 : list) {
			if(p2.getEstado() == filtro) {
				datosFila[0] = p2.getId_usuario();
				datosFila[1] = p2.getNombre();
				datosFila[2] = p2.getApellido();
				datosFila[3] = p2.getDepartamento();
				datosFila[4] = p2.getDocumento();
				datosFila[5] = p2.getTelefono();
				datosFila[6] = p2.getMail();
				if(p2 instanceof ANALISTA) {
					datosFila[7] = "ANALISTA";
				}else if(p2 instanceof TUTOR) {
					datosFila[7] = "TUTOR";
				}else if(p2 instanceof ESTUDIANTE) {
					datosFila[7] = "ESTUDIANTE";
				}
				datosFila[8] = p2.getEstado().name();
				modelo.addRow(datosFila);
				}
			}
		}
	
	private void agregarDatosLista(ANALISTA usuario) throws NamingException {
		EstudianteBeanRemote estudianteBean = (EstudianteBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/EstudianteBean!com.services.EstudianteBeanRemote");

		TutorBeanRemote tutorBean = (TutorBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/TutorBean!com.services.TutorBeanRemote");

		AnalistaBeanRemote analistaBean = (AnalistaBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/AnalistaBean!com.services.AnalistaBeanRemote");

		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/UsuarioBean!com.services.UsuarioBeanRemote");
		String[] columnas = { "ID", "Nombre", "Apellido", "Departamento", "Documento", "Telefono", "Email", "Tipo",
		"Estado"};
		modelo.setColumnIdentifiers(columnas);
		// Borramos todas las filas en la tabla
		modelo.setRowCount(0);
		List<USUARIO> list = null;
		try {
			list = usuarioBean.listAllUsers();
		} catch (ServiciosException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// Creamos los datos de una fila de la tabla
		Object[] datosFila = { "", "", "", "", "", "", "", "", "" };
		
		// Agregamos MUCHOS mas datos
		for (USUARIO p2 : list) {
			datosFila[0] = p2.getId_usuario();
			datosFila[1] = p2.getNombre();
			datosFila[2] = p2.getApellido();
			datosFila[3] = p2.getDepartamento();
			datosFila[4] = p2.getDocumento();
			datosFila[5] = p2.getTelefono();
			datosFila[6] = p2.getMail();
			if(p2 instanceof ANALISTA) {
				datosFila[7] = "ANALISTA";
			}else if(p2 instanceof TUTOR) {
				datosFila[7] = "TUTOR";
			}else if(p2 instanceof ESTUDIANTE) {
				datosFila[7] = "ESTUDIANTE";
			}
			datosFila[8] = p2.getEstado().name();
			modelo.addRow(datosFila);
		}
	}
	
	JFrame getFrame() {
		return this.frmListadoDeUsuarios;
	}

	private void FiltroCi() {

		int columnaTabla = 4;// Documento
		trs.setRowFilter(RowFilter.regexFilter(txtFiltro.getText(), columnaTabla));
	}
}
