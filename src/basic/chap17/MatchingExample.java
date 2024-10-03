package basic.chap17;

import java.util.Arrays;

public class MatchingExample {
    public static void main(String[] args) {
        int[] intArr={2,4,6};

        boolean allMatch = Arrays.stream(intArr)
                .allMatch(a -> a % 2 == 0);
        System.out.println("2의 배수인가? "+allMatch);

        allMatch=Arrays.stream(intArr)
                .anyMatch(a-> a%3==0);
        System.out.println("3의 배수가 하나라도 있는가? "+allMatch);

        allMatch=Arrays.stream(intArr)
                .noneMatch(a -> a%3 ==0);
        System.out.println("3의 배수가 하나도 없는가? "+allMatch);

    }
}
