package com.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Ayuda {

	private JFrame frmAcercaDe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ayuda window = new Ayuda();
					window.frmAcercaDe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ayuda() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAcercaDe = new JFrame();
		frmAcercaDe.setIconImage(Toolkit.getDefaultToolkit().getImage(Ayuda.class.getResource("/PNG/logoUtec.png")));
		frmAcercaDe.setTitle("Acerca de");
		frmAcercaDe.setBounds(100, 100, 364, 318);
		frmAcercaDe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAcercaDe.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Acerca de");
		lblNewLabel.setFont(new Font("SimSun", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 100, 14);
		frmAcercaDe.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		panel.setBounds(0, 0, 348, 282);
		frmAcercaDe.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Gesti\u00F3n de Secretar\u00EDa");
		lblNewLabel_1.setBounds(160, 54, 163, 14);
		lblNewLabel_1.setFont(new Font("SimSun", Font.PLAIN, 14));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Ayuda.class.getResource("/PNG/logoUtec2.png")));
		lblNewLabel_2.setBackground(SystemColor.inactiveCaption);
		lblNewLabel_2.setBounds(10, 54, 140, 103);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Copyright\u00A9 NoCompila Ltd");
		lblNewLabel_3.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(160, 79, 176, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Versi\u00F3n 1.15");
		lblNewLabel_4.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(160, 104, 163, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Noviembre 2022");
		lblNewLabel_5.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(160, 127, 121, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Universidad UTEC");
		lblNewLabel_5_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_5_1.setBounds(160, 152, 121, 14);
		panel.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Por consultas o inconvenientes dir\u00EDjase a ");
		lblNewLabel_5_1_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_5_1_1.setBounds(10, 189, 326, 16);
		panel.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_5_1_2 = new JLabel("soporte@nocompila.net");
		lblNewLabel_5_1_2.setForeground(Color.BLUE);
		lblNewLabel_5_1_2.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_5_1_2.setBounds(189, 215, 147, 14);
		panel.add(lblNewLabel_5_1_2);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.setFont(new Font("SimSun", Font.PLAIN, 13));
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.setBounds(265, 249, 73, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(Ayuda.class.getResource("/PNG/NC 100.jpg")));
		lblNewLabel_6.setBounds(245, 0, 103, 23);
		panel.add(lblNewLabel_6);
	}

}
