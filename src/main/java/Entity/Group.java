package Entity;

import java.util.ArrayList;

public class Group {

	private String categoria; 
	private float totAmount; 
	private ArrayList<Transaction> transactionGroup;
	
	public Group(String categoria, ArrayList<Transaction> transactionGroup) {
		super();
		this.categoria = categoria;
		this.transactionGroup = new ArrayList<Transaction>(); 
		this.totAmount = updateAmount(transactionGroup); 
	}
	
	public Group(String categoria) { 
		this.categoria = categoria; 
		this.totAmount = updateAmount(transactionGroup); 
	}
	
	public float updateAmount(ArrayList<Transaction> categoria) { 
		float somma = 0;
		for(Transaction transaction : categoria) {
			somma += transaction.getImporto(); 
		}
		return somma; 
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public float getTotAmount() {
		return totAmount;
	}

	public void setTotAmount(float totAmount) {
		this.totAmount = totAmount;
	}

	public ArrayList<Transaction> getTransactionGroup() {
		return transactionGroup;
	}

	public void setTransactionGroup(ArrayList<Transaction> transactionGroup) {
		this.transactionGroup = transactionGroup;
	}
	
	
	public void addTransactionToGroup(Transaction transaction) { 
		boolean trovato = false; 
		Group gruppo; 
		for(Transaction trans : transactionGroup) { 
			if(transaction.getCategoria().equals(trans.getCategoria())) { 
				trovato = true; 
				transactionGroup.add(transaction); 
				break; 
			}
		}
		if(!trovato) { 
			gruppo = new Group(transaction.getCategoria()); 
			gruppo.transactionGroup.add(transaction);
		}
	}
}