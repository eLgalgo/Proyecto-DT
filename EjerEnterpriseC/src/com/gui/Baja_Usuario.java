package com.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JScrollBar;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Baja_Usuario {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Baja_Usuario window = new Baja_Usuario();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Baja_Usuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("Z:\\ONE DRIVE\\OneDrive\\Escritorio\\PNG\\logoUtec.png"));
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setResizable(false);
		frame.setBounds(100, 100, 453, 344);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("BAJA DE USUARIO");
		lblNewLabel_2.setBounds(10, 11, 188, 30);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("SimSun", Font.BOLD, 16));
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Buscar Usuario");
		lblNewLabel.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 52, 104, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setFont(new Font("SimSun", Font.PLAIN, 12));
		formattedTextField.setBounds(118, 49, 212, 20);
		frame.getContentPane().add(formattedTextField);
		
		JList list = new JList();
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list.setFont(new Font("SimSun", Font.PLAIN, 13));
		list.setBounds(10, 80, 386, 146);
		frame.getContentPane().add(list);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setFont(new Font("SimSun", Font.PLAIN, 13));
		btnNewButton.setBounds(335, 48, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setFont(new Font("SimSun", Font.BOLD, 13));
		btnNewButton_1.setBounds(323, 271, 101, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Eliminar");
		btnNewButton_2.setFont(new Font("SimSun", Font.BOLD, 13));
		btnNewButton_2.setBounds(323, 237, 101, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(407, 77, 17, 149);
		frame.getContentPane().add(scrollBar);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("Z:\\ONE DRIVE\\OneDrive\\Escritorio\\PNG\\deleteUser.png"));
		lblNewLabel_1.setBounds(245, 246, 46, 48);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
