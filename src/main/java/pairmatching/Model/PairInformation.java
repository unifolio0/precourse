package pairmatching.Model;

import pairmatching.Parser;

import java.util.List;

public class PairInformation {
    private Course course;
    private Level level;
    private String mission;

    public PairInformation(String input) {
        List<String> pairInformation = Parser.parserSplitComma(input);
        this.course = Course.getCourse(pairInformation.get(0));
        this.level = Level.getLevel(pairInformation.get(1));
        this.mission = pairInformation.get(2);
        Level.searchMission(mission, level);
    }

    public Course getCourse() {
        return this.course;
    }

    public Level getLevel() {
        return this.level;
    }

    @Override
    public int hashCode() {
        return this.mission.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PairInformation) {
            PairInformation pairInformation = (PairInformation) obj;
            if (!pairInformation.course.equals(this.course)) {
                return false;
            }
            if (!pairInformation.level.equals(this.level)) {
                return false;
            }
            if (!pairInformation.mission.equals(this.mission)) {
                return false;
            }
            return true;
        }
        return false;
    }
}
