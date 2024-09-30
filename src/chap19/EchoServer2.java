package chap19;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class EchoServer2 {
    private static ServerSocket serverSocket=null;
    private static ExecutorService executorService=Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        System.out.println("서버를 종료하려면 q");
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

        //TCP 시작
        startSever();

        Scanner scanner = new Scanner(System.in);
        while (true){
            String s = scanner.nextLine();
            if (s.toLowerCase().equals("q")) break;
        }
        scanner.close();

        stopServer();
    }

    public static void startSever() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    //소켓 생성 및 포트 바인딩
                    serverSocket = new ServerSocket(50001);
                    System.out.println("서버 시작됨");

                    while (true) {

                        Socket socket = EchoServer2.serverSocket.accept();

                        executorService.execute(()->{
                            try{
                                //클라이언트 정보 얻기
                                InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
                                System.out.println("서버: "+isa.getHostName()+"의 연결 요청 수락함");

                                //데이터 받기
                                DataInputStream dis = new DataInputStream(socket.getInputStream());
                                String message = dis.readUTF();

                                //데이터 보내기
                                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                                dos.writeUTF(message);
                                dos.flush();
                                System.out.println("서버에서 받은 데이터 보냄 - "+message);

                                //연결 끊기
                                socket.close();
                                System.out.println("서버 "+isa.getHostName()+"의 연결을 끊음");
                            }catch (IOException e){}
                        });
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
            //스레드풀 종료
            executorService.shutdownNow();
            System.out.println("서버 종료됨");
        }catch (IOException e){

        }
    }

}