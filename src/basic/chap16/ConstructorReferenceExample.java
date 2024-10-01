package basic.chap16;

public class ConstructorReferenceExample {
    public static void main(String[] args) {
        Person6 person6 = new Person6();

        Member member1 = person6.getMember1(Member::new);
        System.out.println(member1);
        System.out.println();

        Member member2 = person6.getMember2((id, name) -> new Member(id, name));
        System.out.println(member2);


    }
}
