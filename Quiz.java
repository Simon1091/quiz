package edu.fullerton.simon.package1;
import java.io.*;
import java.util.Scanner;

import javax.swing.JPanel;


public class Quiz extends JPanel{
  /**
	 * 
	 */
	

private Question1[] questions;
 


	private FileOutputStream fos;
	private int points =0;

  private int qCount;
  private File filename;
  private int maxQuestions;
  public Quiz(int maxQuestions){
    questions = new Question1[maxQuestions];
    this.maxQuestions = maxQuestions;
    qCount = 0;
    filename = new File("C:\\Users\\Simon\\Documents\\quiz1.dat");
	try {
		fos = new FileOutputStream(filename);
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
  
  public void addQuestion(Question1 q){
	  if(qCount < maxQuestions) {
    questions[qCount++] = q;
    System.out.println("qCount " + qCount );
	  }
	  else
		  System.out.println("error: full or invalid input");
  }
  
  
  public void removeQuestion(int index) {
	  
	  int j = 0;
	
	  if(qCount > 0 && index < qCount && index >= 0) {
	  Question1[] temp = new Question1[questions.length -1];
	  
	  for(int i = 0 ; i < questions.length ; i++) { //add questions to temp array without given index
		  if(i != index) {
			  temp[j++] = questions[i];
			  System.out.println("Remaining questions" + questions[i]);
		  }
		  
	  }
	  qCount--;
	  System.out.println("qCount: " + qCount); //make a question array that has new size
	  Question1[] q = new Question1[maxQuestions];
	  for(int i = 0 ; i < temp.length;i++) {
		  q[i] = temp[i];
	  }
	  questions = q; 
	  
	  }
	  else
	  System.out.println("empty or invalid input");
  }
  @Override
  public String toString(){
    String result = "";
    for(int i=0; i<qCount; i++){
      result+= ("Index Number: " + i  + ". " + questions[i].askQuestion() + "\n");
    }
    return result;
  }
  public void save(){
	  
	 try {
	  FileOutputStream fos;
	
		fos = new FileOutputStream(filename);
	
	    ObjectOutputStream oos;
			oos = new ObjectOutputStream(fos);
		 
	    oos.writeObject(questions);
	    oos.close();
	 }
	 catch(IOException e) {
		 e.printStackTrace();
	 }
	  
}
  //method to load questions from file to a question array
  public Question1[] load() {
	  
		  Question1[] questionsFromFile = new Question1[questions.length];
	  try {
	  FileInputStream fis = new FileInputStream(filename);
	    ObjectInputStream ois = new ObjectInputStream(fis);
	     questionsFromFile = (Question1[]) ois.readObject();
	    ois.close();
	    int i = 0;
	    for(Question1 q : questionsFromFile) {
	    	if(q != null) {
	    		System.out.println(q.toString());
	    		i++;
	    	}
	    	
	    }
	    
	    
	  }
	  catch(IOException e) {
		  e.printStackTrace();
	  } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  
	return questionsFromFile;
	
  }
  //rearranges two questions by their indices
 public void rearrange(int index1,int index2) {
	 if(index2 < qCount && index1 < qCount && index1 >= 0 && index2 >=0) {
	 Question1 temp = questions[index1];
	 questions[index1] = questions[index2];
	 questions[index2] = temp;
	 }
	 else
		 System.out.println("invalid input");
 }
 //total points for correct answers in quiz
 public int getPoints() {
	 for(Question1 question : questions) {
	
		points += question.getPoint();
		 
	 }
	 return points;
 }
 
 public void setQuestions(Question1[] questions) {
	 this.questions = questions;
 }
 public Question1[] getQuestions() {
	 return questions;
 }
 public int getMax() {
	 return maxQuestions;
 }
 public int getqCount() {
	 return qCount;
 }
 
}


