package ua.foxminded.javaspring.tovarnykh.cleancode.task5;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FormulaOne {
    
    private FormulaOne() {
	
    }
    
    
    
    public static Map<String, Instant> getLeaderBoard(Map<String, Instant> racers) {
	
	return racers.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
    
}