package oncall.Model;

import oncall.Parser;
import oncall.Validator.Validator;

import java.util.List;

public class Peoples {
    private List<String> peoples;

    public Peoples(String input) {
        List<String> peoples = Parser.parserSplitComma(input);
        Validator.validatePeoplesName(peoples);
        Validator.validatePeoplesSize(peoples);
        Validator.validateDuplicatePeople(peoples);
        this.peoples = peoples;
    }

    public void checkPeoples(Peoples input) {
        Validator.validateEqualPeoples(this.peoples, input.peoples);
    }
}
