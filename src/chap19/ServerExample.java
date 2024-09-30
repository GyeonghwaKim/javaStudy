package chap19;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerExample {

    private static ServerSocket serverSocket = null;

    public static void main(String[] args) {

        System.out.println("서버를 종료하려면 q 또는 Q 입력하세요");
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

        startServer();

        Scanner scanner = new Scanner(System.in);
        while (true){
            String key = scanner.nextLine();
            if(key.toLowerCase().equals("q")) break;
        }
        scanner.close();
        stopServer();
    }

    public static void startServer() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    //서버 소켓
                    serverSocket = new ServerSocket(50001);
                    System.out.println("서버 시작");

                    while (true) {
                        System.out.println("\n서버 연결 요청을 기다림\n");

                        //소켓
                        Socket socket = serverSocket.accept();

                        InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
                        System.out.println("서버 " + isa.getHostName() + "의 연결 요청을 수락함");

                        socket.close();
                        System.out.println("서버 " + isa.getHostName() + "의 연결을 끊음");
                    }
                } catch (IOException e) {
                    System.out.println("서버 " + e.getMessage());
                }
            }
        };
        thread.start();
    };

    public static void stopServer(){
        try{
            serverSocket.close();
            System.out.println("서버 종료");
        }catch (IOException e){}
    }

}
