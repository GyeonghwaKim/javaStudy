package chap14;

public class PrintThread2 extends Thread{

    @Override
    public void run() {
        try{
            while (true) {
                System.out.println("실행 중");

                //interrupted를 위해
                Thread.sleep(1);
            }
        }catch (InterruptedException e){}

        System.out.println("리소스 정리");
        System.out.println("실행 종료");
    }


}
