package ua.foxminded.javaspring.tovarnykh.cleancode.task4;

import java.util.LinkedHashMap;
import java.util.Map;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 *
 * @author Victor Tovarnykh
 * @version 0.0.1
 * @since 1.8
 */
public class CacheInstrument {

    /**
     * Variable name: CACHE
     *
     * Stores cached data.
     */
    private static final LoadingCache<String, LinkedHashMap<Character, Integer>> CACHE = CacheBuilder.newBuilder()
	    .build(new CacheLoader<>() {

		@Override
		public LinkedHashMap<Character, Integer> load(String key) {

		    LinkedHashMap<Character, Integer> elements = new LinkedHashMap<>();

		    key.chars().forEach(num -> {
			Character character = (char) num;
			if (elements.containsKey(character)) {
			    elements.put(character, elements.get(character) + 1);
			} else {
			    elements.put(character, 1);
			}
		    });

		    return elements;
		}
	    });

    private CacheInstrument() {

    }

    /**
     * Method name: get
     *
     * @param sentence String which characters needs to be counted.
     * @return (Map) Map with stored data.
     *
     *         Inside the function: Check is sentence is presented in cache, if not
     *         loads the data inside the cache
     */
    public static Map<Character, Integer> get(String sentence) {
	if (CACHE.getIfPresent(sentence) != null) {
	    System.out.println("Loaded from CACHE!");
	}
	return CACHE.getUnchecked(sentence);
    }

}
