package com.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.naming.NamingException;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SeleccionarAlta {

	private JFrame selectAltaType;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeleccionarAlta window = new SeleccionarAlta();
					window.selectAltaType.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SeleccionarAlta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		selectAltaType = new JFrame();
		selectAltaType.setBounds(100, 100, 450, 340);
		selectAltaType.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		selectAltaType.getContentPane().setLayout(null);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 267, 414, 23);
		selectAltaType.getContentPane().add(btnCancelar);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 36, 434, 161);
		selectAltaType.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton btnNewButton = new JButton("Alta Analista");
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
        		selectAltaType.dispose();
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Alta Tutor");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Alta_Usuario_Analista ALTAUA=null;
	        	try {
					ALTAUA = new Alta_Usuario_Analista();
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	ALTAUA.getFrame().setVisible(true);
        		selectAltaType.dispose();
			
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Alta Estudiante");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Alta_Usuario_Analista ALTAUA=null;
	        	try {
					ALTAUA = new Alta_Usuario_Analista();
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	ALTAUA.getFrame().setVisible(true);
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
