package com.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import com.entities.ANALISTA;
import com.entities.TIPOCONSTANCIA;
import com.entities.USUARIO;
import com.exception.ServiciosException;
import com.services.AnalistaBeanRemote;
import com.services.EstudianteBeanRemote;
import com.services.EventoBeanRemote;
import com.services.ModeloBeanRemote;
import com.services.SolicitudBeanRemote;
import com.services.TutorBeanRemote;
import com.services.UsuarioBeanRemote;

public class ListarTiposDeConstancia extends JFrame implements ActionListener {
	private JTable tabla;
	private DefaultTableModel modelo;
	private JComboBox comboBoxEstado;

	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
	}

	public ListarTiposDeConstancia(USUARIO userEntrar) throws NamingException, ServiciosException {
		super("Administración Secretaría");
		setResizable(false);
		setBackground(Color.WHITE);
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(674, 396);
		setLocationRelativeTo(null);
		setVisible(true);
		getContentPane().setLayout(null);

		JButton btnCancelar = new JButton("Volver");
		btnCancelar.setBounds(10, 315, 97, 29);
		btnCancelar.setFont(new Font("SimSun", Font.BOLD, 13));
		getContentPane().add(btnCancelar);

		JLabel lblNewLabel_2 = new JLabel("Tipos De Constancias");
		lblNewLabel_2.setBounds(10, 11, 249, 34);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("SimSun", Font.BOLD, 16));
		getContentPane().add(lblNewLabel_2);
		setTitle("Tipos de Constancia");

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
		ModeloBeanRemote modeloBean = (ModeloBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/ModeloBean!com.services.ModeloBeanRemote");

		// Tabla
		crearTablaPersona();
		// Agregamos datos
		agregarDatosLista();

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("SimSun", Font.BOLD, 14));
		btnEliminar.setBounds(332, 315, 113, 29);
		getContentPane().add(btnEliminar);

		JButton btnAgregar = new JButton("Agregar / Modificar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tabla.getSelectedRow() != -1) {
					try {
						CrearModelosConstancia mW = new CrearModelosConstancia((ANALISTA) userEntrar);
						mW.setVisible(true);
						dispose();
					} catch (NamingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ServiciosException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null, "Seleccione un tipo de constancia");
				}
			}
		});
		btnAgregar.setFont(new Font("SimSun", Font.BOLD, 14));
		btnAgregar.setBounds(455, 315, 193, 29);
		getContentPane().add(btnAgregar);

		JButton btnActivar = new JButton("Activar");

		btnActivar.setFont(new Font("SimSun", Font.BOLD, 14));
		btnActivar.setBounds(209, 315, 113, 29);
		getContentPane().add(btnActivar);
		

		comboBoxEstado = new JComboBox();
		comboBoxEstado.setBounds(522, 17, 126, 28);
		comboBoxEstado.addItem("ACTIVO");
		comboBoxEstado.addItem("ELIMINADO");
		comboBoxEstado.addItem("SIN FILTRO");
		
		comboBoxEstado.setSelectedIndex(2);
		
		getContentPane().add(comboBoxEstado);
		
		final ItemListener changeClick = new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (comboBoxEstado.getSelectedItem().equals(e.getItem())) {
					try {
						if(e.getItem().equals("SIN FILTRO")) {
							agregarDatosLista();
						}else if(e.getItem().equals("ACTIVO")) {
							agregarDatosActivo(true);
						}else if(e.getItem().equals("ELIMINADO")) {
							agregarDatosActivo(false);
						}
					} catch (NamingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		};

		comboBoxEstado.addItemListener(changeClick);

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ANALISTA analist;
				try {
					analist = (ANALISTA) usuarioBean.findUser(userEntrar.getDocumento()).get(0);
					Ppal_Analista listUsersW = new Ppal_Analista(analist);
					listUsersW.setVisible(true);
					listUsersW.setLocationRelativeTo(null);
					dispose();
				} catch (ServiciosException | NamingException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnActivar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tabla.getSelectedRow() != -1) {
					try {
						TIPOCONSTANCIA modelo = modeloBean.findTipo(tabla.getValueAt(tabla.getSelectedRow(), 1).toString())
								.get(0);
						modeloBean.activarTipo(modelo.getTipo());
						JOptionPane.showMessageDialog(null, "Activado con exito");
						try {
							agregarDatosLista();
						} catch (NamingException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} catch (ServiciosException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
				}else {
					JOptionPane.showMessageDialog(null, "Seleccione un elemento en la tabla");
				}
			}
		});
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tabla.getSelectedRow() != -1) {
					try {
						TIPOCONSTANCIA modelo = modeloBean.findTipo(tabla.getValueAt(tabla.getSelectedRow(), 1).toString())
								.get(0);
						modeloBean.logicDelete(modelo.getTipo());
						JOptionPane.showMessageDialog(null, "Eliminado con exito");
						try {
							agregarDatosLista();
						} catch (NamingException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} catch (ServiciosException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null, "Seleccione un elemento en la tabla");
				}
				
			}
		});
	}

	private void crearTablaPersona() {
		String[] columnas = { "ID", "Tipo", "Detalle", "Estado" };
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
		desplazamiento.setBounds(10, 48, 638, 234);
		desplazamiento.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		desplazamiento.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		// Modelo de la tabla
		modelo.setColumnIdentifiers(columnas);

		tabla.setModel(modelo);
		getContentPane().add(desplazamiento);
	}

	private void agregarDatosLista() throws NamingException {
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
		ModeloBeanRemote modeloBean = (ModeloBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/ModeloBean!com.services.ModeloBeanRemote");

		// Borramos todas las filas en la tabla
		modelo.setRowCount(0);

		// Creamos los datos de una fila de la tabla
		Object[] datosFila = { "", "", "", "" };
		List<TIPOCONSTANCIA> list = null;
		try {
			list = modeloBean.listAllModelo();
		} catch (ServiciosException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (list != null) {
			for (TIPOCONSTANCIA p : list) {
				datosFila[0] = p.getId_modelo();
				datosFila[1] = p.getTipo();
				datosFila[2] = p.getModelo();
				if (p.isEstado()) {
					datosFila[3] = "ACTIVO";
				} else {
					datosFila[3] = "ELIMINADO";
				}
				modelo.addRow(datosFila);
			}
		}

	}
	
	private void agregarDatosActivo(boolean filtro) throws NamingException {
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
		ModeloBeanRemote modeloBean = (ModeloBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/ModeloBean!com.services.ModeloBeanRemote");

		// Borramos todas las filas en la tabla
		modelo.setRowCount(0);

		// Creamos los datos de una fila de la tabla
		Object[] datosFila = { "", "", "", "" };
		List<TIPOCONSTANCIA> list = null;
		try {
			list = modeloBean.listAllModelo();
		} catch (ServiciosException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (list != null) {
			for (TIPOCONSTANCIA p : list) {
				if(filtro) {
					if(p.isEstado()) {
						datosFila[0] = p.getId_modelo();
						datosFila[1] = p.getTipo();
						datosFila[2] = p.getModelo();
						if (p.isEstado()) {
							datosFila[3] = "ACTIVO";
						} else {
							datosFila[3] = "ELIMINADO";
						}
						modelo.addRow(datosFila);
					}
				}else {
					if(!p.isEstado()) {
						datosFila[0] = p.getId_modelo();
						datosFila[1] = p.getTipo();
						datosFila[2] = p.getModelo();
						if (p.isEstado()) {
							datosFila[3] = "ACTIVO";
						} else {
							datosFila[3] = "ELIMINADO";
						}
						modelo.addRow(datosFila);
					}
				}
			}
		}

	}

	/**
	 * Standard method to print a JTable to the printer directly.. Método estándar
	 * para imprimir un JTable por la impresora directamente.
	 * <h3>Example (Ejemplo)</h3>
	 * 
	 * <pre>
	 * utilJTablePrint(jTable2, getTitle(), "Código Xules", true);
	 * </pre>
	 *
	 * @param jTable          <code>JTable</code> the JTable we are going to extract
	 *                        to excel El Jtable que vamos a extraer a excel.
	 * @param header          <code>String</code> Header to print in the document.
	 *                        Cabecera que imprimiremos en el documento.
	 * @param footer          <code>String</code> Footer to print in the document.
	 *                        Pie de página que imprimiremos en el documento.
	 * @param showPrintDialog <code>boolean</code> To show or not the print dialog.
	 *                        Mostramos o no el diálogo de impresión.
	 */
	public void utilJTablePrint(JTable jTable, String header, String footer, boolean showPrintDialog) {
		boolean fitWidth = true;
		boolean interactive = true;
		// We define the print mode (Definimos el modo de impresión)
		JTable.PrintMode mode = fitWidth ? JTable.PrintMode.FIT_WIDTH : JTable.PrintMode.NORMAL;
		try {
			// Print the table (Imprimo la tabla)
			boolean complete = jTable.print(mode, new MessageFormat(header), new MessageFormat(footer), showPrintDialog,
					null, interactive);
			if (complete) {
				// Mostramos el mensaje de impresión existosa
				JOptionPane.showMessageDialog(jTable, "Print complete (Impresión completa)",
						"Print result (Resultado de la impresión)", JOptionPane.INFORMATION_MESSAGE);
			} else {
				// Mostramos un mensaje indicando que la impresión fue cancelada
				JOptionPane.showMessageDialog(jTable, "Print canceled (Impresión cancelada)",
						"Print result (Resultado de la impresión)", JOptionPane.WARNING_MESSAGE);
			}
		} catch (PrinterException pe) {
			JOptionPane.showMessageDialog(jTable, "Fallo de impresión: " + pe.getMessage(),
					"Print result (Resultado de la impresión)", JOptionPane.ERROR_MESSAGE);
		}
	}
}
