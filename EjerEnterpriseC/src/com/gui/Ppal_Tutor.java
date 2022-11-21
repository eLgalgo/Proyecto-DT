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
import com.entities.USUARIO;
import com.exception.ServiciosException;

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

    public Ppal_Tutor(USUARIO usuario) {
        super("Administración Secretaría");
        getContentPane().setBackground(Color.WHITE);
        
        JButton btnNewButton = new JButton("");
        btnNewButton.setEnabled(false);
        btnNewButton.setBounds(69, 59, 70, 70);
        btnNewButton.setIcon(new ImageIcon(Ppal_Tutor.class.getResource("/PNG/icons8-event-accepted-tentatively-48 - copia.png")));
        btnNewButton.setBackground(Color.WHITE);
        
        JButton btnNewButton_1 = new JButton("");
        btnNewButton_1.setEnabled(false);
        btnNewButton_1.setBounds(69, 210, 70, 70);
        btnNewButton_1.setIcon(new ImageIcon(Ppal_Tutor.class.getResource("/PNG/searchEvent.png")));
        btnNewButton_1.setBackground(Color.WHITE);
        
        JButton btnNewButton_1_1 = new JButton("");
        btnNewButton_1_1.setEnabled(false);
        btnNewButton_1_1.setBounds(396, 210, 70, 70);
        btnNewButton_1_1.setIcon(new ImageIcon(Ppal_Tutor.class.getResource("/PNG/searchJust.png")));
        btnNewButton_1_1.setBackground(Color.WHITE);
        
        JButton btnNewButton_2 = new JButton("");
        btnNewButton_2.setEnabled(false);
        btnNewButton_2.setBounds(223, 59, 70, 70);
        btnNewButton_2.setIcon(new ImageIcon(Ppal_Tutor.class.getResource("/PNG/icons8-event-accepted-tentatively-48 - copia - copia.png")));
        btnNewButton_2.setBackground(Color.WHITE);
        
        JButton btnNewButton_3 = new JButton("");
        btnNewButton_3.setEnabled(false);
        btnNewButton_3.setBounds(223, 210, 70, 70);
        btnNewButton_3.setIcon(new ImageIcon(Ppal_Tutor.class.getResource("/PNG/searchReclam.png")));
        btnNewButton_3.setBackground(Color.WHITE);
        
        JButton btnNewButton_4 = new JButton("");
        btnNewButton_4.setEnabled(false);
        btnNewButton_4.setBounds(562, 210, 70, 70);
        btnNewButton_4.setIcon(new ImageIcon(Ppal_Tutor.class.getResource("/PNG/searchConst.png")));
        btnNewButton_4.setBackground(Color.WHITE);
        
        JButton btnNewButton_5 = new JButton("");
        btnNewButton_5.setBounds(396, 59, 70, 70);
        btnNewButton_5.setIcon(new ImageIcon(Ppal_Tutor.class.getResource("/PNG/searchReclam.png")));
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
        getContentPane().add(btnNewButton_1_1);
        getContentPane().add(lblJustificaciones);
        getContentPane().add(btnNewButton_9);
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
        
        JLabel lblModificar_1 = new JLabel("Analitica de");
        lblModificar_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        lblModificar_1.setBounds(562, 135, 72, 15);
        getContentPane().add(lblModificar_1);
        
        JLabel lblUsuario_1 = new JLabel("Reclamos");
        lblUsuario_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        lblUsuario_1.setBounds(562, 156, 72, 15);
        getContentPane().add(lblUsuario_1);
        
        JLabel lblModificar_1_1_1_1 = new JLabel("Modificar");
        lblModificar_1_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        lblModificar_1_1_1_1.setBounds(396, 135, 72, 15);
        getContentPane().add(lblModificar_1_1_1_1);
        
        JLabel lblConstancia_2 = new JLabel("Mis Datos");
        lblConstancia_2.setFont(new Font("SimSun", Font.PLAIN, 12));
        lblConstancia_2.setBounds(396, 156, 78, 15);
        getContentPane().add(lblConstancia_2);
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
        btnNewButton_5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ModPropiaTutor modPropia = null;
				try {
					modPropia = new ModPropiaTutor(usuario);
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		modPropia.getFrame().setVisible(true);
        		modPropia.getFrame().setLocationRelativeTo(null);
        		dispose();
        	}
        });
        btnNewButton_9.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					ListarReclamos listR = new ListarReclamos(usuario);
					listR.setVisible(true);
					listR.setLocationRelativeTo(null);
					dispose();
				} catch (NamingException | ServiciosException e1) {
					e1.printStackTrace();
				}
        	}
        });
    }
}