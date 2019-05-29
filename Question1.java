package edu.fullerton.simon.package1;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Question1 extends JPanel implements ActionListener {
	private String question, answer;
	private int point = 0;
	private JLabel lblQuestion;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JButton btnCheck;
	public Question1(String question, String answer){
		this.question = question;
		this.answer = answer;
		setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 10, 10);
		add(panel);
		
		 lblQuestion = new JLabel("Question:");
		lblQuestion.setBounds(10, 19, 68, 14);
		add(lblQuestion);
		
		 lblNewLabel = new JLabel(question);
		lblNewLabel.setBounds(62, 19, 307, 14);
		add(lblNewLabel);
		
		 btnCheck = new JButton("Check");
		 btnCheck.addActionListener(this);
		btnCheck.setBounds(167, 181, 115, 29);
		add(btnCheck);
	}
	public String askQuestion(){
		return question;
	}
	public boolean check(String userAnswer){
		return answer.equals(userAnswer);
	}
        protected String getAnswer(){
          return answer;
        }	
	public void setAnswer(String answer){
		this.answer = answer;
	}
	public void setQuestion(String question){
		this.question = question;
	}
	public void test() {}
	public JButton getCheck() {
		return btnCheck;
	}
        @Override
	public Question1 clone(){
		return new Question1(question, answer);
	}
        @Override
        public String toString(){
          return askQuestion();
        }
		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			
		}
		public void addPoint() {
			point = 1;
		}
		public int getPoint() {
			return point;
		}
}


