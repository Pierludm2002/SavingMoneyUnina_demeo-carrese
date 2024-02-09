package GUI;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepositoGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public DepositoGUI() {
		setTitle("Deposito\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 650, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{35,100,50, 50,50, 50, 50, 50,50, 135};
		gbl_contentPane.rowHeights = new int[]{52, 30,20, 182,20, 30,30};
		gbl_contentPane.columnWeights = new double[]{Double.MIN_VALUE};
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
		gbc_backBtn.gridwidth = 1;
		gbc_backBtn.insets = new Insets(0, 0, 5, 5);
		gbc_backBtn.gridx = 0;
		gbc_backBtn.gridy = 0;
		contentPane.add(backBtn, gbc_backBtn);
	}

}
