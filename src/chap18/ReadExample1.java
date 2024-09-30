package chap18;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample1 {
    public static void main(String[] args) {
        try{
            //FileNotFoundE
            InputStream is = new FileInputStream("C:\\Temp\\Test1.db");

            while (true){
                //byte(1)를 읽지만 int(4)를 반환
                int data = is.read();
                if(data ==-1) break;
                System.out.println(data);
            }
            is.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
