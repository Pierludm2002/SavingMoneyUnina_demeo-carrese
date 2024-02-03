package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Controller.LoginController;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JPasswordField;
import java.awt.SystemColor;

public class LoginGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField emailField;
	private JPasswordField passwordField;
	LoginController loginController; 
	private JButton btnAccedi ;

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
	 
		btnAccedi = new JButton("Accedi");  
		emailField = new JTextField(); 
		passwordField = new JPasswordField();
		
		LoginController lc = new LoginController(emailField,passwordField, btnAccedi); 
		
		getContentPane().setBackground(SystemColor.window);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 650, 400);
		getContentPane().setLayout(null);
		
		btnAccedi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 SwingUtilities.invokeLater(() -> {
					 //String email = emailField.getText();
			         //String password = new String(passwordField.getPassword());
			            
			         loginController.AttemptLogin(); 
			         passwordField.setText(""); 
			         
				 });
			}
		});
		btnAccedi.setBounds(155, 200, 117, 29);
		getContentPane().add(btnAccedi);
		
		emailField.setBounds(225, 125, 145, 16);
		getContentPane().add(emailField);
		emailField.setColumns(10);
		
		JLabel lblEmail= new JLabel("Username o email:");
		lblEmail.setBounds(75, 125, 117, 16);
		getContentPane().add(lblEmail);
		
		JLabel lblPsw = new JLabel("Password:");
		lblPsw.setBounds(75, 150, 117, 16);
		getContentPane().add(lblPsw);
		
		
		passwordField.setBounds(225, 150, 145, 16);
		getContentPane().add(passwordField);
		
	}
	
}
 