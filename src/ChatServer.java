import javax.crypto.SealedObject;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {

    //필드
    ServerSocket serverSocket;
    ExecutorService threadPool = Executors.newFixedThreadPool(100);
    Map<String, SocketClient> chatRoom = Collections.synchronizedMap(new HashMap<>());

    //메소드
    public void start() throws IOException {
        serverSocket = new ServerSocket(50001);
        System.out.println(" [server] start");

        Thread thread = new Thread(()-> {
            try {
                Socket socket = serverSocket.accept();
                SocketClient sc = new SocketClient(this, socket);
            } catch (Exception e) {
            }
        });
        thread.start();
    }

    //채팅방에 참가자 추가
    public void addSocketClient(SocketClient socketClient) {
        String key = socketClient.chatName + "@" + socketClient.clientIp;
        chatRoom.put(key, socketClient);
        System.out.println("Enter: " + key);
        System.out.println("Number of member: " + chatRoom.size() + "\n");
    }

    public void removeSocketClient(SocketClient socketClient) {
        String key = socketClient.chatName + "@" + socketClient.clientIp;
        chatRoom.remove(key);
        System.out.println("Out: " + key);
        System.out.println("Number of member: " + chatRoom.size() + "\n");
    }

    public static void maid(String[] arg){

    }
}
