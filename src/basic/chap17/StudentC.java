package basic.chap17;

public class StudentC implements Comparable<StudentC> {
    private String name;
    private  int score;

    public StudentC(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(StudentC o) {
        return Integer.compare(this.score,o.getScore());
    }
}
