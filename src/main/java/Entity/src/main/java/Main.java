import javax.swing.*;

import Controller.LoginController;
import GUI.LoginGUI;

public class Main{
    
    
	public static void main(String[] args) {
		
		LoginGUI Login = new LoginGUI();
		Login.setVisible(true);
		
		System.out.println("CIAO ");
	}
	
	public void closeLoginGui(LoginGUI login){ 
		login.setVisible(false); 
	}
}
