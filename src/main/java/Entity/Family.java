package Entity;

public class Family {
	private String idFamiglia;
	private String cognome; 
	private int numComponenti; 
	private String idAmm;
	
	public String getIdFamiglia() {
		return idFamiglia;
	}
	public void setIdFamiglia(String idFamiglia) {
		this.idFamiglia = idFamiglia;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public int getNumComponenti() {
		return numComponenti;
	}
	public void setNumComponenti(int numComponenti) {
		this.numComponenti = numComponenti;
	}
	public String getIdAmm() {
		return idAmm;
	}
	public void setIdAmm(String idAmm) {
		this.idAmm = idAmm;
	}
	
	
	public Family(String idFamiglia, String cognome, int numComponenti, String idAmm) {
		super();
		this.idFamiglia = idFamiglia;
		this.cognome = cognome;
		this.numComponenti = numComponenti;
		this.idAmm = idAmm;
	} 
	

	
	
}