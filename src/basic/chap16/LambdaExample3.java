package basic.chap16;

public class LambdaExample3 {
    public static void main(String[] args) {
        Person2 person = new Person2();

        person.action1((name,job)->{
            System.out.print(name+"이 ");
            System.out.println(job+"을 합니다");
        });

        person.action2((message)->{
            System.out.println(message+"라고 말합니다");
        });
    }
}
