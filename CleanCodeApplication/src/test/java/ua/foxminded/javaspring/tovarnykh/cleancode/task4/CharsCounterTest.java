package ua.foxminded.javaspring.tovarnykh.cleancode.task4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

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
								 'H' - 1
								 'e' - 1
								 'l' - 3
								 'o' - 2
								 ' ' - 1
								 'W' - 1
								 'r' - 1
								 'd' - 1
								 '!' - 2
								""", СharsСounter.countChars("Hello World!!"));
		}

		@Test
		void countChars_InputWithNumbers_True() {
				assertEquals("""
								 'H' - 1
								 'e' - 1
								 '4' - 2
								 '1' - 2
								 'l' - 3
								 'o' - 2
								 ' ' - 1
								 'W' - 1
								 '2' - 2
								 '9' - 1
								 '0' - 4
								 'r' - 1
								 'd' - 1
								 '!' - 2
								""", СharsСounter.countChars("He4141llo W22o90000rld!!"));
		}

		@Test
		void countChars_BigInput_True() {
				assertEquals("""
								 'E' - 1
								 't' - 21
								 'i' - 25
								 'a' - 18
								 'm' - 11
								 'e' - 27
								 'u' - 27
								 'p' - 10
								 'l' - 13
								 'c' - 9
								 'r' - 18
								 'g' - 2
								 ',' - 4
								 'n' - 14
								 's' - 19
								 '.' - 6
								 'C' - 1
								 'd' - 7
								 'o' - 10
								 'q' - 4
								 'F' - 1
								 'b' - 3
								 'h' - 3
								 'D' - 2
								 'f' - 1
								 'j' - 1
								 'v' - 4
								 'M' - 1
								 'U' - 1
								 'x' - 1
								""", СharsСounter.countChars(
								"Etiameuplaceratligula,necultricesipsum.Crassuscipitimperdietdolorinaliquet.Fuscealiquetdolorutnibhrhoncus,interdumtristiquemetustempor.Donecmassanunc,eleifendutjustovitae,bibendumtristiquenunc.Duispharetragravidapulvinar.Mauristempusnullavelposuereposuere.Utmaximus"));
		}

}