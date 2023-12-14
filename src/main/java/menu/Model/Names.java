package menu.Model;

import menu.Parser;
import menu.Validator;

import java.util.List;

public class Names {
    private List<String> names;

    public Names(String input) {
        List<String> checkNames = Parser.parserSplitComma(input);
        Validator.validateCoachesSize(checkNames);
        Validator.validateCoachesName(checkNames);
        this.names = checkNames;
    }

    public List<String> getNames() {
        return this.names;
    }
}
