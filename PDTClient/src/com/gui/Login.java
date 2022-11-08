package com.gui;

import java.awt.EventQueue;




import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.naming.InitialContext;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.services.FuncionalidadBeanRemote;
import com.services.RolBeanRemote;
import com.services.UsuarioBeanRemote;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login{

	private JFrame frmProgramaIncreible;
	public JTextField tfUser;
	public JPasswordField tfContra;
	public JButton btnNewButton;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProgramaIncreible = new JFrame();
		frmProgramaIncreible.setTitle("Programa Increible");
		frmProgramaIncreible.setBackground(Color.WHITE);
		frmProgramaIncreible.setResizable(false);
		frmProgramaIncreible.getContentPane().setFont(new Font("SimSun", Font.PLAIN, 11));
		frmProgramaIncreible.getContentPane().setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));
		frmProgramaIncreible.getContentPane().setForeground(Color.WHITE);
		frmProgramaIncreible.setBounds(100, 100, 293, 332);
		frmProgramaIncreible.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProgramaIncreible.getContentPane().setLayout(null);
		frmProgramaIncreible.setLocationRelativeTo(null);
		
		tfUser = new JTextField();
		tfUser.setBounds(58, 62, 157, 27);
		frmProgramaIncreible.getContentPane().add(tfUser);
		tfUser.setColumns(10);
		
		btnNewButton = new JButton("Ingresar");
		btnNewButton.setFont(new Font("SimSun", Font.BOLD, 13));
		btnNewButton.setBounds(84, 168, 106, 33);
		frmProgramaIncreible.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("USUARIO");
		lblNewLabel.setFont(new Font("SimSun", Font.BOLD, 16));
		lblNewLabel.setBounds(58, 44, 82, 14);
		frmProgramaIncreible.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setFont(new Font("SimSun", Font.BOLD, 13));
		btnNewButton_1.setBounds(84, 212, 106, 33);
		frmProgramaIncreible.getContentPane().add(btnNewButton_1);
		
		JLabel lblContrasea = new JLabel("CONTRASE\u00D1A");
		lblContrasea.setFont(new Font("SimSun", Font.BOLD, 16));
		lblContrasea.setBounds(58, 109, 106, 20);
		frmProgramaIncreible.getContentPane().add(lblContrasea);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("Z:\\ONE DRIVE\\OneDrive\\Escritorio\\PNG\\NC 100.jpg"));
		lblNewLabel_1.setBounds(161, 11, 106, 33);
		frmProgramaIncreible.getContentPane().add(lblNewLabel_1);
		
		tfContra = new JPasswordField();
		tfContra.setBounds(58, 130, 157, 27);
		frmProgramaIncreible.getContentPane().add(tfContra);
		frmProgramaIncreible.setLocationRelativeTo(null);
			
		
	}
	
	public JFrame getFrame() {
		return this.frmProgramaIncreible;
	}
}
