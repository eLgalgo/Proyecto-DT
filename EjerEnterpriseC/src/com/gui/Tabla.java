package com.gui;
import java.awt.BorderLayout;

import java.util.LinkedList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.entities.USUARIO;
import com.exception.ServiciosException;
import com.services.AnalistaBeanRemote;
import com.services.EstudianteBeanRemote;
import com.services.TutorBeanRemote;
import com.services.UsuarioBeanRemote;

import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Tabla extends JFrame {

	 private JTable tabla = null;
	 DefaultTableModel modelo = null;
	 JScrollPane desplazamiento = null;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * @throws NamingException 
	 * @wbp.parser.constructor
	 */
	public Tabla(List<USUARIO> list) throws NamingException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\crist\\Downloads\\icons8-archivo-de-c\u00F3digo-48.png"));
		crearTablaPersona();
       // Agregamos datos
       this.agregarDatosLista(modelo, list);
       // Agregando elementos a la ventana
       this.getContentPane().add(desplazamiento, BorderLayout.NORTH);
       this.pack();
       setLocationRelativeTo(null);
	}
	public Tabla(USUARIO u) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\crist\\Downloads\\icons8-archivo-de-c\u00F3digo-48.png"));
		crearTablaPersona();
       // Agregamos datos
       this.agregarDatosPersona(modelo, u);
       // Agregando elementos a la ventana
       this.getContentPane().add(desplazamiento, BorderLayout.NORTH);
       this.pack();
       setLocationRelativeTo(null);
	}
	private void crearTablaPersona() {
		setResizable(false);
		String[] columnas = {"ID", "Nombre", "Apellido", "Departamento","Documento", "Telefono", "Email"};
		tabla = new JTable();
		modelo = new DefaultTableModel(){
		    public boolean isCellEditable(int rowIndex,int columnIndex){return false;}
		};
		desplazamiento = new JScrollPane(tabla);    

		// Parametros de la ventana
		this.setTitle("Listado de Usuarios");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());

		// Modelo de la tabla
		modelo.setColumnIdentifiers(columnas);

		// Barras de desplazamiento
		desplazamiento.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		desplazamiento.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		// Propiedades de la tabla
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		tabla.setModel(modelo);
	}
	private void agregarDatosLista(DefaultTableModel modelo, List<USUARIO> list) throws NamingException {
		EstudianteBeanRemote estudianteBean = (EstudianteBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/EstudianteBean!com.services.EstudianteBeanRemote");
		
		TutorBeanRemote tutorBean = (TutorBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/TutorBean!com.services.TutorBeanRemote");
		
		AnalistaBeanRemote analistaBean = (AnalistaBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/AnalistaBean!com.services.AnalistaBeanRemote");
		
		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/UsuarioBean!com.services.UsuarioBeanRemote");
       // Borramos todas las filas en la tabla
       modelo.setRowCount(0);
       
       // Creamos los datos de una fila de la tabla
       Object[] datosFila = {"", "", "", "","","","",""};
       
       // Agregamos MUCHOS mas datos
       for (USUARIO p : list) {
           datosFila[0] = p.getId_usuario();
           datosFila[1] = p.getNombre();
           datosFila[2] = p.getApellido();
           datosFila[3] = p.getDepartamento();
           datosFila[4] = p.getDocumento();
           datosFila[5] = p.getTelefono();
           datosFila[6] = p.getMail();
           
           modelo.addRow(datosFila);
       }
       tabla.addMouseListener
       (
    	    	new MouseAdapter()
    	    	{
    	    		public void mouseClicked(MouseEvent evnt)
    	    		{
    	          if (evnt.getClickCount() == 1)
    	          {
    	          	Mod_Usuario modUserW = null;
					try {
						USUARIO user = usuarioBean.findUser(Integer.parseInt(tabla.getValueAt(tabla.getSelectedRow(), 4).toString())).get(0);
						modUserW = new Mod_Usuario(user);
					} catch (NamingException e) {
						e.printStackTrace();
					} catch (NumberFormatException e) {
						e.printStackTrace();
					} catch (ServiciosException e) {
						e.printStackTrace();
					}
    	          	modUserW.getFrame().setVisible(true);
    	          	dispose();
    	          }
    	    		}
    	    	}
    	    );
   }
	private void agregarDatosPersona(DefaultTableModel modelo, USUARIO p) {

       // Evaluamos si existe una persona
           // Borramos todas las filas en la tabla
           modelo.setRowCount(0);
           
           // Creamos los datos de una fila de la tabla
           Object[] datosFila = {"", "", "", "","","",""};
           
           // agregamos esos datos
           modelo.addRow(datosFila);
           
           datosFila[0] = p.getNombre();
           datosFila[1] = p.getApellido();
           datosFila[2] = p.getDepartamento();
           datosFila[3] = p.getDocumento();
           datosFila[4] = p.getTelefono();
           datosFila[5] = p.getMail();
           
           modelo.addRow(datosFila);
           

   }
}

