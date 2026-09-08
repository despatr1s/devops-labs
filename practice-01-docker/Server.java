import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Server {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/", new MyHandler());
        server.start();
    }
}

class MyHandler implements HttpHandler {
    public void handle(HttpExchange exchange) throws IOException {
        String response = "Hello DevOps!";
        byte[] bytes = response.getBytes();
        int quantity = bytes.length;
        exchange.sendResponseHeaders(200, quantity);

        OutputStream out = exchange.getResponseBody();
        out.write(bytes);
        out.close();
    }
}