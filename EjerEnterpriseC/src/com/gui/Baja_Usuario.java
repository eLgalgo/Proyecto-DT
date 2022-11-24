package com.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.border.BevelBorder;

import com.entities.ANALISTA;
import com.entities.USUARIO;
import com.exception.ServiciosException;
import com.services.AnalistaBeanRemote;
import com.services.EstudianteBeanRemote;
import com.services.TutorBeanRemote;
import com.services.UsuarioBeanRemote;
import java.awt.SystemColor;

public class Baja_Usuario {

	private JFrame frame;

	/**
	 * Create the application.
	 * 
	 * @throws NamingException
	 */
	public Baja_Usuario(USUARIO usuario) throws NamingException {
		initialize(usuario);
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws NamingException
	 */
	private void initialize(USUARIO usuario) throws NamingException {
		EstudianteBeanRemote estudianteBean = (EstudianteBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/EstudianteBean!com.services.EstudianteBeanRemote");

		TutorBeanRemote tutorBean = (TutorBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/TutorBean!com.services.TutorBeanRemote");

		AnalistaBeanRemote analistaBean = (AnalistaBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/AnalistaBean!com.services.AnalistaBeanRemote");

		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/UsuarioBean!com.services.UsuarioBeanRemote");

		frame = new JFrame();
		frame.setIconImage(
				Toolkit.getDefaultToolkit().getImage("Z:\\ONE DRIVE\\OneDrive\\Escritorio\\PNG\\logoUtec.png"));
		frame.getContentPane().setBackground(SystemColor.control);
		frame.setResizable(false);
		frame.setBounds(100, 100, 486, 381);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		JButton atras = new JButton("Atras");
		
		JLabel lblNewLabel_2 = new JLabel("BAJA DE USUARIO");
		lblNewLabel_2.setBounds(10, 22, 188, 30);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("SimSun", Font.BOLD, 16));
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel = new JLabel("Buscar Usuario");
		lblNewLabel.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 78, 104, 14);
		frame.getContentPane().add(lblNewLabel);

		JFormattedTextField ftfDocumento = new JFormattedTextField();
		ftfDocumento.setFont(new Font("SimSun", Font.PLAIN, 12));
		ftfDocumento.setBounds(124, 75, 237, 20);
		frame.getContentPane().add(ftfDocumento);

		JList list = new JList();
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list.setFont(new Font("SimSun", Font.PLAIN, 13));
		list.setBounds(10, 103, 414, 146);
		frame.getContentPane().add(list);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			/**
			 * @param e
			 */
			/**
			 * @param e
			 */
			public void actionPerformed(ActionEvent e) {
				try {
					DefaultListModel model = new DefaultListModel<>();
					java.util.List<USUARIO> u = usuarioBean.findUser(Integer.parseInt(ftfDocumento.getText()));
					if (!u.isEmpty()) {
						if(u.get(0).getEstado().name() == "ELIMINADO") {
							model.addElement("USUARIO YA ELIMINADO");
							model.addElement(u.toString());
							list.setModel(model);
						}
						else {
							btnEliminar.setEnabled(true);
							model.addElement(u.toString());
							list.setModel(model);
						}
						
					} else {
						model.addElement("No se econtró el Usuario");
						list.setModel(model);
					}

				} catch (NumberFormatException | ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnBuscar.setFont(new Font("SimSun", Font.PLAIN, 13));
		btnBuscar.setBounds(371, 74, 89, 23);
		frame.getContentPane().add(btnBuscar);

		
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ppal_Analista pAnalist = null;
				try {
					ANALISTA usuario2 = (ANALISTA) usuarioBean.findUser(usuario.getDocumento()).get(0);
					pAnalist = new Ppal_Analista(usuario2);
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pAnalist.setVisible(true);
				pAnalist.setLocationRelativeTo(null);
				getFrame().dispose();

			}
		});
		atras.setFont(new Font("SimSun", Font.BOLD, 13));
		atras.setBounds(359, 308, 101, 23);
		frame.getContentPane().add(atras);
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					int res = JOptionPane.showConfirmDialog(null, "Esta seguro que desea borrar el Usuario?");
					if (res == JOptionPane.YES_OPTION) {
						usuarioBean.logicDelete(Integer.parseInt(ftfDocumento.getText()));
						JOptionPane.showMessageDialog(null, "Usuario dado de baja lógica.");
						btnEliminar.setEnabled(false);
					}
					
				} catch (NumberFormatException | ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEliminar.setFont(new Font("SimSun", Font.BOLD, 13));
		btnEliminar.setBounds(359, 274, 101, 23);
		frame.getContentPane().add(btnEliminar);

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(443, 100, 17, 149);
		frame.getContentPane().add(scrollBar);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("Z:\\ONE DRIVE\\OneDrive\\Escritorio\\PNG\\deleteUser.png"));
		lblNewLabel_1.setBounds(414, 11, 46, 48);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Baja_Usuario.class.getResource("/PNG/NC 100.jpg")));
		lblNewLabel_3.setBounds(0, 322, 104, 20);
		frame.getContentPane().add(lblNewLabel_3);
	}

	public Window getFrame() {

		return this.frame;
	}
}
