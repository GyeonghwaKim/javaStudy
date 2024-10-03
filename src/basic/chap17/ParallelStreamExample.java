package basic.chap17;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ParallelStreamExample {

    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("홍길동");
        list.add("신용권");
        list.add("김자바");
        list.add("이진상");
        list.add("홍지혜");
        list.add("맹지민");
        list.add("박해빈");

        //병렬처리
        Stream<String> parallelStream =list.parallelStream();
        parallelStream.forEach(name ->{
            System.out.println(name+": "+Thread.currentThread().getName());
        });
    }
}
