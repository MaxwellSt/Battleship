import java.io.*;
import java.net.Socket;

/**
 * Created by maxim.stetsenko on 11.04.2016.
 */
public class Connection implements Runnable {

    private User user;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public Connection(Socket socket, User user) {

        this.socket = socket;
        this.user   = user;

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
