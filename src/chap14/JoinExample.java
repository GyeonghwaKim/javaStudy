package chap14;

public class JoinExample {
    public static void main(String[] args) {
        SumThread sumThread = new SumThread();
        sumThread.start();

        try {
            //main스레드가 결과 값을 받도록 ...
            sumThread.join();
        }catch (InterruptedException e){

        }
        System.out.println("합:"+ sumThread.getSum());
    }
}
