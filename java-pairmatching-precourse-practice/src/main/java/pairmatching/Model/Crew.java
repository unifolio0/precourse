package pairmatching.Model;

public class Crew {
    private Course course;
    private String name;

    public Crew(Course course, String name) {
        this.course = course;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Crew) {
            Crew crew = (Crew) obj;
            return this.name.equals(crew.getName());
        }
        return false;
    }
}
