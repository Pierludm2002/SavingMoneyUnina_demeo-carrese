package Controller;

import javax.swing.*;

import org.jdatepicker.impl.JDatePanelImpl;

public class SignInController {
	private JTextField emailField, nameField, surnameField, fieldAnno, fieldMese,fieldGiorno;
	private JPasswordField pswField;
	public SignInController(JTextField emailField, JTextField nameField, JTextField surnameField, JTextField fieldAnno,
			JTextField fieldMese, JTextField fieldGiorno, JPasswordField pswField) {
		super();
		this.emailField = emailField;
		this.nameField = nameField;
		this.surnameField = surnameField;
		this.fieldAnno = fieldAnno;
		this.fieldMese = fieldMese;
		this.fieldGiorno = fieldGiorno;
		this.pswField = pswField;
	} 
	
	public void InviaRegistrazione() { 
		
	}
	
}
