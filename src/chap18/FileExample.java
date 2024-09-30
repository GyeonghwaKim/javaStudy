package chap18;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExample {
    public static void main(String[] args) throws Exception {
        File dir=new File("C:\\Temp\\images");
        File file1=new File("C:\\Temp\\file1.txt");

        if(!dir.exists()) dir.mkdir();
        if(file1.exists()) dir.createNewFile();

        File temp=new File("C:\\Temp");
        File[] contents=temp.listFiles();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
        for (File file : contents) {
            System.out.printf("%-25s",simpleDateFormat.format(new Date(file.lastModified())));
            if(file.isDirectory()){
                System.out.printf("%-10s%-20s","<Dir>",file.getName());
            }else {
                System.out.printf("%-10s%-20s",file.length(),file.getName());
            }
            System.out.println();

        }

    }
}
