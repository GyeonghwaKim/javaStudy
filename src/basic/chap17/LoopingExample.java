package basic.chap17;

import java.util.Arrays;

public class LoopingExample {
    public static void main(String[] args) {
        int[] intArr={1,2,3,4,5};

        /*최종 처리가 없으므로 동작하지 않음
        Arrays.stream(intArr)
                .filter(a-> a%2 ==0)
                .peek(n -> System.out.println(n    ));
        */

        int total=Arrays.stream(intArr)
                .filter(a-> a%2==0)
                .peek(n -> System.out.println(n ))
                .sum();

        System.out.println("총합: "+ total);

        Arrays.stream(intArr)
                .filter(a -> a%2==0)
                .forEach(System.out::println);
    }
}
