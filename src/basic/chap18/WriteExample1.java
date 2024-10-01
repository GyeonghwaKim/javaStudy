package basic.chap18;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample1 {

    public static void main(String[] args) {
        try {
            //내부에 버퍼를 가짐
            OutputStream os = new FileOutputStream("C:\\Temp\\Test1.db");

            byte a=10;
            byte b=20;
            byte c=30;
            //버퍼에 바이트 저장 후 차면 순서대로 바이트 출력
            os.write(a);
            os.write(b);
            os.write(c);

            //내부 버퍼에 잔류하는 모든 바이트를 출력
            os.flush();
            os.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
