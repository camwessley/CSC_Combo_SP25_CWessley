import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;

public class MultiThreadedHttpServer {
    public static void main(String[] args) {
        int port = 8080;
        ExecutorService threadPool = Executors.newFixedThreadPool(
                10); // Using a thread pool to manage threads efficiently
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Multi-threaded Server running on port " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                threadPool.execute(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    private static String getServerTime() {
        SimpleDateFormat dateFormat =
                new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return dateFormat.format(new Date());
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            String line;
            while (!(line = reader.readLine()).isBlank()) {
                System.out.println(line);
            }

            String responseBody = "Hello from a multithreaded server!";
            String date = getServerTime();
            String serverName = "SimpleJavaHTTPServer/1.1";
            String contentType = "text/plain; charset=UTF-8";
            String contentLength = String.valueOf(responseBody.length());

            String httpResponse = "HTTP/1.1 200 OK\r\n"
                    + "Date: " + date + "\r\n"
                    + "Server: " + serverName + "\r\n"
                    + "Content-Type: " + contentType + "\r\n"
                    + "Content-Length: " + contentLength + "\r\n"
                    + "Connection: close\r\n\r\n" + responseBody;

            OutputStream outputStream = clientSocket.getOutputStream();
            outputStream.write(httpResponse.getBytes());
            outputStream.flush();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}