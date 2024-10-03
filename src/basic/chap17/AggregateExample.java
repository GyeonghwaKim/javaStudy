package basic.chap17;

import java.util.Arrays;

public class AggregateExample {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};

        long count= Arrays.stream(arr)
                .filter(n->n%2==0)
                .count();
        System.out.println("2의 배수 개수: "+count);

        long sum = Arrays.stream(arr)
                .filter(n -> n % 2 == 0)
                .sum();
        System.out.println("합개수: "+sum);

        double asDouble = Arrays.stream(arr)
                .filter(n -> n % 2 == 0)
                .average()
                .getAsDouble();
        System.out.println("평균: "+asDouble);

        int max = Arrays.stream(arr)
                .filter(n -> n % 2 == 0)
                .max()
                .getAsInt();
        System.out.println("최대: "+max);

        int min = Arrays.stream(arr)
                .filter(n -> n % 2 == 0)
                .min()
                .getAsInt();
        System.out.println("최소: "+min);

        int first = Arrays.stream(arr)
                .filter(n -> n % 2 == 0)
                .findFirst()
                .getAsInt();
        System.out.println("처음꺼: "+first);

    }
}
