package menu.Model;

import java.util.List;

public class Coach {
    private String name;
    private List<String> notEatMenu;

    public Coach(String name, List<String> notEatMenu) {
        this.name = name;
        this.notEatMenu = notEatMenu;
    }
}
