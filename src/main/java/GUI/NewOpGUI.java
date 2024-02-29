package GUI;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.NewOperazioneController;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JRadioButton;

public class NewOpGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fieldAnno;
	private JTextField fieldNumCarta;
	private JTextField fieldMese;
	private JTextField fieldCvv;
	private JTextField fieldImporto;
	private JTextField fieldCategoria;

	public NewOpGUI() {
		setTitle("Nuova Operazione\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 650, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{50,90,50, 50,54,30, 53, 15, 50, 50,50, 95};
		gbl_contentPane.rowHeights = new int[]{50, 40, 30, 30,30,30,30,40, 40,30};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		ImageIcon backBtnIcon = new ImageIcon("Images/Go Back.png");
		JButton backBtn = new JButton(backBtnIcon); 
		backBtn.setBorder(null); 
		backBtn.setPreferredSize(new Dimension(10,15)); 
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				HomePageGui homegui = new HomePageGui(); 
				homegui.setVisible(true);
			}
		});
		GridBagConstraints gbc_backBtn = new GridBagConstraints();
		gbc_backBtn.gridwidth = 1;
		gbc_backBtn.insets = new Insets(0, 0, 5, 5);
		gbc_backBtn.gridx = 0;
		gbc_backBtn.gridy = 0;
		contentPane.add(backBtn, gbc_backBtn);
		
		ButtonGroup group =new ButtonGroup(); 
		
		JRadioButton rdbtnPrelievo = new JRadioButton("Prelievo\n");
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.gridwidth = 2;
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 3;
		gbc_rdbtnNewRadioButton.gridy = 2;
		contentPane.add(rdbtnPrelievo, gbc_rdbtnNewRadioButton);
		group.add(rdbtnPrelievo); 
		
		JRadioButton rdbtnDeposito = new JRadioButton("Deposito");
		GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_1.anchor = GridBagConstraints.WEST;
		gbc_rdbtnNewRadioButton_1.gridwidth = 3;
		gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_1.gridx = 6;
		gbc_rdbtnNewRadioButton_1.gridy = 2;
		contentPane.add(rdbtnDeposito, gbc_rdbtnNewRadioButton_1);
		group.add(rdbtnDeposito); 
		
		
		
		JLabel lclNumCarta = new JLabel("Numero carta: ");
		GridBagConstraints gbc_lclNumCarta = new GridBagConstraints();
		gbc_lclNumCarta.anchor = GridBagConstraints.WEST;
		gbc_lclNumCarta.gridwidth = 2;
		gbc_lclNumCarta.insets = new Insets(0, 0, 5, 5);
		gbc_lclNumCarta.gridx = 3;
		gbc_lclNumCarta.gridy = 3;
		contentPane.add(lclNumCarta, gbc_lclNumCarta);
		
		fieldNumCarta = new JTextField();
		GridBagConstraints gbc_fieldNumCarta = new GridBagConstraints();
		gbc_fieldNumCarta.gridwidth = 4;
		gbc_fieldNumCarta.insets = new Insets(0, 0, 5, 5);
		gbc_fieldNumCarta.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldNumCarta.gridx = 6;
		gbc_fieldNumCarta.gridy = 3;
		contentPane.add(fieldNumCarta, gbc_fieldNumCarta);
		fieldNumCarta.setColumns(10);
		
		JLabel lblNData = new JLabel("Data scadenza:\n");
		GridBagConstraints gbc_lblNData = new GridBagConstraints();
		gbc_lblNData.anchor = GridBagConstraints.WEST;
		gbc_lblNData.gridwidth = 2;
		gbc_lblNData.insets = new Insets(0, 0, 5, 5);
		gbc_lblNData.gridx = 3;
		gbc_lblNData.gridy = 4;
		contentPane.add(lblNData, gbc_lblNData);
		
		
		fieldMese = new JTextField();
		GridBagConstraints gbc_fieldMese = new GridBagConstraints();
		gbc_fieldMese.insets = new Insets(0, 0, 5, 5);
		gbc_fieldMese.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldMese.gridx = 6;
		gbc_fieldMese.gridy = 4;
		contentPane.add(fieldMese, gbc_fieldMese);
		fieldMese.setColumns(10);
		

		fieldAnno = new JTextField();
		GridBagConstraints gbc_fieldAnno = new GridBagConstraints();
		gbc_fieldAnno.insets = new Insets(0, 0, 5, 5);
		gbc_fieldAnno.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldAnno.gridx = 8;
		gbc_fieldAnno.gridy = 4;
		contentPane.add(fieldAnno, gbc_fieldAnno);
		fieldAnno.setColumns(10);
		
		JLabel lblSlash = new JLabel("/");
		GridBagConstraints gbc_lblSlash = new GridBagConstraints();
		gbc_lblSlash.insets = new Insets(0, 0, 5, 5);
		gbc_lblSlash.gridx = 7;
		gbc_lblSlash.gridy = 4;
		contentPane.add(lblSlash, gbc_lblSlash);
		
		JLabel lblNewLabel_2 = new JLabel("CVV: ");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_2.gridwidth = 2;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 3;
		gbc_lblNewLabel_2.gridy = 5;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		fieldCvv = new JTextField();
		GridBagConstraints gbc_fieldCvv = new GridBagConstraints();
		gbc_fieldCvv.insets = new Insets(0, 0, 5, 5);
		gbc_fieldCvv.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldCvv.gridx = 6;
		gbc_fieldCvv.gridy = 5;
		contentPane.add(fieldCvv, gbc_fieldCvv);
		fieldCvv.setColumns(10);
		
		JLabel lblImporto = new JLabel("Importo: ");
		lblImporto.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		GridBagConstraints gbc_lblImporto = new GridBagConstraints();
		gbc_lblImporto.anchor = GridBagConstraints.WEST;
		gbc_lblImporto.gridwidth = 2;
		gbc_lblImporto.insets = new Insets(0, 0, 5, 5);
		gbc_lblImporto.gridx = 3;
		gbc_lblImporto.gridy = 6;
		contentPane.add(lblImporto, gbc_lblImporto);
		
		fieldImporto = new JTextField();
		GridBagConstraints gbc_fieldImporto = new GridBagConstraints();
		gbc_fieldImporto.gridwidth = 3;
		gbc_fieldImporto.insets = new Insets(0, 0, 5, 5);
		gbc_fieldImporto.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldImporto.gridx = 6;
		gbc_fieldImporto.gridy = 6;
		contentPane.add(fieldImporto, gbc_fieldImporto);
		fieldImporto.setColumns(10);
		
		
		
		JLabel lblNewLabel = new JLabel("Categoria");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 7;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		fieldCategoria = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 4;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 6;
		gbc_textField.gridy = 7;
		contentPane.add(fieldCategoria, gbc_textField);
		fieldCategoria.setColumns(10);		
		JButton btnConferma = new JButton("Conferma");
		JButton btnRicevuta = new JButton("Ottieni ricevuta");
		NewOperazioneController controller = new NewOperazioneController(fieldNumCarta, fieldMese, fieldAnno,fieldCvv, fieldImporto,rdbtnPrelievo,rdbtnDeposito ,btnConferma, fieldCategoria,btnRicevuta);
		
		
		btnConferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.newOperazione(); 
			}
		});
		
		GridBagConstraints gbc_btnConferma = new GridBagConstraints();
		gbc_btnConferma.anchor = GridBagConstraints.SOUTHWEST;
		gbc_btnConferma.gridwidth = 2;
		gbc_btnConferma.insets = new Insets(0, 0, 5, 5);
		gbc_btnConferma.gridx = 3;
		gbc_btnConferma.gridy = 8;
		contentPane.add(btnConferma, gbc_btnConferma);
		
		
		btnRicevuta.setEnabled(false); //deve effettuare prima la transazione
		btnRicevuta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.stampaRicevuta();
			}
		});
		GridBagConstraints gbc_btnRicevuta = new GridBagConstraints();
		gbc_btnRicevuta.anchor = GridBagConstraints.WEST;
		gbc_btnRicevuta.gridwidth = 4;
		gbc_btnRicevuta.insets = new Insets(0, 0, 5, 5);
		gbc_btnRicevuta.gridx = 6;
		gbc_btnRicevuta.gridy = 8;
		contentPane.add(btnRicevuta, gbc_btnRicevuta);
		
	
	}
}
