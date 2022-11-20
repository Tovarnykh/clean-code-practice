package ua.foxminded.javaspring.tovarnykh.cleancode.task5;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 *
 * @author Victor Tovarnykh
 * @version 0.0.1
 * @since 1.8
 */
public class FormulaOne {

    private static final String DELIMITER = "_";

    private FormulaOne() {

    }

    /**
     * Method name: printLeaderBoard
     * 
     * @return (String) String with formated LeaderBoard made by FormulaOne
     *         conventions.
     * 
     *         Inside the function: 1. Reading the data from all files and storing
     *         it. 2. Creating a descending statistic of racers united two files. 3.
     *         Pushing best 15 racers data on their`s place 4. Adding last worst 3
     *         racers data to the very end of the list.
     */
    public static String printLeaderBoard(String startPath, String endPath, String abbreviationsPath)
	    throws IOException {
	StringBuilder leaderBoard = new StringBuilder();
	AtomicInteger iterator = new AtomicInteger(1);
	Map<String, String> statistic = getLeaderBoard(startPath, endPath);
	Map<String, String> racersPersonalData = FileParser.getAbbreviations(abbreviationsPath);

	statistic.entrySet().stream().limit(15).forEach(racer -> {
	    String[] data = racersPersonalData.get(racer.getKey()).split(DELIMITER);
	    leaderBoard.append(String.format("%2d. %-20s | %-25s | %s\n", iterator.getAndIncrement(), data[0], data[1],
		    racer.getValue()));
	});

	leaderBoard.append("----------------------------------------------------------------\n");

	iterator.set(statistic.size() - 2);
	statistic.entrySet().stream().skip((long) statistic.size() - 3).forEach(racer -> {
	    String[] data = racersPersonalData.get(racer.getKey()).split(DELIMITER);
	    leaderBoard.append(String.format("%2d. %-20s | %-25s | %s\n", iterator.getAndIncrement(), data[0], data[1],
		    racer.getValue()));
	});

	return leaderBoard.toString();
    }

    /**
     * Method name: getLeaderBoard
     * 
     * @return (Map) Map with leader board.
     * 
     *         Inside the function: 1.Get two parsed files. 2. Create new Map with
     *         reworked time format. 3. Creating new map with full leader board.
     */
    private static Map<String, String> getLeaderBoard(String start, String end) throws IOException {
	return createSortedList(FileParser.getStatistic(start), FileParser.getStatistic(end)).entrySet().stream()
		.collect(Collectors.toMap(Map.Entry::getKey,
			racerStatistic -> String.format("%02d:%02d.%03d",
				TimeUnit.MILLISECONDS.toMinutes(racerStatistic.getValue()),
				TimeUnit.MILLISECONDS.toSeconds(racerStatistic.getValue()) - TimeUnit.MINUTES
					.toSeconds(TimeUnit.MILLISECONDS.toMinutes(racerStatistic.getValue())),
				racerStatistic.getValue() - TimeUnit.SECONDS
					.toMillis(TimeUnit.MILLISECONDS.toSeconds(racerStatistic.getValue()))),
			(oldValue, newValue) -> oldValue, LinkedHashMap::new));

    }

    /**
     * Method name: createSortedList
     * 
     * @return (Map) Map with sorted calculated data of two files with racers
     *         statistics.
     * 
     *         Inside the function: 1. Put the time difference in the Map. 2. Sort
     *         the Map and creating new one with sorted parameters.
     */
    private static Map<String, Long> createSortedList(Map<String, Instant> startStatistic,
	    Map<String, Instant> endStatistic) {
	Map<String, Long> leaderBoard = new LinkedHashMap<>();

	startStatistic.forEach(
		(key, value) -> leaderBoard.put(key, Duration.between(value, endStatistic.get(key)).toMillis()));
	return leaderBoard.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors
		.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

}