package menu.Control;

import menu.Model.Names;
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
        String coachNames = InputView.requireCoachesName();
        Names names = new Names(coachNames);
        List<String> inputs = new ArrayList<>();
        for (String name : names.getNames()) {
            InputView.requireNotEatMenu(name);
        }
    }
}
