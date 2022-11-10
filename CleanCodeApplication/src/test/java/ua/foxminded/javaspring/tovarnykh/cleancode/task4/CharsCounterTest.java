package ua.foxminded.javaspring.tovarnykh.cleancode.task4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ua.foxminded.javaspring.tovarnykh.cleancode.task3.IntegerDivision;

class CharsCounterTest {

		@Test
		void countChars_ArgumentIsNull_True() {
				assertEquals("Exception: sentence is blank or null", СharsСounter.countChars(null));
		}

		@Test
		void countChars_ArgumentIsEmpty_True() {
				assertEquals("Exception: sentence is blank or null", СharsСounter.countChars(""));
		}

		@Test
		void countChars_ArgumentIsBlank_True() {
				assertEquals(" ' ' - 11\n", СharsСounter.countChars("           "));
		}

		@Test
		void countChars_CommonInput_True() {
				assertEquals("""
								 'h' - 1
								 'e' - 1
								 'l' - 3
								 'o' - 2
								 ' ' - 1
								 'w' - 1
								 'r' - 1
								 'd' - 1
								 '!' - 2
								""", СharsСounter.countChars("Hello World!!"));
		}

		@Test
		void countChars_InputWithNumbers_True() {
				assertEquals("""
								 'h' - 1
								 'e' - 1
								 '4' - 2
								 '1' - 2
								 'l' - 3
								 'o' - 2
								 ' ' - 1
								 'w' - 1
								 '2' - 2
								 '9' - 1
								 '0' - 4
								 'r' - 1
								 'd' - 1
								 '!' - 2
								""", СharsСounter.countChars("He4141llo W22o90000rld!!"));
		}

}