package Controller;
//
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Database.DBconnection;

public class BusinessLogic {
	//
	Connection conn; 
	
	int contatoreUtenti = 0; 
	int contatoreFamiglia = 0; 
	int contatoreTransazioni = 0; 
	//
	BusinessLogic(){ 
		try { 
			conn = DBconnection.getInstance().getConnection(); 
		}catch(SQLException e) { 
			System.out.println("Connessione per ottenere numero di utenti fallita!");
			e.printStackTrace();
			} 
	}
	public int SetNumUtenti(int contatoreUtenti){
		try { 
			Statement stm = conn.createStatement(); 
			String query = "select count(*) as numUtenti from utente "; 
			ResultSet rs = stm.executeQuery(query);
			if(rs.next()) { 
				contatoreUtenti = rs.getInt("numUtenti"); 
			}
			}catch(SQLException e){ 
			 	System.out.println("Errore durante la richiesta : " + e.getMessage());
			 	e.printStackTrace();
			}finally{
				if(conn!=null){ 
					try{
						conn.close(); 	
					}catch(SQLException e){ 
						System.out.println("Errore durante la chiusura della connessione col Database:");
					e.printStackTrace();  
			}
		}
	}
	return contatoreUtenti++; 
}
	
	public String generaId(TipoEntita entita) {
		
	
		switch(entita) { 
			case User: 
				return generaId("u", SetNumUtenti());
			case Famiglia: 
				contatoreFamiglia++; 
				return generaId("f", contatoreFamiglia); 
			case Transazione: 
				contatoreTransazioni++; 
				return generaId("t", contatoreTransazioni); 
			default: 
				return null; 
			
		}
	}
	
	
	public String generaId(String prefisso, int numero) { 
		String numeroFormattato = String.format("%04d",numero); 
		return prefisso + numeroFormattato; 
	}
	
}
