package basic.chap19;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExample {
    public static void main(String[] args) {
        try{
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("내 컴퓨터 주소: "+localHost.getHostAddress());

            InetAddress[] iaArr = InetAddress.getAllByName("www.naver.com");
            for (InetAddress ia : iaArr) {
                System.out.println("www.naver.com IP 주소: "+ ia.getHostAddress());
            }

        }catch (UnknownHostException e){
            e.printStackTrace();
        }
    }
}
