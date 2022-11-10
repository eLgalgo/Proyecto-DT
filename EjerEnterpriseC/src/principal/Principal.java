package principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;


import javax.naming.NamingException;
import javax.swing.JOptionPane;

import com.entities.FUNCIONALIDADES;
import com.entities.ROLES;
import com.entities.USUARIOS;
import com.exception.ServiciosException;
import com.gui.GUI;
import com.gui.GUser;
import com.gui.Login;
import com.services.FuncionalidadBeanRemote;
import com.services.RolBeanRemote;
import com.services.UsuarioBeanRemote;

public class Principal {
	
	public static void main(String[] args) throws NamingException, ServiciosException {
		// TODO Auto-generated method stub
		
		RolBeanRemote rolBean = (RolBeanRemote)
				//Nombre de EJB Project/NombreBean!NombrePaqueteServicios.NombreDeBeanRemote del Bean inicial
				InitialContext.doLookup("EjEnterpriseEJB/RolBean!com.services.RolBeanRemote");
		
		UsuarioBeanRemote userBean = (UsuarioBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/UsuarioBean!com.services.UsuarioBeanRemote");
		
		FuncionalidadBeanRemote funcBean = (FuncionalidadBeanRemote)
				InitialContext.doLookup("EjEnterpriseEJB/FuncionalidadBean!com.services.FuncionalidadBeanRemote");
		
		Login login = new Login();
		login.getFrame().setVisible(true);
		
		login.btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = login.tfUser.getText();
				String clave = login.tfContra.getText();
				
				try {
					List<USUARIOS> usuario = userBean.findUser(email, clave);
					if(usuario.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Usuario o Contraseña Incorrecta");
					}else {
						List<FUNCIONALIDADES> listFuncionalidades = funcBean.listAllFuncionalidad();
						System.out.println(listFuncionalidades);
						GUser gUser = new GUser(usuario.get(0), listFuncionalidades);
						gUser.getFrame().setVisible(true);
						login.getFrame().dispose();
						System.out.println("Debe ser borrado este syso");
						gUser. btnNewButton.addActionListener(new ActionListener() {
				        	public void actionPerformed(ActionEvent e) {
				        		List<FUNCIONALIDADES> funcsUser = usuario.get(0).getRol().getFunc();
								boolean bandera = false;
								for(FUNCIONALIDADES f:funcsUser) {
									if(f.getNombre().equals("Asignar Funcionalidad a Rol")) {
										bandera = true;
										break;
									}
								}
								if(bandera) {
									GUI ventanaAlta = new GUI(rolBean.listAllRoles());
					        		ventanaAlta.setVisible(true);
					        		gUser.getFrame().dispose();
					        		ventanaAlta.btnAgregar.addActionListener(new ActionListener() {
					        			public void actionPerformed(ActionEvent e) {
					        				USUARIOS user1 = new USUARIOS();
					        				user1.setNombre(ventanaAlta.tfNombre.getText());
					        				user1.setApellido(ventanaAlta.tfApellido.getText());
					        				user1.setDocumento(ventanaAlta.tfDocumento.getText());
					        				user1.setEmail(ventanaAlta.tfEmail.getText());
					        				user1.setClave(ventanaAlta.tfClave.getText());
					        				
					        				try {
					        					List<USUARIOS> list = userBean.findUser(ventanaAlta.tfDocumento.getText());
					        					if(list.isEmpty()) {
					        						userBean.addUser(user1);
													System.out.println();
													userBean.asignRoltoUser(rolBean.listAllRoles().get(ventanaAlta.comboBox.getSelectedIndex()).getId(),
															userBean.findUser(ventanaAlta.tfEmail.getText(), 
																	ventanaAlta.tfClave.getText()).get(0).getId());
													JOptionPane.showMessageDialog(null, "Usuario agregado con exito");
					        					}else {
					        						JOptionPane.showMessageDialog(null, "Usuario ya existente en el sistema");
					        					}
												
											} catch (ServiciosException e1) {
												
												e1.printStackTrace();
											}
					        			}
					        		});
					        		ventanaAlta.btnEliminar.addActionListener(new ActionListener() {
					        			public void actionPerformed(ActionEvent e) {
					        				int input = JOptionPane.showConfirmDialog(null, "¿Seguro que quiere eliminar?");
					        		        // 0=yes, 1=no, 2=cancel
					        				if(input == 0) {
					        					String documento = ventanaAlta.tfDocumento.getText();
						        				try {
													userBean.deleteUser(documento);
													JOptionPane.showMessageDialog(null, "Usuario eliminado con exito");
												} catch (ServiciosException e1) {
													e1.printStackTrace();
												}
					        				}
					        			}
					        		});
					        		ventanaAlta.btnActualizar.addActionListener(new ActionListener() {
					        			public void actionPerformed(ActionEvent e) {
					        				USUARIOS user = new USUARIOS();
											try {
												user = userBean.findUser(ventanaAlta.tfDocumento.getText()).get(0);
												user.setNombre(ventanaAlta.tfNombre.getText());
						        				user.setApellido(ventanaAlta.tfApellido.getText());
						        				user.setDocumento(ventanaAlta.tfDocumento.getText());
						        				user.setEmail(ventanaAlta.tfEmail.getText());
						        				user.setClave(ventanaAlta.tfClave.getText());
						        				user.setRol(rolBean.listAllRoles().get(ventanaAlta.comboBox.getSelectedIndex()));
						        				
											} catch (ServiciosException e2) {
												// TODO Auto-generated catch block
												e2.printStackTrace();
											}
					        				try {
												userBean.editUser(user);
												JOptionPane.showMessageDialog(null, "Actualizado con exito");
											} catch (ServiciosException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
					        			}
					        		});
					        		ventanaAlta.btnVolver.addActionListener(new ActionListener() {
					        			public void actionPerformed(ActionEvent e) {
					        				gUser.getFrame().setVisible(true);
					        				ventanaAlta.dispose();
					        			}
					        		});
								}else {
									JOptionPane.showMessageDialog(null, "No tiene Acceso D:");
								}
				        		
				        	}
				        });
						gUser.btnCerrar.addActionListener(new ActionListener() {
				        	public void actionPerformed(ActionEvent e) {
				        		login.getFrame().setVisible(true);
				        		gUser.getFrame().dispose();
				        	}
				        });
						gUser.btnFunc2.addActionListener(new ActionListener() {
				        	public void actionPerformed(ActionEvent e) {
				        		List<FUNCIONALIDADES> funcsUser = usuario.get(0).getRol().getFunc();
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
						gUser.btnFunc3.addActionListener(new ActionListener() {
				        	public void actionPerformed(ActionEvent e) {
				        		List<FUNCIONALIDADES> funcsUser = usuario.get(0).getRol().getFunc();
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
						gUser.btnFunc4.addActionListener(new ActionListener() {
				        	public void actionPerformed(ActionEvent e) {
				        		List<FUNCIONALIDADES> funcsUser = usuario.get(0).getRol().getFunc();
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
				} catch (ServiciosException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		USUARIOS user1 = new USUARIOS();
		user1.setNombre("Cristofer");
		user1.setApellido("Cabrera");
		user1.setDocumento("53158941");
		user1.setEmail("c");
		user1.setClave("c");
		
		userBean.addUser(user1);
		
		List<USUARIOS> user1DB = userBean.findUser(user1.getEmail(), user1.getClave());
		
		FUNCIONALIDADES func1 = new FUNCIONALIDADES();
		func1.setNombre("ABM");
		func1.setDesc("ABM de Usuario");
		funcBean.addFuncionalidad(func1);
		
		FUNCIONALIDADES func2 = new FUNCIONALIDADES();
		func2.setNombre("Listado de Roles");
		func2.setDesc("Listado de Roles");
		funcBean.addFuncionalidad(func2);
		
		FUNCIONALIDADES func3 = new FUNCIONALIDADES();
		func3.setNombre("Asignar Funcionalidad a Rol");
		func3.setDesc("Asignar");
		funcBean.addFuncionalidad(func3);
		
		FUNCIONALIDADES func4 = new FUNCIONALIDADES();
		func4.setNombre("Crear nuevo Dios");
		func4.setDesc("Crear nuevo Dios");
		funcBean.addFuncionalidad(func4);
		
		ROLES r1 = new ROLES();
		r1.setNombre("Dios");
		r1.setDesc("GOOOOOD");
		rolBean.addRol(r1);
		
		ROLES r2 = new ROLES();
		r2.setNombre("Estudiante");
		r2.setDesc("Estudy");
		rolBean.addRol(r2);
		
		ROLES r3 = new ROLES();
		r3.setNombre("Profesor");
		r3.setDesc("Estudy");
		rolBean.addRol(r3);
		
		rolBean.asignFunctoRol(1, 1);
		rolBean.asignFunctoRol(2, 1);
		rolBean.asignFunctoRol(3, 1);
		rolBean.asignFunctoRol(4, 1);
		
		rolBean.asignFunctoRol(2, 2);
		rolBean.asignFunctoRol(4, 2);
		
		rolBean.asignFunctoRol(2, 3);
		rolBean.asignFunctoRol(3, 3);
		rolBean.asignFunctoRol(4, 3);
		
		userBean.asignRoltoUser(1, 1);
		System.out.println("Linea2");
		System.out.println("Linea20");
	}

}
