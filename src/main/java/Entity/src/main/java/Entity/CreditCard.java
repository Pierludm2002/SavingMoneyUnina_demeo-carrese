package Entity;

public class CreditCard {
	private String numeroCarta; 
	private int CVV; 
	private double saldo; 
	private String meseScadenza; 
	private String annoScadenza; 
	private String idOwner;  
	private String tipoCarta;
	private String idWallet; 
	
	public String getNumeroCarta() {
		return numeroCarta;
	}
	public void setNumeroCarta(String numeroCarta) {
		this.numeroCarta = numeroCarta;
	}
	public int getCVV() {
		return CVV;
	}
	public void setCVV(int cVV) {
		CVV = cVV;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getMeseScadenza() {
		return meseScadenza;
	}
	public void setMeseScadenza(String meseScadenza) {
		this.meseScadenza = meseScadenza;
	}
	public String getAnnoScadenza() {
		return annoScadenza;
	}
	public void setAnnoScadenza(String annoScadenza) {
		this.annoScadenza = annoScadenza;
	}
	public String getOwner() {
		return idOwner;
	}
	public void setOwner(String idOwner) {
		this.idOwner =idOwner;
	}
	public String getTipoCarta() {
		return tipoCarta;
	}
	public void setTipoCarta(String tipoCarta) {
		this.tipoCarta = tipoCarta;
	} 
	
	public String getIdWallet() {
		return idWallet;
	}
	public void setIdWallet(String idWallet) {
		this.idWallet = idWallet;
	}

	private static int contatore = 1;

    public static String generaCodice() {
        String parteNumerica = String.format("%05d", contatore);
        String codiceGenerato = "d" + parteNumerica;
        contatore++;

        return codiceGenerato;
    }
    
    
	public Transaction newTransaction(String numeroCarta, String idOwner){
		Transaction transaction = new Transaction("CATEGORIA", 10.53, generaCodice(),numeroCarta, idOwner); 
		return transaction; 
	}
	
	public CreditCard(String numeroCarta, int cVV, double saldo, String meseScadenza, String annoScadenza,
			String idOwner, String tipoCarta, String idWallet) {
		super();
		this.numeroCarta = numeroCarta;
		CVV = cVV;
		this.saldo = saldo;
		this.meseScadenza = meseScadenza;
		this.annoScadenza = annoScadenza;
		this.idOwner = idOwner;
		this.tipoCarta = tipoCarta;
		this.idWallet = idWallet;
	}


public boolean effettuaPagamento(double importo) {
    if (saldo >= importo) {
        saldo -= importo;
        return true;
    } else {
        return false;
    }
}

	
}