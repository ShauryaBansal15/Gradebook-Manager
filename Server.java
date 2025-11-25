import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(4242);
        Socket clientSocket = ss.accept();
        System.out.println("Client is connected!");
    }
    
}
