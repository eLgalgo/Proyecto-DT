package com.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.InitialContext;
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

import com.exception.ServiciosException;
import com.services.AnalistaBeanRemote;
import com.services.EstudianteBeanRemote;
import com.services.TutorBeanRemote;
import com.services.UsuarioBeanRemote;

public class Ppal_Analista extends JFrame
        implements ActionListener {
	private JMenuItem file_BajaUsr;
	private JMenuItem file_exit;
	private JMenuItem edit_User;
	private JMenuItem edit_Recl;
	private JRadioButtonMenuItem find_Just;
	private JRadioButtonMenuItem find_Const;
	private JMenuItem edit_Just;
	private JMenuItem file_AltaUsr;

    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }

    public Ppal_Analista() throws NamingException {
        super("Administración Secretaría");
        getContentPane().setBackground(Color.WHITE);
        
        JButton btnNewButton = new JButton("");
     
        btnNewButton.setBounds(118, 59, 70, 70);
        btnNewButton.setIcon(new ImageIcon(Ppal_Analista.class.getResource("/PNG/addUser.png")));
        btnNewButton.setBackground(Color.WHITE);
        
        JButton btnNewButton_1 = new JButton("");
        
        btnNewButton_1.setBounds(118, 193, 70, 70);
        btnNewButton_1.setIcon(new ImageIcon(Ppal_Analista.class.getResource("/PNG/searchUser.png")));
        btnNewButton_1.setBackground(Color.WHITE);
        
        JButton btnNewButton_1_1 = new JButton("");
        btnNewButton_1_1.setBounds(118, 323, 70, 70);
        btnNewButton_1_1.setIcon(new ImageIcon(Ppal_Analista.class.getResource("/PNG/searchJust.png")));
        btnNewButton_1_1.setBackground(Color.WHITE);
        
        JButton btnNewButton_2 = new JButton("");
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					Baja_Usuario baja = new Baja_Usuario();
					baja.getFrame().setVisible(true);
					baja.getFrame().setLocationRelativeTo(null);
					dispose();
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        btnNewButton_2.setBounds(287, 59, 70, 70);
        btnNewButton_2.setIcon(new ImageIcon(Ppal_Analista.class.getResource("/PNG/deleteUser.png")));
        btnNewButton_2.setBackground(Color.WHITE);
        
        JButton btnNewButton_3 = new JButton("");
        btnNewButton_3.setBounds(287, 193, 70, 70);
        btnNewButton_3.setIcon(new ImageIcon(Ppal_Analista.class.getResource("/PNG/searchReclam.png")));
        btnNewButton_3.setBackground(Color.WHITE);
        
        JButton btnNewButton_4 = new JButton("");
        btnNewButton_4.setBounds(287, 323, 70, 70);
        btnNewButton_4.setIcon(new ImageIcon(Ppal_Analista.class.getResource("/PNG/searchConst.png")));
        btnNewButton_4.setBackground(Color.WHITE);
        
        JButton btnNewButton_5 = new JButton("");
        btnNewButton_5.setBounds(465, 59, 70, 70);
        btnNewButton_5.setIcon(new ImageIcon(Ppal_Analista.class.getResource("/PNG/modUser.png")));
        btnNewButton_5.setBackground(Color.WHITE);
        
        JButton btnNewButton_6 = new JButton("");
        btnNewButton_6.setBounds(638, 389, 70, 70);
        btnNewButton_6.setIcon(new ImageIcon(Ppal_Analista.class.getResource("/PNG/CloseSession.png")));
        btnNewButton_6.setBackground(Color.WHITE);
        
        JButton btnNewButton_7 = new JButton("");
        btnNewButton_7.setBounds(465, 193, 70, 70);
        btnNewButton_7.setIcon(new ImageIcon(Ppal_Analista.class.getResource("/PNG/modJust.png")));
        btnNewButton_7.setBackground(Color.WHITE);
        
        JButton btnNewButton_8 = new JButton("");
        btnNewButton_8.setBounds(638, 193, 70, 70);
        btnNewButton_8.setIcon(new ImageIcon(Ppal_Analista.class.getResource("/PNG/modConst.png")));
        btnNewButton_8.setBackground(Color.WHITE);
        
        JButton btnNewButton_9 = new JButton("");
        btnNewButton_9.setBounds(636, 59, 70, 70);
        btnNewButton_9.setIcon(new ImageIcon(Ppal_Analista.class.getResource("/PNG/modReclam.png")));
        btnNewButton_9.setBackground(Color.WHITE);
        
        JLabel lblNewLabel = new JLabel("Alta Usuario");
        lblNewLabel.setBounds(118, 135, 72, 15);
        lblNewLabel.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblBajaUsuario = new JLabel("Baja Usuario");
        lblBajaUsuario.setBounds(287, 135, 72, 15);
        lblBajaUsuario.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar = new JLabel("Modificar");
        lblModificar.setBounds(465, 135, 72, 15);
        lblModificar.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblUsuario = new JLabel("Usuario");
        lblUsuario.setBounds(465, 156, 72, 15);
        lblUsuario.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar_1 = new JLabel("Modificar");
        lblModificar_1.setBounds(636, 135, 72, 15);
        lblModificar_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblReclamo = new JLabel("Reclamo");
        lblReclamo.setBounds(636, 156, 72, 15);
        lblReclamo.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar_1_1 = new JLabel("Buscar");
        lblModificar_1_1.setBounds(118, 269, 72, 15);
        lblModificar_1_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblJustificacin = new JLabel("Usuarios");
        lblJustificacin.setBounds(118, 290, 48, 15);
        lblJustificacin.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar_1_1_1 = new JLabel("Buscar");
        lblModificar_1_1_1.setBounds(287, 269, 72, 15);
        lblModificar_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblConstancia = new JLabel("Reclamos");
        lblConstancia.setBounds(287, 290, 78, 15);
        lblConstancia.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar_1_1_1_1 = new JLabel("Modificar");
        lblModificar_1_1_1_1.setBounds(465, 269, 72, 15);
        lblModificar_1_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblUsuarios = new JLabel("Justificaciones");
        lblUsuarios.setBounds(465, 290, 90, 15);
        lblUsuarios.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar_1_1_1_1_1 = new JLabel("Modificar");
        lblModificar_1_1_1_1_1.setBounds(638, 269, 72, 15);
        lblModificar_1_1_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblReclamos = new JLabel("Constancias");
        lblReclamos.setBounds(638, 290, 78, 15);
        lblReclamos.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar_1_1_1_1_1_1 = new JLabel("Buscar");
        lblModificar_1_1_1_1_1_1.setBounds(118, 399, 72, 15);
        lblModificar_1_1_1_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblJustificaciones = new JLabel("Justificaciones");
        lblJustificaciones.setBounds(118, 420, 90, 15);
        lblJustificaciones.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar_1_1_1_1_1_1_1 = new JLabel("Buscar");
        lblModificar_1_1_1_1_1_1_1.setBounds(287, 399, 72, 15);
        lblModificar_1_1_1_1_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblConstancias = new JLabel("Constancias");
        lblConstancias.setBounds(287, 420, 90, 15);
        lblConstancias.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar_1_1_1_1_1_1_1_1 = new JLabel("Cerrar Sesi\u00F3n");
        lblModificar_1_1_1_1_1_1_1_1.setBounds(638, 465, 78, 15);
        lblModificar_1_1_1_1_1_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setBounds(465, 399, 0, 0);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("Z:\\ONE DRIVE\\OneDrive\\Escritorio\\PNG\\utec (1)_1.jpg"));
        lblNewLabel_2.setBounds(387, 335, 220, 158);
        getContentPane().setLayout(null);
        getContentPane().add(lblJustificaciones);
        getContentPane().add(lblModificar_1_1_1_1_1_1);
        getContentPane().add(lblJustificacin);
        getContentPane().add(lblModificar_1_1);
        getContentPane().add(btnNewButton);
        getContentPane().add(lblNewLabel);
        getContentPane().add(btnNewButton_2);
        getContentPane().add(lblBajaUsuario);
        getContentPane().add(btnNewButton_5);
        getContentPane().add(lblModificar);
        getContentPane().add(lblUsuario);
        getContentPane().add(lblReclamo);
        getContentPane().add(lblModificar_1);
        getContentPane().add(btnNewButton_9);
        getContentPane().add(btnNewButton_1);
        getContentPane().add(btnNewButton_3);
        getContentPane().add(lblModificar_1_1_1);
        getContentPane().add(lblConstancia);
        getContentPane().add(btnNewButton_1_1);
        getContentPane().add(lblModificar_1_1_1_1_1_1_1);
        getContentPane().add(btnNewButton_4);
        getContentPane().add(lblConstancias);
        getContentPane().add(lblNewLabel_1);
        getContentPane().add(btnNewButton_7);
        getContentPane().add(lblModificar_1_1_1_1);
        getContentPane().add(lblUsuarios);
        getContentPane().add(lblNewLabel_2);
        getContentPane().add(lblReclamos);
        getContentPane().add(lblModificar_1_1_1_1_1);
        getContentPane().add(btnNewButton_8);
        getContentPane().add(lblModificar_1_1_1_1_1_1_1_1);
        getContentPane().add(btnNewButton_6);
        setTitle("Administraci\u00F3n Secretar\u00EDa - Analista");
        JMenuBar jmb = new JMenuBar();
        jmb.setBackground(UIManager.getColor("InternalFrame.inactiveTitleBackground"));
        JMenu Archivo = new JMenu("Archivo");
        Archivo.setFont(new Font("SimSun", Font.PLAIN, 13));
        @SuppressWarnings("unused")
		JMenuItem item;
        Archivo.add(file_AltaUsr = new JMenuItem("Alta de usuario"));
        file_AltaUsr.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        file_AltaUsr.addActionListener(this);
        Archivo.add(file_BajaUsr = new JMenuItem("Baja de usuario"));
        file_BajaUsr.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        file_BajaUsr.addActionListener(this);
        
        JMenuItem item_1_1 = new JMenuItem("Alta de ITR");
        item_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        Archivo.add(item_1_1);
        
        JMenuItem item_1_1_1 = new JMenuItem("Baja de ITR");
        item_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        Archivo.add(item_1_1_1);
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
        JCheckBoxMenuItem find_User = new JCheckBoxMenuItem("Buscar usuarios");
        find_User.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        find_User.addActionListener(this);
        Buscar.add(find_User);
        ButtonGroup rbg = new ButtonGroup();
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
        
        JRadioButtonMenuItem hpl_2 = new JRadioButtonMenuItem("Choice 1");
        Ayuda.add(hpl_2);
        
        JRadioButtonMenuItem hlp_Help = new JRadioButtonMenuItem("Ayuda");
        Ayuda.add(hlp_Help);
        
        JRadioButtonMenuItem hlp_About = new JRadioButtonMenuItem("Sobre secretar\u00EDa");
        hlp_About.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        Ayuda.add(hlp_About);
        setSize(838, 579);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        //Logica botones
        
        @SuppressWarnings("unused")
		EstudianteBeanRemote estudianteBean = (EstudianteBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/EstudianteBean!com.services.EstudianteBeanRemote");
		
		@SuppressWarnings("unused")
		TutorBeanRemote tutorBean = (TutorBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/TutorBean!com.services.TutorBeanRemote");
		
		@SuppressWarnings("unused")
		AnalistaBeanRemote analistaBean = (AnalistaBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/AnalistaBean!com.services.AnalistaBeanRemote");
		
		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/UsuarioBean!com.services.UsuarioBeanRemote");
        
		   btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        	Alta_Usuario_Analista ALTAUA=null;
	        	try {
					ALTAUA = new Alta_Usuario_Analista();
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	ALTAUA.getFrame().setVisible(true);
        		dispose();
	        	} });
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
        
        btnNewButton_5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					ListUsers table = new ListUsers(usuarioBean.listAllUsers());
					table.getFrame().setVisible(true);
					table.getFrame().setLocationRelativeTo(null);
					dispose();
				} catch (ServiciosException | NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					ListUsers table = new ListUsers(usuarioBean.listAllUsers());
					table.getFrame().setVisible(true);
					table.getFrame().setLocationRelativeTo(null);
					dispose();
				} catch (ServiciosException | NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
    }
}