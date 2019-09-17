import java.io.*;
import java.net.Socket;

public class MonoThreadClientHandler implements Runnable {
    private Socket socket;

    public MonoThreadClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (!socket.isClosed()) {
            System.out.println("MONOTHREAD");
            System.out.println(socket.isClosed());
            try (BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream()))) {
                System.out.println(bufferedReader.readLine());
                if(bufferedReader.readLine()==null){
                    continue;
                }
                else if(bufferedReader.readLine().equalsIgnoreCase("quit")){
                    socket.close();
                    break;
                }

            } catch (IOException e) {
                System.out.println("Exception! " + e);
                e.printStackTrace();
            }

        }

    }
}