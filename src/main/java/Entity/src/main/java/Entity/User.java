package Entity;

import java.time.LocalDate; 
import java.util.Scanner;

public class User {
	private String idUtente; 
	private String nome; 
	private String cognome; 
	private LocalDate dataNascita;
	private String ruolo;
	private String email; 
	private String password; 
	
	public String getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(String idUtente) {
		this.idUtente = idUtente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public LocalDate getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String idUtente, String nome, String cognome, LocalDate dataNascita, String email, String password) {
		super();
		this.idUtente = idUtente;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.email = email; 
		this.password = password; 
		
	} 
	
	public void UpdateDatiPersonali(String newName, String newSurname, String newPsw) {
       
        if (newName != null && !newName.isEmpty()) {
            this.nome = newName;
        }
        if (newSurname != null && !newSurname.isEmpty()) {
            this.cognome = newSurname;
        }
        if (newPsw != null && !newPsw.isEmpty()) {
            this.password = newPsw;
        }
    }

	public void EliminaAccount() {
	    // Chiedi all'utente se e sicuro di voler eliminare l'account
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Sei sicuro di voler eliminare l'account? (sì/no)");
	    String risposta = scanner.nextLine();
	
	    // Se la risposta e si elimina l'account
	    if (risposta.equalsIgnoreCase("sì")) {
	        this.nome = null;
	        this.cognome = null;
	        this.email = null;
	        this.password = null;
	        this.ruolo = null;
	        this.idUtente= null;
		    this.dataNascita=null;
	        System.out.println("Account eliminato correttamente.");
	    } else {
	        System.out.println("Operazione annullata.");
	    }
	    scanner.close(); 
	}
}
