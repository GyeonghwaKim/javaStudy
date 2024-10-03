package basic.chap17;

public class Student{
    private String name;
    private  int score;
    private String sex;

    public Student(String name, int score,String sex) {
        this.name = name;
        this.score = score;
        this.sex=sex;
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public String getSex() {
        return sex;
    }
}
