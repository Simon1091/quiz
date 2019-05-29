package edu.fullerton.simon.package1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSplitPane;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;

public class LoadApp {
	//input correct answers for multiple answers question
	private JCheckBox checkBox;
	private JCheckBox checkBox_1;
	private JCheckBox checkBox_3;
	private JCheckBox checkBox_2; 
	
	private Question1[] questions;
	private int count = 0;
	private String question;
	private String answer;
	private String[] possibleAnswers = new String[4];
	private JFrame frame;
	private Quiz quiz;
	private int quizSize = 4;
	
	private JTextField textField;	//textfield for multiplechoicequestion
	private JTextField textField_1; //textfield for answer to mcq
	private JTextField textField_2; //textfield for possibleanswers[0]
	private JTextField textField_3;	//textfield for possibleanswers[1]
	private JTextField textField_4;	//textfield for possibleanswers[2]
	private JTextField textField_5;	//textfield for possibleanswers[3]
	
	private JTextField textField_6; //textfield for shortanswerquestion
	private JTextField textField_7;	//textfield for answer to shortanswerquestion
	
	private JTextField textField_8; //Remove index input
	
	private JTextField textField_9; //question for multiple answers
	//answers for multipleanswers
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	
	private JTextField textField_10; //Rearrange input indices 
	private JTextField textField_11;
	
