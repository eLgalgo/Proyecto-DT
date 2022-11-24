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
import java.awt.SystemColor;
import java.awt.Toolkit;

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
        setIconImage(Toolkit.getDefaultToolkit().getImage(Ppal_Tutor.class.getResource("/PNG/logoUtec.png")));
        getContentPane().setBackground(SystemColor.menu);
        
        JButton btnNewButton = new JButton("");
        btnNewButton.setEnabled(false);
        btnNewButton.setBounds(69, 75, 70, 70);
        btnNewButton.setIcon(new ImageIcon(Ppal_Tutor.class.getResource("/PNG/icons8-event-accepted-tentatively-48 - copia.png")));
        btnNewButton.setBackground(Color.WHITE);
        
        JButton btnNewButton_1 = new JButton("");
        btnNewButton_1.setEnabled(false);
        btnNewButton_1.setBounds(69, 240, 70, 70);
        btnNewButton_1.setIcon(new ImageIcon(Ppal_Tutor.class.getResource("/PNG/searchEvent.png")));
        btnNewButton_1.setBackground(Color.WHITE);
        
        JButton btnNewButton_1_1 = new JButton("");
        btnNewButton_1_1.setEnabled(false);
        btnNewButton_1_1.setBounds(396, 241, 70, 70);
        btnNewButton_1_1.setIcon(new ImageIcon(Ppal_Tutor.class.getResource("/PNG/searchJust.png")));
        btnNewButton_1_1.setBackground(Color.WHITE);
        
        JButton btnNewButton_2 = new JButton("");
        btnNewButton_2.setEnabled(false);
        btnNewButton_2.setBounds(223, 75, 70, 70);
        btnNewButton_2.setIcon(new ImageIcon(Ppal_Tutor.class.getResource("/PNG/icons8-event-accepted-tentatively-48 - copia - copia.png")));
        btnNewButton_2.setBackground(Color.WHITE);
        
        JButton btnNewButton_3 = new JButton("");
        btnNewButton_3.setEnabled(false);
        btnNewButton_3.setBounds(223, 240, 70, 70);
        btnNewButton_3.setIcon(new ImageIcon(Ppal_Tutor.class.getResource("/PNG/searchReclam.png")));
        btnNewButton_3.setBackground(Color.WHITE);
        
        JButton btnNewButton_4 = new JButton("");
        btnNewButton_4.setEnabled(false);
        btnNewButton_4.setBounds(562, 241, 70, 70);
        btnNewButton_4.setIcon(new ImageIcon(Ppal_Tutor.class.getResource("/PNG/searchConst.png")));
        btnNewButton_4.setBackground(Color.WHITE);
        
        JButton btnNewButton_5 = new JButton("");
        btnNewButton_5.setEnabled(false);
        btnNewButton_5.setBounds(396, 75, 70, 70);
        btnNewButton_5.setIcon(new ImageIcon(Ppal_Tutor.class.getResource("/PNG/icons8-event-declined-48.png")));
        btnNewButton_5.setBackground(Color.WHITE);
        
        JButton btnNewButton_6 = new JButton("");
        btnNewButton_6.setBounds(562, 400, 70, 70);
        btnNewButton_6.setIcon(new ImageIcon(Ppal_Tutor.class.getResource("/PNG/CloseSession.png")));
        btnNewButton_6.setBackground(Color.WHITE);
        
        JButton btnNewButton_9 = new JButton("");
        btnNewButton_9.setEnabled(false);
        btnNewButton_9.setBounds(562, 75, 70, 70);
        btnNewButton_9.setIcon(new ImageIcon(Ppal_Tutor.class.getResource("/PNG/icons8-search-contacts-48.png")));
        btnNewButton_9.setBackground(Color.WHITE);
        
        JLabel lblNewLabel = new JLabel("Nuevo");
        lblNewLabel.setBounds(69, 156, 30, 15);
        lblNewLabel.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblBajaUsuario = new JLabel("Responder");
        lblBajaUsuario.setBounds(223, 156, 72, 15);
        lblBajaUsuario.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar = new JLabel("Cancelar");
        lblModificar.setBounds(396, 156, 70, 15);
        lblModificar.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblUsuario = new JLabel("Evento");
        lblUsuario.setBounds(396, 177, 36, 15);
        lblUsuario.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar_1 = new JLabel("Buscar");
        lblModificar_1.setBounds(562, 156, 72, 15);
        lblModificar_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblReclamo = new JLabel("Estudiantes");
        lblReclamo.setBounds(562, 177, 72, 15);
        lblReclamo.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar_1_1 = new JLabel("Buscar");
        lblModificar_1_1.setBounds(69, 321, 72, 15);
        lblModificar_1_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblJustificacin = new JLabel("Eventos");
        lblJustificacin.setBounds(69, 340, 42, 15);
        lblJustificacin.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar_1_1_1 = new JLabel("Buscar");
        lblModificar_1_1_1.setBounds(223, 321, 72, 15);
        lblModificar_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblConstancia = new JLabel("Reclamos");
        lblConstancia.setBounds(223, 340, 78, 15);
        lblConstancia.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar_1_1_1_1_1_1 = new JLabel("Buscar");
        lblModificar_1_1_1_1_1_1.setBounds(396, 321, 72, 15);
        lblModificar_1_1_1_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblJustificaciones = new JLabel("Justificaciones");
        lblJustificaciones.setBounds(396, 340, 90, 15);
        lblJustificaciones.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar_1_1_1_1_1_1_1 = new JLabel("Buscar");
        lblModificar_1_1_1_1_1_1_1.setBounds(562, 321, 72, 15);
        lblModificar_1_1_1_1_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblConstancias = new JLabel("Constancias");
        lblConstancias.setBounds(562, 340, 90, 15);
        lblConstancias.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar_1_1_1_1_1_1_1_1 = new JLabel("Cerrar Sesi\u00F3n");
        lblModificar_1_1_1_1_1_1_1_1.setBounds(562, 481, 78, 15);
        lblModificar_1_1_1_1_1_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblConstancia_1 = new JLabel("Evento");
        lblConstancia_1.setBounds(69, 177, 36, 15);
        lblConstancia_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblConstancia_1_1 = new JLabel("Evento");
        lblConstancia_1_1.setBounds(223, 177, 60, 15);
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
        lblNewLabel_1.setIcon(new ImageIcon(Ppal_Tutor.class.getResource("/PNG/logoUtec2.png")));
        lblNewLabel_1.setBounds(69, 382, 143, 114);
        getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("BIENVENIDO!");
        lblNewLabel_2.setFont(new Font("SimSun", Font.BOLD, 13));
        lblNewLabel_2.setBounds(28, 26, 90, 14);
        getContentPane().add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon(Ppal_Tutor.class.getResource("/PNG/NC 100.jpg")));
        lblNewLabel_3.setBounds(604, 507, 100, 24);
        getContentPane().add(lblNewLabel_3);
        
        JButton btnAyuda = new JButton("?");
        btnAyuda.setForeground(SystemColor.desktop);
        btnAyuda.setBackground(SystemColor.menu);
        btnAyuda.setFont(new Font("SimSun", Font.PLAIN, 13));
        btnAyuda.setBounds(662, 0, 42, 24);
        getContentPane().add(btnAyuda);
        setTitle("Administraci\u00F3n Secretar\u00EDa - Tutor");
       
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