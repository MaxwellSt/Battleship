import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by maxim.stetsenko on 11.04.2016.
 */
public class MainServer {

    private static ServerSocket server;
    private static ArrayList<User> userList = new ArrayList<User>();

    public static void main(String[] args) {

        int userId = 0;
        try {
            server = new ServerSocket(2000);

            while (true) {

                Socket socket = server.accept();

                User user = new User(userId, socket);
                userList.add(user);
                System.out.println("Create new connection");
                Connection con = new Connection(user, server);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
