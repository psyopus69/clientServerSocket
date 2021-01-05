import com.phonePack.Phone;
import java.io.*;

public class Client {
    public static void main(String[] args) {
        try(Phone phone = new Phone("127.0.0.1", 8000)) {
            System.out.println("Connected to server");
            String request = "SomeCity";
            phone.writeLine(request);
            System.out.println("request: " + request);
            String response = phone.readLine();
            System.out.println("response: " + response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
