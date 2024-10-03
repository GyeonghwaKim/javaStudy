package basic.chap17;

import java.util.ArrayList;
import java.util.List;

public class SortExample2 {
    public static void main(String[] args) {
        List<Student> studentList=new ArrayList<>();
        studentList.add(new Student("홍길동",30));
        studentList.add(new Student("신용권",10));
        studentList.add(new Student("유미선",20));

        studentList.stream()
                .sorted( (o1,o2)->Integer.compare(o1.getScore(),o2.getScore()))
                .forEach(student -> System.out.println(student.getName()+" "+student.getScore()));

        System.out.println();
        studentList.stream()
                .sorted( (o1,o2)->Integer.compare(o2.getScore(),o1.getScore()))
                .forEach(student -> System.out.println(student.getName()+" "+student.getScore()));

    }
}
