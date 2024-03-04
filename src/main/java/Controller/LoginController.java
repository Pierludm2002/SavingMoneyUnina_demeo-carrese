package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import GUI.HomePageGui;
import GUI.SignInGui;

import javax.swing.*;

import Database.DBconnection;


public class LoginController {
	
	private JTextField emailField; 
	private JPasswordField passwordField; 
	JButton btnAccedi; 
	String idUtente; 
	 
	Connection conn; 
	
	public LoginController() {}
	
	public LoginController(JTextField emailField, JPasswordField passwordField, JButton btnAccedi) {
		super();
		this.emailField = emailField;
		this.passwordField = passwordField;
		this.btnAccedi = btnAccedi;
		try {
			conn = DBconnection.getInstance().getConnection();
		}catch(SQLException e){ 
			showErrorDialog("Errore durante l'ottenimento della connessione"); 
			e.printStackTrace();
		} 
	}
	
	
	
	public boolean AttemptLogin() { 
		String email = emailField.getText(); 
		String password = new String(passwordField.getPassword()); 
		
		//Stampe di debug
	    System.out.println("Email: " + email);
	    System.out.println("Password: " + password);
	    
		if(CheckCredentials(email,password)) { 
			
			HomePageGui homePage = new HomePageGui(); 
			homePage.setVisible(true); 
			return true;
		}else return false; 
	}

	private boolean CheckCredentials(String email, String password){
		try {
			if(email.isEmpty() || password.isEmpty()) { 
				showErrorDialog("INSERIRE CREDENZIALI"); 
				return false; 
			}
			Statement stmt = conn.createStatement(); 
			ResultSet rs ; 
			System.out.println("credenziali query "+ email + " psw: " + password);
			String query = "SELECT email, password, id_utente FROM utente WHERE email ='" + email + "'AND password = '" + password+"'"; 
			
			rs = stmt.executeQuery(query); 
			
			if(rs.next() == false) { 
				System.out.println("ERROR , no user has been found");
				return false; 
			}
			else { 
				idUtente = rs.getString("id_utente"); 
				return true; 
			}
			
		}catch(SQLException e) { 
			showErrorDialog("ERRORE durante la comunicazione col db" + e.getMessage()); 
			e.printStackTrace();
			return false;
		}
		
	}
	
	public void OpenSignInGUI() { 
		
		SignInGui signIn = new SignInGui(); 
		signIn.setVisible(true);
		
		
	}
	
	public String getIdUtente() { 
		try {
			String email = emailField.getText(); 
			String query = "SELECT id_utente from utente where email = ?"; 
			PreparedStatement pstm = conn.prepareStatement(query); 
			pstm.setString(1,email); 
			ResultSet rs = pstm.executeQuery(); 
			
			
			if(rs.next()) { 
				String idUtente = rs.getString("id_utente"); 
				return idUtente; 
			}else { 
				return null; 
			}
			
		}catch(SQLException e) { 
			e.printStackTrace();
		}
		return null; 
		
	}

	private void showErrorDialog(String message) {
	    JOptionPane.showMessageDialog(null, message, "Errore", JOptionPane.ERROR_MESSAGE);
	}
}
