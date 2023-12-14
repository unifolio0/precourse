package menu.Control;

import menu.Model.Names;
import menu.Model.notEatMenus;
import menu.View.InputView;
import menu.View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MenuRecommend {
    public void run() {
        OutputView.printOpenTitle();
        createCoaches();
    }

    private void createCoaches() {
        Names names = findCoachesName();
        List<notEatMenus> inputs = findNotEatMenus(names);
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
        System.out.println(inputs);
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
