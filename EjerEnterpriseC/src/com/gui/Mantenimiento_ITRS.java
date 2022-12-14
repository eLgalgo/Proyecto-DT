package com.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.entities.ITR;
import com.entities.TIPOCONSTANCIA;
import com.entities.USUARIO;
import com.enums.EstadoSolicitud;
import com.exception.ServiciosException;
import com.services.ItrBeanRemote;
import java.awt.Label;

public class Mantenimiento_ITRS {

	private JFrame frmMantenimientoItr;
	private JTextField tfNombreItr;

	public Mantenimiento_ITRS(USUARIO usuario) throws NamingException {
		initialize(usuario);
	}

	private void initialize(USUARIO usuario) throws NamingException {

		ItrBeanRemote itrBean = (ItrBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/ItrBean!com.services.ItrBeanRemote");

		frmMantenimientoItr = new JFrame();
		frmMantenimientoItr.setResizable(false);
		frmMantenimientoItr.setBounds(100, 100, 506, 375);
		frmMantenimientoItr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMantenimientoItr.getContentPane().setLayout(null);

		JComboBox comboBoxFiltroItr = new JComboBox();
		comboBoxFiltroItr.setFont(new Font("SimSun", Font.PLAIN, 13));
		comboBoxFiltroItr.setBounds(68, 22, 104, 22);
		comboBoxFiltroItr.addItem("ACTIVOS");
		comboBoxFiltroItr.addItem("ELIMINADOS");
		comboBoxFiltroItr.addItem("SIN FILTRO");
		comboBoxFiltroItr.setSelectedIndex(2);
		frmMantenimientoItr.getContentPane().add(comboBoxFiltroItr);

		JComboBox<ITR> comboBoxItrs = new JComboBox();
		comboBoxItrs.setBounds(10, 85, 177, 22);
		frmMantenimientoItr.getContentPane().add(comboBoxItrs);
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

		final ItemListener changeClick = new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
				if (comboBoxFiltroItr.getSelectedItem().equals("ACTIVOS")) {
					List<ITR> itrs = itrBean.findAll(true);
					String[] itrNombres = new String[itrs.size()];

					// Converting List to Array
					for (int i = 0; i < itrs.size(); i++) {
						itrNombres[i] = itrs.get(i).getNombre();
					}
					comboBoxItrs.setModel(new DefaultComboBoxModel(itrNombres));
				} else if (comboBoxFiltroItr.getSelectedItem().equals("ELIMINADOS")) {
					List<ITR> itrs = itrBean.findAll(false);
					String[] itrNombres = new String[itrs.size()];

					// Converting List to Array
					for (int i = 0; i < itrs.size(); i++) {
						itrNombres[i] = itrs.get(i).getNombre();
					}
					comboBoxItrs.setModel(new DefaultComboBoxModel(itrNombres));
				} else if (comboBoxFiltroItr.getSelectedItem().equals("SIN FILTRO")) {
					List<ITR> itrs;
					try {
						itrs = itrBean.listAllItrs();
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

				}
			}

		};
		comboBoxFiltroItr.addItemListener(changeClick);

		JButton btnGrabar = new JButton("Guardar Modif.");
		btnGrabar.setEnabled(false);
		btnGrabar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<ITR> itr = null;
				
				if (tfNombreItr.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "No se puede agregar un ITR sin nombre");
				} else {
					try {
						itr = itrBean.findItr(tfNombreItr.getText());
						if(itr.isEmpty()) {
							try {
								itr = itrBean.findItr(comboBoxItrs.getSelectedItem().toString());
							} catch (ServiciosException e2) {
								e2.printStackTrace();
							}
							if(!itr.isEmpty()) {
								try {
									
									itrBean.editItr(itr.get(0), tfNombreItr.getText());
									btnGrabar.setEnabled(false);
									if (comboBoxFiltroItr.getSelectedItem().equals("ACTIVOS")) {
										List<ITR> itrs = itrBean.findAll(true);
										String[] itrNombres = new String[itrs.size()];

										// Converting List to Array
										for (int i = 0; i < itrs.size(); i++) {
											itrNombres[i] = itrs.get(i).getNombre();
										}
										comboBoxItrs.setModel(new DefaultComboBoxModel(itrNombres));
									} else if (comboBoxFiltroItr.getSelectedItem().equals("ELIMINADOS")) {
										List<ITR> itrs = itrBean.findAll(false);
										String[] itrNombres = new String[itrs.size()];

										// Converting List to Array
										for (int i = 0; i < itrs.size(); i++) {
											itrNombres[i] = itrs.get(i).getNombre();
										}
										comboBoxItrs.setModel(new DefaultComboBoxModel(itrNombres));
									} else if (comboBoxFiltroItr.getSelectedItem().equals("SIN FILTRO")) {
										List<ITR> itrs;
										try {
											itrs = itrBean.listAllItrs();
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

									}
									JOptionPane.showMessageDialog(null, "Actualizado con exito");
								} catch (ServiciosException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}else {
								JOptionPane.showMessageDialog(null, "Ya existe el nombre especificado");
							}
						}else {
							JOptionPane.showMessageDialog(null, "Ya existe el nombre especificado");
						}
					} catch (ServiciosException e3) {
						e3.printStackTrace();
					}
					
					
				}
			}
		});
		btnGrabar.setFont(new Font("SimSun", Font.PLAIN, 13));
		btnGrabar.setBounds(197, 193, 132, 23);
		frmMantenimientoItr.getContentPane().add(btnGrabar);

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
		btnVolver.setBounds(391, 301, 89, 23);
		frmMantenimientoItr.getContentPane().add(btnVolver);

		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxItrs.getSelectedItem() == null) {
					JOptionPane.showMessageDialog(null, "No se puede borrar ITR vac?o");
				} else {
					try {
						itrBean.logicDelete(comboBoxItrs.getSelectedItem().toString());
						if (comboBoxFiltroItr.getSelectedItem().equals("ACTIVOS")) {
							List<ITR> itrs = itrBean.findAll(true);
							String[] itrNombres = new String[itrs.size()];

							// Converting List to Array
							for (int i = 0; i < itrs.size(); i++) {
								itrNombres[i] = itrs.get(i).getNombre();
							}
							comboBoxItrs.setModel(new DefaultComboBoxModel(itrNombres));
						} else if (comboBoxFiltroItr.getSelectedItem().equals("ELIMINADOS")) {
							List<ITR> itrs = itrBean.findAll(false);
							String[] itrNombres = new String[itrs.size()];

							// Converting List to Array
							for (int i = 0; i < itrs.size(); i++) {
								itrNombres[i] = itrs.get(i).getNombre();
							}
							comboBoxItrs.setModel(new DefaultComboBoxModel(itrNombres));
						} else if (comboBoxFiltroItr.getSelectedItem().equals("SIN FILTRO")) {
							List<ITR> itrs;
							try {
								itrs = itrBean.listAllItrs();
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

						}
						JOptionPane.showMessageDialog(null, "ITR Borrado!");
					} catch (ServiciosException e1) {
						JOptionPane.showMessageDialog(null, "Error al borrar ITR");
						e1.printStackTrace();
					}
				}
			}
		});
		btnBorrar.setFont(new Font("SimSun", Font.PLAIN, 13));
		btnBorrar.setBounds(10, 118, 131, 23);
		frmMantenimientoItr.getContentPane().add(btnBorrar);

		frmMantenimientoItr.setTitle("Mantenimiento de ITRs");

		tfNombreItr = new JTextField();
		tfNombreItr.setBounds(10, 194, 177, 20);
		frmMantenimientoItr.getContentPane().add(tfNombreItr);
		tfNombreItr.setColumns(10);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxItrs.getSelectedItem() == null) {
					JOptionPane.showMessageDialog(null, "No hay tal ITR");
				} else {
					try {
						ITR itr = itrBean.findItr(comboBoxItrs.getSelectedItem().toString()).get(0);
						if (itr != null) {
							tfNombreItr.setText(itr.getNombre());
							btnGrabar.setEnabled(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "No hay ITR seleccionado");
						}
					} catch (ServiciosException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnModificar.setFont(new Font("SimSun", Font.PLAIN, 13));
		btnModificar.setBounds(197, 85, 132, 23);
		frmMantenimientoItr.getContentPane().add(btnModificar);

		JLabel lblNombre = new JLabel("Nombre ITR");
		lblNombre.setFont(new Font("SimSun", Font.PLAIN, 13));
		lblNombre.setBounds(10, 175, 79, 14);
		frmMantenimientoItr.getContentPane().add(lblNombre);

		JButton btnAgregar_2 = new JButton("Agregar Nuevo");
		btnAgregar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ITR itr2 = new ITR();

				itr2.setEstado(true);
				itr2.setNombre(tfNombreItr.getText());
				if (tfNombreItr.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "No se puede agregar un ITR sin nombre");
				} else {
					try {
						List<ITR> list = itrBean.findItr(tfNombreItr.getText());
						if (list.isEmpty()) {
							try {
								itrBean.addItr(itr2);
								if (comboBoxFiltroItr.getSelectedItem().equals("ACTIVOS")) {
									List<ITR> itrs = itrBean.findAll(true);
									String[] itrNombres = new String[itrs.size()];

									// Converting List to Array
									for (int i = 0; i < itrs.size(); i++) {
										itrNombres[i] = itrs.get(i).getNombre();
									}
									comboBoxItrs.setModel(new DefaultComboBoxModel(itrNombres));
								} else if (comboBoxFiltroItr.getSelectedItem().equals("ELIMINADOS")) {
									List<ITR> itrs = itrBean.findAll(false);
									String[] itrNombres = new String[itrs.size()];

									// Converting List to Array
									for (int i = 0; i < itrs.size(); i++) {
										itrNombres[i] = itrs.get(i).getNombre();
									}
									comboBoxItrs.setModel(new DefaultComboBoxModel(itrNombres));
								} else if (comboBoxFiltroItr.getSelectedItem().equals("SIN FILTRO")) {
									List<ITR> itrs;
									try {
										itrs = itrBean.listAllItrs();
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

								}
								JOptionPane.showMessageDialog(null, "Agregado con exito");
							} catch (ServiciosException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								JOptionPane.showMessageDialog(null, e1.getMessage());
							}
						} else {
							JOptionPane.showMessageDialog(null, "ITR ya existe!");
						}
					} catch (ServiciosException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				}
			}
		});
		btnAgregar_2.setFont(new Font("SimSun", Font.PLAIN, 13));
		btnAgregar_2.setBounds(10, 225, 131, 23);
		frmMantenimientoItr.getContentPane().add(btnAgregar_2);

		Label label = new Label("(?) Para modificar seleccione del combo el ITR y clickee en Modificar");
		label.setBounds(10, 280, 349, 22);
		frmMantenimientoItr.getContentPane().add(label);

		Label label_1 = new Label("Modifique el nombre y clickee en Guardar Modif.");
		label_1.setBounds(10, 302, 319, 22);
		frmMantenimientoItr.getContentPane().add(label_1);

		JButton btnReActivar = new JButton("Reactivar");
		btnReActivar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxItrs.getSelectedItem() == null) {
					JOptionPane.showMessageDialog(null, "No hay tal ITR");
				} else {
					try {
						ITR itr = itrBean.findItr(comboBoxItrs.getSelectedItem().toString()).get(0);
						itrBean.activeItr(itr, true);
						if (comboBoxFiltroItr.getSelectedItem().equals("ACTIVOS")) {
							List<ITR> itrs = itrBean.findAll(true);
							String[] itrNombres = new String[itrs.size()];

							// Converting List to Array
							for (int i = 0; i < itrs.size(); i++) {
								itrNombres[i] = itrs.get(i).getNombre();
							}
							comboBoxItrs.setModel(new DefaultComboBoxModel(itrNombres));
						} else if (comboBoxFiltroItr.getSelectedItem().equals("ELIMINADOS")) {
							List<ITR> itrs = itrBean.findAll(false);
							String[] itrNombres = new String[itrs.size()];

							// Converting List to Array
							for (int i = 0; i < itrs.size(); i++) {
								itrNombres[i] = itrs.get(i).getNombre();
							}
							comboBoxItrs.setModel(new DefaultComboBoxModel(itrNombres));
						} else if (comboBoxFiltroItr.getSelectedItem().equals("SIN FILTRO")) {
							List<ITR> itrs;
							try {
								itrs = itrBean.listAllItrs();
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

						}
						JOptionPane.showMessageDialog(null, "Reactivado!");
					} catch (ServiciosException e1) {
						JOptionPane.showMessageDialog(null, "No se pudo reactivar ITR");
						e1.printStackTrace();
					}
				}
			}
		});
		btnReActivar.setFont(new Font("SimSun", Font.PLAIN, 13));
		btnReActivar.setBounds(198, 118, 131, 23);
		frmMantenimientoItr.getContentPane().add(btnReActivar);

	}

	JFrame getFrame() {
		return this.frmMantenimientoItr;
	}
}
