package ua.com.foxminded.springcourse.cleancode.task_one;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Anagrams {

	/**
	 * Function name: reverseWord
	 * 
	 * @return (String)
	 * @throws NullPointerException, IllegalArgumentException
	 * 
	 * Inside the function: 1. Identifying left and right borders of one word;
	 * 2. Looking for the signs on the both sides, if the
	 * conditions are accepted, then it changes the places;
	 */
	public static String reverseWord(String word){

		if (word == null)
			throw new NullPointerException("Argument can not be null");
		
		if (word.isBlank())
			throw new IllegalArgumentException("String is blank");

		StringBuilder reversedWord = new StringBuilder(word);
		int rightWordBorder = word.length() - 1, leftWordBorder = 0;

		while (leftWordBorder < rightWordBorder) {

			if (!Character.isAlphabetic( reversedWord.charAt( leftWordBorder ) ))
				leftWordBorder++;

			else if (!Character.isAlphabetic( reversedWord.charAt( rightWordBorder ) ))
				rightWordBorder--;

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
	 * @throws NullPointerException, IllegalArgumentException
	 * 
	 * Inside the function: 1. Splitting String on words;
	 * 2. Calling the method reverseWord() for each word;
	 * 3. Joining back words in one sentence
	 */
	public static String reverseSentence(String sentence) {
		
		if (sentence == null)
			throw new NullPointerException("Argument can not be null");
		
		if (sentence.isBlank())
			throw new IllegalArgumentException("String is blank");

		return Arrays.stream(sentence.split(" ")).map( word -> word = reverseWord( word ) )
				.collect(Collectors.joining(" "));
		
	}

}
