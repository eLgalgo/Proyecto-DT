package com.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.entities.ANALISTA;
import com.entities.ESTUDIANTE;
import com.entities.TUTOR;
import com.entities.USUARIO;
import com.enums.EstadoUsuario;
import com.exception.ServiciosException;
import com.services.AnalistaBeanRemote;
import com.services.EstudianteBeanRemote;
import com.services.TutorBeanRemote;
import com.services.UsuarioBeanRemote;

public class ListUsers {

	private JFrame frmListadoDeUsuarios;
	private JTable tabla;
	private DefaultTableModel modelo;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JLabel lblListadoDeUsuarios;
	private JTextField txtFiltro;
	private TableRowSorter trs;
	private JComboBox comboBoxEstado;

	/**
	 * Create the application.
	 * 
	 * @throws NamingException
	 */
	public ListUsers(List<USUARIO> list, USUARIO usuario) throws NamingException {
		initialize(list, usuario);
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws NamingException
	 */
	private void initialize(List<USUARIO> list, USUARIO usuario) throws NamingException {
		frmListadoDeUsuarios = new JFrame();
		frmListadoDeUsuarios.setTitle("Listado de Usuarios");
		frmListadoDeUsuarios.setIconImage(
				Toolkit.getDefaultToolkit().getImage("Z:\\ONE DRIVE\\OneDrive\\Escritorio\\PNG\\logoUtec.png"));
		frmListadoDeUsuarios.getContentPane().setBackground(Color.WHITE);
		frmListadoDeUsuarios.setResizable(false);
		frmListadoDeUsuarios.setBounds(100, 100, 547, 392);
		frmListadoDeUsuarios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btnNewButton = new JButton("Volver");
		btnNewButton.setBounds(10, 300, 110, 25);
		btnNewButton.setFont(new Font("SimSun", Font.BOLD, 13));

		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(228, 17, 0, 0);
		lblNewLabel.setIcon(new ImageIcon("Z:\\ONE DRIVE\\OneDrive\\Escritorio\\PNG\\deleteUser.png"));

		crearTablaPersona();
		// Agregamos datos
		agregarDatosLista(modelo, list);
		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/UsuarioBean!com.services.UsuarioBeanRemote");
		
		btnNewButton.addActionListener(new ActionListener() {
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
	}

	private void crearTablaPersona() {
		String[] columnas = { "ID", "Nombre", "Apellido", "Departamento", "Documento", "Telefono", "Email", "Tipo",
				"Estado" };
		tabla = new JTable();
		modelo = new DefaultTableModel() {
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return false;
			}
		};

		JButton btnNewButton_2 = new JButton("Modificar");
		btnNewButton_2.setBounds(411, 300, 110, 25);
		btnNewButton_2.setFont(new Font("SimSun", Font.BOLD, 13));
		JScrollPane desplazamiento = new JScrollPane(tabla);
		desplazamiento.setBounds(10, 69, 511, 201);
		desplazamiento.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		desplazamiento.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		// Modelo de la tabla
		modelo.setColumnIdentifiers(columnas);

		tabla.setModel(modelo);
		frmListadoDeUsuarios.getContentPane().setLayout(null);
		frmListadoDeUsuarios.getContentPane().add(btnNewButton);
		frmListadoDeUsuarios.getContentPane().add(lblNewLabel);
		frmListadoDeUsuarios.getContentPane().add(btnNewButton_2);
		frmListadoDeUsuarios.getContentPane().add(desplazamiento);

		lblListadoDeUsuarios = new JLabel("Listado de Usuarios");
		lblListadoDeUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblListadoDeUsuarios.setFont(new Font("SimSun", Font.PLAIN, 18));
		lblListadoDeUsuarios.setBounds(10, 14, 511, 15);
		frmListadoDeUsuarios.getContentPane().add(lblListadoDeUsuarios);

		txtFiltro = new JTextField();
		txtFiltro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				txtFiltro.addKeyListener(new KeyAdapter() {
					public void keyReleased (final KeyEvent e) {
						String s = txtFiltro.getText();
						txtFiltro.setText(s);
						FiltroCi();
					}
				});
				
				trs = new TableRowSorter(tabla.getModel());
				tabla.setRowSorter(trs);
			}
		});
		txtFiltro.setBounds(10, 40, 131, 20);
		frmListadoDeUsuarios.getContentPane().add(txtFiltro);
		txtFiltro.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Filtrar x CI");
		lblNewLabel_1.setFont(new Font("SimSun", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(151, 44, 101, 14);
		frmListadoDeUsuarios.getContentPane().add(lblNewLabel_1);
		
		comboBoxEstado = new JComboBox();
		
		comboBoxEstado.setBounds(411, 40, 110, 22);
		comboBoxEstado.setModel(new DefaultComboBoxModel(EstadoUsuario.values()));
		comboBoxEstado.setSelectedItem(null);
		frmListadoDeUsuarios.getContentPane().add(comboBoxEstado);
	}

	private void agregarDatosLista(DefaultTableModel modelo, List<USUARIO> list) throws NamingException {
		EstudianteBeanRemote estudianteBean = (EstudianteBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/EstudianteBean!com.services.EstudianteBeanRemote");

		TutorBeanRemote tutorBean = (TutorBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/TutorBean!com.services.TutorBeanRemote");

		AnalistaBeanRemote analistaBean = (AnalistaBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/AnalistaBean!com.services.AnalistaBeanRemote");

		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/UsuarioBean!com.services.UsuarioBeanRemote");
		// Borramos todas las filas en la tabla
		modelo.setRowCount(0);

		// Creamos los datos de una fila de la tabla
		Object[] datosFila = { "", "", "", "", "", "", "", "", "", "" };

		// Agregamos MUCHOS mas datos
		for (USUARIO p : list) {
			datosFila[0] = p.getId_usuario();
			datosFila[1] = p.getNombre();
			datosFila[2] = p.getApellido();
			datosFila[3] = p.getDepartamento();
			datosFila[4] = p.getDocumento();
			datosFila[5] = p.getTelefono();
			datosFila[6] = p.getMail();
			if (p instanceof ANALISTA) {
				datosFila[7] = "Analista";
			} else if (p instanceof TUTOR) {
				datosFila[7] = "Tutor";
			} else if (p instanceof ESTUDIANTE) {
				datosFila[7] = "Estudiante";
			}
			datosFila[8] = p.getEstado().name();

			modelo.addRow(datosFila);
		}
		tabla.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evnt) {
				if (evnt.getClickCount() == 2) {
					try {
						USUARIO user = usuarioBean
								.findUser(Integer.parseInt(tabla.getValueAt(tabla.getSelectedRow(), 4).toString()))
								.get(0);
						if (user instanceof ESTUDIANTE) {
							Mod_Estudiante modEstudW = new Mod_Estudiante((ESTUDIANTE) user);
							modEstudW.getFrame().setVisible(true);
							modEstudW.getFrame().setLocationRelativeTo(null);
							getFrame().dispose();
						} else if (user instanceof ANALISTA) {
							Mod_Analista modAnalistW = new Mod_Analista((ANALISTA) user);
							modAnalistW.getFrame().setVisible(true);
							modAnalistW.getFrame().setLocationRelativeTo(null);
							getFrame().dispose();
						} else if (user instanceof TUTOR) {
							Mod_Tutor modTutorW = new Mod_Tutor((TUTOR) user);
							modTutorW.getFrame().setVisible(true);
							modTutorW.getFrame().setLocationRelativeTo(null);
							getFrame().dispose();
						}

					} catch (NamingException e) {
						e.printStackTrace();
					} catch (NumberFormatException e) {
						e.printStackTrace();
					} catch (ServiciosException e) {
						e.printStackTrace();
					}
				}
			}
		});
	}

	JFrame getFrame() {
		return this.frmListadoDeUsuarios;
	}

	private void FiltroCi() {

		int columnaTabla = 4;//Documento
		trs.setRowFilter(RowFilter.regexFilter(txtFiltro.getText(), columnaTabla));
	}
	
	private void FiltroEstado() {

		int columnaTabla = 5;//Estado
		String estado = comboBoxEstado.getSelectedItem().toString();
		System.out.println(estado);
		trs.setRowFilter(RowFilter.regexFilter(estado, columnaTabla));
	}
}
