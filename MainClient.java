import java.io.IOException;
import java.net.Socket;

public class MainClient {
    public static void main(String[] args) throws IOException {


        Client client = new Client(new Socket("localhost",5001));

        while(client.beginChat());


    }
}
