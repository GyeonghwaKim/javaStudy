package basic.chap16;

public class Person5 {
    public void ordering(Comparable comparable){
        String a="홍길동";
        String b="김길동";

        int result=comparable.compare(a,b);

        if(result<0){
            System.out.println("홍길동은 김길동보다 앞에 온다");
        }else{
            System.out.println("홍길동은 김길동 보다 뒤에 온다");
        }
    }
}
