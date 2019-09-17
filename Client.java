import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class Client extends Thread {
    private Socket socket;
    private final String T="TG:";


    public Client(Socket socket){
        this.socket=socket;
    }


    public boolean beginChat() throws IOException {
        System.out.println("beginChat");
        Scanner input=new Scanner(System.in);

        while(true) {
            System.out.println("first : "+socket.isClosed());
            if(socket.isClosed()) {
                Scanner s = new Scanner(System.in);
                int g=s.nextByte();
            }
            try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))){
                System.out.println("second : "+socket.isClosed());
                System.out.println("Enter something: ");
                String mes = input.nextLine();
                bufferedWriter.write(T + mes);
                bufferedWriter.flush();
                System.out.println("third : "+socket.isClosed());
                if(mes.equalsIgnoreCase("quit"))
                    break;
            }catch(Exception e){
                System.out.println("Exception! "+e);
            }
            System.out.println("4 : "+socket.isClosed());

        }

        socket.close();
        return false;
    }
}
