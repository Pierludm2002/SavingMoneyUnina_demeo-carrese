package Controller;

public class BusinessLogic {
	int contatoreUtenti = 2; 
	int contatoreFamiglia = 0; 
	int contatoreTransazioni = 0; 
	
	
	public String generaId(TipoEntita entita) {
		switch(entita) { 
			case User: 
				contatoreUtenti++; 
				return generaId("u", contatoreUtenti);
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
