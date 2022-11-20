package ua.foxminded.javaspring.tovarnykh.cleancode.main;

import java.io.IOException;
import java.util.Scanner;
import ua.foxminded.javaspring.tovarnykh.cleancode.task1.Anagrams;
import ua.foxminded.javaspring.tovarnykh.cleancode.task3.IntegerDivision;
import ua.foxminded.javaspring.tovarnykh.cleancode.task4.СharsСounter;
import ua.foxminded.javaspring.tovarnykh.cleancode.task5.FormulaOne;

public class Main {

    private static Scanner in;
    private static final String EXIT = "exit";

    public static void main(String[] args) {
	in = new Scanner(System.in);
	exerciseChooser();
	in.close();
    }

    /**
     * Method name: exerciseChooser
     * 
     * 
     * Inside the function: Prints simple interface to choose program to execute.
     */
    private static void exerciseChooser() {
	System.out.print("""
		╔═══════════════════════════════╗
		║Select which Program to execute║
		╠───────────────────────────────╣
		║1 - Anagrams                   ║
		║2 - IntegerDivision            ║
		║3 - CharsCounter               ║
		║4 - FormulaOne Leader Board    ║
		║                               ║
		║? - Any symbol to Exit         ║
		╚═══════════════════════════════╝
		 >""");

	String choice = in.nextLine();

	if (choice.equals("1")) {
	    taskOneExecutor();
	} else if (choice.equals("2")) {
	    taskThreeExecutor();
	} else if (choice.equals("3")) {
	    taskFourExecutor();
	} else if (choice.equals("4")) {
	    taskFiveExecutor();
	} else {
	    System.out.print("Shutting Down...");
	}

    }

    /**
     * Method name: exerciseChooser
     * 
     * 
     * Inside the function: Prints simple interface to input sentence.
     */
    private static void taskOneExecutor() {
	System.out.print("""
		╔═════════════════════════╗
		║Insert a word or sentence║
		╟─────────────────────────╢
		 in:""");
	System.out.print(" out:" + Anagrams.reverseSentence(in.nextLine()) + """

		╚═════════════════════════╝
		""");
    }

    /**
     * Method name: exerciseChooser
     * 
     * 
     * Inside the function: Prints simple interface to input dividend and divisor.
     */
    private static void taskThreeExecutor() {
	System.out.print("""
		╔═══════════════════════════╗
		║Insert dividend and divisor║
		╟───────────────────────────╢
		║      Insert dividend      ║
		 >""");
	String dividend = in.nextLine();
	System.out.print("║      Insert divisor       ║" + "\n >");
	String divisor = in.nextLine();
	System.out.print("""
		╚═══════════════════════════╝


		""");

	if ((dividend.replaceFirst("-", "").chars().allMatch(Character::isDigit))
		&& (divisor.replaceFirst("-", "").chars().allMatch(Character::isDigit))) {
	    System.out.println(IntegerDivision.makeDivision(Integer.parseInt(dividend), Integer.parseInt(divisor)));
	} else {
	    System.out.println("Cannot make division with such arguments");

	}
    }

    /**
     * Method name: taskFourExecutor
     * 
     * 
     * Inside the function: Prints simple interface to calculate how many characters
     * in sentence.
     */
    private static void taskFourExecutor() {
	String sentence = "";
	System.out.print("""
		╔═════════════════════════╗
		║Insert a word or sentence║
		║      Or Write Exit      ║
		╟─────────────────────────╢
		""");

	while (!EXIT.equalsIgnoreCase(sentence)) {
	    System.out.print("in:");
	    sentence = in.nextLine();
	    if (EXIT.equalsIgnoreCase(sentence)) {
		break;
	    }

	    System.out.print(СharsСounter.countChars(sentence));
	}

	System.out.print("""
		╚═════════════════════════╝
		""");
    }

    /**
     * Method name: taskFiveExecutor
     * 
     * 
     * Inside the function: Prints simple interface with Formula One Leader Board
     */
    private static void taskFiveExecutor() {
	System.out.print("""
		╔═════════════════════════╗
		║Insert file paths for:   ║
		║   Start.log  End.log    ║
		║   abbreviations.txt     ║
		╟─────────────────────────╢
		start.log>""");
	String start_path = in.nextLine();
	System.out.print("end.log>");
	String end_path = in.nextLine();
	System.out.print("abbreviations.txt>");
	String abbreviations_path = in.nextLine();
	System.out.print("""
		╚═════════════════════════╝
		""");
	try {
	    System.out.print("Loading Files");
	    for (int i = 0; i < 4; i++) {
		System.out.print('.');
		Thread.sleep(1000);
	    }
	    System.out.println("""


	    	╔═══════════════════════════════════════════════════════════════╗
	    	║			    Formula  One		       	║
	    	║			    Leader Board		        ║
	    	╟───────────────────────────────────────────────────────────────╢
	    	""" + FormulaOne.printLeaderBoard(start_path, end_path, abbreviations_path) + """
	    	╚═══════════════════════════════════════════════════════════════╝
	    	""");
	} catch (InterruptedException e) {
	    System.out.println("Critical Error! Main Thread is Dead!");
	} catch (IOException e) {
	    System.out.println("Error, no access to Files");
	}
    }

}