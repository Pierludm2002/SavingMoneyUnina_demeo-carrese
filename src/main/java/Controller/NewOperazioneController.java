package Controller;

import javax.swing.*;

import Database.DBconnection;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class NewOperazioneController {
	Connection conn; 
	private JTextField fieldNumCarta, fieldCategoria; 
	private JTextField fieldMese; 
	private JTextField fieldAnno; 
	private JTextField fieldCvv;
	private JTextField fieldImporto; 
	private JRadioButton checkPrelievo = new JRadioButton(); 
	private JRadioButton checkDeposito = new JRadioButton(); 
	private JButton btnConferma;
	private JButton btnRicevuta; 
	private String cvvDb; 
	private String dataDb; 
	private float saldoDb;
	private String idProp; 
	BusinessLogic bl = new BusinessLogic(); 
	
	private String idTransazione = bl.generaId(TipoEntita.Transazione); 
	
	public NewOperazioneController(JTextField fieldNumCarta, JTextField fieldMese, JTextField fieldAnno,
			JTextField fieldCvv, JTextField fieldImporto, JRadioButton checkPrelievo, JRadioButton checkDeposito,
			JButton btnConferma, JTextField fieldCategoria, JButton btnRicevuta) {
		super();
		this.fieldNumCarta = fieldNumCarta;
		this.fieldMese = fieldMese;
		this.fieldAnno = fieldAnno;
		this.fieldCvv = fieldCvv;
		this.fieldCategoria = fieldCategoria;
		this.fieldImporto = fieldImporto;
		this.checkPrelievo = checkPrelievo;
		this.checkDeposito = checkDeposito;
		this.btnConferma = btnConferma;
		this.btnRicevuta = btnRicevuta; 
		
		try {
			conn = DBconnection.getInstance().getConnection(); 
		}catch(SQLException e) { 
			System.out.println("Connessione per aggiornare saldo fallita");
			e.printStackTrace();
		}
	} 
	
	public void newOperazione() {
		float importo = Float.parseFloat(fieldImporto.getText()); 
		String numero = fieldNumCarta.getText(); 
		String mese = fieldMese.getText(); 
		String anno = fieldAnno.getText(); 
		String Cvv = fieldCvv.getText(); 
		String dataInserita = mese + "/" + anno; 
		String categoria = fieldCategoria.getText(); 
		LocalDate dataCorrente = LocalDate.now(); 

		
		boolean ricevuto = false; 
		
		String query = "SELECT cvv, data_scadenza, saldo FROM carta_di_credito"
				+ " WHERE num_carta = ?"; 
		try { 
			PreparedStatement pstm = conn.prepareStatement(query); 
			pstm.setString(1, numero);
			ResultSet rs = pstm.executeQuery();
			
			if(rs.next()) { 
				cvvDb = rs.getString("cvv"); 
				dataDb = rs.getString("data_scadenza"); 
				saldoDb = rs.getFloat("saldo"); 
				//idProp = rs.getString("id_utente"); 
				
			}
			
		}catch(SQLException e) { 
			System.out.println("Errore nel prelevare i dati dal database");
			e.printStackTrace();
		}
		
		try { 
			
		
			if(dataDb.equals(dataInserita) && cvvDb.equals(Cvv)) { 
				
				//genera idTransazione e prendi data poi inviare la transazione e aggiornare saldo 
				String query1 = "INSERT INTO transazione VALUES (?,?,?,?,?)"; 
				PreparedStatement pstm1 = conn.prepareStatement(query1);
				
				if((checkPrelievo.isSelected() && importo <= saldoDb) || checkDeposito.isSelected() ) { 
					if(checkPrelievo.isSelected()) {
						importo = -importo; //l'importo dovrà essere sottratto al saldo
					}
					 
				}else {
					JOptionPane.showMessageDialog(null, "Saldo insufficiente", "Errore", JOptionPane.ERROR_MESSAGE);
					ricevuto = false; 
				}
				
				pstm1.setFloat(1, importo);
				pstm1.setString(2,numero); 
				pstm1.setString(3, idTransazione);
				pstm1.setString(4,categoria); //se la categoria non è specificata esiste il gruppo apposito di transazioni 
				pstm1.setDate(5, Date.valueOf(dataCorrente));
				pstm1.executeUpdate(); 
				ricevuto = true; 
			}else { 
				JOptionPane.showMessageDialog(null, "Dati carta errati! \n Riprova", "Errore", JOptionPane.ERROR_MESSAGE); 
				ricevuto = false; 
			}
			
		}catch(SQLException e) { 
			System.out.println("Errore durante il salvataggio della transazione" + e.getMessage());
			
			e.printStackTrace();
			ricevuto = false; 
		}
		System.out.println("Transazione salvata con successo!");
		btnRicevuta.setEnabled(ricevuto); //solo quando la transazione è stata effettuata si può vedere la ricevuta
	}
	
	public void stampaRicevuta()  { 
		
		try { 
			String query = "SELECT importo, num_carta,id_transazione,categoria,data_transazione"
					+ " FROM transazione WHERE id_transazione = ? "; 
			PreparedStatement ps = conn.prepareStatement(query); 
			ps.setString(1, idTransazione);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
	            JFrame frame = new JFrame("Ricevuta Transazione");
	            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	            
	            JPanel panel = new JPanel(new GridLayout(5, 2));
	            panel.setPreferredSize(new Dimension(300,200));
	            panel.add(new JLabel("ID Transazione: "));
	            panel.add(new JLabel(rs.getString("id_transazione")));
	            panel.add(new JLabel("Importo: "));
	            panel.add(new JLabel(rs.getString("importo")));
	            panel.add(new JLabel("Numero Carta: "));
	            panel.add(new JLabel(rs.getString("num_carta")));
	            panel.add(new JLabel("Categoria: "));
	            panel.add(new JLabel(rs.getString("categoria")));
	            panel.add(new JLabel("Data Transazione: "));
	            panel.add(new JLabel(rs.getString("data_transazione")));
	            
	            frame.add(panel);
	            frame.pack();
	            frame.setVisible(true);
	            
	        } else {
	            JOptionPane.showMessageDialog(null, "Transazione non trovata", "Errore", JOptionPane.ERROR_MESSAGE);
	        }
			
	    } catch (SQLException e) { 
	        System.out.println("Errore durante la stampa della ricevuta");
	        e.printStackTrace();
	    }
	}
		
}
