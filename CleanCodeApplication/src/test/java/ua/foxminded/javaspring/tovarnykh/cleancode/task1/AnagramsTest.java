package ua.foxminded.javaspring.tovarnykh.cleancode.task1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> Anagrams.reverseWord(null),
				"Illegal argument");
		assertEquals("Illegal argument", thrown.getMessage());
	}

	@Test
	void reverseWord_BlankString_True() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> Anagrams.reverseWord(""),
				"Illegal argument");
		assertEquals("Illegal argument", thrown.getMessage());
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
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> Anagrams.reverseSentence(null),
				"Illegal argument");
		assertEquals("Illegal argument", thrown.getMessage());
	}

	@Test
	void reverseSentence_BlankString_True() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> Anagrams.reverseSentence(" "), "Illegal argument");
		assertEquals("Illegal argument", thrown.getMessage());
	}

	@Test
	void reverseSentence_DataWithNumbers_False() {
		assertNotEquals("1!2 .34,5' 6,7890", Anagrams.reverseWord("0!9 .87,6' 5,4321"));
	}

}
