package basic.chap16;

public class LambdaExample4 {
    public static void main(String[] args) {
        Person3 person = new Person3();

        person.action((x,y)->{
            double result=x-y;
            return result;
        });

        person.action((x, y) -> x+y);

        person.action((x, y) -> sum(x,y));
    }

    public static double sum(double x,double y){
        return (x+y);
    }
}
