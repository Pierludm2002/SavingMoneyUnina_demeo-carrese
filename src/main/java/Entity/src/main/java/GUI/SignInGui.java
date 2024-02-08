package GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JButton;
import org.jdatepicker.JDatePicker;

import Controller.SignInController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignInGui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textCognome;
	private JTextField textAnno;
	private JTextField textEmail;
	private JPasswordField textPsw;
	private JTextField textMese;
	private JTextField textGiorno;
	//SignInController controller = new SignInController(textEmail,textFieldNome,textCognome,textAnno,
		//	textMese,	textGiorno, textPsw, btnRegistrati); 

	
	public SignInGui() {
		setTitle("Registrazione");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 650, 400);
		contentPane = new JPanel();

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{145, 90, 49, 15, 50, 17, 75, 50, 130};
		gbl_contentPane.rowHeights = new int[]{120, 30, 30, 30, 30, 30, 0, 40, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 10;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		
		ImageIcon icon = new ImageIcon("Images/logo.png"); 
		int newWidth = (int) Math.round(icon.getIconWidth() * (double) 100/icon.getIconHeight()); 
		Image imageSmaller = icon.getImage().getScaledInstance(newWidth, 100, Image.SCALE_SMOOTH); 
		ImageIcon iconSmaller = new ImageIcon(imageSmaller); 
		JLabel lblLogo = new JLabel(iconSmaller);
		panel.add(lblLogo);
		
		JLabel lblNome = new JLabel("Nome: ");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 1;
		contentPane.add(lblNome, gbc_lblNewLabel_2);
		
		textFieldNome = new JTextField();
		GridBagConstraints gbc_textFieldNome = new GridBagConstraints();
		gbc_textFieldNome.gridwidth = 6;
		gbc_textFieldNome.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNome.gridx = 2;
		gbc_textFieldNome.gridy = 1;
		contentPane.add(textFieldNome, gbc_textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblCognome = new JLabel("Cognome: ");
		GridBagConstraints gbc_lblCognome = new GridBagConstraints();
		gbc_lblCognome.insets = new Insets(0, 0, 5, 5);
		gbc_lblCognome.gridx = 1;
		gbc_lblCognome.gridy = 2;
		contentPane.add(lblCognome, gbc_lblCognome);
				
				textCognome = new JTextField();
				GridBagConstraints gbc_textCognome = new GridBagConstraints();
				gbc_textCognome.gridwidth = 6;
				gbc_textCognome.insets = new Insets(0, 0, 5, 5);
				gbc_textCognome.fill = GridBagConstraints.HORIZONTAL;
				gbc_textCognome.gridx = 2;
				gbc_textCognome.gridy = 2;
				contentPane.add(textCognome, gbc_textCognome);
				textCognome.setColumns(10);
				
				JLabel lblDataNascita = new JLabel("Data nascita: ");
				GridBagConstraints gbc_lblDataNascita = new GridBagConstraints();
				gbc_lblDataNascita.insets = new Insets(0, 0, 5, 5);
				gbc_lblDataNascita.gridx = 1;
				gbc_lblDataNascita.gridy = 3;
				contentPane.add(lblDataNascita, gbc_lblDataNascita);
				
				textGiorno = new JTextField();
				GridBagConstraints gbc_textGiorno = new GridBagConstraints();
				gbc_textGiorno.insets = new Insets(0, 0, 5, 5);
				gbc_textGiorno.fill = GridBagConstraints.HORIZONTAL;
				gbc_textGiorno.gridx = 2;
				gbc_textGiorno.gridy = 3;
				contentPane.add(textGiorno, gbc_textGiorno);
				textGiorno.setColumns(10);
				
				JLabel lblNewLabel = new JLabel("/");
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel.gridx = 3;
				gbc_lblNewLabel.gridy = 3;
				contentPane.add(lblNewLabel, gbc_lblNewLabel);
				
				textMese = new JTextField();
				GridBagConstraints gbc_textField = new GridBagConstraints();
				gbc_textField.insets = new Insets(0, 0, 5, 5);
				gbc_textField.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField.gridx = 4;
				gbc_textField.gridy = 3;
				contentPane.add(textMese, gbc_textField);
				textMese.setColumns(10);
				
				JLabel lblslash_1 = new JLabel("/");
				GridBagConstraints gbc_lblslash_1 = new GridBagConstraints();
				gbc_lblslash_1.anchor = GridBagConstraints.EAST;
				gbc_lblslash_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblslash_1.gridx = 5;
				gbc_lblslash_1.gridy = 3;
				contentPane.add(lblslash_1, gbc_lblslash_1);
		
				textAnno = new JTextField();
				GridBagConstraints gbc_textAnno = new GridBagConstraints();
				gbc_textAnno.insets = new Insets(0, 0, 5, 5);
				gbc_textAnno.fill = GridBagConstraints.HORIZONTAL;
				gbc_textAnno.gridx = 6;
				gbc_textAnno.gridy = 3;
				contentPane.add(textAnno, gbc_textAnno);
				textAnno.setColumns(10);
		
		JLabel lbldataFormat = new JLabel("(DD-MM-YYYY)");
		GridBagConstraints gbc_lbldataFormat = new GridBagConstraints();
		gbc_lbldataFormat.gridwidth = 2;
		gbc_lbldataFormat.insets = new Insets(0, 0, 5, 5);
		gbc_lbldataFormat.gridx = 7;
		gbc_lbldataFormat.gridy = 3;
		contentPane.add(lbldataFormat, gbc_lbldataFormat);
		
		JLabel lblEmail = new JLabel("Email: ");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 4;
		contentPane.add(lblEmail, gbc_lblEmail);
		
		textEmail = new JTextField();
		GridBagConstraints gbc_textEmail = new GridBagConstraints();
		gbc_textEmail.gridwidth = 6;
		gbc_textEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textEmail.gridx = 2;
		gbc_textEmail.gridy = 4;
		contentPane.add(textEmail, gbc_textEmail);
		textEmail.setColumns(10);
		
		JLabel lblPsw = new JLabel("Password: ");
		GridBagConstraints gbc_lblPSW = new GridBagConstraints();
		gbc_lblPSW.insets = new Insets(0, 0, 5, 5);
		gbc_lblPSW.gridx = 1;
		gbc_lblPSW.gridy = 5;
		contentPane.add(lblPsw, gbc_lblPSW);
		
		textPsw = new JPasswordField();
		GridBagConstraints gbc_textPsw = new GridBagConstraints();
		gbc_textPsw.gridwidth = 6;
		gbc_textPsw.insets = new Insets(0, 0, 5, 5);
		gbc_textPsw.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPsw.gridx = 2;
		gbc_textPsw.gridy = 5;
		contentPane.add(textPsw, gbc_textPsw);
		textPsw.setColumns(10);
		
		JButton btnRegistrati = new JButton("Registrati");
		SignInController controller = new SignInController(textEmail,textFieldNome,textCognome,textAnno,
				textMese,	textGiorno, textPsw, btnRegistrati); 
		btnRegistrati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.InviaRegistrazione();
			}
		});
		GridBagConstraints gbc_btnRegistrati = new GridBagConstraints();
		gbc_btnRegistrati.gridwidth = 5;
		gbc_btnRegistrati.insets = new Insets(0, 0, 5, 5);
		gbc_btnRegistrati.gridx = 2;
		gbc_btnRegistrati.gridy = 6;
		contentPane.add(btnRegistrati, gbc_btnRegistrati);
		
	
		
		
	}

}
