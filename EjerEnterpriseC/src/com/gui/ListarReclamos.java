package com.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.DefaultComboBoxModel;
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
import com.entities.RECLAMO;
import com.entities.TUTOR;
import com.entities.USUARIO;
import com.enums.TipoReclamo;
import com.exception.ServiciosException;
import com.services.AnalistaBeanRemote;
import com.services.EstudianteBeanRemote;
import com.services.EventoBeanRemote;
import com.services.ReclamoBeanRemote;
import com.services.SolicitudBeanRemote;
import com.services.TutorBeanRemote;
import com.services.UsuarioBeanRemote;

public class ListarReclamos extends JFrame
        implements ActionListener {
	private JTable tabla;
	private DefaultTableModel modelo;
	private JComboBox comboBoxEstado;

    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }

    public ListarReclamos(USUARIO userEntrar) throws NamingException, ServiciosException {
        super("Administración Secretaría");
        setResizable(false);
        setBackground(Color.WHITE);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(550,362);
        setLocationRelativeTo(null);
        setVisible(true);
        getContentPane().setLayout(null);
        
        JButton btnCancelar = new JButton("Volver");
        btnCancelar.setBounds(10, 293, 97, 23);
        btnCancelar.setFont(new Font("SimSun", Font.BOLD, 13));
        getContentPane().add(btnCancelar);
        
        JButton btnSolicitar = new JButton("Descargar");
        btnSolicitar.setBounds(406, 293, 113, 23);
        btnSolicitar.setFont(new Font("SimSun", Font.BOLD, 14));
        getContentPane().add(btnSolicitar);
        
        JLabel lblNewLabel_2 = new JLabel("Listado de Reclamos");
        lblNewLabel_2.setBounds(10, 11, 205, 34);
        lblNewLabel_2.setForeground(Color.BLACK);
        lblNewLabel_2.setFont(new Font("SimSun", Font.BOLD, 16));
        getContentPane().add(lblNewLabel_2);
        setTitle("Reclamos de estudiantes");
        
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
        crearTablaPersona();
		// Agregamos datos
		agregarDatosLista();
		
		comboBoxEstado.setSelectedIndex(2);
		
        btnCancelar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(userEntrar instanceof ANALISTA) {
        			ANALISTA analist;
					try {
						analist = (ANALISTA) usuarioBean.findUser(userEntrar.getDocumento()).get(0);
						Ppal_Analista pAnalistW = new Ppal_Analista(analist);
						pAnalistW.setVisible(true);
						pAnalistW.setLocationRelativeTo(null);
						dispose();
					} catch (ServiciosException | NamingException e1) {
						e1.printStackTrace();
					}
        		}else {
        			if(userEntrar instanceof TUTOR) {
        				TUTOR est;
        				try {
							est = (TUTOR) usuarioBean.findUser(userEntrar.getDocumento()).get(0);
							Ppal_Tutor pEstudianteW = new Ppal_Tutor(est);
	        				pEstudianteW.setVisible(true);
	        				pEstudianteW.setLocationRelativeTo(null);
	                		dispose();
						} catch (ServiciosException e1) {
							e1.printStackTrace();
						}
        			}
        		}
        		
        	}
        });
        
        btnSolicitar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(tabla.getSelectedRow() != -1) {
                	String header = "RECLAMO UNIVERSIDAD TECNOLOGICA";
                	String footer = "EMITIDO POR UTEC \nFECHA: " + LocalDate.now();
               		utilJTablePrint(tabla, header, footer, true);
               	}
               	else {
        			JOptionPane.showMessageDialog(null, "Seleccione un reclamo para descargar");
               	}	
        	}
        });
    }
    private void crearTablaPersona() {
		String[] columnas = { "ID", "Titulo", "Detalle", "Fecha", "Estudiante", "Tipo" };
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
		desplazamiento.setBounds(10, 48, 511, 234);
		desplazamiento.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		desplazamiento.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		// Modelo de la tabla
		modelo.setColumnIdentifiers(columnas);

		tabla.setModel(modelo);
		getContentPane().add(desplazamiento);
		
		comboBoxEstado = new JComboBox();
		comboBoxEstado.setBounds(393, 18, 126, 28);
		comboBoxEstado.setModel(new DefaultComboBoxModel(TipoReclamo.values()));
		getContentPane().add(comboBoxEstado);
		
		
		
	    final ItemListener changeClick = new ItemListener()
	    {
	        public void itemStateChanged(ItemEvent e) 
	        {
	            if(comboBoxEstado.getSelectedItem().equals(e.getItem()))
	            {
	            	try {
						agregarDatosLista();
					} catch (NamingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            }
	        }
	    };
	    
	    comboBoxEstado.addItemListener(changeClick);
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
		
		ReclamoBeanRemote reclamoBean = (ReclamoBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/ReclamoBean!com.services.ReclamoBeanRemote");
		
		SolicitudBeanRemote solicitudBean = (SolicitudBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/SolicitudBean!com.services.SolicitudBeanRemote");
		
		// Borramos todas las filas en la tabla
		modelo.setRowCount(0);

		// Creamos los datos de una fila de la tabla
		Object[] datosFila = { "", "", "", "", "",""};
		List<RECLAMO> list = null;
		try {
			list = reclamoBean.listAllReclamo();
		} catch (ServiciosException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// Agregamos MUCHOS mas datos
		for (RECLAMO p : list) {
				datosFila[0] = p.getId_reclamo();
				datosFila[1] = p.getTitulo();
				datosFila[2] = p.getDetalle();
				datosFila[3] = p.getFecha();
				datosFila[4] = p.getEs().getDocumento();
				datosFila[5] = p.getTipo().name();

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

