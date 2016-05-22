import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by maxim.stetsenko on 11.04.2016.
 */
public class Connection implements Runnable {

    private User user;
    private Socket socket;
    private ServerSocket server;
    private DataInputStream in;
    private DataOutputStream out;

    public static void main(String[] args) {
        Integer a = 154;
        Object a1 = a;

    }

    public Connection(Socket socket, User user, ServerSocket server) {

        this.socket = socket;
        this.user = user;
        this.server = server;

        try {
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            // Конвертируем потоки в другой тип, чтоб легче обрабатывать текстовые сообщения.
            in = new DataInputStream(sin);
            out = new DataOutputStream(sout);

        } catch (IOException e) {
            e.printStackTrace();
        }

        new Thread(this).start();
    }

    public void run() {

        try {
            String str = "";
            while (true) {

                str = in.readUTF();

                if (str.equals("exit")) break;
                System.out.println(str);
                out.writeUTF("answer from server: " + str);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
