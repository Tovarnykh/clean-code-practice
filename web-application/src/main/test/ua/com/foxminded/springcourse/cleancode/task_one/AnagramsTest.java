package ua.com.foxminded.springcourse.cleancode.task_one;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AnagramsTest {

	@Test
	void reverseWord_SimpleDataTest_True() {
		assertEquals("i!!!h.g.f,e'd,cba", Anagrams.reverseWord("a!!!b.c.d,e'f,ghi"));
	}

	@Test
	void reverseWord_DataWithNumbers_False() {
		assertNotEquals("1!2.34,5'6,7890", Anagrams.reverseWord("0!9.87,6'5,4321"));
	}

	@Test
	void reverseWord_NullPointerArgument_True() {
		NullPointerException thrown = assertThrows(NullPointerException.class, () -> Anagrams.reverseWord(null),
				"Argument can not be null");
		assertEquals("Argument can not be null", thrown.getMessage());
	}

	@Test
	void reverseWord_BlankString_True() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> Anagrams.reverseWord(""),
				"String is blank");
		assertEquals("String is blank", thrown.getMessage());
	}

	@Test
	void reverseWord_ContainsSpace_True() {
		assertEquals("i!! !h. g.f,e'd, cba", Anagrams.reverseWord("a!! !b. c.d,e'f, ghi"));
	}

	@Test
	void reverseSentence_SimpleDataTest_True() {
		assertEquals("b!!!a .e.d,c 'i,hgf", Anagrams.reverseSentence("a!!!b .c.d,e 'f,ghi"));
	}

	@Test
	void reverseSentence_NullPointerArgument_True() {
		NullPointerException thrown = assertThrows(NullPointerException.class, () -> Anagrams.reverseSentence(null),
				"Argument can not be null");
		assertEquals("Argument can not be null", thrown.getMessage());
	}

	@Test
	void reverseSentence_BlankString_True() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> Anagrams.reverseSentence(" "), "String is blank");
		assertEquals("String is blank", thrown.getMessage());
	}

	@Test
	void reverseSentence_DataWithNumbers_False() {
		assertNotEquals("1!2 .34,5' 6,7890", Anagrams.reverseWord("0!9 .87,6' 5,4321"));
	}

}
