package ua.com.foxminded.springcourse.cleancode.task_one;

public class Anagrams {

	public static String reverseWord(String word) {
		
		if(word == null)
			throw new NullPointerException("Argument can not be null");
		if(word.isBlank())
			throw new IllegalArgumentException("String is blank");
		
		StringBuilder reversedWord = new StringBuilder(word);
		int rightWordBorder = word.length() - 1, leftWordBorder = 0;

		while (leftWordBorder < rightWordBorder) {

			if (!Character.isAlphabetic(reversedWord.charAt(leftWordBorder)))
				leftWordBorder++;
			
			else if (!Character.isAlphabetic(reversedWord.charAt(rightWordBorder)))
				rightWordBorder--;
			
			else {
				char tmp = reversedWord.charAt(leftWordBorder);
				reversedWord.setCharAt(leftWordBorder, reversedWord.charAt(rightWordBorder));
				reversedWord.setCharAt(rightWordBorder, tmp);
				leftWordBorder++;
				rightWordBorder--;
			}
			
		}

		return reversedWord.toString();
	}

}
