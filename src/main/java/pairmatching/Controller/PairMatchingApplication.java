package pairmatching.Controller;

import pairmatching.Model.Course;
import pairmatching.Model.Crew;
import pairmatching.Model.Crews;
import pairmatching.View.InputView;
import pairmatching.View.OutputView;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PairMatchingApplication {
    private Crews backendCrews;
    private Crews frontendCrews;
    private boolean running = true;

    public void run() {
        saveCrew();
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
        }
        if (option.equals("2")) {
            pairSearching();
        }
        if (option.equals("3")) {
            pairReset();
        }
        if (option.equals("Q")) {
            running = false;
        }
        throw new IllegalArgumentException();
    }

    private void pairMatching() {
    }

    private void pairSearching() {
    }

    private void pairReset() {
    }
}
