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

import com.entities.ANALISTA;
import com.entities.USUARIO;
import com.exception.ServiciosException;
import com.services.AnalistaBeanRemote;
import com.services.EstudianteBeanRemote;
import com.services.TutorBeanRemote;
import com.services.UsuarioBeanRemote;


public class Ppal_Analista extends JFrame implements ActionListener {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
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

    public Ppal_Analista(USUARIO usuario) throws NamingException {
        super("Administración Secretaría");
        getContentPane().setBackground(Color.WHITE);
        
        JButton btnNewButton = new JButton("");
     
        btnNewButton.setBounds(118, 59, 70, 70);
        btnNewButton.setIcon(new ImageIcon(Ppal_Analista.class.getResource("/PNG/addUser.png")));
        btnNewButton.setBackground(Color.WHITE);
        
        JButton btnNewButton_1 = new JButton("");
        
        btnNewButton_1.setBounds(465, 59, 70, 70);
        btnNewButton_1.setIcon(new ImageIcon(Ppal_Analista.class.getResource("/PNG/searchUser.png")));
        btnNewButton_1.setBackground(Color.WHITE);
        
        JButton btnNewButton_1_1 = new JButton("");
        btnNewButton_1_1.setEnabled(false);
        btnNewButton_1_1.setBounds(287, 323, 70, 70);
        btnNewButton_1_1.setIcon(new ImageIcon(Ppal_Analista.class.getResource("/PNG/searchJust.png")));
        btnNewButton_1_1.setBackground(Color.WHITE);
        
        JButton btnNewButton_2 = new JButton("");
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					EliminarUsuarios baja = new EliminarUsuarios((ANALISTA) usuario);
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
        btnNewButton_4.setBounds(638, 59, 70, 70);
        btnNewButton_4.setIcon(new ImageIcon(Ppal_Analista.class.getResource("/PNG/searchConst.png")));
        btnNewButton_4.setBackground(Color.WHITE);
        
        JButton btnAnaliticaR = new JButton("");
        btnAnaliticaR.setBounds(118, 193, 70, 70);
        btnAnaliticaR.setIcon(new ImageIcon(Ppal_Analista.class.getResource("/PNG/icons8-search-contacts-48.png")));
        btnAnaliticaR.setBackground(Color.WHITE);
        
        JButton btnNewButton_6 = new JButton("");
        btnNewButton_6.setBounds(638, 389, 70, 70);
        btnNewButton_6.setIcon(new ImageIcon(Ppal_Analista.class.getResource("/PNG/CloseSession.png")));
        btnNewButton_6.setBackground(Color.WHITE);
        
        JButton btnNewButton_7 = new JButton("");
        btnNewButton_7.setEnabled(false);
        btnNewButton_7.setBounds(118, 323, 70, 70);
        btnNewButton_7.setIcon(new ImageIcon(Ppal_Analista.class.getResource("/PNG/modJust.png")));
        btnNewButton_7.setBackground(Color.WHITE);
        
        JButton btnNewButton_8 = new JButton("");
        btnNewButton_8.setBounds(638, 193, 70, 70);
        btnNewButton_8.setIcon(new ImageIcon(Ppal_Analista.class.getResource("/PNG/modConst.png")));
        btnNewButton_8.setBackground(Color.WHITE);
        
        JButton btnNewButton_9 = new JButton("");
        btnNewButton_9.setEnabled(false);
        btnNewButton_9.setBounds(465, 323, 70, 70);
        btnNewButton_9.setIcon(new ImageIcon(Ppal_Analista.class.getResource("/PNG/modReclam.png")));
        btnNewButton_9.setBackground(Color.WHITE);
        
        JLabel lblNewLabel = new JLabel("Alta Usuario");
        lblNewLabel.setBounds(118, 135, 72, 15);
        lblNewLabel.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblBajaUsuario = new JLabel("Gestion de Estado");
        lblBajaUsuario.setBounds(273, 135, 102, 15);
        lblBajaUsuario.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar = new JLabel("Analitica de");
        lblModificar.setBounds(118, 269, 72, 15);
        lblModificar.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblUsuario = new JLabel("Reclamos");
        lblUsuario.setBounds(118, 290, 72, 15);
        lblUsuario.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar_1 = new JLabel("Modificar");
        lblModificar_1.setBounds(465, 399, 72, 15);
        lblModificar_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblReclamo = new JLabel("Reclamo");
        lblReclamo.setBounds(465, 420, 72, 15);
        lblReclamo.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar_1_1 = new JLabel("Buscar");
        lblModificar_1_1.setBounds(465, 135, 72, 15);
        lblModificar_1_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblJustificacin = new JLabel("Usuarios");
        lblJustificacin.setBounds(465, 156, 48, 15);
        lblJustificacin.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar_1_1_1 = new JLabel("Modificar");
        lblModificar_1_1_1.setBounds(287, 269, 72, 15);
        lblModificar_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblConstancia = new JLabel("Mis Datos");
        lblConstancia.setBounds(287, 290, 78, 15);
        lblConstancia.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar_1_1_1_1 = new JLabel("Modificar");
        lblModificar_1_1_1_1.setBounds(118, 399, 72, 15);
        lblModificar_1_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblUsuarios = new JLabel("Justificaciones");
        lblUsuarios.setBounds(118, 420, 90, 15);
        lblUsuarios.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar_1_1_1_1_1 = new JLabel("Tipos de");
        lblModificar_1_1_1_1_1.setBounds(638, 269, 72, 15);
        lblModificar_1_1_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblReclamos = new JLabel("Constancias");
        lblReclamos.setBounds(638, 290, 78, 15);
        lblReclamos.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar_1_1_1_1_1_1 = new JLabel("Buscar");
        lblModificar_1_1_1_1_1_1.setBounds(287, 399, 72, 15);
        lblModificar_1_1_1_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblJustificaciones = new JLabel("Justificaciones");
        lblJustificaciones.setBounds(287, 420, 90, 15);
        lblJustificaciones.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblModificar_1_1_1_1_1_1_1 = new JLabel("Buscar");
        lblModificar_1_1_1_1_1_1_1.setBounds(638, 135, 72, 15);
        lblModificar_1_1_1_1_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        
        JLabel lblConstancias = new JLabel("Constancias");
        lblConstancias.setBounds(638, 156, 90, 15);
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
        getContentPane().add(btnAnaliticaR);
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
        
        JButton btnMantenimientoItr = new JButton("");
        btnMantenimientoItr.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Mantenimiento_ITRS mant = null;
				try {
					mant = new Mantenimiento_ITRS(usuario);
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		mant.getFrame().setVisible(true);
        		mant.getFrame().setLocationRelativeTo(null);
        		dispose();
        	}
        });
        btnMantenimientoItr.setIcon(new ImageIcon(Ppal_Analista.class.getResource("/PNG/itr.png")));
        btnMantenimientoItr.setBackground(Color.WHITE);
        btnMantenimientoItr.setBounds(465, 193, 70, 70);
        getContentPane().add(btnMantenimientoItr);
        
        JLabel lblModificar_1_1_1_2 = new JLabel("Mantenimiento");
        lblModificar_1_1_1_2.setFont(new Font("SimSun", Font.PLAIN, 12));
        lblModificar_1_1_1_2.setBounds(465, 269, 90, 15);
        getContentPane().add(lblModificar_1_1_1_2);
        
        JLabel lblItrs = new JLabel("ITRs");
        lblItrs.setFont(new Font("SimSun", Font.PLAIN, 12));
        lblItrs.setBounds(465, 290, 78, 15);
        getContentPane().add(lblItrs);
        setTitle("Administraci\u00F3n Secretar\u00EDa - Analista");
        ANALISTA analista = (ANALISTA) usuario;
        if(!analista.getDios()) {
        	btnNewButton.setEnabled(false);
        }
        
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
	        	SeleccionarAlta ALTATAB=null;
	        	try {
					ALTATAB = new SeleccionarAlta(usuario);
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	ALTATAB.getFrame().setVisible(true);
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
        btnAnaliticaR.addActionListener(new ActionListener() {
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
        btnNewButton_8.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					ListarTiposDeConstancia listTips = new ListarTiposDeConstancia(usuario);
					listTips.setVisible(true);
					dispose();
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        btnNewButton_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ModPropiaAnalista modPropia = null;
				try {
					modPropia = new ModPropiaAnalista(usuario);
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		modPropia.getFrame().setVisible(true);
        		modPropia.getFrame().setLocationRelativeTo(null);
        		dispose();
        	}
        });
//        btnNewButton_5.addActionListener(new ActionListener() {
//        	public void actionPerformed(ActionEvent e) {
//        		try {
//					ModificarUsuarios table = new ModificarUsuarios(usuario);
//					table.getFrame().setVisible(true);
//					table.getFrame().setLocationRelativeTo(null);
//					dispose();
//				} catch (NamingException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//        	}
//        });
        
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					ListarUsuarios table = new ListarUsuarios((ANALISTA) usuario);
					table.getFrame().setVisible(true);
					table.getFrame().setLocationRelativeTo(null);
					dispose();
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        
        btnNewButton_4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					Listar_SConstanciasAnalista constW = new Listar_SConstanciasAnalista((ANALISTA) usuario);
					constW.setVisible(true);
					constW.setLocationRelativeTo(null);
					dispose();
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
    }
}