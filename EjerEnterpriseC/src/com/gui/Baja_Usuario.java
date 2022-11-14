package com.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.border.BevelBorder;

import com.entities.USUARIO;
import com.exception.ServiciosException;
import com.services.AnalistaBeanRemote;
import com.services.EstudianteBeanRemote;
import com.services.TutorBeanRemote;
import com.services.UsuarioBeanRemote;

import org.hibernate.mapping.List;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	 * @throws NamingException 
	 */
	public Baja_Usuario() throws NamingException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws NamingException 
	 */
	private void initialize() throws NamingException {
		EstudianteBeanRemote estudianteBean = (EstudianteBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/EstudianteBean!com.services.EstudianteBeanRemote");
		
		TutorBeanRemote tutorBean = (TutorBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/TutorBean!com.services.TutorBeanRemote");
		
		AnalistaBeanRemote analistaBean = (AnalistaBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/AnalistaBean!com.services.AnalistaBeanRemote");
		
		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/UsuarioBean!com.services.UsuarioBeanRemote");
		
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
		
		JFormattedTextField ftfDocumento = new JFormattedTextField();
		ftfDocumento.setFont(new Font("SimSun", Font.PLAIN, 12));
		ftfDocumento.setBounds(118, 49, 212, 20);
		frame.getContentPane().add(ftfDocumento);
		
		JList list = new JList();
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list.setFont(new Font("SimSun", Font.PLAIN, 13));
		list.setBounds(10, 80, 386, 146);
		frame.getContentPane().add(list);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					USUARIO u = usuarioBean.findUser(Integer.parseInt(ftfDocumento.getText())).get(0);
					DefaultListModel model = new DefaultListModel<>();
					model.addElement(u.toString());
					list.setModel(model);
					
				} catch (NumberFormatException | ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnBuscar.setFont(new Font("SimSun", Font.PLAIN, 13));
		btnBuscar.setBounds(335, 48, 89, 23);
		frame.getContentPane().add(btnBuscar);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListUsers list = null;
				try {
					list = new ListUsers(usuarioBean.listAllUsers());
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				list.getFrame().setVisible(true);
				list.getFrame().setLocationRelativeTo(null);
				getFrame().dispose();
				
			}
		});
		btnNewButton_1.setFont(new Font("SimSun", Font.BOLD, 13));
		btnNewButton_1.setBounds(323, 271, 101, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Eliminar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					usuarioBean.logicDelete(Integer.parseInt(ftfDocumento.getText()));
				} catch (NumberFormatException | ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
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

	public Window getFrame() {
		
		return this.frame;
	}
}
