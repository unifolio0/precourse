package christmas.Model;

public enum EventBadge {
    NOTHING("없음", 0),
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000);

    private String badgeName;
    private int minimumPrice;

    EventBadge(String badgeName, int minimumPrice) {
        this.badgeName = badgeName;
        this.minimumPrice = minimumPrice;
    }

    public static EventBadge valueOf(int totalBenifitPrice) {
        totalBenifitPrice *= -1;
        if (totalBenifitPrice >= SANTA.minimumPrice) {
            return SANTA;
        }
        if (totalBenifitPrice >= TREE.minimumPrice) {
            return TREE;
        }
        if (totalBenifitPrice >= STAR.minimumPrice) {
            return STAR;
        }
        if (totalBenifitPrice >= NOTHING.minimumPrice) {
            return NOTHING;
        }
        throw new IllegalArgumentException();
    }

    public String getBadgeName() {
        return this.badgeName;
    }
}
