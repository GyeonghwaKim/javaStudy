package basic.chap17;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample2 {
    public static void main(String[] args) {
        List<Product> list=new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Product produc = new Product(i, "상품" + i, "멋진회사", (int) (10000 * Math.random()));
            list.add(produc );
        }
        //리스트로부터 스트림 얻기
        Stream<Product> stream=list.stream();
        stream.forEach( p -> System.out.println(p));
    }
}
