package com.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Mod_Usuario {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mod_Usuario window = new Mod_Usuario();
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
	public Mod_Usuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("Z:\\ONE DRIVE\\OneDrive\\Escritorio\\PNG\\logoUtec.png"));
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("MODIFICACI\u00D3N DE USUARIO");
		lblNewLabel_2.setBounds(10, 11, 203, 34);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("SimSun", Font.BOLD, 16));
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Buscar Usuario");
		lblNewLabel.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 50, 104, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setFont(new Font("SimSun", Font.PLAIN, 12));
		formattedTextField.setBounds(114, 47, 212, 20);
		frame.getContentPane().add(formattedTextField);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setFont(new Font("SimSun", Font.PLAIN, 13));
		btnNewButton.setBounds(335, 46, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Tel\u00E9fono");
		lblNewLabel_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 101, 64, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("SimSun", Font.PLAIN, 13));
		textField.setColumns(10);
		textField.setBounds(10, 125, 131, 20);
		frame.getContentPane().add(textField);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblCorreo.setBounds(10, 154, 64, 14);
		frame.getContentPane().add(lblCorreo);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		textField_1.setColumns(10);
		textField_1.setBounds(10, 177, 131, 20);
		frame.getContentPane().add(textField_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Localidad");
		lblNewLabel_1_2.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(10, 208, 64, 14);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBox.setBounds(10, 228, 131, 22);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Departamento");
		lblNewLabel_1_2_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_2_1.setBounds(151, 100, 91, 14);
		frame.getContentPane().add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("G\u00E9nero");
		lblNewLabel_1_2_1_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_2_1_1.setBounds(151, 154, 52, 14);
		frame.getContentPane().add(lblNewLabel_1_2_1_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBox_1.setBounds(151, 124, 131, 22);
		frame.getContentPane().add(comboBox_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBox_1_1.setBounds(151, 176, 62, 22);
		frame.getContentPane().add(comboBox_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("ITR");
		lblNewLabel_1_2_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel_1_2_1_1_1.setBounds(218, 154, 42, 14);
		frame.getContentPane().add(lblNewLabel_1_2_1_1_1);
		
		JComboBox comboBox_1_1_1 = new JComboBox();
		comboBox_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBox_1_1_1.setBounds(218, 176, 64, 22);
		frame.getContentPane().add(comboBox_1_1_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("SimSun", Font.PLAIN, 12));
		textPane.setBounds(114, 72, 212, 20);
		frame.getContentPane().add(textPane);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblUsuario.setBounds(293, 101, 64, 14);
		frame.getContentPane().add(lblUsuario);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("SimSun", Font.PLAIN, 13));
		textField_2.setColumns(10);
		textField_2.setBounds(293, 125, 131, 20);
		frame.getContentPane().add(textField_2);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblContrasea.setBounds(293, 154, 70, 14);
		frame.getContentPane().add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("SimSun", Font.PLAIN, 13));
		passwordField.setBounds(292, 177, 132, 20);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton_1 = new JButton("Guardar");
		btnNewButton_1.setFont(new Font("SimSun", Font.BOLD, 14));
		btnNewButton_1.setBounds(327, 223, 97, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Cancelar");
		btnNewButton_1_1.setFont(new Font("SimSun", Font.BOLD, 13));
		btnNewButton_1_1.setBounds(327, 255, 97, 23);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("Z:\\ONE DRIVE\\OneDrive\\Escritorio\\PNG\\modUser.png"));
		lblNewLabel_3.setBounds(258, 235, 46, 43);
		frame.getContentPane().add(lblNewLabel_3);
		frame.setBounds(100, 100, 450, 325);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
