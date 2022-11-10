package ua.foxminded.javaspring.tovarnykh.cleancode.main;

import java.util.Scanner;

import ua.foxminded.javaspring.tovarnykh.cleancode.task1.Anagrams;
import ua.foxminded.javaspring.tovarnykh.cleancode.task3.IntegerDivision;
import ua.foxminded.javaspring.tovarnykh.cleancode.task4.СharsСounter;

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
								║                               ║
								║? - Any symbol to Exit         ║
								╚═══════════════════════════════╝
								 >""");

				String choice = in.next();

				if (choice.equals("1")) {
						taskOneExecutor();
				} else if (choice.equals("2")) {
						taskThreeExecutor();
				} else if (choice.equals("3")) {
						taskFourExecutor();
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
				in = new Scanner(System.in);
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
				String dividend = in.next();
				System.out.print("║      Insert divisor       ║" + "\n >");
				String divisor = in.next();
				System.out.print("╚═══════════════════════════╝" + "\n\n");

				if ((dividend.replaceFirst("-", "").chars().allMatch(Character::isDigit))
								&& (divisor.replaceFirst("-", "").chars().allMatch(Character::isDigit))) {
						System.out.println(IntegerDivision.makeDivision(Integer.parseInt(dividend), Integer.parseInt(divisor)));
				} else {
						System.out.println("Cannot make division with such arguments");

				}
		}

		private static void taskFourExecutor() {
				System.out.print("""
								╔═════════════════════════╗
								║Insert a word or sentence║
								╟─────────────────────────╢
								 in:""");
				in = new Scanner(System.in);
				System.out.print("\n" + СharsСounter.countChars(in.nextLine()) + """

								╚═════════════════════════╝
								""");
		}

}