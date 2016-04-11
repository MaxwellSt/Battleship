import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by maxim.stetsenko on 11.04.2016.
 */
public class MainServer {

    private static ServerSocket server;

    public static void main(String[] args) {

        try {
            server = new ServerSocket(2000);

            while (true) {
                Socket socket = server.accept();

                Connection con = new Connection(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
