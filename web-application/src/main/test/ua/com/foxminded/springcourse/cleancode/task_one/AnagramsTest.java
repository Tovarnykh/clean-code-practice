package ua.com.foxminded.springcourse.cleancode.task_one;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AnagramsTest {

	@Test
	void reversWord_SimpleDataTest_True() {
		assertEquals("i!!!h.g.f,e'd,cba",Anagrams.reverseWord("a!!!b.c.d,e'f,ghi"));
	}
	
	@Test
	void reversWord_DataWithNumbers_False() {
		assertNotEquals("1!2.34,5'6,7890",Anagrams.reverseWord("0!9.87,6'5,4321"));
	}

	@Test
	void reversWord_NullPointerArgument_True() {
		NullPointerException thrown = assertThrows(NullPointerException.class, ()->Anagrams.reverseWord(null), "Argument can not be null");
		assertEquals("Argument can not be null", thrown.getMessage());
	}
	
	@Test
	void reversWord_BlankString_True() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, ()->Anagrams.reverseWord(""), "String is blank");
		assertEquals("String is blank", thrown.getMessage());
	}
	
	@Test
	void reversWord_ContainsSpace_True() {
		assertEquals("i!! !h. g.f,e'd, cba",Anagrams.reverseWord("a!! !b. c.d,e'f, ghi"));
	}
	
	
	
}
