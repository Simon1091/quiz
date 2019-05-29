package edu.fullerton.simon.package1;
import java.awt.event.ActionEvent;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;

//SHORT ANSWER
public class DerivedQuestion3 extends Question1 {
	private String[] possibleAnswers;
	private JTextField textField;
	public DerivedQuestion3(String question,String answer) {
		super(question,answer);
	
		
		JLabel lblAnswer = new JLabel("Answer: ");
		lblAnswer.setBounds(15, 86, 69, 20);
		add(lblAnswer);
		
		textField = new JTextField();
		textField.addActionListener(this);
			
		textField.setBounds(80, 83, 146, 26);
		add(textField);
		textField.setColumns(10);
	}
	//Checks if string is a substring of given string or the opposite or both the same
	@Override
	public boolean check(String userAnswer) {
		if(userAnswer.length() < super.getAnswer().length()) {
			return super.getAnswer().toLowerCase().contains(userAnswer.toLowerCase());
		}
		else if(userAnswer.length() == super.getAnswer().length()) {
			return userAnswer.toLowerCase().equals(super.getAnswer().toLowerCase());
		}
	
		else {
			return userAnswer.toLowerCase().contains(super.getAnswer().toLowerCase());
		}
	}
	public  DerivedQuestion3 clone() {
		return new  DerivedQuestion3(super.askQuestion(),super.getAnswer());
	}
	public void actionPerformed(ActionEvent arg0) {
		Object choice = arg0.getSource();
		
		
		  if(choice.equals(super.getCheck())) {
			  if(check(textField.getText())) {
				  addPoint();
				  JOptionPane.showMessageDialog(null,"correct\nWell Done :)" + "points: " + getPoint());
				  }
				  else
					  JOptionPane.showMessageDialog(null,"wrong\nU suck :)");
		
	}
	
	}
}
