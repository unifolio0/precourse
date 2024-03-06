package pairmatching;

import pairmatching.Model.Crew;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
    private static final String DELIMITER = ", ";

    public static List<String> parserSplitComma(String input) {
        List<String> split = Arrays.asList(input.split(DELIMITER));
        return split;
    }

    public static List<List<String>> parserCrew(List<List<Crew>> allCrews) {
        List<List<String>> ret = new ArrayList<>();
        for (List<Crew> crews : allCrews) {
            List<String> strings = new ArrayList<>();
            for (Crew crew : crews) {
                strings.add(crew.getName());
            }
            ret.add(strings);
        }
        return ret;
    }
}
