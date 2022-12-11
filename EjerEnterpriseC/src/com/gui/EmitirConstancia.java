package com.gui;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import com.entities.ACCIONANALISTACONSTANCIA;
import com.entities.ANALISTA;
import com.entities.ESTUDIANTE;
import com.entities.SOLICITUD;
import com.entities.TIPOCONSTANCIA;
import com.enums.EstadoSolicitud;
import com.exception.ServiciosException;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import com.services.AccionBeanRemote;
import com.services.AnalistaBeanRemote;
import com.services.EstudianteBeanRemote;
import com.services.EventoBeanRemote;
import com.services.ModeloBeanRemote;
import com.services.SolicitudBeanRemote;
import com.services.TutorBeanRemote;
import com.services.UsuarioBeanRemote;

import org.w3c.dom.Text;



public class EmitirConstancia extends JFrame implements ActionListener {
	private DefaultTableModel modelo;
	private JTextField textField;
    private String ruta = null;
    private JTextField tfNombre;
    private JTextField tfApellido;
    private JTextField tfEventoDetalle;
    private JTextField tfEventoNombre;

	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
	}

	public EmitirConstancia(ANALISTA usuario, SOLICITUD sol) throws NamingException, ServiciosException {
		super("Administración Secretaría");
		setResizable(false);
		setBackground(Color.WHITE);
		getContentPane().setBackground(SystemColor.activeCaption);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(619, 523);
		setLocationRelativeTo(null);
		setVisible(true);
		getContentPane().setLayout(null);

		JButton btnCancelar = new JButton("Volver");
		btnCancelar.setBounds(10, 450, 97, 23);
		btnCancelar.setFont(new Font("SimSun", Font.BOLD, 13));
		getContentPane().add(btnCancelar);

		JButton btnSolicitar2 = new JButton("Emitir");
		btnSolicitar2.setBounds(455, 416, 138, 23);
		btnSolicitar2.setFont(new Font("SimSun", Font.BOLD, 14));
		getContentPane().add(btnSolicitar2);

		JLabel lblNewLabel_2 = new JLabel("Previsualizacion");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 11, 583, 34);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("SimSun", Font.BOLD, 20));
		getContentPane().add(lblNewLabel_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setBackground(Color.WHITE);
		textArea.setBounds(10, 168, 291, 202);
		getContentPane().add(textArea);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(10, 123, 291, 34);
		textField.setText(sol.getTipo().getTipo());
		getContentPane().add(textField);
		String area = sol.getTipo().getModelo();
		String cadenaTerminada = area;
		if(area.indexOf("&nombre&") != -1) {
			int posicion = area.indexOf("&nombre&");
			String principio = area.substring(0, posicion);
			String final2 = area.substring(posicion + 8, area.length());
			String cadenaFinal = principio + sol.getEstSol().getNombre() + final2;
			cadenaTerminada = cadenaFinal;
			
			if(cadenaTerminada.indexOf("&apellido&") != -1) {
				int posicion2 = cadenaTerminada.indexOf("&apellido&");
				String principio2 = cadenaTerminada.substring(0, posicion2);
				String final22 = cadenaTerminada.substring(posicion2 + 10, cadenaTerminada.length());
				String cadenaFinal2 = principio2 + sol.getEstSol().getApellido() + final22;
				cadenaTerminada = cadenaFinal2;
				
				if(cadenaTerminada.indexOf("&cedula&") != -1) {
					int posicion3 = cadenaTerminada.indexOf("&cedula&");
					String principio3 = cadenaTerminada.substring(0, posicion3);
					String final222 = cadenaTerminada.substring(posicion3 + 8, cadenaTerminada.length());
					String cadenaFinal22 = principio3 + sol.getEstSol().getDocumento() + final222;
					cadenaTerminada = cadenaFinal22;
				}
				
				if(cadenaTerminada.indexOf("&evento&") != -1) {
					int posicion3 = cadenaTerminada.indexOf("&evento&");
					String principio3 = cadenaTerminada.substring(0, posicion3);
					String final222 = cadenaTerminada.substring(posicion3 + 8, cadenaTerminada.length());
					String cadenaFinal22 = principio3 + sol.getEventoAsis().getTitulo() + final222;
					cadenaTerminada = cadenaFinal22;
				}
			}
		}
		
		textArea.setText(cadenaTerminada);
	
		textField.setColumns(10);
		
		JLabel lblNewLabel_2_2 = new JLabel("Constancia");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setForeground(SystemColor.window);
		lblNewLabel_2_2.setFont(new Font("SimSun", Font.BOLD, 17));
		lblNewLabel_2_2.setBounds(10, 78, 291, 34);
		getContentPane().add(lblNewLabel_2_2);
		
		JButton btnAgregarFirma = new JButton("Agregar Firma");
		btnAgregarFirma.setFont(new Font("SimSun", Font.BOLD, 14));
		btnAgregarFirma.setBounds(455, 450, 138, 23);
		getContentPane().add(btnAgregarFirma);
		
		tfNombre = new JTextField();
		tfNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfNombre.setEditable(false);
		tfNombre.setText(sol.getEstSol().getNombre());
		tfNombre.setColumns(10);
		tfNombre.setBounds(361, 124, 108, 28);
		getContentPane().add(tfNombre);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Estudiante");
		lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_2_1.setFont(new Font("SimSun", Font.BOLD, 17));
		lblNewLabel_2_2_1.setBounds(361, 78, 232, 34);
		getContentPane().add(lblNewLabel_2_2_1);
		
		tfApellido = new JTextField();
		tfApellido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfApellido.setEditable(false);
		tfApellido.setText(sol.getEstSol().getApellido());
		tfApellido.setColumns(10);
		tfApellido.setBounds(485, 124, 108, 28);
		getContentPane().add(tfApellido);
		
		tfEventoDetalle = new JTextField();
		tfEventoDetalle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfEventoDetalle.setEditable(false);
		tfEventoDetalle.setText(sol.getEventoAsis().getTutor().getNombre());
		tfEventoDetalle.setColumns(10);
		tfEventoDetalle.setBounds(485, 208, 108, 28);
		getContentPane().add(tfEventoDetalle);
		
		tfEventoNombre = new JTextField();
		tfEventoNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfEventoNombre.setEditable(false);
		tfEventoNombre.setText(sol.getEventoAsis().getTitulo());
		tfEventoNombre.setColumns(10);
		tfEventoNombre.setBounds(361, 208, 108, 28);
		getContentPane().add(tfEventoNombre);
		
		JTextArea txAreaDetalle = new JTextArea();
		txAreaDetalle.setEditable(false);
		txAreaDetalle.setWrapStyleWord(true);
		txAreaDetalle.setText(sol.getInfoAdj());
		txAreaDetalle.setLineWrap(true);
		txAreaDetalle.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txAreaDetalle.setBackground(Color.WHITE);
		txAreaDetalle.setBounds(361, 292, 232, 78);
		getContentPane().add(txAreaDetalle);
		
		JButton btnRegistrarAccion = new JButton("Registrar Accion");
		btnRegistrarAccion.setFont(new Font("SimSun", Font.BOLD, 14));
		btnRegistrarAccion.setBounds(287, 450, 158, 23);
		getContentPane().add(btnRegistrarAccion);
		
		JButton btnSolicitar = new JButton("Procesar");
		btnSolicitar.setFont(new Font("SimSun", Font.BOLD, 14));
		btnSolicitar.setBounds(287, 416, 158, 23);
		getContentPane().add(btnSolicitar);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Evento y Encargado");
		lblNewLabel_2_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_2_1_1.setFont(new Font("SimSun", Font.BOLD, 17));
		lblNewLabel_2_2_1_1.setBounds(361, 163, 232, 34);
		getContentPane().add(lblNewLabel_2_2_1_1);
		
		JLabel lblNewLabel_2_2_1_1_1 = new JLabel("Informacion Adicional");
		lblNewLabel_2_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_2_1_1_1.setFont(new Font("SimSun", Font.BOLD, 17));
		lblNewLabel_2_2_1_1_1.setBounds(361, 247, 232, 34);
		getContentPane().add(lblNewLabel_2_2_1_1_1);
		setTitle("Ver Constancia");
		
		// Logica botones

		EstudianteBeanRemote estudianteBean = (EstudianteBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/EstudianteBean!com.services.EstudianteBeanRemote");

		TutorBeanRemote tutorBean = (TutorBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/TutorBean!com.services.TutorBeanRemote");

		AnalistaBeanRemote analistaBean = (AnalistaBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/AnalistaBean!com.services.AnalistaBeanRemote");

		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/UsuarioBean!com.services.UsuarioBeanRemote");

		EventoBeanRemote eventoBean = (EventoBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/EventoBean!com.services.EventoBeanRemote");

		SolicitudBeanRemote solicitudBean = (SolicitudBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/SolicitudBean!com.services.SolicitudBeanRemote");

		AccionBeanRemote accionBean = (AccionBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/AccionBean!com.services.AccionBeanRemote");
		
		ModeloBeanRemote modeloBean = (ModeloBeanRemote) InitialContext
				.doLookup("EjEnterpriseEJB/ModeloBean!com.services.ModeloBeanRemote");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Listar_SConstanciasAnalista pAnalistaW = null;
				try {
					pAnalistaW = new Listar_SConstanciasAnalista(usuario);
					pAnalistaW.setVisible(true);
					dispose();
				} catch (NamingException | ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pAnalistaW.setVisible(true);
				pAnalistaW.setLocationRelativeTo(null);
				dispose();
			}
		});

		btnSolicitar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ruta != null) {
					Document document = new Document(PageSize.A4, 35, 30, 50, 50);
					
					// El archivo pdf que vamos a generar
					FileOutputStream fileOutputStream = null;
					try {
						fileOutputStream = new FileOutputStream(
						  "reportePDFDatoJava.pdf");
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					 
					// Obtener la instancia del PdfWriter
					try {
						PdfWriter.getInstance(document, fileOutputStream);
					} catch (DocumentException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// Abrir el documento
					document.open();
					
					// Crear las fuentes para el contenido y los titulos
					com.itextpdf.text.Font fontContenido = FontFactory.getFont(
					  FontFactory.TIMES_ROMAN.toString(), 12, 0,
					  BaseColor.BLACK);
					com.itextpdf.text.Font fontTitulos = FontFactory.getFont(
					  FontFactory.TIMES_BOLDITALIC, 17, 0,
					  BaseColor.BLACK);
					Image img = null;
					try {
						img = Image.getInstance("src/PNG/logoasfas.jpg");
						img.scaleToFit(125, 250);
					} catch (BadElementException | IOException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}
			        try {
						document.add(img);
					} catch (DocumentException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}
			        
					Paragraph paragraph = new Paragraph();
					paragraph.add(new Phrase(Chunk.NEWLINE));
					paragraph.add(new Phrase("CONSTANCIA " + textField.getText(), fontTitulos));
					paragraph.add(new Phrase(Chunk.NEWLINE));
					paragraph.add(new Phrase(Chunk.NEWLINE));
					paragraph.add(new Phrase(Chunk.NEWLINE));
					paragraph.add(new Phrase(textArea.getText(), fontContenido));
					paragraph.add(new Phrase(Chunk.NEWLINE));
					paragraph.add(new Phrase(Chunk.NEWLINE));
					paragraph.add(new Phrase("Se expide la presente constancia en la fecha "+ LocalDate.now()+" a los efectos de ser presentada"
							+ " ante quien corresponda", fontContenido));
					paragraph.add(new Phrase(Chunk.NEWLINE));
					paragraph.add(new Phrase(Chunk.NEWLINE));
					Image img2 = null;
					try {
						img2 = Image.getInstance(ruta);
						img2.scaleToFit(200, 200);
					} catch (BadElementException | IOException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}
					paragraph.add(img2);
					paragraph.add(new Phrase("----------------------------------------", fontContenido));
					paragraph.add(new Phrase(Chunk.NEWLINE));
					paragraph.add(new Phrase("Firma", fontContenido));
					img2.setAlignment(Element.ALIGN_CENTER);
					paragraph.add(new Phrase(Chunk.NEWLINE));
					paragraph.add(new Phrase(Chunk.NEWLINE));
					paragraph.add(new Phrase(Chunk.NEWLINE));
					paragraph.add(new Phrase(Chunk.NEWLINE));
					paragraph.add(new Phrase(Chunk.NEWLINE));
					paragraph.add(new Phrase(Chunk.NEWLINE));
					paragraph.add(new Phrase(Chunk.NEWLINE));
					paragraph.add(new Phrase(Chunk.NEWLINE));
					paragraph.add(new Phrase(Chunk.NEWLINE));
					paragraph.add(new Phrase(Chunk.NEWLINE));
					paragraph.add(new Phrase(Chunk.NEWLINE));
					paragraph.add(new Phrase(Chunk.NEWLINE));
					
					paragraph.add(new Phrase("----------------------------------------", fontContenido));
					paragraph.add(new Phrase("\r\n"
							+ " Debe contar con firma y sello de persona autorizada para que tenga validez"
							+ "Av. Italia 6201 Edificio Los Talas – CP 11500 Montevideo, Uruguay – Tel. (+598) 26038832 – secretaria@utec.edu.uy."
							+ "www.utec.edu.uy", fontContenido));
					paragraph.setAlignment(Element.ALIGN_CENTER);
					
					try {
						document.add(paragraph);
					} catch (DocumentException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
					// Cerrar el documento
					document.close();
					 
					// Abrir el archivo
					File file = new File("reportePDFDatoJava.pdf");
					try {
						Desktop.getDesktop().open(file);
						
						SOLICITUD sol2 = solicitudBean
								.findSol(sol.getId_solicitud())
								.get(0);
						sol2.setAnalist(usuario);
						solicitudBean.cambiarEstado(sol2, EstadoSolicitud.EN_PROCESO);
						
						ACCIONANALISTACONSTANCIA acc = new ACCIONANALISTACONSTANCIA();
						acc.setAnalista(usuario);
						acc.setFecha(LocalDate.now());
						acc.setDetalle("Emision de constancia");
						acc.setSolicitud(sol);
						
						accionBean.addAccion(acc);
						
						JOptionPane.showMessageDialog(null, "Constancia emitida con exito");
						
						MandarEmail("reportePDFDatoJava.pdf", sol2.getEstSol());
					} catch (IOException | ServiciosException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null, "Debe seleccionar una firma para poder emitir.");
				}
				
			}
		});
		
		btnAgregarFirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        
				JFileChooser fileChooser = new JFileChooser();
			    fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			    
			    FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png"); 
			    fileChooser.setFileFilter(imgFilter);

			    int result = fileChooser.showOpenDialog(null);

			    if (result != JFileChooser.CANCEL_OPTION) {

			        File fileName = fileChooser.getSelectedFile();

			        if ((fileName == null) || (fileName.getName().equals(""))) {
			        	ruta = "...";
			        } else {
			        	ruta = (fileName.getAbsolutePath());
			        	JOptionPane.showMessageDialog(null, "Firma cargada con exito");
			        }
			    }
			}
		});
		
		btnSolicitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			
						if(sol.getEstado() == EstadoSolicitud.INGRESADO) {
							sol.setAnalist(usuario);
							solicitudBean.cambiarEstado(sol, EstadoSolicitud.EN_PROCESO);
							
							ACCIONANALISTACONSTANCIA acc = new ACCIONANALISTACONSTANCIA();
							acc.setAnalista(usuario);
							acc.setFecha(LocalDate.now());
							acc.setDetalle("Cambio a Solicitud En Proceso");
							acc.setSolicitud(sol);
							
							accionBean.addAccion(acc);
							JOptionPane.showMessageDialog(null, "Estado cambiado con exito");
							SOLICITUD sol2 = solicitudBean.findSol(sol.getId_solicitud()).get(0);
							
							MandarEmail(sol2);
						}
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
		btnRegistrarAccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String detalle = JOptionPane.showInputDialog("Aclare detalle de accion");
					if(detalle != null) {
						if(detalle.equals("")) {
							JOptionPane.showMessageDialog(null, "Debe ingresar detalle de accion");
						}else {
								ACCIONANALISTACONSTANCIA acc = new ACCIONANALISTACONSTANCIA();
								acc.setAnalista(usuario);
								acc.setDetalle(detalle);
								acc.setFecha(LocalDate.now());
								try {
									sol.setAnalist(usuario);
									solicitudBean.cambiarEstado(sol, EstadoSolicitud.INGRESADO);
								} catch (NumberFormatException | ServiciosException e2) {
									e2.printStackTrace();
								}
								
								try {
									SOLICITUD sol2 = solicitudBean.findSol(sol.getId_solicitud()).get(0);
									acc.setSolicitud(sol2);
									accionBean.addAccion(acc);
									JOptionPane.showMessageDialog(null, "Accion registrada con exito");
									MandarEmailAccion(sol2, acc);
								} catch (ServiciosException e1) {
									e1.printStackTrace();
								}
						}
					}
			}
		});
		
	}
	
	public void MandarEmail(String ruta, ESTUDIANTE estudiante) {
		Properties properties = new Properties();

	      properties.put("mail.smtp.auth", true);
	      properties.put("mail.smtp.host", "smtp.gmail.com");
	      properties.put("mail.smtp.port", 587);
	      properties.put("mail.smtp.starttls.enable", true);
	      properties.put("mail.transport.protocl", "smtp");
	      properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	      
	      Session session = Session.getInstance(properties, new Authenticator() {
	    	  @Override
	    	  protected PasswordAuthentication getPasswordAuthentication() {
	    		  return new PasswordAuthentication("cristofer.cabrera@estudiantes.utec.edu.uy","_.CL5315841c");
	    	  }
	      });

	      
	      try {
	    	Message message = new MimeMessage(session);
			message.setSubject("Emision de Constancia " + estudiante.getNombre());
			
			 Address addressTo = new InternetAddress(estudiante.getMail());
		      message.setRecipient(Message.RecipientType.TO, addressTo);
		      
		      MimeMultipart multipart = new MimeMultipart();
		      
		      MimeBodyPart attachment = new MimeBodyPart();
		      attachment.attachFile(new File(ruta));
		      
		      MimeBodyPart messageBodyPart = new MimeBodyPart();
		      messageBodyPart.setContent("<h1> ¡CONSTANCIA EMITIDA! ¡SALUDOS!</h1> ", "text/html");
		      
		      multipart.addBodyPart(attachment);
		      multipart.addBodyPart(messageBodyPart);
		      
		      message.setContent(multipart);
		      
		      Transport.send(message);
	     } catch (MessagingException | IOException e) {
			e.printStackTrace();
	     } 
	}
	
	public void MandarEmail(SOLICITUD sol) {
		Properties properties = new Properties();

	      properties.put("mail.smtp.auth", true);
	      properties.put("mail.smtp.host", "smtp.gmail.com");
	      properties.put("mail.smtp.port", 587);
	      properties.put("mail.smtp.starttls.enable", true);
	      properties.put("mail.transport.protocl", "smtp");
	      properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	      
	      Session session = Session.getInstance(properties, new Authenticator() {
	    	  @Override
	    	  protected PasswordAuthentication getPasswordAuthentication() {
	    		  return new PasswordAuthentication("cristofer.cabrera@estudiantes.utec.edu.uy","_.CL5315841c");
	    	  }
	      });

	      
	      try {
	    	Message message = new MimeMessage(session);
			message.setSubject("Cambio de Estado |  " + sol.getEstado() + " | " + sol.getEstSol().getNombre());
			
			 Address addressTo = new InternetAddress(sol.getEstSol().getMail());
		      message.setRecipient(Message.RecipientType.TO, addressTo);
		      
		      MimeMultipart multipart = new MimeMultipart();
		      
		      MimeBodyPart messageBodyPart = new MimeBodyPart();
		      messageBodyPart.setContent("<h1> SU SOLICITUD HA CAMBIADO DE ESTADO A </h1> " + sol.getEstado(), "text/html");
		      
		      multipart.addBodyPart(messageBodyPart);
		      
		      message.setContent(multipart);
		      
		      Transport.send(message);
	     } catch (MessagingException e) {
			e.printStackTrace();
	     }
	      
	}
	
	public void MandarEmailAccion(SOLICITUD sol, ACCIONANALISTACONSTANCIA a) {
		Properties properties = new Properties();

	      properties.put("mail.smtp.auth", true);
	      properties.put("mail.smtp.host", "smtp.gmail.com");
	      properties.put("mail.smtp.port", 587);
	      properties.put("mail.smtp.starttls.enable", true);
	      properties.put("mail.transport.protocl", "smtp");
	      properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	      
	      Session session = Session.getInstance(properties, new Authenticator() {
	    	  @Override
	    	  protected PasswordAuthentication getPasswordAuthentication() {
	    		  return new PasswordAuthentication("cristofer.cabrera@estudiantes.utec.edu.uy","_.CL5315841c");
	    	  }
	      });

	      
	      try {
	    	Message message = new MimeMessage(session);
			message.setSubject("ACCION SOBRE TU RECIENTE SOLICITUD DE CONSTANCIA");
			
			 Address addressTo = new InternetAddress(sol.getEstSol().getMail());
		      message.setRecipient(Message.RecipientType.TO, addressTo);
		      
		      MimeMultipart multipart = new MimeMultipart();
		      
		      MimeBodyPart messageBodyPart = new MimeBodyPart();
		      messageBodyPart.setContent("<h1> Accion del Analista "+ sol.getAnalist().getNombre()+ " sobre tu solicitud de constancia </h1></br>"
		    		  + " <h3> Detalle de la accion: " + a.getDetalle() + "</h3></br>"
		    		  + "<h2> Su solicitud de constancia pasa a estado de " + sol.getEstado() + "</h2>", "text/html");
		      
		      multipart.addBodyPart(messageBodyPart);
		      
		      message.setContent(multipart);
		      
		      Transport.send(message);
	     } catch (MessagingException e) {
			e.printStackTrace();
	     }
	      
	}
}