
import com.phone.Phone;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args){
        System.out.println("main started");
        try (ServerSocket server = new ServerSocket(8000)) {
            System.out.println("Server started");
            while (true) {
//                System.out.println("Client connected");
                try (Phone phone = new Phone(server) ) {

                    String request = phone.readLine();
                    System.out.println("Request " + request);

                    phone.writeLine("Hello from server " + request.length() + " " + request);
                }catch (NullPointerException e){
                    e.printStackTrace();
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }


//    public static void main(String[] args){
//        System.out.println("main started");
//        try (ServerSocket server = new ServerSocket(8000)) {
//            System.out.println("Server started");
//            while (true) {
////                System.out.println("Client connected");
//                try (
//                     Socket socket = server.accept();
//                     BufferedWriter writer =
//                             new BufferedWriter(
//                                     new OutputStreamWriter(
//                                             socket.getOutputStream()));
//
//                     BufferedReader reader =
//                             new BufferedReader(
//                                     new InputStreamReader((
//                                             socket.getInputStream())));
//                     ) {
//
//                    String request = reader.readLine();
//                    System.out.println("Request " + request);
//
//                    writer.write("Hello from server " + request.length() + " " + request);
//                    writer.newLine();
//                    writer.flush();
//
////                    writer.close();
////                    socket.close();
////                    server.close();
//                }catch (NullPointerException e){
////                    throw new RuntimeException();
//                    e.printStackTrace();
//                }
//            }
//        }catch (IOException e){
////            throw new RuntimeException();
//            e.printStackTrace();
//        }
//    }
}
