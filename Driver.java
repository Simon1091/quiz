package edu.fullerton.simon.package1;

import java.util.Scanner;
public class Driver {
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
	    Quiz quiz1 = new Quiz(3);
	    Question1 q = new Question1("How many days are there in a week?\n", "7");
	    quiz1.addQuestion(q.clone());
	    String[] possibleAnswers = {"March", "Autumn", "Monday", "2017"};
	    //DerivedQuestion1 mq = new DerivedQuestion1("Which among the following is the name of a day in a week?", "3", possibleAnswers);
	    //quiz1.addQuestion(mq.clone());
	    //DerivedQuestion2 s = new  DerivedQuestion2("What is my name", "Simon");
	   // DerivedQuestion3 m = new  DerivedQuestion3("Which among the folsimowing is the name of a day in a week?", "321", possibleAnswers);
	    //quiz1.addQuestion(s.clone());
	   // quiz1.addQuestion(m.clone());
	    System.out.println(quiz1);
	   quiz1.save();
	   quiz1.load();
}	
}
