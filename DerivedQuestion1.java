package edu.fullerton.simon.package1;
import javax.swing.JPanel;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

//MULTIPLE CHOICE QUESTION PANEL
public class DerivedQuestion1 extends Question1 implements ActionListener {
	
	private JPanel panel;
	private String[] possibleAnswers;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private JRadioButton rdbtnNewRadioButton_3;
	private ButtonGroup group;
	public DerivedQuestion1(String question, String answer,String[] possibleAnswers) {
		super(question,answer); 
		group = new ButtonGroup();
		this.possibleAnswers = possibleAnswers;
		panel = new JPanel();
		panel.setBounds(0, 0, 10, 10);
		add(panel);
		
		
		
		
		//4 radio buttons for possibleanswers 
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
		
		//add radiobuttons to buttongroup for one selection for each question
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton_2);
		group.add(rdbtnNewRadioButton_3);
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
	  public DerivedQuestion1 clone(){
		  DerivedQuestion1 temp = new  DerivedQuestion1(super.askQuestion(), getAnswer(), possibleAnswers.clone());
	   return temp;
	  }
	  @Override
	  public String toString(){
	    return askQuestion();
	  }
	  
	 
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object choice = arg0.getSource(); //for check button 
		String myAnswer = "";
		 for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
	            AbstractButton button = buttons.nextElement();

	            if (button.isSelected()) {
	                myAnswer = button.getActionCommand();
	            }
	        }
		 
		 //check for the correct answer and then output message if true or false 
		  if(choice.equals(super.getCheck())) {
			  if(check(myAnswer)) {
				  addPoint();
				  JOptionPane.showMessageDialog(null,"correct\nWell Done :)" + "points: " + getPoint());
				  
				  }
				  else {
					  JOptionPane.showMessageDialog(null,"wrong\nU suck :)");
					  
				  }
	}
	
	}
}

