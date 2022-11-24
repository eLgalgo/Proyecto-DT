package com.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.NamingException;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.UIManager;

import com.entities.ESTUDIANTE;
import com.exception.ServiciosException;
import java.awt.SystemColor;

public class Ppal_Estudiante extends JFrame
        implements ActionListener {
	private JMenuItem file_NvoRecl;
	private JMenuItem file_exit;
	private JMenuItem edit_User;
	private JMenuItem edit_Recl;
	private JRadioButtonMenuItem find_Just;
	private JRadioButtonMenuItem find_Const;
	private JMenuItem edit_Just;
	private JMenuItem file_NvaConst;

    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }

    public Ppal_Estudiante(ESTUDIANTE usuario) {
        super("Administración Secretaría");
        setResizable(false);
        setBackground(Color.WHITE);
        setIconImage(Toolkit.getDefaultToolkit().getImage("Z:\\ONE DRIVE\\OneDrive\\Escritorio\\PNG\\logoUtec.png"));
        getContentPane().setForeground(Color.WHITE);
        getContentPane().setBackground(SystemColor.menu);
        
        JButton btnNewButton = new JButton("");
        btnNewButton.setBounds(98, 59, 70, 70);
        btnNewButton.setIcon(new ImageIcon(Ppal_Estudiante.class.getResource("/PNG/newConst.png")));
        btnNewButton.setBackground(Color.WHITE);
        
        JButton btnNewButton_1 = new JButton("");
        btnNewButton_1.setEnabled(false);
        btnNewButton_1.setBounds(98, 203, 70, 70);
        btnNewButton_1.setIcon(new ImageIcon(Ppal_Estudiante.class.getResource("/PNG/searchEvent.png")));
        btnNewButton_1.setBackground(Color.WHITE);
        
        JButton btnNewButton_1_1 = new JButton("");
        btnNewButton_1_1.setBounds(619, 59, 70, 70);
        btnNewButton_1_1.setIcon(new ImageIcon(Ppal_Estudiante.class.getResource("/PNG/searchJust.png")));
        btnNewButton_1_1.setBackground(Color.WHITE);
        
        JButton btnNewButton_2 = new JButton("");
        btnNewButton_2.setEnabled(false);
        btnNewButton_2.setBounds(619, 203, 70, 70);
        btnNewButton_2.setIcon(new ImageIcon(Ppal_Estudiante.class.getResource("/PNG/newReclam.png")));
        btnNewButton_2.setBackground(Color.WHITE);
        
        JButton btnEliminarSolicitud = new JButton("");
        btnEliminarSolicitud.setBounds(268, 59, 70, 70);
        btnEliminarSolicitud.setIcon(new ImageIcon(Ppal_Estudiante.class.getResource("/PNG/searchReclam.png")));
        btnEliminarSolicitud.setBackground(Color.WHITE);
        
        JButton btnNewButton_4 = new JButton("");
        btnNewButton_4.setEnabled(false);
        btnNewButton_4.setBounds(268, 342, 70, 70);
        btnNewButton_4.setIcon(new ImageIcon(Ppal_Estudiante.class.getResource("/PNG/cancelEvento.png")));
        btnNewButton_4.setBackground(Color.WHITE);
        
        JButton btnNewButton_5 = new JButton("");
        btnNewButton_5.setEnabled(false);
        btnNewButton_5.setBounds(442, 203, 70, 70);
        btnNewButton_5.setIcon(new ImageIcon(Ppal_Estudiante.class.getResource("/PNG/newJust.png")));
        btnNewButton_5.setBackground(Color.WHITE);
        
        JButton btnNewButton_6 = new JButton("");
        btnNewButton_6.setBounds(619, 389, 70, 70);
        btnNewButton_6.setIcon(new ImageIcon(Ppal_Estudiante.class.getResource("/PNG/CloseSession.png")));
        btnNewButton_6.setBackground(Color.WHITE);
        
        JButton btnNewButton_9 = new JButton("");
        btnNewButton_9.setEnabled(false);
        btnNewButton_9.setBounds(268, 203, 70, 70);
        btnNewButton_9.setIcon(new ImageIcon(Ppal_Estudiante.class.getResource("/PNG/acceptEvento.png")));
        btnNewButton_9.setBackground(Color.WHITE);
        
        JLabel lblNewLabel = new JLabel("Nueva");
        lblNewLabel.setBounds(98, 140, 30, 15);
        lblNewLabel.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblBajaUsuario = new JLabel("Nuevo");
        lblBajaUsuario.setBounds(619, 284, 72, 15);
        lblBajaUsuario.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar = new JLabel("Nueva");
        lblModificar.setBounds(442, 284, 78, 15);
        lblModificar.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblUsuario = new JLabel("Justificaci\u00F3n");
        lblUsuario.setBounds(442, 303, 78, 15);
        lblUsuario.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar_1 = new JLabel("Asistencia a");
        lblModificar_1.setBounds(268, 284, 72, 15);
        lblModificar_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblReclamo = new JLabel("Evento");
        lblReclamo.setBounds(268, 303, 72, 15);
        lblReclamo.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar_1_1 = new JLabel("Buscar");
        lblModificar_1_1.setBounds(98, 284, 72, 15);
        lblModificar_1_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblJustificacin = new JLabel("Eventos");
        lblJustificacin.setBounds(98, 303, 42, 15);
        lblJustificacin.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar_1_1_1 = new JLabel("Eliminar");
        lblModificar_1_1_1.setBounds(268, 140, 72, 15);
        lblModificar_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblConstancia = new JLabel("Solicitud");
        lblConstancia.setBounds(268, 161, 78, 15);
        lblConstancia.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar_1_1_1_1_1_1 = new JLabel("Modificar");
        lblModificar_1_1_1_1_1_1.setBounds(619, 140, 72, 15);
        lblModificar_1_1_1_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblJustificaciones = new JLabel("Solicitudes");
        lblJustificaciones.setBounds(619, 161, 90, 15);
        lblJustificaciones.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar_1_1_1_1_1_1_1 = new JLabel("Cancelar asist.");
        lblModificar_1_1_1_1_1_1_1.setBounds(268, 423, 90, 15);
        lblModificar_1_1_1_1_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblConstancias = new JLabel("Evento");
        lblConstancias.setBounds(268, 444, 90, 15);
        lblConstancias.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar_1_1_1_1_1_1_1_1 = new JLabel("Cerrar Sesi\u00F3n");
        lblModificar_1_1_1_1_1_1_1_1.setBounds(619, 470, 78, 15);
        lblModificar_1_1_1_1_1_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblConstancia_1 = new JLabel("Constancia");
        lblConstancia_1.setBounds(98, 161, 60, 15);
        lblConstancia_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblConstancia_1_1 = new JLabel("Reclamo");
        lblConstancia_1_1.setBounds(619, 303, 60, 15);
        lblConstancia_1_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JButton btnNewButton_6_1 = new JButton("");
        btnNewButton_6_1.setBounds(442, 59, 70, 70);
        btnNewButton_6_1.setIcon(new ImageIcon(Ppal_Estudiante.class.getResource("/PNG/searchConst.png")));
        btnNewButton_6_1.setBackground(Color.WHITE);
        
        JLabel lblModificar_1_1_1_1_1_1_1_2 = new JLabel("Buscar");
        lblModificar_1_1_1_1_1_1_1_2.setBounds(442, 140, 72, 15);
        lblModificar_1_1_1_1_1_1_1_2.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblEvento = new JLabel("Solicitudes");
        lblEvento.setBounds(442, 161, 90, 15);
        lblEvento.setFont(new Font("SimSun", Font.PLAIN, 12));
        getContentPane().setLayout(null);
        getContentPane().add(btnNewButton);
        getContentPane().add(lblNewLabel);
        getContentPane().add(lblConstancia_1);
        getContentPane().add(btnNewButton_1);
        getContentPane().add(btnEliminarSolicitud);
        getContentPane().add(lblModificar_1_1_1);
        getContentPane().add(lblConstancia);
        getContentPane().add(btnNewButton_2);
        getContentPane().add(lblBajaUsuario);
        getContentPane().add(lblConstancia_1_1);
        getContentPane().add(lblModificar_1_1);
        getContentPane().add(lblJustificacin);
        getContentPane().add(btnNewButton_4);
        getContentPane().add(lblModificar_1_1_1_1_1_1_1);
        getContentPane().add(lblConstancias);
        getContentPane().add(btnNewButton_5);
        getContentPane().add(lblModificar);
        getContentPane().add(lblUsuario);
        getContentPane().add(btnNewButton_1_1);
        getContentPane().add(lblModificar_1_1_1_1_1_1);
        getContentPane().add(lblJustificaciones);
        getContentPane().add(lblModificar_1_1_1_1_1_1_1_1);
        getContentPane().add(lblEvento);
        getContentPane().add(btnNewButton_6_1);
        getContentPane().add(lblReclamo);
        getContentPane().add(lblModificar_1);
        getContentPane().add(btnNewButton_9);
        getContentPane().add(lblModificar_1_1_1_1_1_1_1_2);
        getContentPane().add(btnNewButton_6);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(Ppal_Estudiante.class.getResource("/PNG/logoUtec2.png")));
        lblNewLabel_1.setBounds(66, 382, 146, 103);
        getContentPane().add(lblNewLabel_1);
        
        JButton btnAyuda = new JButton("?");
        btnAyuda.setForeground(Color.BLACK);
        btnAyuda.setFont(new Font("SimSun", Font.PLAIN, 13));
        btnAyuda.setBackground(SystemColor.menu);
        btnAyuda.setBounds(744, 0, 42, 24);
        getContentPane().add(btnAyuda);
        
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon(Ppal_Estudiante.class.getResource("/PNG/NC 100.jpg")));
        lblNewLabel_3.setBounds(686, 511, 100, 24);
        getContentPane().add(lblNewLabel_3);
        
        JLabel lblNewLabel_2 = new JLabel("BIENVENIDO!");
        lblNewLabel_2.setFont(new Font("SimSun", Font.BOLD, 13));
        lblNewLabel_2.setBounds(38, 24, 90, 14);
        getContentPane().add(lblNewLabel_2);
        setTitle("Administraci\u00F3n Secretar\u00EDa - Estudiante");
     
        setSize(802, 574);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        //Logica botones
        
        btnNewButton_6.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Login login = null;
				try {
					login = new Login();
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		login.getFrame().setVisible(true);
        		dispose();
        	}
        });
        btnEliminarSolicitud.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					EliminarSolicitud elW = new EliminarSolicitud(usuario);
					elW.setVisible(true);
					dispose();
				} catch (NamingException | ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		
        	}
        });
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					Solicitud_Constancia solicitudW = new Solicitud_Constancia(usuario);
					solicitudW.setVisible(true);
	        		dispose();
				} catch (NamingException e1) {
					e1.printStackTrace();
				} catch (ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		
        	}
        });
        
        btnNewButton_6_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					Listar_SConstancias listSW = new Listar_SConstancias(usuario, usuario, 0);
					listSW.setVisible(true);
					dispose();
				} catch (NamingException e1) {
					e1.printStackTrace();
				} catch (ServiciosException e1) {
					e1.printStackTrace();
				}
        	}
        });
        
        //Modificar Solicitudes
        
        btnNewButton_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					ModificarSolicitud1 modW = new ModificarSolicitud1(usuario);
					modW.setVisible(true);
					dispose();
				} catch (NamingException e1) {
					e1.printStackTrace();
				} catch (ServiciosException e1) {
					e1.printStackTrace();
				}
        	}
        });
    }
}