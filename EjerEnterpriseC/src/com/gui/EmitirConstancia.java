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

	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
	}

	public EmitirConstancia(ANALISTA usuario, SOLICITUD sol) throws NamingException, ServiciosException {
		super("Administración Secretaría");
		setResizable(false);
		setBackground(Color.WHITE);
		getContentPane().setBackground(SystemColor.activeCaption);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(550, 471);
		setLocationRelativeTo(null);
		setVisible(true);
		getContentPane().setLayout(null);

		JButton btnCancelar = new JButton("Volver");
		btnCancelar.setBounds(10, 398, 97, 23);
		btnCancelar.setFont(new Font("SimSun", Font.BOLD, 13));
		getContentPane().add(btnCancelar);

		JButton btnSolicitar = new JButton("Emitir");
		btnSolicitar.setBounds(366, 398, 158, 23);
		btnSolicitar.setFont(new Font("SimSun", Font.BOLD, 14));
		getContentPane().add(btnSolicitar);

		JLabel lblNewLabel_2 = new JLabel("Emitir Constancia");
		lblNewLabel_2.setBounds(10, 11, 448, 34);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("SimSun", Font.BOLD, 20));
		getContentPane().add(lblNewLabel_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 19));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setBackground(Color.WHITE);
		textArea.setBounds(10, 176, 514, 177);
		getContentPane().add(textArea);
		
		JLabel lblNewLabel_2_1 = new JLabel("Header");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(SystemColor.window);
		lblNewLabel_2_1.setFont(new Font("SimSun", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(10, 139, 514, 44);
		getContentPane().add(lblNewLabel_2_1);
		
		textField = new JTextField();
		textField.setBounds(190, 100, 158, 28);
		getContentPane().add(textField);
		textField.setText(sol.getTipo().getTipo());
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
		
		JLabel lblNewLabel_2_2 = new JLabel("Tipo de Constancia");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setForeground(SystemColor.window);
		lblNewLabel_2_2.setFont(new Font("SimSun", Font.BOLD, 17));
		lblNewLabel_2_2.setBounds(10, 68, 514, 34);
		getContentPane().add(lblNewLabel_2_2);
		
		JButton btnAgregarFirma = new JButton("Agregar Firma");
		btnAgregarFirma.setFont(new Font("SimSun", Font.BOLD, 14));
		btnAgregarFirma.setBounds(190, 398, 158, 23);
		getContentPane().add(btnAgregarFirma);
		setTitle("Emitir Constancias");
		
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

		btnSolicitar.addActionListener(new ActionListener() {
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
	    		  return new PasswordAuthentication("","");
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
}