	private JTextArea textArea_1;
	private JScrollPane scrollPane_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoadApp window = new LoadApp();
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
	public LoadApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		quiz = new Quiz(quizSize);
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new CardLayout(0, 0));
		CardLayout cl = (CardLayout)panel.getLayout();
		
		JPanel mainPanel = new JPanel();
		panel.add(mainPanel, "mainPanel");
		mainPanel.setLayout(null);
		
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quiz.save();
			}
		});
		btnSave.setBounds(15, 57, 115, 29);
		mainPanel.add(btnSave);
		
		JPanel Remove = new JPanel();
		panel.add(Remove, "Remove");
		Remove.setLayout(null);
		
		JButton btnRemoveQuestion = new JButton("Remove Question");
		btnRemoveQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = Integer.parseInt(textField_8.getText());
				quiz.removeQuestion(index);
				System.out.println(quiz.toString());
				cl.show(panel, "mainPanel");
			}
		});
		btnRemoveQuestion.setBounds(298, 199, 115, 29);
		Remove.add(btnRemoveQuestion);
		
		JLabel lblChoose = new JLabel("Choose:");
		lblChoose.setBounds(15, 16, 69, 20);
		Remove.add(lblChoose);
		
		JLabel lblInput = new JLabel("Input:");
		lblInput.setBounds(15, 203, 69, 20);
		Remove.add(lblInput);
		
		textField_8 = new JTextField(); 
		textField_8.setBounds(99, 200, 146, 26);
		Remove.add(textField_8);
		textField_8.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(75, 27, 338, 156);
		Remove.add(scrollPane);
		
		
		
		
		
		JPanel AddMultipleChoice = new JPanel();
		panel.add(AddMultipleChoice, "Addmcq");
		AddMultipleChoice.setLayout(null);
		
		JLabel lblQuestion = new JLabel("Question:");
		lblQuestion.setBounds(15, 16, 69, 20);
		AddMultipleChoice.add(lblQuestion);
		
		JLabel lblAnswer = new JLabel("Answer:");
		lblAnswer.setBounds(15, 41, 69, 20);
		AddMultipleChoice.add(lblAnswer);
		
		textField = new JTextField();
		textField.setBounds(92, 13, 146, 26);
		AddMultipleChoice.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(92, 38, 146, 26);
		AddMultipleChoice.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPossibleAnswers = new JLabel("Possible Answers:");
		lblPossibleAnswers.setBounds(15, 77, 128, 20);
		AddMultipleChoice.add(lblPossibleAnswers);
		
		textField_2 = new JTextField();
		textField_2.setBounds(155, 80, 146, 26);
		AddMultipleChoice.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(155, 107, 146, 26);
		AddMultipleChoice.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(155, 135, 146, 26);
		AddMultipleChoice.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(155, 159, 146, 26);
		AddMultipleChoice.add(textField_5);
		textField_5.setColumns(10);
		
		//Add Button for Adding MultipleChoiceQuestion to quiz
		JButton btnAdd_1 = new JButton("Add");
		btnAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String answer;
				String question;
				String[] possibleAnswers = new String[4];
				question = textField.getText();
				answer = textField_1.getText();
				possibleAnswers[0] = textField_2.getText();
				possibleAnswers[1] = textField_3.getText();
				possibleAnswers[2] = textField_4.getText();
				possibleAnswers[3] = textField_5.getText();
				DerivedQuestion1 mcq = new DerivedQuestion1(question,answer,possibleAnswers.clone());
				quiz.addQuestion(mcq.clone());
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				cl.show(panel, "mainPanel");
			}
		});
		btnAdd_1.setBounds(148, 199, 115, 29);
		AddMultipleChoice.add(btnAdd_1);
		
		//Button in the mainPanel to show addmultiplechoicequestion panel
		JButton btnAdd = new JButton("AddMultipleChoice");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				cl.show(panel, "Addmcq");
				
				
			}
		});
		btnAdd.setBounds(15, 16, 212, 29);
		mainPanel.add(btnAdd);
		
		//Panel With BorderLayout for two panels one for questions and one for next button
		JPanel quizPanel = new JPanel();
		panel.add(quizPanel, "quizPanel");
		quizPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel slidePanel = new JPanel();
		quizPanel.add(slidePanel, BorderLayout.CENTER);
		slidePanel.setLayout(new CardLayout(0, 0));
		
		//button for next question while taking the quiz
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(count < questions.length -1 ) {
					
				CardLayout cardLayout = (CardLayout) slidePanel.getLayout();
				cardLayout.next(slidePanel);
				
				count++;
				}
				else {
					
					JOptionPane.showMessageDialog(null,"finished :)\n total: " + quiz.getPoints());
					
					count = 0;
					cl.show(panel, "mainPanel");
				}
			}
		});
		
		quizPanel.add(btnNext, BorderLayout.SOUTH);
		
		JButton btnTakeQuiz = new JButton("Take Quiz");
		btnTakeQuiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel, "quizPanel");
				if(quiz.getqCount() == quiz.getMax()) {
				 questions = quiz.load(); //initialize questions from binaryfile
				 
				 quiz.setQuestions(questions); //initialize quiz with questionsFromFile
				
				for(int i = 0; i < questions.length;i++) {
					
					slidePanel.add(questions[i]); //add question panels to slidepanel
				}
			
			}
			else  {
				System.out.println("Add question");
				cl.show(panel, "mainPanel");
			}
			}
		});
		btnTakeQuiz.setBounds(15, 102, 115, 29);
		mainPanel.add(btnTakeQuiz);
		
		//Button in mainPanel to show panel 
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String questions1 = quiz.toString();
				textArea.setText(questions1);
				
				
				cl.show(panel, "Remove");
				
			}
		});
		btnRemove.setBounds(15, 192, 115, 29);
		mainPanel.add(btnRemove);
		
		//mainPanel Button to show AddMultipleAnswer Panel
		JButton btnAddMultipleAnswer = new JButton("Add Multiple Answer");
		btnAddMultipleAnswer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel, "AddMA");
			}
		});
		btnAddMultipleAnswer.setBounds(145, 57, 212, 29);
		mainPanel.add(btnAddMultipleAnswer);
		
		JPanel AddShortAnswer = new JPanel(); 
		panel.add(AddShortAnswer, "AddSA");
		AddShortAnswer.setLayout(null); //layout absolute 
		
		JLabel lblQuestion_1 = new JLabel("Question:");
		lblQuestion_1.setBounds(15, 16, 69, 20);
		AddShortAnswer.add(lblQuestion_1);
		
		JLabel lblAnswer_1 = new JLabel("Answer: ");
		lblAnswer_1.setBounds(15, 36, 69, 20);
		AddShortAnswer.add(lblAnswer_1);
		
		textField_6 = new JTextField();
		textField_6.setBounds(99, 13, 146, 26);
		AddShortAnswer.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(99, 33, 146, 26);
		AddShortAnswer.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnAdd_2 = new JButton("Add");
		btnAdd_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String answer;
				String question;
				question = textField_6.getText();
				answer = textField_7.getText();
				DerivedQuestion3 sa = new DerivedQuestion3(question,answer);
				quiz.addQuestion(sa.clone());
				textField_6.setText("");
				textField_7.setText("");
				cl.show(panel, "mainPanel");
			}
		});
		btnAdd_2.setBounds(155, 199, 115, 29);
		AddShortAnswer.add(btnAdd_2);
		JButton btnAddShortAnswer = new JButton("Add Short Answer");
		btnAddShortAnswer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel,"AddSA");
				
				
			}
		});
		btnAddShortAnswer.setBounds(15, 147, 212, 29);
		mainPanel.add(btnAddShortAnswer);
		
		JButton btnRearrange = new JButton("Rearrange");
		btnRearrange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String questionsForRearranging = quiz.toString();
				textArea_1.setText(questionsForRearranging);
				cl.show(panel,"Reorder");
			}
		});
		btnRearrange.setBounds(145, 102, 115, 29);
		mainPanel.add(btnRearrange);
		
		JPanel AddMultipleAnswer = new JPanel();
		panel.add(AddMultipleAnswer, "AddMA");
		AddMultipleAnswer.setLayout(null);
		
		JLabel lblQuestion_2 = new JLabel("Question:");
		lblQuestion_2.setBounds(15, 16, 69, 20);
		AddMultipleAnswer.add(lblQuestion_2);
		
		JLabel lblAnswer_2 = new JLabel("Answer:");
		lblAnswer_2.setBounds(15, 41, 69, 20);
		AddMultipleAnswer.add(lblAnswer_2);
		
		JLabel lblPossibleAnswers_1 = new JLabel("Possible Answers");
		lblPossibleAnswers_1.setBounds(208, 41, 69, 20);
		AddMultipleAnswer.add(lblPossibleAnswers_1);
		
		textField_9 = new JTextField();
		textField_9.setBounds(86, 13, 146, 26);
		AddMultipleAnswer.add(textField_9);
		textField_9.setColumns(10);
		
		textField_14 = new JTextField();
		textField_14.setBounds(176, 77, 146, 26);
		AddMultipleAnswer.add(textField_14);
		textField_14.setColumns(10);
		
		textField_15 = new JTextField();
		textField_15.setBounds(176, 101, 146, 26);
		AddMultipleAnswer.add(textField_15);
		textField_15.setColumns(10);
		
		textField_16 = new JTextField();
		textField_16.setBounds(176, 128, 146, 26);
		AddMultipleAnswer.add(textField_16);
		textField_16.setColumns(10);
		
		textField_17 = new JTextField();
		textField_17.setBounds(176, 157, 146, 26);
		AddMultipleAnswer.add(textField_17);
		textField_17.setColumns(10);
		
		//Add Button in AddMultipleAnswers panel 
		JButton btnAdd_3 = new JButton("Add");
		btnAdd_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> multipleAnswers = new ArrayList<String>();
				String question;
				String[] possibleAnswers = new String[4];
				
				if(checkBox.isSelected()) {
					multipleAnswers.add(textField_14.getText());
				}
				if(checkBox_1.isSelected()) {
					multipleAnswers.add(textField_15.getText());
				}
				if(checkBox_2.isSelected()) {
					multipleAnswers.add(textField_16.getText());
				}
				if(checkBox_3.isSelected()) {
					multipleAnswers.add(textField_17.getText());
				}
				question = textField_9.getText();
				
				possibleAnswers[0] = textField_14.getText();
				possibleAnswers[1] = textField_15.getText();
				possibleAnswers[2] =textField_16.getText();
				possibleAnswers[3] = textField_17.getText();
				
				DerivedQuestion2 sa = new DerivedQuestion2(question,answer,possibleAnswers,multipleAnswers);
				quiz.addQuestion(sa.clone());
				textField_14.setText("");
				textField_15.setText("");
				textField_16.setText("");
				textField_17.setText("");
				textField_9.setText("");
				checkBox.setSelected(false);
				checkBox_1.setSelected(false);
				checkBox_2.setSelected(false);
				checkBox_3.setSelected(false);
				cl.show(panel, "mainPanel");
				
			}
		});
		btnAdd_3.setBounds(148, 199, 115, 29);
		AddMultipleAnswer.add(btnAdd_3);
		
		checkBox = new JCheckBox("1:");
		
		checkBox.setBounds(133, 76, 32, 29);
		AddMultipleAnswer.add(checkBox);
		
		 checkBox_1 = new JCheckBox("2:");
		checkBox_1.setBounds(133, 100, 32, 29);
		AddMultipleAnswer.add(checkBox_1);
		
		checkBox_2 = new JCheckBox("3:");
		checkBox_2.setBounds(133, 127, 32, 29);
		AddMultipleAnswer.add(checkBox_2);
		
		checkBox_3 = new JCheckBox("4:");
		checkBox_3.setBounds(133, 156, 32, 29);
		AddMultipleAnswer.add(checkBox_3);
		
		JPanel Rearranage = new JPanel();
		panel.add(Rearranage, "Reorder");
		Rearranage.setLayout(null);
		
		JLabel lblInputTwoIndices = new JLabel("Input two indices you want to switch");
		lblInputTwoIndices.setBounds(15, 16, 372, 20);
		Rearranage.add(lblInputTwoIndices);
		
		textField_10 = new JTextField();
		textField_10.setBounds(25, 52, 146, 26);
		Rearranage.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(25, 80, 146, 26);
		Rearranage.add(textField_11);
		textField_11.setColumns(10);
		
		JButton btnRearrange_1 = new JButton("Rearrange");
		btnRearrange_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index_1 = Integer.parseInt(textField_10.getText());
				int index_2 = Integer.parseInt(textField_11.getText());
				quiz.rearrange(index_1, index_2);
				textField_10.setText("");
				textField_11.setText("");
				cl.show(panel, "mainPanel");
			}
		});
		btnRearrange_1.setBounds(170, 199, 115, 29);
		Rearranage.add(btnRearrange_1);
		
		
		 textArea_1 = new JTextArea();
		 scrollPane_1 = new JScrollPane(textArea_1);
		scrollPane_1.setBounds(186, 52, 227, 131);
		Rearranage.add(scrollPane_1);
		 
		
		
	}
}
