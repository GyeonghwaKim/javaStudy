package basic.chap17;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample3 {
    public static void main(String[] args) {
        String[] sttArray={"홍길동","신용권","김미나"};
        //배열로부터 스트림 얻기
        Stream<String> strStream= Arrays.stream(sttArray);
        strStream.forEach(item -> System.out.print(item+", "));
        System.out.println(
        );

        int[] intArray={1,2,3,4};
        IntStream integerStream=Arrays.stream(intArray);
        integerStream.forEach(item -> System.out.print(item+", "));

    }
}
