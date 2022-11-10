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
import javax.naming.NamingException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.entities.FUNCIONALIDADES;
import com.entities.USUARIOS;
import com.exception.ServiciosException;
import com.services.FuncionalidadBeanRemote;
import com.services.RolBeanRemote;
import com.services.UsuarioBeanRemote;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.util.List;
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
	 * @throws NamingException 
	 */
	public Login() throws NamingException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws NamingException 
	 */
	private void initialize() throws NamingException {
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
				String email = tfUser.getText();
				String clave = tfContra.getText();
				
				try {
					List<USUARIOS> usuario = userBean.findUser(email, clave);
					if(usuario.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Usuario o Contraseña Incorrecta");
					}else {
						List<FUNCIONALIDADES> listFuncionalidades = funcBean.listAllFuncionalidad();
						System.out.println(listFuncionalidades);
						GUser gUser = new GUser(usuario.get(0), listFuncionalidades);
						gUser.getFrame().setVisible(true);
						getFrame().dispose();
					}
				} catch (ServiciosException e1) {
					e1.printStackTrace();
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
	}
	
	public JFrame getFrame() {
		return this.frmProgramaIncreible;
	}
}
