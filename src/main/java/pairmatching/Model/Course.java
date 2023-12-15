package pairmatching.Model;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static Course getCourse(String name) {
        if (BACKEND.name.equals(name)) {
            return BACKEND;
        }
        if (FRONTEND.name.equals(name)) {
            return FRONTEND;
        }
        throw new IllegalArgumentException("[ERROR] 해당 코스는 존재하지 않습니다.");
    }
}
