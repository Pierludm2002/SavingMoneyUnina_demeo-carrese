package Controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

import Database.DBconnection;

public class SignInController {
	private JTextField emailField, nameField, surnameField, fieldAnno, fieldMese,fieldGiorno;
	private JPasswordField pswField;
	Connection conn;
	JButton btnRegistrati;


	public SignInController(JTextField emailField, JTextField nameField, JTextField surnameField, JTextField fieldAnno,
			JTextField fieldMese, JTextField fieldGiorno, JPasswordField pswField, JButton btnRegistrati) {
		super();
		this.emailField = emailField;
		this.nameField = nameField;
		this.surnameField = surnameField;
		this.fieldAnno = fieldAnno;
		this.fieldMese = fieldMese;
		this.fieldGiorno = fieldGiorno;
		this.pswField = pswField;
		this.btnRegistrati = btnRegistrati;

		try {
			conn = DBconnection.getInstance().getConnection();
		}catch(SQLException e) {
			System.out.println("Connessione per invio dati fallita!");
			e.printStackTrace();

		}
	}


	public boolean InviaRegistrazione() {
		String email = emailField.getText();
		String psw = new String(pswField.getPassword());
		String name = nameField.getText();
		String surname = surnameField.getText();
		String giorno = fieldGiorno.getText();
		String mese = fieldMese.getText();
		String anno = fieldAnno.getText();
		String dataDiNascita = anno + "-" + mese + "-" + giorno;
		BusinessLogic bl = new BusinessLogic();
		String idUtente = bl.generaId(TipoEntita.User);
		boolean inviato = false ; 

			if(email.isEmpty()) {
				System.out.println("email non inserita");
				showCampoMancante("email");
				inviato = false; 
			}else if( psw.isEmpty()) {
				System.out.println("password non inserita");
				showCampoMancante("password");
				inviato = false; 
			}else if (name.isEmpty()) {
				System.out.println("nome non inserito");
				showCampoMancante("nome");
				inviato = false; 
			}else if(surname.isEmpty()) {
				System.out.println("cognome non inserito");
				showCampoMancante("cognome");
				inviato= false ;
			}else if(giorno.isEmpty() || mese.isEmpty() || anno.isEmpty()) {
				System.out.println("Data mancante");
				showCampoMancante("data di nascita");
				inviato = false; 
			}
			else {
				try {
					Statement stmt = conn.createStatement();
					String query = "INSERT INTO utente(nome,cognome,data_nascita,id_utente,email,password)"
								+ " VALUES('"+name+"','"+surname+"','"+ dataDiNascita +"','"+idUtente+"','"+email+"','"+ psw +"')";
					int numRighe = stmt.executeUpdate(query);
					if(numRighe == 1) {
						System.out.println("Inserimento avvenuto con successo");
						inviato = true; 
					}else {
						System.out.println("Inserimento fallito");
						inviato = false; 
					}

				}catch(SQLException e) {
					   System.out.println("Errore durante l'inserimento: " + e.getMessage());
					   e.printStackTrace();
					   inviato = false; 
				}
			}
		return inviato; 


	}

	private void showCampoMancante(String campo){
		String errore = "Inserire" + campo;

		JOptionPane.showMessageDialog(null,errore ,"Errore", JOptionPane.ERROR_MESSAGE) ;
	}
}
