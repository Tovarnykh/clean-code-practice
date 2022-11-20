package ua.foxminded.javaspring.tovarnykh.cleancode.task5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.stream.Collectors;

import org.checkerframework.common.reflection.qual.GetClass;

/**
 *
 * @author Victor Tovarnykh
 * @version 0.0.1
 * @since 1.8
 */
public class FileParser {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS")
	    .withZone(ZoneOffset.UTC);
    private static final String DELIMITER = "_";

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
		.collect(Collectors.toMap(line -> line.substring(0, 3),
			line -> Instant.from(DATE_TIME_FORMATTER.parse(line.substring(3)))));
    }

    /**
     * Method name: getAbbreviations
     * 
     * @param (filepath) String with path to file.
     * @return (Map) Map with data parsed from txt file.
     * 
     *         Inside the function: 1. Reading the lines of file. 2. Spiting the
     *         data on logic parts. 3. Creating a Map and store each type of data in
     *         cell.
     */
    public static Map<String, String> getAbbreviations(String filepath) throws IOException {
	return Files.readAllLines(Paths.get(filepath)).stream().map(line -> line.split(DELIMITER)).collect(
		Collectors.toMap(lines -> lines[0], lines -> lines[1] + DELIMITER + lines[2]));
    }

}