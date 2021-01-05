import com.phonePack.Phone;
import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) {
        try(ServerSocket server = new ServerSocket(8000)) {
            System.out.println("Server started!");
            while(true) {
                Phone phone = new Phone(server);
                new Thread(() -> {
                    String request = phone.readLine();
                    System.out.println(request);
                    int outInt = (int) (Math.random() * 30 - 10);
                    String response = "Hello from server!" + request.length() + "resp: " + outInt;
                    System.out.println(response);
                    try {
                      Thread.sleep(4000);
                    } catch (InterruptedException e) {
                       throw new RuntimeException(e);
                    }
                    phone.writeLine(outInt + "");
                    try {
                        phone.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
