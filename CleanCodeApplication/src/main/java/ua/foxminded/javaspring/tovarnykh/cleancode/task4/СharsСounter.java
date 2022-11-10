package ua.foxminded.javaspring.tovarnykh.cleancode.task4;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
*
* @author Victor Tovarnykh
* @version 0.0.1
* @since 0.0.1
*/
public class СharsСounter {

		private СharsСounter() {

		}
		
		/**
		 * Method name: countChars
		 * 
		 * @param sentence String which characters needs to be counted.
		 * @return (String) String with summarized characters.
		 * 
		 *         Inside the function:
		 */
		public static String countChars(String sentence) {
				
				if ((sentence == null) || (sentence.isEmpty())) {
						return "Exception: sentence is blank or null";
				}

				StringBuilder string = new StringBuilder();
				
				count(sentence).forEach((character, number) -> string
								.append(" '" + character + "' - " + number + "\n"));
				
				return string.toString();
		}

		/**
		 * Method name: count
		 * 
		 * @param sentence String which characters we count.
		 * @return (Map<String,Long>) Map where key it`s a char, and the value it`s a
		 *         number of chars.
		 * 
		 *         Inside the function: 1. Splitting sentence on atomic chars. 2.
		 *         Getting them to the lower case. 3. Grouping sentence by characters and
		 *         counting each of them.
		 */
		private static Map<String, Long> count(String sentence) {
				
				return Arrays.stream(sentence.split(""))
								.map(String::toLowerCase)
								.collect(Collectors
												.groupingBy(character -> character, LinkedHashMap::new, Collectors.counting()));
		}

}