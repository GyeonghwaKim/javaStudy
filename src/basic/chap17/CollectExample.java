package basic.chap17;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectExample {
    public static void main(String[] args) {
        List<Student> totalList=new ArrayList<>();
        totalList.add(new Student("홍길동",92,"남"));
        totalList.add(new Student("김수영",82,"여"));
        totalList.add(new Student("김자바",67,"남"));
        totalList.add(new Student("오해영",99,"여"));

        List<Student> maleList = totalList.stream().filter(student -> student.getSex().equals("남")).toList();

        maleList.forEach(s -> System.out.println(s.getName()));
        System.out.println();

        Map<String,Integer> map=totalList.stream()
                .collect(
                Collectors.toMap(
                        s-> s.getName(),
                        s -> s.getScore()
                )
        );

        System.out.println(map);

        Map<String,List<Student>> map2=totalList.stream().collect(
                Collectors.groupingBy(s -> s.getSex())
        );

        List<Student> studentList = map2.get("남");
        studentList.forEach(s -> System.out.println(s.getName()));
        System.out.println();

        List<Student> studentList2 = map2.get("여");
        studentList2.forEach(s -> System.out.println(s.getName()));
        System.out.println();


        Map<String, Double> collect = totalList.stream().collect(
                Collectors.groupingBy(
                        s -> s.getSex(),
                        Collectors.averagingDouble(s -> s.getScore())
                )
        );
        Map<String, Double> collect2 = totalList.stream().collect(
                Collectors.groupingBy(
                        s -> s.getSex(),
                        Collectors.averagingDouble(s -> s.getScore())
                )
        );
        System.out.println(collect);

        System.out.println(collect2);
    }


}
