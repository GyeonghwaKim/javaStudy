package basic.chap18;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample2 {
    public static void main(String[] args) {
        try{
            //FileNotFoundE
            InputStream is = new FileInputStream("C:\\Temp\\Test2.db");

            //많은 양의 바이트를 읽을 때
            byte[] data = new byte[100];

            while (true){
                //num ==3
                int num = is.read(data);

                if(num ==-1) break;
                for (int i = 0; i < num; i++) {
                    System.out.println(data[i]);

                }
            }
            is.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
