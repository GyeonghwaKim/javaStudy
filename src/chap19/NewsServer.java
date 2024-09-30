package chap19;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.util.Scanner;

public class NewsServer {
    private static DatagramSocket datagramSocket=null;

    public static void main(String[] args) {
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        System.out.println("서버를 종료하려면 q");
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

        startServer();
        Scanner sc = new Scanner(System.in);
        while (true){
            String key = sc.nextLine();
            if(key.toLowerCase().equals("q")){
                break;
            }
        }

        stopServer();

    }

    public static void startServer(){

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    datagramSocket = new DatagramSocket(50001);
                    System.out.println("서버 시작됨");

                    while (true) {

                        //데이터 받기
                        DatagramPacket receivePacket = new DatagramPacket(new byte[1024], 1024);
                        datagramSocket.receive(receivePacket);
                        String s = new String(receivePacket.getData(), 0, receivePacket.getLength(), "UTF-8");

                        //클라이언트의 정보
                        SocketAddress socketAddress = receivePacket.getSocketAddress();
                        for (int i = 0; i <= 10; i++) {
                            //데이터 보내기
                            String data = s + ": 뉴스" + i;
                            byte[] bytes = data.getBytes("UTF-8");
                            DatagramPacket sendPacket = new DatagramPacket(bytes, 0, bytes.length, socketAddress);
                            datagramSocket.send(sendPacket);

                        }

                    }
                } catch (Exception e) {
                    System.out.println("서버 " + e.getMessage());
                }
            }
        };
        thread.start();

    }
    public static void stopServer(){
        datagramSocket.close();
        System.out.println("서버 종료");
    }
}
