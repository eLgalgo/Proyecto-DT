package com.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.entities.ANALISTA;
import com.entities.USUARIO;
import com.enums.EstadoUsuario;
import com.enums.TipoUser;
import com.exception.ServiciosException;
import com.services.UsuarioBeanRemote;

public class SeleccionarAlta {

	private JFrame selectAltaType;

	/**
	 * Create the application.
	 * @throws NamingException 
	 */
	public SeleccionarAlta(USUARIO usuario) throws NamingException {
		initialize(usuario);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws NamingException 
	 */
	private void initialize(USUARIO usuario) throws NamingException {
		selectAltaType = new JFrame();
		selectAltaType.setBounds(100, 100, 450, 340);
		selectAltaType.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		selectAltaType.getContentPane().setLayout(null);
		selectAltaType.setLocationRelativeTo(null);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ppal_Analista pAnalistaW =null;
				try {
					pAnalistaW = new Ppal_Analista((ANALISTA)usuario);
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pAnalistaW.setVisible(true);
				pAnalistaW.setLocationRelativeTo(null);
        		getFrame().dispose();
			}
		});
		btnCancelar.setBounds(10, 267, 414, 23);
		selectAltaType.getContentPane().add(btnCancelar);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 36, 434, 161);
		selectAltaType.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/UsuarioBean!com.services.UsuarioBeanRemote");
		
		JComboBox<TipoUser> comboBoxTipoUser = new javax.swing.JComboBox<>();
		comboBoxTipoUser.setBounds(10, 234, 131, 22);
		comboBoxTipoUser.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxTipoUser.setModel(new DefaultComboBoxModel(EstadoUsuario.values()));
		comboBoxTipoUser.setSelectedItem(EstadoUsuario.SIN_CHEQUEAR);
		comboBoxTipoUser.setEnabled(false);
		selectAltaType.getContentPane().add(comboBoxTipoUser);
		
		JButton btnNewButton = new JButton("Alta Analista");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Alta_Usuario_Analista ALTAUA=null;
	        	try {
	        		ANALISTA usuario2 = (ANALISTA) usuarioBean.findUser(usuario.getDocumento()).get(0);
					ALTAUA = new Alta_Usuario_Analista(usuario2);
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	ALTAUA.getFrame().setVisible(true);
	        	ALTAUA.getFrame().setLocationRelativeTo(null);
        		selectAltaType.dispose();
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Alta Tutor");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Alta_Usuario_Tutor ALTAUT=null;
	        	try {
					ALTAUT = new Alta_Usuario_Tutor(usuario);
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	ALTAUT.getFrame().setVisible(true);
	        	ALTAUT.getFrame().setLocationRelativeTo(null);
        		selectAltaType.dispose();
			
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Alta Estudiante");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Alta_Usuario_Estudiante ALTAUE=null;
	        	try {
					ALTAUE = new Alta_Usuario_Estudiante(usuario);
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	ALTAUE.getFrame().setVisible(true);
	        	ALTAUE.getFrame().setLocationRelativeTo(null);
        		selectAltaType.dispose();
			
			}
		});
		panel.add(btnNewButton_2);
	}

	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return selectAltaType;
	}
}
