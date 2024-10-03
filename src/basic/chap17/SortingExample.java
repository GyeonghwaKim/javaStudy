package basic.chap17;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortingExample {

    public static void main(String[] args) {
        List<StudentC> studentList=new ArrayList<>();
        studentList.add(new StudentC("홍길동",30));
        studentList.add(new StudentC("신용권",10));
        studentList.add(new StudentC("유미선",20));

        studentList.stream()
                .sorted()
                .forEach(s-> System.out.println(s.getName()+" "+s.getScore()));
        System.out.println();

        studentList.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(s-> System.out.println(s.getName()+ ": "+s.getScore()));

    }
}
