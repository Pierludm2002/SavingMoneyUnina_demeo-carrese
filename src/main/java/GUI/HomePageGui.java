package GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.JTree;
import java.awt.Font;



public class HomePageGui extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public HomePageGui() {
		setForeground(new Color(72, 255, 248));
		
		setTitle("Homepage");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200,200,650,400); 
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0};
        gbl_panel.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, 0.0};
        gbl_panel.columnWidths = new int[]{45,45, 150, 57, 150, 45 ,45};
        gbl_panel.rowHeights = new int[]{35, 30, 50, 50, 50, 60};
        JPanel panel = new JPanel(gbl_panel);
        ImageIcon icon = new ImageIcon("Images/home.png"); 
		int newWidth = (int) Math.round(icon.getIconWidth() * (double) 100/icon.getIconHeight()); 
		Image imageSmaller = icon.getImage().getScaledInstance(newWidth, 100, Image.SCALE_SMOOTH); 
		ImageIcon iconSmaller = new ImageIcon(imageSmaller); 
		
		ImageIcon icon1 = new ImageIcon("Images/User.png"); 
	
		JButton btnUser = new JButton(icon1);
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PaginaUtente userPage = new PaginaUtente(); 
				userPage.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnUser = new GridBagConstraints();
		gbc_btnUser.fill = GridBagConstraints.BOTH;
		gbc_btnUser.insets = new Insets(0, 0, 5, 0);
		gbc_btnUser.gridx = 6;
		gbc_btnUser.gridy = 0;
		panel.add(btnUser, gbc_btnUser);
		
		JButton famigliaButton = new JButton("Gestione famiglia");
		famigliaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GestioneFamigliaGUI pagFamiglia = new GestioneFamigliaGUI(); 
				pagFamiglia.setVisible(true);
			}
		});
		famigliaButton.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 2;
		panel.add(famigliaButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Portafoglio");
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.HORIZONTAL;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 4;
		gbc_button.gridy = 2;
		panel.add(btnNewButton_1, gbc_button);
		JLabel lblLogo = new JLabel(iconSmaller);
		panel.add(lblLogo);
        
        
        GridBagConstraints gbc_image = new GridBagConstraints();
        gbc_image.insets = new Insets(0, 0, 5, 5);
        gbc_image.gridx = 3; 
        gbc_image.gridy = 3; 
        panel.add(lblLogo, gbc_image); 
        getContentPane().add(panel);

        
        getContentPane().add(panel);
                
                        
                       
        JButton depositoButton = new JButton("Cronologia transazioni\n");
        depositoButton.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
                        
          depositoButton.addActionListener(new ActionListener() {
                                    @Override
              public void actionPerformed(ActionEvent e) {
                       JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panel);
                                frame.dispose();
                                CronoTransGUI paginadeposito = new CronoTransGUI();
                                        paginadeposito.setVisible(true);
                                    }
                                });
                                        
    
        
        JButton newOpButton = new JButton("Nuova operazione");
        newOpButton.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
        
        newOpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chiudi la finestra corrente
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panel);
                frame.dispose();
                // Apri la pagina per il deposito
                NewOpGUI newop = new NewOpGUI();
                newop.setVisible(true);
                
            }
        });
               
        GridBagConstraints p = new GridBagConstraints();
        p.insets = new Insets(0, 0, 5, 5);
        p.gridx = 2;
        p.gridy = 4;
        panel.add(newOpButton, p);                         
        GridBagConstraints d = new GridBagConstraints();
        d.insets = new Insets(0, 0, 5, 5);
        d.gridx = 4;
        d.gridy = 4;
        panel.add(depositoButton, d);                        
        setSize(416, 331);
        pack();
        setLocationRelativeTo(null);
    }
    
   
}

