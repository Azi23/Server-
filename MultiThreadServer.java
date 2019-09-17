import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadServer{
    private ExecutorService executorService = Executors.newFixedThreadPool(5);

    protected void Begin() throws IOException {
        ServerSocket serverSocket = new ServerSocket(5001);
        System.out.println("MULTITHREAD");
        while (true) {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            if (bf.ready()) {
                Socket socket = serverSocket.accept();
                executorService.execute(new MonoThreadClientHandler(socket));
            }

        }
    }
}