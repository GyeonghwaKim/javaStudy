package chap19;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class EchoClient {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("localhost", 50001);
            System.out.println("클라이언트 연결 성공");

            //데이터 보내기
            String str="나는 자바가 좋아";
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF(str);
            dos.flush();
            System.out.println("클라이언트 데이터 보냄: "+str);
            System.out.println(System.nanoTime());


            //데이터 받기
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String receiveMessage=dis.readUTF();
            System.out.println("클라이언트 데이터 받음: "+receiveMessage);
            System.out.println(System.nanoTime());

            socket.close();
            System.out.println("클라이언트 연결 끊음");
        }catch (Exception e){}
    }
}
