package pairmatching.Controller;

import pairmatching.Model.*;
import pairmatching.Parser;
import pairmatching.View.InputView;
import pairmatching.View.OutputView;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PairMatchingApplication {
    private Crews backendCrews;
    private Crews frontendCrews;
    private Pairs pairs;
    private boolean running = true;
    private int count = 0;

    public void run() {
        saveCrew();
        this.pairs = new Pairs();
        while (running) {
            try {
                String option = InputView.requireOption();
                playOption(option);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void saveCrew() {
        backendCrews = makeCrews(Course.BACKEND);
        frontendCrews = makeCrews(Course.FRONTEND);
    }

    private Crews makeCrews(Course course) {
        try {
            File file = new File("src/main/resources/backend-crew.md");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            List<Crew> crew = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                crew.add(new Crew(course, line));
            }
            Crews crews = new Crews(crew);
            bufferedReader.close();
            return crews;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void playOption(String option) {
        if (option.equals("1")) {
            pairMatching();
            return;
        }
        if (option.equals("2")) {
            pairSearching();
            return;
        }
        if (option.equals("3")) {
            pairReset();
            return;
        }
        if (option.equals("Q")) {
            running = false;
            return;
        }
        throw new IllegalArgumentException("[ERROR] 정확한 옵션을 입력해 주세요.");
    }

    private void pairMatching() {
        while (true) {
            try {
                String input = InputView.requireCourseLevelMission();
                PairInformation pairInformation = new PairInformation(input);
                updatePairs(pairInformation);
                return;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private Pair makePair(PairInformation pairInformation) {
        Pair pair = null;
        if (count == 3) {
            count = 0;
            throw new IllegalArgumentException("[ERROR] 페어를 만들 수가 없습니다.");
        }
        if (pairInformation.getCourse().equals(Course.BACKEND)) {
            pair = new Pair(pairInformation, backendCrews);
        }
        if (pairInformation.getCourse().equals(Course.FRONTEND)) {
            pair = new Pair(pairInformation, frontendCrews);
        }
        if (pairs.checkPairs(pair)) {
            count++;
            makePair(pairInformation);
        }
        return pair;
    }

    private void updatePairs(PairInformation pairInformation) {
        if (pairs.isContain(pairInformation)) {
            if (!retryPair()) {
                pairMatching();
            }
        }
        Pair pair = makePair(pairInformation);
        OutputView.printPair(Parser.parserCrew(pair.getPair()));
        this.pairs.updatePairs(pair);
    }

    private boolean retryPair() {
        String chice = InputView.requireRetry();
        if (chice.equals("네")) {
            return true;
        }
        if (chice.equals("아니오")) {
            return false;
        }
        throw new IllegalArgumentException("[ERROR] 해당 옵션은 존재하지 않습니다.");
    }

    private void pairSearching() {

    }

    private void pairReset() {
        pairs.reset();
        OutputView.printReset();
    }
}
