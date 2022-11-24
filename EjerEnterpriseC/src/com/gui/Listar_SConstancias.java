package com.gui;

import java.awt.EventQueue;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
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

public class Listar_SConstancias extends JFrame
        implements ActionListener {
	private JTable tabla;
	private DefaultTableModel modelo;
	private JComboBox comboBoxEstado;

    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }

    public Listar_SConstancias(ESTUDIANTE usuario, USUARIO userEntrar, int ventana) throws NamingException, ServiciosException {
        super("Administración Secretaría");
        setIconImage(Toolkit.getDefaultToolkit().getImage(Listar_SConstancias.class.getResource("/PNG/logoUtec.png")));
        setResizable(false);
        setBackground(Color.WHITE);
        getContentPane().setBackground(SystemColor.control);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(550,408);
        setLocationRelativeTo(null);
        setVisible(true);
        getContentPane().setLayout(null);
        
        JButton btnCancelar = new JButton("Volver");
        btnCancelar.setBounds(10, 335, 97, 23);
        btnCancelar.setFont(new Font("SimSun", Font.BOLD, 13));
        getContentPane().add(btnCancelar);
        
        JButton btnSolicitar = new JButton("Imprimir");
        btnSolicitar.setBounds(408, 335, 113, 23);
        btnSolicitar.setFont(new Font("SimSun", Font.BOLD, 14));
        getContentPane().add(btnSolicitar);
        
        JLabel lblNewLabel_2 = new JLabel("Mis Solicitudes");
        lblNewLabel_2.setBounds(10, 22, 159, 34);
        lblNewLabel_2.setForeground(Color.BLACK);
        lblNewLabel_2.setFont(new Font("SimSun", Font.BOLD, 16));
        getContentPane().add(lblNewLabel_2);
        setTitle("Solicitudes de Constancia");
        
        //Logica botones
        
        EstudianteBeanRemote estudianteBean = (EstudianteBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/EstudianteBean!com.services.EstudianteBeanRemote");
		
		TutorBeanRemote tutorBean = (TutorBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/TutorBean!com.services.TutorBeanRemote");
		
		AnalistaBeanRemote analistaBean = (AnalistaBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/AnalistaBean!com.services.AnalistaBeanRemote");
		
		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/UsuarioBean!com.services.UsuarioBeanRemote");
		
		EventoBeanRemote eventoBean = (EventoBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/EventoBean!com.services.EventoBeanRemote");
		
		SolicitudBeanRemote solicitudBean = (SolicitudBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/SolicitudBean!com.services.SolicitudBeanRemote");

        //Tabla
        crearTablaPersona(usuario);
		// Agregamos datos
		agregarDatosLista(usuario, EstadoSolicitud.SIN_FILTRO);
		
		comboBoxEstado.setSelectedIndex(2);
		
        btnCancelar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(ventana == 1) {
        			ANALISTA analist;
					try {
						analist = (ANALISTA) usuarioBean.findUser(userEntrar.getDocumento()).get(0);
						ListarUsuarios listUsersW = new ListarUsuarios(analist);
						listUsersW.getFrame().setVisible(true);
						listUsersW.getFrame().setLocationRelativeTo(null);
						dispose();
					} catch (ServiciosException | NamingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        		}else {
        			if(ventana == 0) {
        				ESTUDIANTE est;
        				try {
							est = (ESTUDIANTE) usuarioBean.findUser(userEntrar.getDocumento()).get(0);
							Ppal_Estudiante pEstudianteW = new Ppal_Estudiante(est);
	        				pEstudianteW.setVisible(true);
	        				pEstudianteW.setLocationRelativeTo(null);
	                		dispose();
						} catch (ServiciosException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
        				
        			}
        		}
        		
        	}
        });
        
        btnSolicitar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(tabla.getValueAt(tabla.getSelectedRow(), 4).toString().equals("EMITIDA")) {
        			if(tabla.getSelectedRow() != -1) {
                		String header = "CONSTANCIA " + usuario.getNombre() +" "+ usuario.getApellido();
                		String footer = "EMITIDO POR UTEC \nFECHA: " + LocalDate.now();
                		utilJTablePrint(tabla, header, footer, true);
                		}
                		else {
        					JOptionPane.showMessageDialog(null, "Seleccione una constancia para imprimir");
        				}	
        		}else {
        			JOptionPane.showMessageDialog(null, "Solicitud de constancia aun no emitida");
        		}
        		
        	}
        });
    }
    private void crearTablaPersona(ESTUDIANTE usuario) {
		String[] columnas = { "Tipo", "Fecha", "Evento", "Estudiante", "Estado" };
		tabla = new JTable();
		tabla.setBackground(SystemColor.text);
		modelo = new DefaultTableModel() {
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return false;
			}
		};

		JButton btnNewButton_2 = new JButton("Modificar");
		btnNewButton_2.setBounds(411, 300, 110, 25);
		btnNewButton_2.setFont(new Font("SimSun", Font.BOLD, 13));
		JScrollPane desplazamiento = new JScrollPane(tabla);
		desplazamiento.setBounds(10, 78, 511, 234);
		desplazamiento.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		desplazamiento.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		// Modelo de la tabla
		modelo.setColumnIdentifiers(columnas);

		tabla.setModel(modelo);
		getContentPane().add(desplazamiento);
		
		comboBoxEstado = new JComboBox();
		comboBoxEstado.setBounds(398, 39, 126, 28);
		comboBoxEstado.setModel(new DefaultComboBoxModel(EstadoSolicitud.values()));
		getContentPane().add(comboBoxEstado);
		
		
		
	    final ItemListener changeClick = new ItemListener()
	    {
	        public void itemStateChanged(ItemEvent e) 
	        {
	            if(comboBoxEstado.getSelectedItem().equals(e.getItem()))
	            {
	            	try {
						agregarDatosLista(usuario, EstadoSolicitud.valueOf(comboBoxEstado.getSelectedItem().toString()));
					} catch (NamingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            }
	        }
	    };
	    
	    comboBoxEstado.addItemListener(changeClick);
	}

	private void agregarDatosLista(ESTUDIANTE usuario, EstadoSolicitud estadoSolicitud) throws NamingException {
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
		Object[] datosFila = { "", "", "", "", ""};
		List<SOLICITUD> list = null;
		try {
			list = solicitudBean.listarSolicitudEstu(usuario.getDocumento());
		} catch (ServiciosException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// Agregamos MUCHOS mas datos
		for (SOLICITUD p : list) {
			if(p.getEstado().equals(estadoSolicitud) || estadoSolicitud.equals(EstadoSolicitud.SIN_FILTRO)) {
				datosFila[0] = p.getTipo();
				datosFila[1] = p.getFecha();
				datosFila[2] = p.getEventoAsis().getTitulo();
				datosFila[3] = p.getEstSol().getDocumento();
				datosFila[4] = p.getEstado();

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
	
	/**
	 * Standard method to print a JTable to the printer directly..
	 * Método estándar para imprimir un JTable por la impresora directamente.
	 * <h3>Example (Ejemplo)</h3>
	 * <pre>
	 *      utilJTablePrint(jTable2, getTitle(), "Código Xules", true);
	 * </pre>
	 *
	 * @param jTable <code>JTable</code> 
	 *      the JTable we are going to extract to excel 
	 *      El Jtable que vamos a extraer a excel.
	 * @param header <code>String</code>
	 *      Header to print in the document.
	 *      Cabecera que imprimiremos en el documento.
	 * @param footer <code>String</code>
	 *      Footer to print in the document.
	 *      Pie de página que imprimiremos en el documento.
	 * @param showPrintDialog  <code>boolean</code>
	 *      To show or not the print dialog.
	 *      Mostramos o no el diálogo de impresión.
	 */
	public void utilJTablePrint(JTable jTable, String header, String footer, boolean showPrintDialog){        
	    boolean fitWidth = true;        
	    boolean interactive = true;
	    // We define the print mode (Definimos el modo de impresión)
	    JTable.PrintMode mode = fitWidth ? JTable.PrintMode.FIT_WIDTH : JTable.PrintMode.NORMAL;
	    try {
	        // Print the table (Imprimo la tabla)             
	        boolean complete = jTable.print(mode,
	                new MessageFormat(header),
	                new MessageFormat(footer),
	                showPrintDialog,
	                null,
	                interactive);                 
	        if (complete) {
	            // Mostramos el mensaje de impresión existosa
	            JOptionPane.showMessageDialog(jTable,
	                    "Print complete (Impresión completa)",
	                    "Print result (Resultado de la impresión)",
	                    JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            // Mostramos un mensaje indicando que la impresión fue cancelada                 
	            JOptionPane.showMessageDialog(jTable,
	                    "Print canceled (Impresión cancelada)",
	                    "Print result (Resultado de la impresión)",
	                    JOptionPane.WARNING_MESSAGE);
	        }
	    } catch (PrinterException pe) {
	        JOptionPane.showMessageDialog(jTable, 
	                "Fallo de impresión: " + pe.getMessage(), 
	                "Print result (Resultado de la impresión)", 
	                JOptionPane.ERROR_MESSAGE);
	    }
	}
}

