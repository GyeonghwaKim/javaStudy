package basic.chap16;

public class MethodReferenceExample {
    public static void main(String[] args) {
        Person4 person = new Person4();

        person.action((x, y) -> Computer.staticMethod(x,y));

        Computer com = new Computer();
        person.action((x, y) -> com.instanceMethod(x,y));
    }
}
