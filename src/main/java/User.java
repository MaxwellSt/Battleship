import java.net.Socket;

/**
 * Created by maxim.stetsenko on 11.04.2016.
 */
public class User {

    private String name;
    private Socket socket;
    private int id;

    public User(int id, Socket socket) {

        this.socket = socket;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {

        return name;
    }

    public Socket getSocket() {
        return socket;
    }
}
