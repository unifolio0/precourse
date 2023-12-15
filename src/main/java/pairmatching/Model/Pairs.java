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
            if (isContainPair(pair, pairInformation) != null) {
                return true;
            }
        }
        return false;
    }

    private Pair isContainPair(List<Pair> pair, PairInformation pairInformation) {
        for (Pair oldPair : pair) {
            if (oldPair.equals(pairInformation)) {
                return oldPair;
            }
        }
        return null;
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

    public Pair searchPair(PairInformation pairInformation) {
        Collection<List<Pair>> values = this.pairs.values();
        for (List<Pair> pair : values) {
            Pair oldPair = isContainPair(pair, pairInformation);
            if (oldPair != null) {
                return oldPair;
            }
        }
        throw new IllegalArgumentException("[ERROR] 매칭 이력이 없습니다.");
    }
}
