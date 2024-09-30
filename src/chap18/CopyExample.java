package chap18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyExample {

    public static void main(String[] args) {
        String ori = "C:\\Temp\\cat.jpg";
        String target = "C:\\Temp\\copyCat2.jpg";

        try {

        //파일 읽을 스트림
        InputStream is = new FileInputStream(ori);
        //파일 출력 스트림
        OutputStream os = new FileOutputStream(target);

//        byte[] data = new byte[1024];
//        while (true){
//            int num = is.read(data);
//            if(num==-1) break;
//            os.write(data,0,num);
//        }

            is.transferTo(os);
        os.flush();
        os.close();
        is.close();
        System.out.println("복사가 잘 되었습니다");
        }catch (Exception e){}

    }
}
