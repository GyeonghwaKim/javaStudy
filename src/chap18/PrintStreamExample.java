package chap18;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamExample {
    public static void main(String[] args) throws Exception{

        FileOutputStream fos=new FileOutputStream("C:\\Temp\\printstream.txt");
        PrintStream ps=new PrintStream(fos);

        ps.print("마치 ");
        ps.println("프린터가 출력한 것 처럼");
        ps.println("출력합니다");
        ps.printf("| %6d | %-10s | %10s | \n",1,"홍길동","도적");
        ps.printf("| %6d | %-10s | %10s | \n",2,"김상수","닌자");

        ps.flush();
        ps.close();

    }
}
