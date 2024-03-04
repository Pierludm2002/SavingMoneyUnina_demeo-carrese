package GUI;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PaginaUtente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public PaginaUtente() {
		setTitle("Informazioni Account\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 650, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null); 

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{60,30, 30, 30,50, 120, 120, 50,120, 30};
		gbl_contentPane.rowHeights = new int[]{40, 30, 30,50,30 ,60, 50,30,25};
		gbl_contentPane.columnWeights = new double[]{Double.MIN_VALUE, 0.0, 0.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{Double.MIN_VALUE};
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
		gbc_backBtn.fill = GridBagConstraints.BOTH;
		gbc_backBtn.gridwidth = 1;
		gbc_backBtn.insets = new Insets(0, 0, 5, 5);
		gbc_backBtn.gridx = 0;
		gbc_backBtn.gridy = 0;
		contentPane.add(backBtn, gbc_backBtn);
	}

}
