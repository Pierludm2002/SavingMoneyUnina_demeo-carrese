package Entity;

public class Transaction {
	private String categoria;  
	private double importo; 
	private String idTransaction; 
	private String numCarta; 
	private String idUtente;
	
	public Transaction(String categoria, double importo, String idTransaction, String numCarta, String idUtente) {
		super();
		this.categoria = categoria;
		this.importo = importo;
		this.idTransaction = idTransaction;
		this.numCarta = numCarta;
		this.idUtente = idUtente;
		
	}

	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public double getImporto() {
		return importo;
	}


	public void setImporto(double importo) {
		this.importo = importo;
	}


	public String getIdTransaction() {
		return idTransaction;
	}


	public void setIdTransaction(String idTransaction) {
		this.idTransaction = idTransaction;
	}


	public String getNumCarta() {
		return numCarta;
	}


	public void setNumCarta(String numCarta) {
		this.numCarta = numCarta;
	}


	public String getIdUtente() {
		return idUtente;
	}


	public void setIdUtente(String idUtente) {
		this.idUtente = idUtente;
	} 
	
	
}