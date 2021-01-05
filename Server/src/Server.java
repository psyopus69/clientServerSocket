import com.phonePack.*;
import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) {

        try(ServerSocket server = new ServerSocket(8000)) {
            System.out.println("Server started!");
            while(true)
                try (Phone phone = new Phone(server)) {
                    String request = phone.readLine();
                    System.out.println(request);
                    String response = "Hello from server!" + request.length();
                    System.out.println(response);
                    phone.writeLine((int) (Math.random() * 30 - 10) + "");
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
