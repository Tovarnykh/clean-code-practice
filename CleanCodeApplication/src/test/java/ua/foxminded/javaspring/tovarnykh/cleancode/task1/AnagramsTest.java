package ua.foxminded.javaspring.tovarnykh.cleancode.task1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class AnagramsTest {

    @Test
    void reverseWord_NullPointerArgument_ExceptionThrown() {
	IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> Anagrams.reverseWord(null),
		"Illegal argument");

	assertEquals("Illegal argument", thrown.getMessage());
    }

    @Test
    void reverseWord_SimpleDataTest_True() {
	assertEquals("i!!!h.g.f,e'd,cba", Anagrams.reverseWord("a!!!b.c.d,e'f,ghi"));
    }

    @Test
    void reverseWord_DataWithNumbers_False() {
	assertNotEquals("1!2.34,5'6,7890", Anagrams.reverseWord("0!9.87,6'5,4321"));
    }

    @Test
    void reverseWord_SinglChar_True() {
	assertEquals("a", Anagrams.reverseWord("a"));
    }

    @Test
    void reverseWord_MultipleSameLetter_True() {
	assertEquals("aaaaaaaaa", Anagrams.reverseWord("aaaaaaaaa"));
    }

    @Test
    void reverseSentence_NullPointerArgument_ExceptionThrown() {
	IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
		() -> Anagrams.reverseSentence(null), "Illegal argument");

	assertEquals("Illegal argument", thrown.getMessage());
    }

    @Test
    void reverseSentence_BlankString_ExceptionThrown() {
	IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
		() -> Anagrams.reverseSentence(" "), "Illegal argument");

	assertEquals("Illegal argument", thrown.getMessage());
    }

    @Test
    void reverseSentence_ContainsSpace_True() {
	assertEquals("a!! !b. f.e,d'c, ihg", Anagrams.reverseSentence("a!! !b. c.d,e'f, ghi"));
    }

    @Test
    void reverseSentence_SimpleDataTest_True() {
	assertEquals("b!!!a .e.d,c 'i,hgf", Anagrams.reverseSentence("a!!!b .c.d,e 'f,ghi"));
    }

    @Test
    void reverseSentence_DataWithNumbers_False() {
	assertNotEquals("1!2 .34,5' 6,7890", Anagrams.reverseSentence("0!9 .87,6' 5,4321"));
    }

    @Test
    void reverseSentence_SingleSpaceIsSingle_True() {
	assertEquals(1, Anagrams.reverseSentence("0!9 .87,6'5,4321").chars().filter(symbol -> symbol == ' ').count());
    }

    @Test
    void reverseSentence_SeveralSpaceIsSeveral_True() {
	assertEquals(11, Anagrams.reverseSentence("af0!9     .87,6'5,   43   21").chars()
		.filter(symbol -> symbol == ' ').count());
    }

    @Test
    void reverseSentence_SinglChar_True() {
	assertEquals("a", Anagrams.reverseSentence("a"));
    }

    @Test
    void reverseSentence_MultipleSameLetter_True() {
	assertEquals("aaa aaaaa aaaa", Anagrams.reverseSentence("aaa aaaaa aaaa"));
    }

    @Test
    void reverseSentence_OneLetterInDifferentRegister_True() {
	assertEquals("g!!!ah.i.AA,cd'aeafbAg", Anagrams.reverseSentence("g!!!Ab.f.ae,ad'cAAihag"));
    }

}