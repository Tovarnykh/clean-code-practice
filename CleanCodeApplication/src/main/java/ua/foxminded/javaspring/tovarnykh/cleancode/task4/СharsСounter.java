package ua.foxminded.javaspring.tovarnykh.cleancode.task4;

/**
 *
 * @author Victor Tovarnykh
 * @version 0.0.3
 * @since 0.0.1
 */
public class СharsСounter {

    private static final String LEFTBORDER = " '";
    private static final String RIGHTBORDER = "' - ";
    private static final String NEWLINE = "\n";

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

	CacheInstrument.get(sentence).forEach((character, number) -> string.append(LEFTBORDER).append(character)
		.append(RIGHTBORDER).append(number).append(NEWLINE));

	return string.toString();
    }

}