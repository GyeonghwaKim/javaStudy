package basic.chap16;

public class Person6 {
    public Member getMember1(Creatable1 c)
    {
        String id="winter";
        Member member=c.create(id);
        return member;
    }

    public Member getMember2(Creatable2 c)
    {
        String id="winter";
        String name="한겨울";
        Member member=c.create(id,name);
        return member;
    }


}
