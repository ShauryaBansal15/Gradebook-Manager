import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException, FileNotFoundException {
        Socket clientSocket = new Socket("localhost", 4242);
        
    }
    
}
