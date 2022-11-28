package ua.foxminded.javaspring.tovarnykh.cleancode.task5;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

import java.util.Map.Entry;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;
import static java.util.concurrent.TimeUnit.MINUTES;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 *
 * @author Victor Tovarnykh
 * @version 0.0.2
 * @since 1.8
 */
public class FormulaOne {

    private static final String DELIMITER = "_";
    private static final String TIME_FORMAT = "%02d:%02d.%03d";
    private static final String BOARD_FORMAT = "%2d. %-20s | %-25s | %s\n";
    private static final String SKIP_LINE = "----------------------------------------------------------------\n";
    private static final int RACERS_LIMIT = 15;
    private static final int NUMBER_OF_LOWEST_RECORDS = 3;

    private FormulaOne() {

    }

    /**
     * Method name: buildLeaderBoard
     *
     * @return (String) String with formated LeaderBoard made by FormulaOne
     *         conventions.
     *
     *         Inside the function: 1. Reading the data from all files and storing
     *         it. 2. Creating a descending statistic of racers united two files. 3.
     *         Pushing best 15 racers data on their`s place 4. Adding last worst 3
     *         racers data to the very end of the list.
     */
    public static String buildLeaderBoard(String startPath, String endPath, String abbreviationsPath)
	    throws IOException {
	StringBuilder leaderBoard = new StringBuilder();
	AtomicInteger iterator = new AtomicInteger(1);
	Map<String, String> statistic = createBoard(startPath, endPath);
	Map<String, String> racersPersonalData = FileParser.getAbbreviations(abbreviationsPath);
	int endListPositionsNumber = statistic.size() - NUMBER_OF_LOWEST_RECORDS;

	statistic.entrySet().stream()
	.limit(RACERS_LIMIT).forEach(racer -> {
	    String[] data = racersPersonalData.get(
		    racer.getKey()).split(DELIMITER);
	    leaderBoard
		    .append(String.format(BOARD_FORMAT, 
			    iterator.getAndIncrement(), data[0], data[1], racer.getValue()));
	});

	leaderBoard.append(SKIP_LINE);
	
	iterator.set(endListPositionsNumber + 1);
	statistic.entrySet().stream().skip(endListPositionsNumber).forEach(racer -> {
	    String[] data = racersPersonalData.get(racer.getKey()).split(DELIMITER);
	    leaderBoard
		    .append(String.format(BOARD_FORMAT, 
			    iterator.getAndIncrement(), data[0], data[1], racer.getValue()));
	});

	return leaderBoard.toString();
    }
    
    /**
     * Method name: createBoard
     *
     * @return (Map) Map with formated time leader board.
     *
     *         Inside the function: 1.Get two parsed files. 2. Create new Map with
     *         reworked time format. 3. Creating new map with full leader board.
     */
    private static Map<String, String> createBoard(String startFile, String endFile) throws IOException {
	Map<String, Long> rawMap = createRawMap(
		FileParser.getStatistic(startFile), FileParser.getStatistic(endFile));
	return sortRawMap(rawMap).entrySet().stream()
		.collect(Collectors.toMap(Entry::getKey,
			FormulaOne::formateTime,
			(oldValue, newValue) -> oldValue, LinkedHashMap::new));

    }
    
    /**
     * Method name: formateTime
     *
     * @return (String) String with formated time from milliseconds to readable view.
     *
     *         Inside the function: Converts milliseconds to hours, minutes and seconds.
     */
    private static String formateTime(Entry<String, Long> racer) {
	long racerRecord = racer.getValue();
	return String.format(TIME_FORMAT,
		MILLISECONDS.toMinutes(racerRecord),
		MILLISECONDS.toSeconds(racerRecord) 
		- MINUTES.toSeconds(MILLISECONDS.toMinutes(racerRecord)),
		racerRecord - SECONDS.toMillis(MILLISECONDS.toSeconds(racerRecord)));
    }
    
    /**
     * Method name: sortRawMap
     *
     * @return (Map) Map with sorted data.
     *
     *         Inside the function: Sort the Map and creating new one with sorted parameters.
     */
    private static Map<String, Long> sortRawMap(Map<String, Long> rawMap) {
	return rawMap.entrySet().stream()
		.sorted(Map.Entry.comparingByValue())
		.collect(Collectors
		.toMap(Entry::getKey, Entry::getValue, 
			(oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
    
    /**
     * Method name: createBoard
     *
     * @return (Map) Map with calculated data of two files of racers
     *         statistics with not formated data.
     *
     *         Inside the function: Put the time difference of two files in the Map.
     */
    private static Map<String, Long> createRawMap(Map<String, Instant> startStatistic,
	    Map<String, Instant> endStatistic) {
	Map<String, Long> leaderBoard = new LinkedHashMap<>();

	startStatistic.forEach(
		(key, value) -> leaderBoard.put(key, Duration.between(value, endStatistic.get(key)).toMillis()));
	return leaderBoard.entrySet().stream()
		.sorted(Map.Entry.comparingByValue())
		.collect(Collectors
		.toMap(Map.Entry::getKey, Entry::getValue, 
			(oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

}