package chap14;

import java.awt.*;

public class BeepPrintExample3 {
    public static void main(String[] args) {

        //스레드 자식객체 구현
        Thread thread=new Thread(){
            @Override
            public void run() {
                Toolkit toolkit=Toolkit.getDefaultToolkit();
                for (int i = 0; i < 5; i++) {
                    toolkit.beep();
                    trySleep500();
                }
            }
        };
        //작업스레드 시작
        thread.start();

        //메인스레드 시작
        for (int i = 0; i < 5; i++) {
            System.out.println("띵");
            trySleep500();

        }
    }

    private static void trySleep500() {
        try {
            Thread.sleep(500);
        }catch (Exception e){}
    }
}
