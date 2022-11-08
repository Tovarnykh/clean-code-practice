package ua.foxminded.javaspring.tovarnykh.cleancode.main;

import java.util.Scanner;

import ua.foxminded.javaspring.tovarnykh.cleancode.task1.Anagrams;
import ua.foxminded.javaspring.tovarnykh.cleancode.task3.IntegerDivision;

public class Main {

	private static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		exerciseChooser();
		in.close();
	}
	
	/**
	 * Method name: exerciseChooser
	 * 
	 * 
	 *                                  Inside the function: Prints simple interface to choose program to execute.
	 */
	private static void exerciseChooser() {
		System.out.print("""
				╔═══════════════════════════════╗
				║Select which Program to execute║
				╠───────────────────────────────╣
				║1 - Anagrams                   ║
				║2- IntegerDivision             ║
				║                               ║
				║3- Any symbol to Exit          ║
				╚═══════════════════════════════╝
				 >""");

		String choice = in.next();

		if (choice.equals("1")) {
			taskOneExecutor();
		} else if (choice.equals("2")) {
			taskThreeExecutor();
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
		System.out.print(" out:" + Anagrams.reverseSentence(in.next()) + """

				╚═════════════════════════╝
				""");
	}
	
	/**
	 * Method name: exerciseChooser
	 * 
	 * 
	 * Inside the function: Prints simple interface to input divident and divisor.
	 */
	private static void taskThreeExecutor() {
		System.out.print("""
				╔═══════════════════════════╗
				║Insert dividend and divisor║
				╟───────────────────────────╢
				║      Insert dividend      ║
				 >""");
		int devidend = in.nextInt();
		System.out.print("║      Insert divisor       ║" + "\n >");
		int divisor = in.nextInt();
		System.out.print("╚═══════════════════════════╝" + "\n\n");
		System.out.println(IntegerDivision.makeDivision(devidend, divisor));
	}

}