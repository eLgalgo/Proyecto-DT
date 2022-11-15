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

    public Ppal_Estudiante() {
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
        btnNewButton_1.setBounds(118, 177, 70, 70);
        btnNewButton_1.setIcon(new ImageIcon(Ppal_Estudiante.class.getResource("/PNG/searchEvent.png")));
        btnNewButton_1.setBackground(Color.WHITE);
        
        JButton btnNewButton_1_1 = new JButton("");
        btnNewButton_1_1.setBounds(463, 177, 70, 70);
        btnNewButton_1_1.setIcon(new ImageIcon(Ppal_Estudiante.class.getResource("/PNG/searchJust.png")));
        btnNewButton_1_1.setBackground(Color.WHITE);
        
        JButton btnNewButton_2 = new JButton("");
        btnNewButton_2.setBounds(287, 59, 70, 70);
        btnNewButton_2.setIcon(new ImageIcon(Ppal_Estudiante.class.getResource("/PNG/newReclam.png")));
        btnNewButton_2.setBackground(Color.WHITE);
        
        JButton btnNewButton_3 = new JButton("");
        btnNewButton_3.setBounds(654, 59, 70, 70);
        btnNewButton_3.setIcon(new ImageIcon(Ppal_Estudiante.class.getResource("/PNG/searchReclam.png")));
        btnNewButton_3.setBackground(Color.WHITE);
        
        JButton btnNewButton_4 = new JButton("");
        btnNewButton_4.setBounds(118, 307, 70, 70);
        btnNewButton_4.setIcon(new ImageIcon(Ppal_Estudiante.class.getResource("/PNG/cancelEvento.png")));
        btnNewButton_4.setBackground(Color.WHITE);
        
        JButton btnNewButton_5 = new JButton("");
        btnNewButton_5.setBounds(463, 59, 70, 70);
        btnNewButton_5.setIcon(new ImageIcon(Ppal_Estudiante.class.getResource("/PNG/newJust.png")));
        btnNewButton_5.setBackground(Color.WHITE);
        
        JButton btnNewButton_6 = new JButton("");
        btnNewButton_6.setBounds(654, 360, 70, 70);
        btnNewButton_6.setIcon(new ImageIcon(Ppal_Estudiante.class.getResource("/PNG/CloseSession.png")));
        btnNewButton_6.setBackground(Color.WHITE);
        
        JButton btnNewButton_9 = new JButton("");
        btnNewButton_9.setBounds(287, 177, 70, 70);
        btnNewButton_9.setIcon(new ImageIcon(Ppal_Estudiante.class.getResource("/PNG/acceptEvento.png")));
        btnNewButton_9.setBackground(Color.WHITE);
        
        JLabel lblNewLabel = new JLabel("Nueva");
        lblNewLabel.setBounds(118, 135, 30, 15);
        lblNewLabel.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblBajaUsuario = new JLabel("Nuevo");
        lblBajaUsuario.setBounds(287, 135, 72, 15);
        lblBajaUsuario.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar = new JLabel("Nueva");
        lblModificar.setBounds(463, 135, 78, 15);
        lblModificar.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblUsuario = new JLabel("Justificaci\u00F3n");
        lblUsuario.setBounds(463, 156, 78, 15);
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
        
        JLabel lblModificar_1_1_1 = new JLabel("Buscar");
        lblModificar_1_1_1.setBounds(654, 135, 72, 15);
        lblModificar_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblConstancia = new JLabel("Reclamos");
        lblConstancia.setBounds(654, 156, 78, 15);
        lblConstancia.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar_1_1_1_1_1_1 = new JLabel("Buscar");
        lblModificar_1_1_1_1_1_1.setBounds(463, 253, 72, 15);
        lblModificar_1_1_1_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblJustificaciones = new JLabel("Justificaciones");
        lblJustificaciones.setBounds(463, 274, 90, 15);
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
        lblConstancia_1_1.setBounds(287, 156, 60, 15);
        lblConstancia_1_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JButton btnNewButton_6_1 = new JButton("");
        btnNewButton_6_1.setBounds(654, 177, 70, 70);
        btnNewButton_6_1.setIcon(new ImageIcon(Ppal_Estudiante.class.getResource("/PNG/searchConst.png")));
        btnNewButton_6_1.setBackground(Color.WHITE);
        
        JLabel lblModificar_1_1_1_1_1_1_1_2 = new JLabel("Buscar");
        lblModificar_1_1_1_1_1_1_1_2.setBounds(654, 253, 72, 15);
        lblModificar_1_1_1_1_1_1_1_2.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblEvento = new JLabel("Constancias");
        lblEvento.setBounds(654, 274, 90, 15);
        lblEvento.setFont(new Font("SimSun", Font.PLAIN, 12));
        getContentPane().setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setBounds(304, 307, 220, 179);
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setIcon(new ImageIcon("Z:\\ONE DRIVE\\OneDrive\\Escritorio\\PNG\\utec (1)_1.jpg"));
        getContentPane().add(lblNewLabel_1);
        getContentPane().add(btnNewButton);
        getContentPane().add(lblNewLabel);
        getContentPane().add(lblConstancia_1);
        getContentPane().add(btnNewButton_1);
        getContentPane().add(btnNewButton_3);
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
        JMenuBar jmb = new JMenuBar();
        jmb.setBackground(Color.WHITE);
        JMenu Archivo = new JMenu("Archivo");
        Archivo.setFont(new Font("SimSun", Font.PLAIN, 13));
        JMenuItem item;
        Archivo.add(file_NvaConst = new JMenuItem("Nueva constancia"));
        file_NvaConst.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        file_NvaConst.addActionListener(this);
        Archivo.add(file_NvoRecl = new JMenuItem("Nuevo reclamo"));
        file_NvoRecl.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        file_NvoRecl.addActionListener(this);
        
        JMenuItem item_1_1 = new JMenuItem("Nueva justificaci\u00F3n");
        item_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        Archivo.add(item_1_1);
        
        JMenuItem asistEvent = new JMenuItem("Asistencia a evento");
        asistEvent.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        Archivo.add(asistEvent);
        
        JMenuItem cancelEvent = new JMenuItem("Cancelar evento");
        cancelEvent.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        Archivo.add(cancelEvent);
        Archivo.addSeparator();
        
        JMenuItem file_LogOut = new JMenuItem("Cerrar sesi\u00F3n");
        file_LogOut.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        Archivo.add(file_LogOut);
        Archivo.add(file_exit = new JMenuItem("Salir"));
        file_exit.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        file_exit.addActionListener(this);
        jmb.add(Archivo);
        JMenu Modificacion = new JMenu("Modificaci\u00F3n");
        Modificacion.setFont(new Font("SimSun", Font.PLAIN, 13));
        Modificacion.add(edit_User = new JMenuItem("Modifiar usuario"));
        edit_User.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        edit_User.addActionListener(this);
        Icon tigerIcon = new ImageIcon("SmallTiger.gif");
        Modificacion.add(edit_Recl = new JMenuItem("Modificar reclamo", tigerIcon));
        edit_Recl.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        edit_Recl.setHorizontalTextPosition(JMenuItem.LEFT);
        edit_Recl.addActionListener(this);
        Modificacion.add(edit_Just = new JMenuItem("Modificar justificaci\u00F3n", tigerIcon));
        edit_Just.addActionListener(this);
        jmb.add(Modificacion);
        
        JMenuItem edit_Const = new JMenuItem("Modificar constancia", (Icon) null);
        Modificacion.add(edit_Const);
        JMenu Buscar = new JMenu("Buscar");
        Buscar.setFont(new Font("SimSun", Font.PLAIN, 13));
        ButtonGroup rbg = new ButtonGroup();
        
        JRadioButtonMenuItem find_Event = new JRadioButtonMenuItem("Buscar eventos");
        find_Event.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        Buscar.add(find_Event);
        JRadioButtonMenuItem find_Recl = new JRadioButtonMenuItem("Buscar reclamos");
        find_Recl.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        Buscar.add(find_Recl);
        rbg.add(find_Recl);
        find_Recl.addActionListener(this);
        find_Just = new JRadioButtonMenuItem("Buscar justificaciones");
        find_Just.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        Buscar.add(find_Just);
        rbg.add(find_Just);
        find_Just.addActionListener(this);
        find_Const = new JRadioButtonMenuItem("Buscar constancias");
        find_Const.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        Buscar.add(find_Const);
        rbg.add(find_Const);
        find_Const.addActionListener(this);
        jmb.add(Buscar);
        setJMenuBar(jmb);
        
        JMenu Ayuda = new JMenu("Ayuda");
        Ayuda.setFont(new Font("SimSun", Font.PLAIN, 13));
        jmb.add(Ayuda);
        
        JCheckBoxMenuItem hlp_1 = new JCheckBoxMenuItem("Puto el que Lea");
        hlp_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        Ayuda.add(hlp_1);
        
        JRadioButtonMenuItem hpl_2 = new JRadioButtonMenuItem("Comiste Gato");
        Ayuda.add(hpl_2);
        
        JRadioButtonMenuItem hlp_Help = new JRadioButtonMenuItem("Ayuda");
        Ayuda.add(hlp_Help);
        
        JRadioButtonMenuItem hlp_About = new JRadioButtonMenuItem("Sobre secretar\u00EDa");
        hlp_About.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        Ayuda.add(hlp_About);
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
        
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					Solicitud_Constancia solicitudW = new Solicitud_Constancia();
					solicitudW.setVisible(true);
	        		dispose();
				} catch (NamingException e1) {
					e1.printStackTrace();
				}
        		
        	}
        });
    }
    public static void main(String[] args) {
        new Ppal_Estudiante();
    }
}