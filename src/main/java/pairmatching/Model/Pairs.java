package pairmatching.Model;

import java.util.*;

public class Pairs {
    private Map<Level, List<Pair>> pairs;

    public Pairs() {
        this.pairs = new HashMap<>();
    }

    public void updatePairs(Pair pair) {
        Level level = pair.getPairInformation().getLevel();
        if (this.pairs.containsKey(level)) {
            this.pairs.get(level).add(pair);
            return;
        }
        this.pairs.put(level, new ArrayList<>());
        this.pairs.get(level).add(pair);
    }

    public boolean isContain(PairInformation pairInformation) {
        Collection<List<Pair>> values = this.pairs.values();
        for (List<Pair> pair : values) {
            for (Pair oldPair : pair) {
                if (oldPair.equals(pairInformation)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkPairs(Pair pair) {
        if (!pairs.containsKey(pair.getPairInformation().getLevel())) {
            return false;
        }
        Level level = pair.getPairInformation().getLevel();
        for (Pair oldPair : pairs.get(level)) {
            if (oldPair.checkPairs(pair)) {
                return true;
            }
        }
        return false;
    }

    public void reset() {
        pairs.clear();
    }
}
