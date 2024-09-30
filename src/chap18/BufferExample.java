package chap18;

import java.io.*;

public class BufferExample {
    public static void main(String[] args) throws Exception {
        String oriPath1=BufferExample.class.getResource("oriFile1.jpg").getPath();
        String targetPath1="C:\\Temp\\targetFile1.jpg";
        FileInputStream fis1=new FileInputStream(oriPath1);
        FileOutputStream fos1=new FileOutputStream(targetPath1);


        String oriPath2=BufferExample.class.getResource("oriFile2.jpg").getPath();
        String targetPath2="C:\\Temp\\targetFile2.jpg";
        FileInputStream fis2=new FileInputStream(oriPath2);
        FileOutputStream fos2=new FileOutputStream(targetPath2);
        BufferedInputStream bis=new BufferedInputStream(fis2);
        BufferedOutputStream bos=new BufferedOutputStream(fos2);

        long nonBufferTime=copy(fis1,fos1);
        System.out.println("버퍼 미사용: "+nonBufferTime);

        long bufferTime =copy(bis,bos);
        System.out.println("버퍼 사용: "+bufferTime);

        fis1.close();
        fos1.close();
        bis.close();
        bos.close();
    }

    public static long copy(InputStream is,OutputStream os) throws Exception{

        long start=System.nanoTime();

        is.transferTo(os);

        long end=System.nanoTime();
        return (end-start);

    }
}
