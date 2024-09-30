package chap18;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample2 {

    public static void main(String[] args) {
        try {
            //내부에 버퍼를 가짐
            OutputStream os = new FileOutputStream("C:\\Temp\\Test2.db");


            byte[] arr={10,20,30};

            os.write(arr);

            //내부 버퍼에 잔류하는 모든 바이트를 출력
            os.flush();
            os.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
