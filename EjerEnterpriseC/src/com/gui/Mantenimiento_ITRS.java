package com.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.entities.ITR;
import com.entities.USUARIO;
import com.exception.ServiciosException;
import com.services.ItrBeanRemote;

public class Mantenimiento_ITRS {

	private JFrame frmMantenimientoItr;
	private JTextField tfNombreItr;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 * @param usuario 
	 * 
	 * @throws NamingException
	 */
	public Mantenimiento_ITRS(USUARIO usuario) throws NamingException {
		initialize(usuario);
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws NamingException
	 */
	private void initialize(USUARIO usuario) throws NamingException {

		ItrBeanRemote itrBean = (ItrBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/ItrBean!com.services.ItrBeanRemote");

		frmMantenimientoItr = new JFrame();
		frmMantenimientoItr.setEnabled(false);
		frmMantenimientoItr.setBounds(100, 100, 506, 375);
		frmMantenimientoItr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMantenimientoItr.getContentPane().setLayout(null);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("SimSun", Font.PLAIN, 13));
		btnAgregar.setBounds(180, 244, 89, 23);
		frmMantenimientoItr.getContentPane().add(btnAgregar);

		JComboBox comboBoxFiltroItr = new JComboBox();
		comboBoxFiltroItr.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxFiltroItr.setBounds(68, 22, 104, 22);
		comboBoxFiltroItr.addItem("ACTIVOS");
		comboBoxFiltroItr.addItem("ELIMINADOS");
		comboBoxFiltroItr.addItem("TODOS");
		comboBoxFiltroItr.setSelectedIndex(2);
		frmMantenimientoItr.getContentPane().add(comboBoxFiltroItr);

		JLabel Filtrar = new JLabel("Filtrar");
		Filtrar.setFont(new Font("SimSun", Font.PLAIN, 13));
		Filtrar.setBounds(10, 26, 59, 14);
		frmMantenimientoItr.getContentPane().add(Filtrar);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ppal_Analista ventAnalista = null;
				try {
					ventAnalista = new Ppal_Analista(usuario);
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ventAnalista.setVisible(true);
				ventAnalista.setLocationRelativeTo(null);
				getFrame().dispose();
			}
		});
		btnVolver.setFont(new Font("SimSun", Font.PLAIN, 13));
		btnVolver.setBounds(395, 303, 89, 23);
		frmMantenimientoItr.getContentPane().add(btnVolver);

		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setFont(new Font("SimSun", Font.PLAIN, 13));
		btnBorrar.setBounds(320, 52, 89, 23);
		frmMantenimientoItr.getContentPane().add(btnBorrar);

		frmMantenimientoItr.setTitle("Mantenimiento de ITRs");

		tfNombreItr = new JTextField();
		tfNombreItr.setBounds(153, 198, 140, 20);
		frmMantenimientoItr.getContentPane().add(tfNombreItr);
		tfNombreItr.setColumns(10);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModificar.setFont(new Font("SimSun", Font.PLAIN, 13));
		btnModificar.setBounds(320, 108, 89, 23);
		frmMantenimientoItr.getContentPane().add(btnModificar);

		JLabel lblNombre = new JLabel("Nombre ITR");
		lblNombre.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNombre.setBounds(190, 173, 79, 14);
		frmMantenimientoItr.getContentPane().add(lblNombre);

		JComboBox<ITR> comboBoxItrs = new JComboBox();
		comboBoxItrs.setBounds(133, 77, 177, 22);
		try {
			List<ITR> itrs = itrBean.listAllItrs();
			String[] itrNombres = new String[itrs.size()];

			// Converting List to Array
			for (int i = 0; i < itrs.size(); i++) {
				itrNombres[i] = itrs.get(i).getNombre();
			}
			comboBoxItrs.setModel(new DefaultComboBoxModel(itrNombres));
		} catch (ServiciosException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// Declaring Array with Equal Size to the List
		

		
		frmMantenimientoItr.getContentPane().add(comboBoxItrs);

	}

	JFrame getFrame() {
		return this.frmMantenimientoItr;
	}
}
