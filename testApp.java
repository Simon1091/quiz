package edu.fullerton.simon.package1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class testApp {
	private int count =0;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testApp window = new testApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public testApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		String[] mcqs = {"simon","vincent","eric","peter"};
		Quiz quiz = new Quiz(4);
		DerivedQuestion1 mcq = new DerivedQuestion1(" what is my name","simon",mcqs);
		DerivedQuestion3 shortanswer = new DerivedQuestion3("which language do i speak?","English");
		quiz.addQuestion(shortanswer.clone());
		quiz.addQuestion(mcq.clone());
		mcqs[0] = "1";
		DerivedQuestion1 mcq2 = new DerivedQuestion1(" how old am i? ","1",mcqs);
		String[] mapa = {"I like dick","I eat chicken", "I dont know shit","I suck"};
		ArrayList<String> maca = new ArrayList<String>();
		maca.add("I eat chicken");
		maca.add("I like dick");
		
		DerivedQuestion2 ma = new DerivedQuestion2("which of these are true","re",mapa,maca);
		quiz.addQuestion(mcq2);
		quiz.addQuestion(ma);
		quiz.save();
		Question1[] questions = quiz.load();
		
		for(int i = 0; i < questions.length;i++) {
			//frame.getContentPane().add(questions[i], ("question " + i));
			panel.add(questions[i]);
		}
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(count < questions.length - 1 ) {
					
				CardLayout cardLayout = (CardLayout) panel.getLayout();
				cardLayout.next(panel);
				count++;
				}
				else
					JOptionPane.showMessageDialog(null,"finished :)");
			}
		});
		
		frame.getContentPane().add(btnNext, BorderLayout.SOUTH);
		//frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		
		
			
				
				
				
				
		
		
		//questions[0].getTextField().setText("what is my name");
		
		
	}

}
