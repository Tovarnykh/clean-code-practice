package ua.foxminded.javaspring.Tovarnykh.cleancode.task1;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Anagrams {

	/**
	 * Function name: reverseWord
	 * 
	 * @return (String)
	 * @throws IllegalArgumentException
	 * 
	 * Inside the function: 1. Identifying left and right borders of one word;
	 * 2. Looking for the signs on the both sides, if the
	 * conditions are accepted, then it changes the places;
	 */
	public static String reverseWord(String word){
		
		if (word == null || word.isBlank()) {
			throw new IllegalArgumentException("Illegal argument");
		}

		StringBuilder reversedWord = new StringBuilder(word);
		int rightWordBorder = word.length() - 1, leftWordBorder = 0;

		while (leftWordBorder < rightWordBorder) {

			if (!Character.isAlphabetic( reversedWord.charAt( leftWordBorder ) )) {
				leftWordBorder++;
				}

			else if (!Character.isAlphabetic( reversedWord.charAt( rightWordBorder ) )) {
				rightWordBorder--;
				}

			else {
				char tmp = reversedWord.charAt( leftWordBorder );
				reversedWord.setCharAt( leftWordBorder, reversedWord.charAt( rightWordBorder ) );
				reversedWord.setCharAt( rightWordBorder, tmp );
				leftWordBorder++;
				rightWordBorder--;
			}

		}

		return reversedWord.toString();
	}
	
	/**
	 * Function name: reverseSentence
	 * 
	 * @return (String)
	 * @throws IllegalArgumentException
	 * 
	 * Inside the function: 1. Splitting String on words;
	 * 2. Calling the method reverseWord() for each word;
	 * 3. Joining back words in one sentence
	 */
	public static String reverseSentence(String sentence) {
		
		if (sentence == null || sentence.isBlank()) {
			throw new IllegalArgumentException("Illegal argument");
		}

		return Arrays.stream(sentence.split(" ")).map( Anagrams::reverseWord )
				.collect(Collectors.joining(" "));
		
	}

}
