package chap14;

import java.awt.*;

public class BeepPrintExample2 {
    public static void main(String[] args) {

        //Runnable 구현
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                //작업스래드 생성
                Toolkit toolkit=Toolkit.getDefaultToolkit();
                for (int i = 0; i < 5; i++) {
                    toolkit.beep();
                    trySleep500();
                }
            }
        });
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
