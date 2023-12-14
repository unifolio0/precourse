package menu.Control;

import menu.Model.Coaches;
import menu.Model.Names;
import menu.Model.notEatMenus;
import menu.View.InputView;
import menu.View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MenuRecommend {
    public void run() {
        OutputView.printOpenTitle();
        Coaches coaches = createCoaches();
        coaches.updateRecommendMenuChategory();
        String chategoryAnswer = coaches.findChategoryAnswer();
        List<String> detailAnswers = coaches.findDetailAnswers();
        OutputView.printMenuRecommed(chategoryAnswer, detailAnswers);
    }

    private Coaches createCoaches() {
        Names names = findCoachesName();
        List<notEatMenus> inputs = findNotEatMenus(names);
        Coaches coaches = new Coaches(names, inputs);
        return coaches;
    }

    private Names findCoachesName() {
        while (true) {
            try {
                String coachNames = InputView.requireCoachesName();
                Names names = new Names(coachNames);
                return names;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private List<notEatMenus> findNotEatMenus(Names names) {
        List<notEatMenus> inputs = new ArrayList<>();
        for (String name : names.getNames()) {
            updateInputs(inputs, name);
        }
        return inputs;
    }

    private void updateInputs(List<notEatMenus> inputs, String name) {
        while (true) {
            try {
                String input = InputView.requireNotEatMenu(name);
                inputs.add(new notEatMenus(input));
                return;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
