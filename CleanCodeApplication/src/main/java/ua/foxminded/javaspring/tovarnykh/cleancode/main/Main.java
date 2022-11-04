package ua.foxminded.javaspring.tovarnykh.cleancode.main;

import java.util.Scanner;

import ua.foxminded.javaspring.tovarnykh.cleancode.task1.Anagrams;
import ua.foxminded.javaspring.tovarnykh.cleancode.task2.IntegerDivision;

public class Main {
	
	private static Scanner in;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		exerciseChooser();
		in.close();
	}

	private static void exerciseChooser() {
		System.out.println("|Enter number to execute|\n" + "1 Anagrams\n" + "2 IntegerDivision\n" + "3 Exit");
		
		
		String choice = in.nextLine();
		
		if (choice.equals("1")) {
			taskOneExecutor();
		} else if (choice.equals("2")) {
			taskTwoExecutor();
		} else if (choice.equals("3")) {
			System.out.println("\nShutting down...");
		} else {
			System.out.println("\nIncorrect Input\n");
			
			exerciseChooser();
		}

	}

	private static void taskOneExecutor() {
		System.out.println("\nInsert a word or sentence");

		System.out.println(Anagrams.reverseSentence(in.nextLine()) + "\n");
		exerciseChooser();
	}

	private static void taskTwoExecutor() {
		System.out.println("Insert dividend:");
		int devidend = in.nextInt();

		System.out.println("Insert divisor:");
		int divisor = in.nextInt();

		System.out.println(IntegerDivision.makeDivision(devidend, divisor) + "\n");
		in.nextLine();
		exerciseChooser();
	}

}