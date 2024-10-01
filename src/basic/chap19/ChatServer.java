package basic.chap19;

import org.json.JSONObject;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {
    ServerSocket serverSocket;
    ExecutorService threadPool= Executors.newFixedThreadPool(100);
    Map<String,SocketClient> chatRoom= Collections.synchronizedMap(new HashMap<>());

    public static void main(String[] args) {
        try{
            ChatServer chatServer=new ChatServer();
            chatServer.start();

            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
            System.out.println("서버 종료하려면 q");
            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

            Scanner scanner = new Scanner(System.in);
            while (true){
                String key=scanner.nextLine();
                if(key.equals("q")) break;
            }
        scanner.close();
        chatServer.stop();
        }catch (IOException e){
            System.out.println("[서버] "+e.getMessage());
        }
    }

    //서버 시작
    public void start() throws IOException{
        serverSocket=new ServerSocket(50001);
        System.out.println("[서버] 시작됨");

        Thread thread = new Thread(() -> {
            try {
                while (true) {
                    Socket socket = serverSocket.accept();
                    SocketClient sc = new SocketClient(this, socket);
                }
            } catch (IOException e) {

            }
        });

        thread.start();
    }

    //클라이언트 연결 시 socket client 생성 및 추가
    public void addSocketClient(SocketClient socketClient){
        String key = getKey(socketClient);
        chatRoom.put(key,socketClient);
        System.out.println("입장: "+key);
        showParticipant();
    }

    public void removeSocketClient(SocketClient socketClient){
        String key = getKey(socketClient);
        chatRoom.remove(key);
        System.out.println("나감: "+key);
        System.out.println("현재 채팅자수: "+chatRoom.size()+"\n");
    }

    public void sendToAll(SocketClient sender,String message){
        JSONObject root = new JSONObject();
        root.put("clientIp",sender.clientIp);
        root.put("chatName",sender.chatName);
        root.put("message",message);
        String json=root.toString();

        Collection<SocketClient> socketClients=chatRoom.values();
        for (SocketClient sc : socketClients) {
            //메세지를 보낸 자신한테는 send()안함
            if(sc==sender) continue;
            sc.send(json);
        }
    }
    public void stop(){
        try {
            serverSocket.close();
            threadPool.shutdownNow();
            chatRoom.values().stream().forEach(sc ->sc.close());
            System.out.println("[서버] 종료됨");
        }catch (IOException e){

        }
    }

    private void showParticipant() {
        System.out.println("현재 채팅자 수: "+chatRoom.size()+ "\n");
    }

    private static String getKey(SocketClient socketClient) {
        String key= socketClient.chatName+"@"+ socketClient.clientIp;
        return key;
    }




}
