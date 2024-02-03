package Entity;

import java.util.ArrayList;

public class Wallet {
	private String idWallet; 
	private String idOwner; 
	private ArrayList<CreditCard> listaCarte; 
	private float spesaTotale; 
	private float saldoTotale; 
	
	
	public String getIdWallet() {
		return idWallet;
	}
	public void setIdWallet(String idWallet) {
		this.idWallet = idWallet;
	}
	public String getIdOwner() {
		return idOwner;
	}
	public void setIdOwner(String idOwner) {
		this.idOwner = idOwner;
	}
	public float getSpesaTotale() {
		return spesaTotale;
	}
	public void setSpesaTotale(float spesaTotale) {
		this.spesaTotale = spesaTotale;
	}
	public float getSaldoTotale() {
		return saldoTotale;
	}
	public void setSaldoTotale(float saldoTotale) {
		this.saldoTotale = saldoTotale;
	}
	public Wallet(String idWallet, String idOwner, float spesaTotale, float saldoTotale) {
		super();
		this.idWallet = idWallet;
		this.idOwner = idOwner;
		this.spesaTotale = spesaTotale;
		this.saldoTotale = saldoTotale;
		 
	}
	
	public void addCarta(CreditCard carta){  
			if(listaCarte == null) { 
				listaCarte = new ArrayList<CreditCard>(); 
			}
		listaCarte.add(carta); 
	}
	
	public void removeCarta(String numeroCarta){
		if(listaCarte != null) {
		listaCarte.removeIf(carta -> carta.getNumeroCarta().equals(numeroCarta)); 
		}
	}
	
	
}