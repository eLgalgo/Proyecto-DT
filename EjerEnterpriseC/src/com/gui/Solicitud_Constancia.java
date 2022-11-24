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

public class Solicitud_Constancia extends JFrame
        implements ActionListener {
	private JTextField textField;
	private JTable tabla;
	private DefaultTableModel modelo;

    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }

    public Solicitud_Constancia(ESTUDIANTE usuario) throws NamingException, ServiciosException {
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
        
        JButton btnSolicitar = new JButton("Solicitar");
        btnSolicitar.setBounds(406, 293, 113, 23);
        btnSolicitar.setFont(new Font("SimSun", Font.BOLD, 14));
        getContentPane().add(btnSolicitar);
        
        JLabel lblTipo = new JLabel("Tipo");
        lblTipo.setBounds(10, 60, 86, 14);
        lblTipo.setFont(new Font("SimSun", Font.PLAIN, 17));
        getContentPane().add(lblTipo);
        
        JComboBox comboBoxTipo = new JComboBox();
        comboBoxTipo.setBounds(10, 79, 150, 28);
        comboBoxTipo.setModel(new DefaultComboBoxModel(TipoConstancia.values()));
        getContentPane().add(comboBoxTipo);
        
        JLabel lblNewLabel_2 = new JLabel("Solicitar Constancia");
        lblNewLabel_2.setBounds(10, 11, 211, 34);
        lblNewLabel_2.setForeground(Color.BLACK);
        lblNewLabel_2.setFont(new Font("SimSun", Font.BOLD, 16));
        getContentPane().add(lblNewLabel_2);
        
        JLabel lblSeleccioneEvento = new JLabel("Seleccione Evento");
        lblSeleccioneEvento.setBounds(10, 118, 288, 14);
        lblSeleccioneEvento.setFont(new Font("SimSun", Font.PLAIN, 17));
        getContentPane().add(lblSeleccioneEvento);
        
        textField = new JTextField();
        textField.setBounds(194, 79, 325, 28);
        getContentPane().add(textField);
        textField.setColumns(10);
        
        JLabel lblMasInfo = new JLabel("Mas info");
        lblMasInfo.setFont(new Font("SimSun", Font.PLAIN, 17));
        lblMasInfo.setBounds(194, 60, 161, 14);
        getContentPane().add(lblMasInfo);
        setTitle("Solicitar Constancia");
        
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
		agregarDatosLista(modelo, usuario);
		
        btnCancelar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Ppal_Estudiante pEstudianteW = new Ppal_Estudiante(usuario);
				pEstudianteW.setVisible(true);
				pEstudianteW.setLocationRelativeTo(null);
        		dispose();
        	}
        });
        
        btnSolicitar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		SOLICITUD sol = new SOLICITUD();
        		sol.setTipo(TipoConstancia.valueOf(comboBoxTipo.getSelectedItem().toString()));
        		sol.setInfoAdj(textField.getText());
        		sol.setEstado(EstadoSolicitud.PENDIENTE);
        		Date date = Date.from(Instant.now());
        		sol.setFecha(date);
        		sol.setEstSol(usuario);
        		try {
					sol.setEventoAsis(eventoBean.findEvento(Integer.parseInt(tabla.getValueAt(tabla.getSelectedRow(), 0).toString())).get(0));
				} catch (NumberFormatException | ServiciosException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
        		
        		try {
					solicitudBean.addSolicitud(sol);
					JOptionPane.showMessageDialog(null, "Solicitud enviada con exito");
				} catch (ServiciosException e1) {
					e1.printStackTrace();
				}
        		
        	}
        });
    }
    private void crearTablaPersona() {
		String[] columnas = { "ID","Tipo", "Titulo", "Fecha_Fin", "Fecha_Inc", "Detalle", "Tutor" };
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
		desplazamiento.setBounds(10, 143, 509, 139);
		desplazamiento.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		desplazamiento.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		// Modelo de la tabla
		modelo.setColumnIdentifiers(columnas);

		tabla.setModel(modelo);
		getContentPane().add(desplazamiento);
	}

	private void agregarDatosLista(DefaultTableModel modelo, ESTUDIANTE usuario) throws NamingException {
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
		
		// Borramos todas las filas en la tabla
		modelo.setRowCount(0);

		// Creamos los datos de una fila de la tabla
		Object[] datosFila = { "","","", "", "", "", ""};
		List<EVENTO> list = null;
		try {
			list = eventoBean.listarEventosEstu(usuario.getDocumento());
		} catch (ServiciosException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// Agregamos MUCHOS mas datos
		for (EVENTO p : list) {
			datosFila[0] = p.getId_evento();
			datosFila[1] = p.getTipo();
			datosFila[2] = p.getTitulo();
			datosFila[3] = p.getFechaFinal();
			datosFila[4] = p.getFechaInicio();
			datosFila[5] = p.getInformacion();
			datosFila[6] = p.getTutor().getNombre();

			modelo.addRow(datosFila);
		}
	}
}