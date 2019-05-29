package edu.fullerton.simon.package1;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.sun.xml.internal.ws.api.Component;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.awt.event.ActionEvent;

//MULTIPLEANSWERS
public class DerivedQuestion2 extends Question1 {
	private int points =0;
	private JPanel panel;
	private String[] possibleAnswers;
	private ArrayList<String> multipleanswers;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private JRadioButton rdbtnNewRadioButton_3;
	private ButtonGroup group;
	public DerivedQuestion2(String question, String answer,String[] possibleAnswers,ArrayList<String> multipleanswers) {
		super(question,answer);
		group = new ButtonGroup();
		this.possibleAnswers = possibleAnswers;
		panel = new JPanel();
		this.multipleanswers = multipleanswers;
		panel.setBounds(0, 0, 10, 10);
		add(panel);
		
		
		
		
		
		rdbtnNewRadioButton = new JRadioButton(possibleAnswers[0]);
		rdbtnNewRadioButton.addActionListener(this);
		rdbtnNewRadioButton.setActionCommand(possibleAnswers[0]);
		rdbtnNewRadioButton.setBounds(0, 120, 155, 29);
		
		rdbtnNewRadioButton_1 = new JRadioButton(possibleAnswers[1]);
		rdbtnNewRadioButton_1.addActionListener(this);
		rdbtnNewRadioButton_1.setActionCommand(possibleAnswers[1]);
		
		rdbtnNewRadioButton_1.setBounds(157, 120, 155, 29);
		
		 rdbtnNewRadioButton_2 = new JRadioButton(possibleAnswers[2]);
		 rdbtnNewRadioButton_2.addActionListener(this);
			rdbtnNewRadioButton_2.setActionCommand(possibleAnswers[2]);
		rdbtnNewRadioButton_2.setBounds(0, 157, 155, 29);
		
		 rdbtnNewRadioButton_3 = new JRadioButton(possibleAnswers[3]);
		 rdbtnNewRadioButton_3.addActionListener(this);
			rdbtnNewRadioButton_3.setActionCommand(possibleAnswers[3]);
		rdbtnNewRadioButton_3.setBounds(157, 157, 155, 29);
		
		
		add(rdbtnNewRadioButton);
		add(rdbtnNewRadioButton_1);
		add(rdbtnNewRadioButton_2);
		add(rdbtnNewRadioButton_3);
	}
	
	 @Override
	  public String askQuestion(){
	    String result = super.askQuestion() + "\n";
	    for(int i=0; i<possibleAnswers.length; i++){
	      result += ((i+1) + ". " + possibleAnswers[i] + "\n");
	    }
	    return result;
	  }
	  public void setPossibleAnswers(String[] possibleAnswers){
	    this.possibleAnswers = possibleAnswers;
	  }
	  public String[] getPossibleAnswers(){
	    return possibleAnswers;
	  }
	  @Override
	  public DerivedQuestion2 clone(){
		  DerivedQuestion2 temp = new  DerivedQuestion2(super.askQuestion(), getAnswer(), possibleAnswers.clone(),multipleanswers);
	   return temp;
	  }
	  @Override
	  public String toString(){
	    return askQuestion();
	  }
	 
	@Override
	public void actionPerformed(ActionEvent arg0) {
		boolean result = true;
		Object choice = arg0.getSource();
		ArrayList<String> myAnswers1= new ArrayList<String>();
		
		if(rdbtnNewRadioButton.isSelected()) {
			myAnswers1.add(rdbtnNewRadioButton.getActionCommand());
		}
		if(rdbtnNewRadioButton_1.isSelected()) {
			myAnswers1.add(rdbtnNewRadioButton_1.getActionCommand());
		}if(rdbtnNewRadioButton_2.isSelected()) {
			myAnswers1.add(rdbtnNewRadioButton_2.getActionCommand());
		}if(rdbtnNewRadioButton_3.isSelected()) {
			myAnswers1.add(rdbtnNewRadioButton_3.getActionCommand());
		}
		
		//Check Button
		if(choice.equals(super.getCheck())) {
			
			 //check every answer input through every correct answer
			  for(String answer: myAnswers1) {
				  boolean found = false;
				  System.out.println("myAnswers1forloop " + answer);
				 for(String multipleanswer : multipleanswers) {
					 System.out.println("multipleanswers " + multipleanswer);
					 if(answer.equals(multipleanswer)){
						points++;
						found = true;
					 }
					 
					
				 }
				 if(found == false) { //if myanswers are not found in correct answers list 
					 points--;
				 }
				 //display whether correct or wrong
			  }
			  if(myAnswers1.size()==multipleanswers.size() && points == myAnswers1.size()) {
				  addPoint();
				  JOptionPane.showMessageDialog(null,"correct\nWell Done :)" + "Points: 0");
			  }
			  else
				  JOptionPane.showMessageDialog(null,"wrong\nU suck :)" + "Points: " + points);
			  
		
	}
	
	}
}
