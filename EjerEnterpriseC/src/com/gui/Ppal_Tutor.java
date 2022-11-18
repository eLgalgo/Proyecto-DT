package com.gui;

import java.awt.Color;
import java.awt.Font;
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

import com.entities.TUTOR;

public class Ppal_Tutor extends JFrame
        implements ActionListener {
	private JMenuItem file_SupEvento;
	private JMenuItem file_exit;
	private JMenuItem edit_User;
	private JMenuItem edit_ModEvento;
	private JRadioButtonMenuItem find_Just;
	private JRadioButtonMenuItem find_Const;
	private JMenuItem edit_Just;
	private JMenuItem file_NvaEvento;

    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }

    public Ppal_Tutor(TUTOR usuario) {
        super("Administración Secretaría");
        getContentPane().setBackground(Color.WHITE);
        
        JButton btnNewButton = new JButton("");
        btnNewButton.setBounds(69, 59, 70, 70);
        btnNewButton.setIcon(new ImageIcon(Ppal_Tutor.class.getResource("/PNG/icons8-event-accepted-tentatively-48 - copia.png")));
        btnNewButton.setBackground(Color.WHITE);
        
        JButton btnNewButton_1 = new JButton("");
        btnNewButton_1.setBounds(69, 210, 70, 70);
        btnNewButton_1.setIcon(new ImageIcon(Ppal_Tutor.class.getResource("/PNG/searchEvent.png")));
        btnNewButton_1.setBackground(Color.WHITE);
        
        JButton btnNewButton_1_1 = new JButton("");
        btnNewButton_1_1.setBounds(396, 210, 70, 70);
        btnNewButton_1_1.setIcon(new ImageIcon(Ppal_Tutor.class.getResource("/PNG/searchJust.png")));
        btnNewButton_1_1.setBackground(Color.WHITE);
        
        JButton btnNewButton_2 = new JButton("");
        btnNewButton_2.setBounds(223, 59, 70, 70);
        btnNewButton_2.setIcon(new ImageIcon(Ppal_Tutor.class.getResource("/PNG/icons8-event-accepted-tentatively-48 - copia - copia.png")));
        btnNewButton_2.setBackground(Color.WHITE);
        
        JButton btnNewButton_3 = new JButton("");
        btnNewButton_3.setBounds(223, 210, 70, 70);
        btnNewButton_3.setIcon(new ImageIcon(Ppal_Tutor.class.getResource("/PNG/searchReclam.png")));
        btnNewButton_3.setBackground(Color.WHITE);
        
        JButton btnNewButton_4 = new JButton("");
        btnNewButton_4.setBounds(562, 210, 70, 70);
        btnNewButton_4.setIcon(new ImageIcon(Ppal_Tutor.class.getResource("/PNG/searchConst.png")));
        btnNewButton_4.setBackground(Color.WHITE);
        
        JButton btnNewButton_5 = new JButton("");
        btnNewButton_5.setBounds(396, 59, 70, 70);
        btnNewButton_5.setIcon(new ImageIcon(Ppal_Tutor.class.getResource("/PNG/icons8-event-declined-48.png")));
        btnNewButton_5.setBackground(Color.WHITE);
        
        JButton btnNewButton_6 = new JButton("");
        btnNewButton_6.setBounds(562, 363, 70, 70);
        btnNewButton_6.setIcon(new ImageIcon(Ppal_Tutor.class.getResource("/PNG/CloseSession.png")));
        btnNewButton_6.setBackground(Color.WHITE);
        
        JButton btnNewButton_9 = new JButton("");
        btnNewButton_9.setBounds(562, 59, 70, 70);
        btnNewButton_9.setIcon(new ImageIcon(Ppal_Tutor.class.getResource("/PNG/icons8-search-contacts-48.png")));
        btnNewButton_9.setBackground(Color.WHITE);
        
        JLabel lblNewLabel = new JLabel("Nuevo");
        lblNewLabel.setBounds(69, 135, 30, 15);
        lblNewLabel.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblBajaUsuario = new JLabel("Responder");
        lblBajaUsuario.setBounds(223, 135, 72, 15);
        lblBajaUsuario.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar = new JLabel("Cancelar");
        lblModificar.setBounds(396, 135, 70, 15);
        lblModificar.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblUsuario = new JLabel("Evento");
        lblUsuario.setBounds(396, 156, 36, 15);
        lblUsuario.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar_1 = new JLabel("Buscar");
        lblModificar_1.setBounds(562, 135, 72, 15);
        lblModificar_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblReclamo = new JLabel("Estudiantes");
        lblReclamo.setBounds(562, 156, 72, 15);
        lblReclamo.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar_1_1 = new JLabel("Buscar");
        lblModificar_1_1.setBounds(69, 286, 72, 15);
        lblModificar_1_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblJustificacin = new JLabel("Eventos");
        lblJustificacin.setBounds(69, 307, 42, 15);
        lblJustificacin.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar_1_1_1 = new JLabel("Buscar");
        lblModificar_1_1_1.setBounds(223, 286, 72, 15);
        lblModificar_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblConstancia = new JLabel("Reclamos");
        lblConstancia.setBounds(223, 307, 78, 15);
        lblConstancia.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar_1_1_1_1_1_1 = new JLabel("Buscar");
        lblModificar_1_1_1_1_1_1.setBounds(396, 286, 72, 15);
        lblModificar_1_1_1_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblJustificaciones = new JLabel("Justificaciones");
        lblJustificaciones.setBounds(396, 307, 90, 15);
        lblJustificaciones.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar_1_1_1_1_1_1_1 = new JLabel("Buscar");
        lblModificar_1_1_1_1_1_1_1.setBounds(562, 286, 72, 15);
        lblModificar_1_1_1_1_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblConstancias = new JLabel("Constancias");
        lblConstancias.setBounds(562, 307, 90, 15);
        lblConstancias.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar_1_1_1_1_1_1_1_1 = new JLabel("Cerrar Sesi\u00F3n");
        lblModificar_1_1_1_1_1_1_1_1.setBounds(562, 439, 78, 15);
        lblModificar_1_1_1_1_1_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblConstancia_1 = new JLabel("Evento");
        lblConstancia_1.setBounds(69, 156, 36, 15);
        lblConstancia_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblConstancia_1_1 = new JLabel("Evento");
        lblConstancia_1_1.setBounds(223, 156, 60, 15);
        lblConstancia_1_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        getContentPane().setLayout(null);
        getContentPane().add(btnNewButton);
        getContentPane().add(lblNewLabel);
        getContentPane().add(lblConstancia_1);
        getContentPane().add(btnNewButton_1);
        getContentPane().add(lblJustificacin);
        getContentPane().add(lblConstancia);
        getContentPane().add(lblBajaUsuario);
        getContentPane().add(btnNewButton_2);
        getContentPane().add(lblConstancia_1_1);
        getContentPane().add(lblModificar_1_1_1);
        getContentPane().add(btnNewButton_3);
        getContentPane().add(lblModificar_1_1);
        getContentPane().add(btnNewButton_5);
        getContentPane().add(lblUsuario);
        getContentPane().add(lblModificar);
        getContentPane().add(btnNewButton_1_1);
        getContentPane().add(lblJustificaciones);
        getContentPane().add(lblModificar_1);
        getContentPane().add(btnNewButton_9);
        getContentPane().add(lblReclamo);
        getContentPane().add(btnNewButton_4);
        getContentPane().add(lblConstancias);
        getContentPane().add(lblModificar_1_1_1_1_1_1_1);
        getContentPane().add(btnNewButton_6);
        getContentPane().add(lblModificar_1_1_1_1_1_1_1_1);
        getContentPane().add(lblModificar_1_1_1_1_1_1);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("Z:\\ONE DRIVE\\OneDrive\\Escritorio\\PNG\\utec (1)_1.jpg"));
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setBounds(233, 340, 220, 166);
        getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("");
        lblNewLabel_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1.setBounds(233, 340, 220, 179);
        getContentPane().add(lblNewLabel_1_1);
        setTitle("Administraci\u00F3n Secretar\u00EDa - Tutor");
        JMenuBar jmb = new JMenuBar();
        jmb.setBackground(UIManager.getColor("InternalFrame.inactiveTitleBackground"));
        JMenu Archivo = new JMenu("Archivo");
        Archivo.setFont(new Font("SimSun", Font.PLAIN, 13));
        JMenuItem item;
        Archivo.add(file_NvaEvento = new JMenuItem("Nueva evento"));
        file_NvaEvento.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        file_NvaEvento.addActionListener(this);
        
        JMenuItem item_RespEvento = new JMenuItem("Responder evento");
        item_RespEvento.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        Archivo.add(item_RespEvento);
        
        JMenuItem cancelEvent = new JMenuItem("Cancelar evento");
        cancelEvent.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        Archivo.add(cancelEvent);
        Archivo.add(file_SupEvento = new JMenuItem("VACIO"));
        file_SupEvento.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        file_SupEvento.addActionListener(this);
        
        JMenuItem asistEvent = new JMenuItem("VACIO");
        asistEvent.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        Archivo.add(asistEvent);
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
        Modificacion.add(edit_ModEvento = new JMenuItem("Modificar evento", tigerIcon));
        edit_ModEvento.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        edit_ModEvento.setHorizontalTextPosition(JMenuItem.LEFT);
        edit_ModEvento.addActionListener(this);
        Modificacion.add(edit_Just = new JMenuItem("VACIO", tigerIcon));
        edit_Just.addActionListener(this);
        jmb.add(Modificacion);
        
        JMenuItem edit_Const = new JMenuItem("VACIO", (Icon) null);
        Modificacion.add(edit_Const);
        JMenu Buscar = new JMenu("Buscar");
        Buscar.setFont(new Font("SimSun", Font.PLAIN, 13));
        ButtonGroup rbg = new ButtonGroup();
        
        JRadioButtonMenuItem find_Estudiantes = new JRadioButtonMenuItem("Buscar estudiantes");
        find_Estudiantes.setIcon(null);
        find_Estudiantes.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        Buscar.add(find_Estudiantes);
        
        JRadioButtonMenuItem find_Eventos = new JRadioButtonMenuItem("Buscar eventos");
        find_Eventos.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        Buscar.add(find_Eventos);
        JRadioButtonMenuItem find_Reclamos = new JRadioButtonMenuItem("Buscar reclamos");
        find_Reclamos.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        Buscar.add(find_Reclamos);
        rbg.add(find_Reclamos);
        find_Reclamos.addActionListener(this);
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
        
        JCheckBoxMenuItem hlp_1 = new JCheckBoxMenuItem("Ayuda 1");
        hlp_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        Ayuda.add(hlp_1);
        
        JRadioButtonMenuItem hpl_2 = new JRadioButtonMenuItem("Ayuda 2");
        Ayuda.add(hpl_2);
        
        JRadioButtonMenuItem hlp_Help = new JRadioButtonMenuItem("Ayuda 3");
        Ayuda.add(hlp_Help);
        
        JRadioButtonMenuItem hlp_About = new JRadioButtonMenuItem("Sobre secretar\u00EDa");
        hlp_About.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        Ayuda.add(hlp_About);
        setSize(720, 570);
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
    }
}