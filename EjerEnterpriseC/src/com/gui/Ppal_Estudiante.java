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
        getContentPane().setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));
        
        JButton btnNewButton = new JButton("");
        btnNewButton.setBounds(118, 59, 70, 70);
        btnNewButton.setIcon(new ImageIcon(Ppal_Estudiante.class.getResource("/PNG/newConst.png")));
        btnNewButton.setBackground(Color.WHITE);
        
        JButton btnNewButton_1 = new JButton("");
        btnNewButton_1.setEnabled(false);
        btnNewButton_1.setBounds(118, 177, 70, 70);
        btnNewButton_1.setIcon(new ImageIcon(Ppal_Estudiante.class.getResource("/PNG/searchEvent.png")));
        btnNewButton_1.setBackground(Color.WHITE);
        
        JButton btnNewButton_1_1 = new JButton("");
        btnNewButton_1_1.setBounds(652, 59, 70, 70);
        btnNewButton_1_1.setIcon(new ImageIcon(Ppal_Estudiante.class.getResource("/PNG/searchJust.png")));
        btnNewButton_1_1.setBackground(Color.WHITE);
        
        JButton btnNewButton_2 = new JButton("");
        btnNewButton_2.setEnabled(false);
        btnNewButton_2.setBounds(652, 177, 70, 70);
        btnNewButton_2.setIcon(new ImageIcon(Ppal_Estudiante.class.getResource("/PNG/newReclam.png")));
        btnNewButton_2.setBackground(Color.WHITE);
        
        JButton btnEliminarSolicitud = new JButton("");
        btnEliminarSolicitud.setBounds(287, 59, 70, 70);
        btnEliminarSolicitud.setIcon(new ImageIcon(Ppal_Estudiante.class.getResource("/PNG/searchReclam.png")));
        btnEliminarSolicitud.setBackground(Color.WHITE);
        
        JButton btnNewButton_4 = new JButton("");
        btnNewButton_4.setEnabled(false);
        btnNewButton_4.setBounds(118, 307, 70, 70);
        btnNewButton_4.setIcon(new ImageIcon(Ppal_Estudiante.class.getResource("/PNG/cancelEvento.png")));
        btnNewButton_4.setBackground(Color.WHITE);
        
        JButton btnNewButton_5 = new JButton("");
        btnNewButton_5.setEnabled(false);
        btnNewButton_5.setBounds(463, 177, 70, 70);
        btnNewButton_5.setIcon(new ImageIcon(Ppal_Estudiante.class.getResource("/PNG/newJust.png")));
        btnNewButton_5.setBackground(Color.WHITE);
        
        JButton btnNewButton_6 = new JButton("");
        btnNewButton_6.setBounds(654, 360, 70, 70);
        btnNewButton_6.setIcon(new ImageIcon(Ppal_Estudiante.class.getResource("/PNG/CloseSession.png")));
        btnNewButton_6.setBackground(Color.WHITE);
        
        JButton btnNewButton_9 = new JButton("");
        btnNewButton_9.setEnabled(false);
        btnNewButton_9.setBounds(287, 177, 70, 70);
        btnNewButton_9.setIcon(new ImageIcon(Ppal_Estudiante.class.getResource("/PNG/acceptEvento.png")));
        btnNewButton_9.setBackground(Color.WHITE);
        
        JLabel lblNewLabel = new JLabel("Nueva");
        lblNewLabel.setBounds(118, 135, 30, 15);
        lblNewLabel.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblBajaUsuario = new JLabel("Nuevo");
        lblBajaUsuario.setBounds(652, 253, 72, 15);
        lblBajaUsuario.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar = new JLabel("Nueva");
        lblModificar.setBounds(463, 253, 78, 15);
        lblModificar.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblUsuario = new JLabel("Justificaci\u00F3n");
        lblUsuario.setBounds(463, 274, 78, 15);
        lblUsuario.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar_1 = new JLabel("Asistencia a");
        lblModificar_1.setBounds(287, 253, 72, 15);
        lblModificar_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblReclamo = new JLabel("Evento");
        lblReclamo.setBounds(287, 274, 72, 15);
        lblReclamo.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar_1_1 = new JLabel("Buscar");
        lblModificar_1_1.setBounds(118, 253, 72, 15);
        lblModificar_1_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblJustificacin = new JLabel("Eventos");
        lblJustificacin.setBounds(118, 274, 42, 15);
        lblJustificacin.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar_1_1_1 = new JLabel("Eliminar");
        lblModificar_1_1_1.setBounds(287, 135, 72, 15);
        lblModificar_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblConstancia = new JLabel("Solicitud");
        lblConstancia.setBounds(287, 156, 78, 15);
        lblConstancia.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar_1_1_1_1_1_1 = new JLabel("Modificar");
        lblModificar_1_1_1_1_1_1.setBounds(652, 135, 72, 15);
        lblModificar_1_1_1_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblJustificaciones = new JLabel("Solicitudes");
        lblJustificaciones.setBounds(652, 156, 90, 15);
        lblJustificaciones.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar_1_1_1_1_1_1_1 = new JLabel("Cancelar asist.");
        lblModificar_1_1_1_1_1_1_1.setBounds(118, 383, 90, 15);
        lblModificar_1_1_1_1_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblConstancias = new JLabel("Evento");
        lblConstancias.setBounds(118, 404, 90, 15);
        lblConstancias.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar_1_1_1_1_1_1_1_1 = new JLabel("Cerrar Sesi\u00F3n");
        lblModificar_1_1_1_1_1_1_1_1.setBounds(654, 436, 78, 15);
        lblModificar_1_1_1_1_1_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblConstancia_1 = new JLabel("Constancia");
        lblConstancia_1.setBounds(118, 156, 60, 15);
        lblConstancia_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblConstancia_1_1 = new JLabel("Reclamo");
        lblConstancia_1_1.setBounds(652, 274, 60, 15);
        lblConstancia_1_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JButton btnNewButton_6_1 = new JButton("");
        btnNewButton_6_1.setBounds(463, 59, 70, 70);
        btnNewButton_6_1.setIcon(new ImageIcon(Ppal_Estudiante.class.getResource("/PNG/searchConst.png")));
        btnNewButton_6_1.setBackground(Color.WHITE);
        
        JLabel lblModificar_1_1_1_1_1_1_1_2 = new JLabel("Buscar");
        lblModificar_1_1_1_1_1_1_1_2.setBounds(463, 135, 72, 15);
        lblModificar_1_1_1_1_1_1_1_2.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblEvento = new JLabel("Solicitudes");
        lblEvento.setBounds(463, 156, 90, 15);
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
        setTitle("Administraci\u00F3n Secretar\u00EDa - Estudiante");
     
        setSize(838, 547);
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