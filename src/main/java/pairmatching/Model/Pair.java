package pairmatching.Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Pair {
    private PairInformation pairInformation;
    private Crews crews;
    private List<List<Crew>> pair;

    public Pair(PairInformation pairInformation, Crews crews) {
        this.pairInformation = pairInformation;
        this.crews = crews;
        pair = new ArrayList<>();
        makePair();
    }

    private void makePair() {
        List<Crew> shuffleCrew = crews.getCrews();
        List<Crew> shuffledCrew = Randoms.shuffle(shuffleCrew);
        for (int i = 0; i < shuffledCrew.size() / 2; i++) {
            pair.add(new ArrayList<>());
        }
        for (int i = 0; i < pair.size(); i++) {
            pair.get(i).add(shuffledCrew.get(i * 2));
            pair.get(i).add(shuffledCrew.get(i * 2 + 1));
            if (pair.size() % 2 == 1 && i == pair.size() - 1) {
                pair.get(i).add(shuffledCrew.get(i * 2 + 2));
            }
        }
    }

    public PairInformation getPairInformation() {
        return this.pairInformation;
    }

    public List<List<Crew>> getPair() {
        return pair;
    }

    @Override
    public int hashCode() {
        return this.pairInformation.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PairInformation) {
            PairInformation pairInfo = (PairInformation) obj;
            return this.pairInformation.equals(pairInfo);
        }
        return false;
    }

    public boolean checkPairs(Pair checkPair) {
        for (List<Crew> checkCrew : checkPair.getPair()) {
            if (checkPair(checkCrew)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkPair(List<Crew> checkCrew) {
        for (int i = 0; i < this.pair.size(); i++) {
            if (this.pair.get(i).get(0).equals(checkCrew.get(0)) && this.pair.get(i).get(1).equals(checkCrew.get(1))) {
                return true;
            }
            if (this.pair.get(i).get(1).equals(checkCrew.get(0)) && this.pair.get(i).get(0).equals(checkCrew.get(1))) {
                return true;
            }
        }
        return false;
    }
}
