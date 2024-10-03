package basic.chap17;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPipeLineExample {

    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("홍길동", 10),
                new Student("신용권", 20),
                new Student("김자바", 40)
        );

        //1
        Stream<Student> studentStream=list.stream();
        IntStream scoreStream=studentStream.mapToInt(Student::getScore);
        double asDouble = scoreStream.average().getAsDouble();

        System.out.println("1: "+asDouble);

        //2
        double asDouble1 = list
                .stream()
                .mapToInt(Student::getScore)
                .average()
                .getAsDouble();

        System.out.println("2: "+asDouble1);

    }
}
