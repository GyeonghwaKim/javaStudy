package basic.chap14;

public class PrintThread3 extends Thread{

    @Override
    public void run() {
            while (true) {
                System.out.println("실행 중");
                if(Thread.interrupted()) break;
        }

        System.out.println("리소스 정리");
        System.out.println("실행 종료");
    }


}
