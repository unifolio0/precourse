package menu.Model;

import menu.Parser;
import menu.Validator;

import java.util.List;

public class notEatMenus {
    private List<String> notEatMenu;

    public notEatMenus(String input) {
        List<String> checkMenus = Parser.parserSplitComma(input);
        Validator.validateMenuNames(checkMenus);
        Validator.validateMenuNamesSize(checkMenus);
        this.notEatMenu = checkMenus;
    }

    public List<String> getNotEatMenu() {
        return this.notEatMenu;
    }
}
