package basic.chap16;

public class MethodReferenceExample2 {
    public static void main(String[] args) {
        Person5 person= new Person5();

        person.ordering(String::compareToIgnoreCase);
    }
}
