package basic.chap17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlatMappingExample {
    public static void main(String[] args) {

        //요소를 복수 개의 요소로 변환
        List<String> list=new ArrayList<>();
        list.add("this is a java");
        list.add("i am a best developer");
        list.stream()
                .flatMap(data -> Arrays.stream(data.split(" ")))
                .forEach(word -> System.out.println(word));

        System.out.println(
        );

        List<String> list2=Arrays.asList("10,20,30","40","50");
        list2.stream()
                .flatMapToInt(data->{
                    String[] split = data.split(",");
                    int[] intArr = new int[split.length];
                    for (int i = 0; i < split.length; i++) {
                        intArr[i]=Integer.parseInt(split[i].trim());
                    }
                    return Arrays.stream(intArr);
                        }
                )
                .forEach(num -> System.out.println(num));
    }
}
