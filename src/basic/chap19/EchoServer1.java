package basic.chap19;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer1 {
    private static ServerSocket serverSocket=null;

    public static void main(String[] args) {
        System.out.println("서버를 종료하려면 q");
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

        startSever();
    }

    public static void startSever() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    serverSocket = new ServerSocket(50001);
                    System.out.println("서버 시작됨");

                    while (true) {
                        System.out.println();
                        System.out.println("서버 연결 요청 기다림");
                        System.out.println();

                        Socket socket = serverSocket.accept();

                        InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
                        System.out.println("서버 " + isa.getHostName() + "의 연결 요청을 수락함");

                        //데이터 보내기
                        DataInputStream dis = new DataInputStream(socket.getInputStream());
                        String message = dis.readUTF();

                        //데이터 받기
                        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                        dos.writeUTF(message);
                        dos.flush();
                        System.out.println("서버 받은 데이터를 다시 보냄: " + message);
                        System.out.println(System.nanoTime());


                        socket.close();
                        System.out.println("서버 " + isa.getHostName() + "의 연결을 끊음");
                        System.out.println(System.nanoTime());

                    }

                } catch (IOException e) {
                    System.out.println("서버 " + e.getMessage());
                }
            }
        };
        thread.start();
    }
    public static void stopServer(){
        try{
            serverSocket.close();
            System.out.println("서버 종료됨");
        }catch (IOException e){

        }
    }

}