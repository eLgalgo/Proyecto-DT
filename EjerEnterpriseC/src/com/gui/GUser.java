package com.gui;

import java.awt.EventQueue;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.*;
import java.awt.Font;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Label;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.entities.FUNCIONALIDADES;
import com.entities.USUARIOS;
import com.exception.ServiciosException;
import com.services.FuncionalidadBeanRemote;
import com.services.RolBeanRemote;
import com.services.UsuarioBeanRemote;

import java.awt.Color;


public class GUser
        implements ActionListener {
	
	private JFrame frame;
	public JButton btnNewButton;
	public JButton btnCerrar;
	public JButton btnFunc2;
	public JButton btnFunc3;
	public JButton btnFunc4;

    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }

    public GUser(USUARIOS usuario, List<FUNCIONALIDADES> listFuncs) throws NamingException {
        frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.setResizable(false);
		frame.getContentPane().setFont(new Font("SimSun", Font.PLAIN, 11));
		frame.getContentPane().setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(100, 100, 293, 332);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);
        
        
		List<FUNCIONALIDADES> auxListFunc = usuario.getRol().getFunc();
		
		ArrayList<String> arrayModeloString = new ArrayList<String>();
		for(FUNCIONALIDADES s: auxListFunc) {
			arrayModeloString.add(s.getNombre());
		}
		ArrayList<String> arrayModeloString2 = new ArrayList<String>();
        
		for(FUNCIONALIDADES s: listFuncs) {
			arrayModeloString2.add(s.getNombre());
		}
		ArrayList<String> arrayModeloStringDef = new ArrayList<String>();
		for(String s : arrayModeloString2) {
			if(arrayModeloString.contains(s)) {
				arrayModeloStringDef.add(s);
			}else {
				arrayModeloStringDef.add(s + " No tiene acceso");
			}
		}
		
		String [] arrayModelo = new String[auxListFunc.size()];
		arrayModelo = arrayModeloString.toArray(arrayModelo);
        JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBox.setModel(new DefaultComboBoxModel(arrayModelo));
		comboBox.setBounds(10, 191, 220, 30);

		frame.getContentPane().add(comboBox);
        frame.getContentPane().add(comboBox);
       
		String [] arrayModelo2 = new String[listFuncs.size()];
		arrayModelo2 = arrayModeloStringDef.toArray(arrayModelo2);
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBox_1.setModel(new DefaultComboBoxModel(arrayModelo2));
    
		
        comboBox_1.setFont(new Font("SimSun", Font.PLAIN, 13));
        comboBox_1.setBounds(292, 191, 220, 30);
        frame.getContentPane().add(comboBox_1);
        
        btnNewButton = new JButton("");
        btnNewButton.setBackground(Color.WHITE);
        btnNewButton.setBounds(65, 67, 70, 70);
        frame.getContentPane().add(btnNewButton);
        
        JLabel lblNewLabel = new JLabel("Alta Usuario");
        lblNewLabel.setFont(new Font("SimSun", Font.PLAIN, 12));
        lblNewLabel.setBounds(65, 143, 72, 15);
        frame.getContentPane().add(lblNewLabel);
        
        btnCerrar = new JButton("Cerrar sesion");
        btnCerrar.setBounds(406, 245, 106, 30);
        frame.getContentPane().add(btnCerrar);
        
        btnFunc2 = new JButton("");
        btnFunc2.setBackground(Color.WHITE);
        btnFunc2.setBounds(170, 67, 70, 70);
        frame.getContentPane().add(btnFunc2);
        
        JLabel lblNewLabel_1 = new JLabel("Func2");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("SimSun", Font.PLAIN, 12));
        lblNewLabel_1.setBounds(170, 143, 72, 15);
        frame.getContentPane().add(lblNewLabel_1);
        
        btnFunc3 = new JButton("");
        btnFunc3.setBackground(Color.WHITE);
        btnFunc3.setBounds(271, 67, 70, 70);
        frame.getContentPane().add(btnFunc3);
        
        JLabel lblNewLabel_2 = new JLabel("Func3");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setFont(new Font("SimSun", Font.PLAIN, 12));
        lblNewLabel_2.setBounds(271, 143, 72, 15);
        frame.getContentPane().add(lblNewLabel_2);
        
        btnFunc4 = new JButton("");
        btnFunc4.setBackground(Color.WHITE);
        btnFunc4.setBounds(369, 67, 70, 70);
        frame.getContentPane().add(btnFunc4);
        
        JLabel lblNewLabel_3 = new JLabel("Func4");
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setFont(new Font("SimSun", Font.PLAIN, 12));
        lblNewLabel_3.setBounds(369, 143, 72, 15);
        frame.getContentPane().add(lblNewLabel_3);
        
        JLabel lblVentanaPrincipal = new JLabel("Ventana Principal");
        lblVentanaPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
        lblVentanaPrincipal.setFont(new Font("SimSun", Font.PLAIN, 28));
        lblVentanaPrincipal.setBounds(10, 11, 502, 30);
        frame.getContentPane().add(lblVentanaPrincipal);
        frame.setTitle("Gesti\u00F3n de Usuario - " + usuario.getRol().getNombre());
     
        frame.setSize(538, 347);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
        //Logica
        
        RolBeanRemote rolBean = (RolBeanRemote)
				//Nombre de EJB Project/NombreBean!NombrePaqueteServicios.NombreDeBeanRemote del Bean inicial
				InitialContext.doLookup("EjEnterpriseEJB/RolBean!com.services.RolBeanRemote");
		
		UsuarioBeanRemote userBean = (UsuarioBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/UsuarioBean!com.services.UsuarioBeanRemote");
		
		FuncionalidadBeanRemote funcBean = (FuncionalidadBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/FuncionalidadBean!com.services.FuncionalidadBeanRemote");
		
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		List<FUNCIONALIDADES> funcsUser = usuario.getRol().getFunc();
				boolean bandera = false;
				for(FUNCIONALIDADES f:funcsUser) {
					if(f.getNombre().equals("Asignar Funcionalidad a Rol")) {
						bandera = true;
						break;
					}
				}
				if(bandera) {
					GUI ventanaAlta = null;
					try {
						ventanaAlta = new GUI(usuario, listFuncs, rolBean.listAllRoles());
					} catch (NamingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	        		ventanaAlta.setVisible(true);
	        		getFrame().dispose();
				}else {
					JOptionPane.showMessageDialog(null, "No tiene Acceso D:");
				}
        		
        	}
        });
       btnCerrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Login login = null;
				try {
					login = new Login();
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		login.getFrame().setVisible(true);
        		getFrame().dispose();
        	}
        });
		btnFunc2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		List<FUNCIONALIDADES> funcsUser = usuario.getRol().getFunc();
				boolean bandera = false;
				for(FUNCIONALIDADES f:funcsUser) {
					if(f.getNombre().equals("Listado de Roles")) {
						bandera = true;
						break;
					}
				}
				if(bandera) {
					JOptionPane.showMessageDialog(null, "¡Tiene Acceso!");
				}else {
					JOptionPane.showMessageDialog(null, "No tiene Acceso D:");
				}
        	}
        });
		btnFunc3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		List<FUNCIONALIDADES> funcsUser = usuario.getRol().getFunc();
				boolean bandera = false;
				for(FUNCIONALIDADES f:funcsUser) {
					if(f.getNombre().equals("Asignar Funcionalidad a Rol")) {
						bandera = true;
						break;
					}
				}
				if(bandera) {
					JOptionPane.showMessageDialog(null, "¡Tiene Acceso!");
				}else {
					JOptionPane.showMessageDialog(null, "No tiene Acceso D:");
				}
        	}
        });
		btnFunc4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		List<FUNCIONALIDADES> funcsUser = usuario.getRol().getFunc();
				boolean bandera = false;
				for(FUNCIONALIDADES f:funcsUser) {
					if(f.getNombre().equals("Crear nuevo Dios")) {
						bandera = true;
						break;
					}
				}
				if(bandera) {
					JOptionPane.showMessageDialog(null, "¡Tiene Acceso!");
				}else {
					JOptionPane.showMessageDialog(null, "No tiene Acceso D:");
				}
        	}
        });

    }
    
    public JFrame getFrame() {
		return this.frame;
	}
}