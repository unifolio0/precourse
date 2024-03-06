package menu.Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private String name;
    private List<String> notEatMenu;
    private List<String> recommendMenu;

    public Coach(String name, List<String> notEatMenu) {
        this.name = name;
        this.notEatMenu = notEatMenu;
        this.recommendMenu = new ArrayList<>();
    }

    public void updateRecommendMenu(Menu menu) {
        while (true) {
            String detailMenu = Randoms.shuffle(menu.getDetaliMenu()).get(0);
            if (!recommendMenu.contains(detailMenu) && !notEatMenu.contains(detailMenu)) {
                recommendMenu.add(detailMenu);
                return;
            }
        }
    }

    public String findDetailAnswer() {
        String detailAnswer = "";
        detailAnswer += "[ " + this.name;
        for (String menu : recommendMenu) {
            detailAnswer += " | " + menu;
        }
        detailAnswer += " ]";
        return detailAnswer;
    }
}
