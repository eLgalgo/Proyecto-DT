package com.gui;

import java.awt.EventQueue;
import java.awt.event.*;

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

import com.enums.Estado;
import com.enums.TipoConstancia;
import com.exception.ServiciosException;
import com.services.AnalistaBeanRemote;
import com.services.EstudianteBeanRemote;
import com.services.TutorBeanRemote;
import com.services.UsuarioBeanRemote;

import java.awt.Color;
import java.awt.Component;

public class Solicitud_Constancia extends JFrame
        implements ActionListener {
	private JTextField textField;

    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }

    public Solicitud_Constancia() throws NamingException {
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
        comboBoxTipo.setBounds(10, 85, 150, 22);
        comboBoxTipo.setModel(new DefaultComboBoxModel(TipoConstancia.values()));
        getContentPane().add(comboBoxTipo);
        
        JLabel lblNewLabel_2 = new JLabel("Solicitar Constancia");
        lblNewLabel_2.setBounds(10, 11, 448, 34);
        lblNewLabel_2.setForeground(Color.BLACK);
        lblNewLabel_2.setFont(new Font("SimSun", Font.BOLD, 16));
        getContentPane().add(lblNewLabel_2);
        
        JScrollPane desplazamiento = new JScrollPane((Component) null);
        desplazamiento.setBounds(170, 85, 349, 197);
        desplazamiento.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        desplazamiento.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        getContentPane().add(desplazamiento);
        
        JLabel lblSeleccioneEvento = new JLabel("Seleccione Evento");
        lblSeleccioneEvento.setBounds(170, 61, 288, 14);
        lblSeleccioneEvento.setFont(new Font("SimSun", Font.PLAIN, 17));
        getContentPane().add(lblSeleccioneEvento);
        
        textField = new JTextField();
        textField.setBounds(10, 143, 150, 34);
        getContentPane().add(textField);
        textField.setColumns(10);
        
        JLabel lblMasInfo = new JLabel("Mas info");
        lblMasInfo.setFont(new Font("SimSun", Font.PLAIN, 17));
        lblMasInfo.setBounds(10, 118, 161, 14);
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
		
        btnCancelar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Ppal_Estudiante pEstudianteW = new Ppal_Estudiante();
				pEstudianteW.setVisible(true);
				pEstudianteW.setLocationRelativeTo(null);
        		dispose();
        	}
        });
    }
}