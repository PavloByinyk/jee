import com.phone.Phone;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args){
        try (Phone phone = new Phone("127.0.0.1", 8000)){
            System.out.println("Connected to server");
            String request = "Lviv";
            phone.writeLine(request);
            String response = phone.readLine();
            System.out.println("Response client = " + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
