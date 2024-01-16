import java.net.Socket;

public class SocketClient {
    //필드
    ChatServer chatServer;
    Socket socket;
    String clientIp;
    String chatName;

    //생성자
    public SocketClient(ChatServer chatServer, Socket socket){
        this.chatServer = chatServer;
        this.socket = socket;
    }
}
