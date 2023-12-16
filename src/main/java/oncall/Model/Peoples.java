package oncall.Model;

import oncall.Parser;
import oncall.Validator.Validator;

import java.util.List;

public class Peoples {
    private List<String> peoples;

    public Peoples(String input) {
        Validator.validateLastComma(input);
        List<String> peoples = Parser.parserSplitComma(input);
        Validator.validatePeoplesName(peoples);
        Validator.validatePeoplesSize(peoples);
        Validator.validateDuplicatePeople(peoples);
        this.peoples = peoples;
    }

    public void checkPeoples(Peoples input) {
        Validator.validateEqualPeoples(this.peoples, input.peoples);
    }

    public String todayPeople(int idx) {
        if (idx < 0) {
            idx += this.peoples.size();
        }
        return this.peoples.get(idx % this.peoples.size());
    }
}
