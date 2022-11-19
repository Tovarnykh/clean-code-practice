package ua.foxminded.javaspring.tovarnykh.cleancode.task5;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class FormulaOne {

    private FormulaOne() {

    }

    public static Map<String, String> getLeaderBoard(String start, String end) throws IOException {
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

    public static Map<String, Long> createSortedList(Map<String, Instant> startStatistic,
	    Map<String, Instant> endStatistic) {
	Map<String, Long> leaderBoard = new LinkedHashMap<>();
	startStatistic.forEach((key, value) -> {
	    Duration d = Duration.between(value, endStatistic.get(key));
	    leaderBoard.put(key, d.toMillis());
	});
	return leaderBoard.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors
		.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

}