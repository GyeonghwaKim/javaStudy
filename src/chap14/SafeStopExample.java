package chap14;

public class SafeStopExample {
    public static void main(String[] args) {
        PrintThread printThread = new PrintThread();
        printThread.start();

        try{
            Thread.sleep(3000);
        }catch (Exception e){}

        printThread.setStop(true);

    }

}
