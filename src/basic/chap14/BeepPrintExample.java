package basic.chap14;

import java.awt.*;

public class BeepPrintExample {
    public static void main(String[] args) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for (int i = 0; i < 5; i++) {
            toolkit.beep();
            trySleep500();
        }

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
