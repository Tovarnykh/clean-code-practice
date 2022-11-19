package ua.foxminded.javaspring.tovarnykh.cleancode.task5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.stream.Collectors;

public class FileParser {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS")
	    .withZone(ZoneOffset.UTC);
    private static final String DELIMITER = "_";

    private FileParser() {

    }

    public static Map<String, Instant> getStatistic(String filepath) throws IOException {
	return Files.readAllLines(Paths.get(filepath)).stream()
		.collect(Collectors.toMap((String line) -> line.substring(0, 3),
			(String line) -> Instant.from(DATE_TIME_FORMATTER.parse(line.substring(3)))));
    }

    public static Map<String, String> getAbbreviations(String filepath) throws IOException {
	return Files.readAllLines(Paths.get(filepath)).stream().map(line -> line.split(DELIMITER)).collect(
		Collectors.toMap((String[] line) -> line[0], (String[] line) -> line[1] + DELIMITER + line[2]));
    }

}