package ua.foxminded.javaspring.tovarnykh.cleancode.task1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		System.out.println("Insert a word or sentence");

		try (Scanner in = new Scanner(System.in)) {
			System.out.println(Anagrams.reverseSentence(in.nextLine()));
		}
	}
}