package chap18;

import java.io.FileReader;
import java.io.Reader;

public class ReadExample4 {
    public static void main(String[] args) {
        try {
            Reader reader=null;

            reader=new FileReader("C:\\Temp\\test.txt");

            while (true){
                int data=reader.read();
                if(data==-1)break;
                System.out.println("int: "+data);
                System.out.println("char: "+(char)data);
            }
            reader.close();
            System.out.println();

            reader=new FileReader("C:\\Temp\\test.txt");
            char[] data = new char[100];
            while (true){
                int num = reader.read(data);
                if(num==-1) break;
                for (int i = 0; i < num; i++) {
                    System.out.println(data[i]);
                }
            }
            reader.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
