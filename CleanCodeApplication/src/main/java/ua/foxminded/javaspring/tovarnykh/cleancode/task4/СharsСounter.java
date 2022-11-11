package ua.foxminded.javaspring.tovarnykh.cleancode.task4;

import java.util.LinkedHashMap;
import java.util.concurrent.ExecutionException;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 *
 * @author Victor Tovarnykh
 * @version 0.0.2
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
		 *         Inside the function: Calls count method to calculate number of
		 *         characters and caching the result with CACHE method.
		 */
		public static String countChars(String sentence) {

				if ((sentence == null) || (sentence.isEmpty())) {
						return "Exception: sentence is blank or null";
				}

				StringBuilder string = new StringBuilder();

				try {
						CACHE.get(sentence)
										.forEach((character, number) -> string.append(" '" + character + "' - " + number + "\n"));
				} catch (ExecutionException e) {
						return "Execution Failed";
				}

				return string.toString();
		}

		/**
		 * Method name: CACHE
		 * 
		 * @return (LoadingCache<String, LinkedHashMap<Character, Integer>>) Cashed
		 *         result of previous calculations.
		 * 
		 *         Inside the function: Cashing the result of count calculations to make
		 *         same calculations faster next time.
		 */
		private static final LoadingCache<String, LinkedHashMap<Character, Integer>> CACHE = CacheBuilder.newBuilder()
						.build(new CacheLoader<String, LinkedHashMap<Character, Integer>>() {
								@Override
								public LinkedHashMap<Character, Integer> load(String key) {
										return count(key);
								}
						});

		/**
		 * Method name: count
		 * 
		 * @param sentence String which characters we count.
		 * @return (LinkedHashMap<Character, Integer>) Map where key it`s a char, and
		 *         the value it`s a number of chars.
		 * 
		 *         Inside the function: 1. Splitting sentence on atomic chars. 2.
		 *         Grouping sentence by characters and counting each of them.
		 */
		private static LinkedHashMap<Character, Integer> count(String arg) {
				LinkedHashMap<Character, Integer> elements = new LinkedHashMap();
				arg.chars().forEach((num) -> {
						Character character = (char) num;
						if (elements.containsKey(character)) {
								elements.put(character, elements.get(character) + 1);
						} else {
								elements.put(character, 1);
						}
				});
				return elements;
		}

}