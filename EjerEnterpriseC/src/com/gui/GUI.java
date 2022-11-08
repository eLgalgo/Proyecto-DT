package com.gui;
import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.entities.FUNCIONALIDADES;
import com.entities.ROLES;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class GUI extends JFrame {

	private JPanel contentPane;
	public JTextField tfNombre;
	public JPasswordField tfClave;
	public JTextField tfApellido;
	public JTextField tfEmail;
	public JTextField tfDocumento;
	public int idNuevo;
	public JButton btnAgregar;
	public JComboBox comboBox;
	public JButton btnEliminar;
	public JButton btnActualizar;
	public JButton btnVolver;

	public GUI(List<ROLES> listRoles) {
		setResizable(false);
		setTitle("Administrador de Personas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(83, 11, 122, 29);
		contentPane.add(tfNombre);
		tfNombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre *");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(23, 16, 64, 14);
		contentPane.add(lblNewLabel);
		
		tfClave = new JPasswordField();
		tfClave.setColumns(10);
		tfClave.setBounds(302, 11, 122, 29);
		contentPane.add(tfClave);
		
		JLabel lblApellido = new JLabel("Clave");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellido.setBounds(247, 16, 46, 14);
		contentPane.add(lblApellido);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(163, 141, 111, 35);
		contentPane.add(btnAgregar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(10, 141, 111, 35);
		contentPane.add(btnEliminar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(313, 141, 111, 35);
		contentPane.add(btnActualizar);
		
		tfApellido = new JTextField();
		tfApellido.setColumns(10);
		tfApellido.setBounds(83, 51, 122, 29);
		contentPane.add(tfApellido);
		
		JLabel lblApellido_2 = new JLabel("Apellido *");
		lblApellido_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellido_2.setBounds(23, 56, 64, 14);
		contentPane.add(lblApellido_2);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(302, 53, 122, 29);
		contentPane.add(tfEmail);
		
		JLabel lblApellido_3 = new JLabel("Email");
		lblApellido_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellido_3.setBounds(247, 56, 46, 14);
		contentPane.add(lblApellido_3);
		
		JLabel lblApellido_2_1 = new JLabel("Docum");
		lblApellido_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellido_2_1.setBounds(23, 98, 64, 14);
		contentPane.add(lblApellido_2_1);
		
		tfDocumento = new JTextField();
		tfDocumento.setColumns(10);
		tfDocumento.setBounds(83, 93, 122, 29);
		contentPane.add(tfDocumento);
		
		ArrayList<String> arrayModeloString = new ArrayList<String>();
		for(ROLES r: listRoles) {
			arrayModeloString.add(r.getNombre());
		}
		String [] arrayModelo2 = new String[listRoles.size()];
		arrayModelo2 = arrayModeloString.toArray(arrayModelo2);
		comboBox = new JComboBox();
		comboBox.setBounds(300, 93, 122, 29);
		contentPane.add(comboBox);
		comboBox.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBox.setModel(new DefaultComboBoxModel(arrayModelo2));

		JLabel lblApellido_3_1 = new JLabel("Rol");
		lblApellido_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellido_3_1.setBounds(247, 100, 46, 14);
		contentPane.add(lblApellido_3_1);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(313, 212, 111, 38);
		contentPane.add(btnVolver);
		
	}
}
