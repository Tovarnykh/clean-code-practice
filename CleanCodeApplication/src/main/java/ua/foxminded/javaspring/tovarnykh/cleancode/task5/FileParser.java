package ua.foxminded.javaspring.tovarnykh.cleancode.task5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Victor Tovarnykh
 * @version 0.0.2
 * @since 1.8
 */
public class FileParser {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS")
	    .withZone(ZoneOffset.UTC);
    private static final String DELIMITER = "_";
    private static final int START_ABBREVIATION_KEY_INDEX = 0;
    private static final int END_ABBREVIATION_KEY_INDEX = 3;

    private FileParser() {

    }

    /**
     * Method name: getStatistic
     *
     * @param (filepath) String with path to file.
     * @return (Map) Map with data parsed from log file.
     *
     *         Inside the function: 1. Reading the lines of file. 2. Creating a Map
     *         and store each type of data in cell.
     */
    public static Map<String, Instant> getStatistic(String filepath) throws IOException {
	return Files.readAllLines(Paths.get(filepath)).stream()
		.collect(Collectors.toMap(FileParser::getStatisticAbbreviation, FileParser::getStatisticPersonalData
		));
    }

    /**
     * Method name: getAbbreviations
     *
     * @param (filepath) String with path to file.
     * @return (Map) Map with data parsed from text file.
     *
     *         Inside the function: 1. Reading the lines of file. 2. Spiting the
     *         data on logic parts. 3. Creating a Map and store each type of data in
     *         cell.
     */
    public static Map<String, String> getAbbreviations(String filepath) throws IOException {
	return Files.readAllLines(Paths.get(filepath)).stream()
		.map(line -> line.split(DELIMITER))
		.collect(Collectors
			.toMap(FileParser::getAbbreviationCode, FileParser::getAbbreviationDecoding));
    }
    
    private static String getStatisticAbbreviation(String text) {
		return text.substring(START_ABBREVIATION_KEY_INDEX, END_ABBREVIATION_KEY_INDEX);
    }
    
    private static Instant getStatisticPersonalData(String text) {	
		return Instant.from(DATE_TIME_FORMATTER.parse(text.substring(END_ABBREVIATION_KEY_INDEX)));
    }
    
    private static String getAbbreviationCode(String[] texts) {
	return texts[0];
    }
    
    private static String getAbbreviationDecoding(String[] texts) {
	return texts[1] + DELIMITER + texts[2];
    }

}