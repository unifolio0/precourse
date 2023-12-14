package menu.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Coaches {
    private List<Coach> coaches;
    private List<Menu> recommendChategory;

    public Coaches(Names names, List<notEatMenus> inputs) {
        coaches = new ArrayList<>();
        for (int i = 0; i < names.getNames().size(); i++) {
            coaches.add(new Coach(names.getNames().get(i), inputs.get(i).getNotEatMenu()));
        }
        this.recommendChategory = new ArrayList<>();
    }

    public void updateRecommendMenuChategory() {
        for (int i = 0; i < 5; i++) {
            Menu menu = Menu.valueOf(Randoms.pickNumberInRange(1, 5));
            i = checkMenuChategory(menu, i);
        }
    }

    private int checkMenuChategory(Menu menu, int idx) {
        if (Collections.frequency(recommendChategory, menu) >= 2) {
            idx--;
            return idx;
        }
        recommendChategory.add(menu);
        for (Coach coach : coaches) {
            coach.updateRecommendMenu(menu);
        }
        return idx;
    }

    public String findChategoryAnswer() {
        String answer = "";
        answer += "[ 카테고리";
        for (Menu menu : recommendChategory) {
            answer += " | " + menu.getName();
        }
        answer += " ]";
        return answer;
    }

    public List<String> findDetailAnswers() {
        List<String> detailMents = new ArrayList<>();
        for(Coach coach : coaches) {
            detailMents.add(coach.findDetailAnswer());
        }
        return detailMents;
    }
}
