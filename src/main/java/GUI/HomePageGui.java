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



public class HomePageGui extends JFrame {

	private static final long serialVersionUID = 1L;
	private final JLabel label = new JLabel("New label");
	public HomePageGui() {
		setForeground(new Color(72, 255, 248));
		
		setTitle("Homepage");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0};
        gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0};
        gbl_panel.columnWidths = new int[]{0, 121, 110, 100, 104, 86};
        gbl_panel.rowHeights = new int[]{100, 57, 94, 0};
        JPanel panel = new JPanel(gbl_panel);
        ImageIcon icon = new ImageIcon("Images/home.png"); 
		int newWidth = (int) Math.round(icon.getIconWidth() * (double) 100/icon.getIconHeight()); 
		Image imageSmaller = icon.getImage().getScaledInstance(newWidth, 100, Image.SCALE_SMOOTH); 
		ImageIcon iconSmaller = new ImageIcon(imageSmaller); 
		JLabel lblLogo = new JLabel(iconSmaller);
		panel.add(lblLogo);
		
    
        
        JButton prelievoButton = new JButton("Prelievo");
        
        prelievoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chiudi la finestra corrente
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panel);
                frame.dispose();
                // Apri la pagina per il deposito
                Prelievo paginaprelievo = new Prelievo();
                paginaprelievo.setVisible(true);
            }
        });


        
        
        GridBagConstraints p = new GridBagConstraints(); 
        p.insets = new Insets(0, 0, 5, 5);
        p.gridx = 1;
        p.gridy = 0;
        panel.add(prelievoButton, p);
        
        
        GridBagConstraints gbc_image = new GridBagConstraints();
        gbc_image.insets = new Insets(0, 0, 5, 5);
        gbc_image.gridx = 3; 
        gbc_image.gridy = 1; 
        panel.add(lblLogo, gbc_image); 
        
        getContentPane().add(panel);

        
        getContentPane().add(panel);
        
                
               
                JButton depositoButton = new JButton("Deposito");
                
                        depositoButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // Chiudi la finestra corrente
                                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panel);
                                frame.dispose();
                                
                                // Apri la pagina per il deposito
                                Deposito paginadeposito = new Deposito();
                                paginadeposito.setVisible(true);
                            }
                        });
                        
                                
                                GridBagConstraints d = new GridBagConstraints();
                                d.insets = new Insets(0, 0, 5, 5);
                                d.gridx = 1;
                                d.gridy = 1;
                                panel.add(depositoButton, d);
                                
                                
        setSize(416, 331);
        pack();
        setLocationRelativeTo(null);
    }
    
   
}

		
