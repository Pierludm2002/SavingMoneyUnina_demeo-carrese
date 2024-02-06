package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Controller.LoginController;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import java.awt.Canvas;
import javax.swing.JSlider;

public class LoginGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField emailField;
	private JPasswordField passwordField;
	LoginController lc; 
	private JButton btnAccedi ;
	private JButton btnNewButton;
	private JPanel panel;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	 * Create the frame.
	 */
	public LoginGUI() {
		setFont(new Font("Verdana", Font.PLAIN, 14));
		setTitle("LOGIN-SAVINMONEYUNINA");
		
		getContentPane().setBackground(SystemColor.window);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 650, 400);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{207, 221, 225, 0};
		gridBagLayout.rowHeights = new int[]{100, 40, 40, 40, 0, 39, 49, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		getContentPane().add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		ImageIcon icon = new ImageIcon("Images/logo.png"); 
		int newWidth = (int) Math.round(icon.getIconWidth() * (double) 100/icon.getIconHeight()); 
		Image imageSmaller = icon.getImage().getScaledInstance(newWidth, 100, Image.SCALE_SMOOTH); 
		ImageIcon iconSmaller = new ImageIcon(imageSmaller); 
		JLabel lblLogo = new JLabel(iconSmaller);
		panel.add(lblLogo);
		
		JLabel lblEmail= new JLabel("Inserire nome utente ( o email) e password. ");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.gridwidth = 3;
		gbc_lblEmail.insets = new Insets(0, 0, 15, 0);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 1;
		getContentPane().add(lblEmail, gbc_lblEmail);
		emailField = new JTextField(); 
		emailField.setForeground(Color.GRAY);
		emailField.setFont(emailField.getFont().deriveFont(14f));
		GridBagConstraints gbc_emailField = new GridBagConstraints();
		gbc_emailField.fill = GridBagConstraints.HORIZONTAL;
		gbc_emailField.insets = new Insets(0, 0, 15, 5);
		gbc_emailField.gridx = 1;
		gbc_emailField.gridy = 2;
		getContentPane().add(emailField, gbc_emailField);
		emailField.setColumns(10);
		passwordField = new JPasswordField();
		passwordField.setToolTipText("");
		passwordField.setForeground(Color.YELLOW);
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.BOTH;
		gbc_passwordField.insets = new Insets(0, 0, 15, 5);
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 3;
		getContentPane().add(passwordField, gbc_passwordField);
		
		btnAccedi = new JButton("Accedi");  
		
		btnAccedi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 SwingUtilities.invokeLater(() -> {
					 //String email = emailField.getText();
			         //String password = new String(passwordField.getPassword())
			         if(lc.AttemptLogin()) {
			        	 dispose(); 
			         }
			         passwordField.setText("");
			         
			         
				 });
			}
		});
		
		
		lc = new LoginController(emailField,passwordField, btnAccedi); 
		GridBagConstraints gbc_btnAccedi = new GridBagConstraints();
		gbc_btnAccedi.insets = new Insets(0, 0, 5, 5);
		gbc_btnAccedi.anchor = GridBagConstraints.NORTH;
		gbc_btnAccedi.gridx = 1;
		gbc_btnAccedi.gridy = 4;
		getContentPane().add(btnAccedi, gbc_btnAccedi);
		
		JLabel lblPsw = new JLabel("Altrimenti ");
		GridBagConstraints gbc_lblPsw = new GridBagConstraints();
		gbc_lblPsw.insets = new Insets(0, 0, 5, 5);
		gbc_lblPsw.gridx = 1;
		gbc_lblPsw.gridy = 5;
		getContentPane().add(lblPsw, gbc_lblPsw);
		
		btnNewButton = new JButton("Nuovo utente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				lc.OpenSignInGUI();
				dispose(); 
				
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 6;
		getContentPane().add(btnNewButton, gbc_btnNewButton);
		
	}
}
 