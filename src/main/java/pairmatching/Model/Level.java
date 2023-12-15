package pairmatching.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Level {
    LEVEL1("레벨1", new ArrayList<String>(Arrays.asList(new String[] {"자동차경주", "로또", "숫자야구게임"}))),
    LEVEL2("레벨2", new ArrayList<String>(Arrays.asList(new String[] {"장바구니", "결제", "지하철노선도"}))),
    LEVEL3("레벨3", new ArrayList<String>(Arrays.asList(new String[] {""}))),
    LEVEL4("레벨4", new ArrayList<String>(Arrays.asList(new String[] {"성능개선", "배포"}))),
    LEVEL5("레벨5", new ArrayList<String>(Arrays.asList(new String[] {""})));

    private String name;
    private List<String> missions;

    Level(String name, List<String> missions) {
        this.name = name;
        this.missions = missions;
    }

    public static Level getLevel(String name) {
        if (LEVEL1.name.equals(name)) {
            return LEVEL1;
        }
        if (LEVEL2.name.equals(name)) {
            return LEVEL2;
        }
        if (LEVEL3.name.equals(name)) {
            return LEVEL3;
        }
        if (LEVEL4.name.equals(name)) {
            return LEVEL4;
        }
        if (LEVEL5.name.equals(name)) {
            return LEVEL5;
        }
        throw new IllegalArgumentException("[ERROR] 해당 레벨은 존재하지 않습니다.");
    }

    public static boolean searchMission(String mission, Level level) {
        if(level.missions.contains(mission)) {
            return true;
        }
        throw new IllegalArgumentException("[ERROR] 해당 미션은 존재하지 않습니다.");
    }
}
