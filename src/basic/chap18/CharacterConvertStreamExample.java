package basic.chap18;

import java.io.*;

public class CharacterConvertStreamExample {
    public static void main(String[] args) throws Exception{

        write("문자 변환 스트림을 사용합니다");
        String read = read();
        System.out.println(read);
    }

    public static void write(String str) throws Exception{

        //존재하는 파일일땐? 덮어쓰는 것 같다
        //이 과정 없이 바로 filewriter 사용 가능
        OutputStream os = new FileOutputStream("C:\\Temp\\test.txt");
        Writer writer = new OutputStreamWriter(os,"UTF-8");

        writer.write(str);
        writer.flush();
        writer.close();
    }


    public static String read() throws Exception{
        InputStream is=
        new FileInputStream("C:\\Temp\\test.txt");
        Reader reader=new InputStreamReader(is,"UTF-8");

        char[] data=new char[100];
        int num =reader.read(data);

        reader.close();
        String str=new String(data,0,num);
        return str;
    }

}
