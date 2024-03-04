package GUI;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PortafoglioGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public PortafoglioGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 650, 400);
		setLocationRelativeTo(null); 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{60,30, 150, 100, 150, 30 ,60};
		gbl_contentPane.rowHeights = new int[]{60, 30, 40, 150,30,100};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnAddCarta = new JButton("Aggiungi carta");
		btnAddCarta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddCartaGUI add = new AddCartaGUI(); 
				add.setVisible(true); 
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 2;
		contentPane.add(btnAddCarta, gbc_btnNewButton);
		
		JButton btnCardView = new JButton("Visualizza carte");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 4;
		contentPane.add(btnCardView, gbc_btnNewButton_1);
		
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
