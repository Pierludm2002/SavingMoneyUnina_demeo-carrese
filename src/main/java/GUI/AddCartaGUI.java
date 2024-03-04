package GUI;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class AddCartaGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textAnno;
	private JTextField textCvv;
	private JTextField textMail;

	
	public AddCartaGUI() {
		setTitle("Aggiungi Carta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 650, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null); 

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{30,90,180,40,45,15, 45,45,145};
		gbl_contentPane.rowHeights = new int[]{50,50,30,30,30,30,30,30, 0,30,30};
		gbl_contentPane.columnWeights = new double[]{Double.MIN_VALUE, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{Double.MIN_VALUE, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Aggiungi dettagli della carta");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 6;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 3;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Numero Carta:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 4;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JTextField txtNumeroCarta = new JTextField(); 
		GridBagConstraints gbc_txtNumeroCarta = new GridBagConstraints();
		gbc_txtNumeroCarta.gridwidth = 4;
		gbc_txtNumeroCarta.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNumeroCarta.insets = new Insets(0, 0, 5, 5);
		gbc_txtNumeroCarta.gridx = 4;
		gbc_txtNumeroCarta.gridy = 4;
		contentPane.add(txtNumeroCarta, gbc_txtNumeroCarta);
		
		JLabel lblNewLabel_2 = new JLabel("Data scadenza:\n");
		lblNewLabel_2.setToolTipText("");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 5;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JTextField txtMese = new JTextField(); 
		GridBagConstraints gbc_txtMese = new GridBagConstraints();
		gbc_txtMese.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMese.insets = new Insets(0, 0, 5, 5);
		gbc_txtMese.gridx = 4;
		gbc_txtMese.gridy = 5;
		contentPane.add(txtMese, gbc_txtMese);
		
		JLabel lblNewLabel_3 = new JLabel("/");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 5;
		gbc_lblNewLabel_3.gridy = 5;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textAnno = new JTextField();
		GridBagConstraints gbc_textAnno = new GridBagConstraints();
		gbc_textAnno.insets = new Insets(0, 0, 5, 5);
		gbc_textAnno.fill = GridBagConstraints.HORIZONTAL;
		gbc_textAnno.gridx = 6;
		gbc_textAnno.gridy = 5;
		contentPane.add(textAnno, gbc_textAnno);
		textAnno.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("CVV: ");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 6;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		textCvv = new JTextField();
		GridBagConstraints gbc_textCvv = new GridBagConstraints();
		gbc_textCvv.insets = new Insets(0, 0, 5, 5);
		gbc_textCvv.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCvv.gridx = 4;
		gbc_textCvv.gridy = 6;
		contentPane.add(textCvv, gbc_textCvv);
		textCvv.setColumns(10);
		
		JLabel lblNomeIntestatario = new JLabel("Indirizzo mail dell'intestatario:");
		GridBagConstraints gbc_lblNomeIntestatario = new GridBagConstraints();
		gbc_lblNomeIntestatario.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomeIntestatario.gridx = 2;
		gbc_lblNomeIntestatario.gridy = 7;
		contentPane.add(lblNomeIntestatario, gbc_lblNomeIntestatario);
		
		textMail = new JTextField();
		GridBagConstraints gbc_textMail = new GridBagConstraints();
		gbc_textMail.gridwidth = 4;
		gbc_textMail.insets = new Insets(0, 0, 5, 5);
		gbc_textMail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textMail.gridx = 4;
		gbc_textMail.gridy = 7;
		contentPane.add(textMail, gbc_textMail);
		textMail.setColumns(10);
		
		JButton btnNewButton = new JButton("Aggiungi");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 6;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 8;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
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
		gbc_backBtn.fill = GridBagConstraints.BOTH;
		gbc_backBtn.gridwidth = 1;
		gbc_backBtn.insets = new Insets(0, 0, 5, 5);
		gbc_backBtn.gridx = 0;
		gbc_backBtn.gridy = 0;
		contentPane.add(backBtn, gbc_backBtn);
		
	}

}
