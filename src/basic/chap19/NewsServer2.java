package basic.chap19;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewsServer2 {
    private static DatagramSocket datagramSocket=null;
    private static ExecutorService executorService= Executors.newFixedThreadPool(10);

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

                        executorService.execute(()->{

                            try {
                                String newsKind = new String(receivePacket.getData(), 0, receivePacket.getLength(), "UTF-8");

                                SocketAddress socketAddress = receivePacket.getSocketAddress();

                                for (int i = 1; i <= 10; i++) {
                                    String data = newsKind + ": 뉴스" + i;
                                    byte[] bytes = data.getBytes("UTF-8");
                                    DatagramPacket sendPacket = new DatagramPacket(bytes, 0, bytes.length, socketAddress);
                                    datagramSocket.send(sendPacket);
                            }
                            }catch(Exception e){

                                }

                        });

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
        executorService.shutdownNow();
        System.out.println("서버 종료");
    }
}
