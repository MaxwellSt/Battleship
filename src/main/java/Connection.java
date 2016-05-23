import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by maxim.stetsenko on 11.04.2016.
 */
public class Connection implements Runnable {

    private User userA;
    private User userB;
    private ServerSocket server;
    private DataInputStream inA;
    private DataOutputStream outA;
    private DataInputStream inB;
    private DataOutputStream outB;

    public Connection(User user, ServerSocket server) {

        this.userA = user;
        this.server = server;

        try {

            System.out.println("Wait userB");

            Socket socketB = server.accept();
            userB = new User(0, socketB);

            System.out.println("UserB connected");

            InputStream sinA = userA.getSocket().getInputStream();
            OutputStream soutA = userA.getSocket().getOutputStream();
            InputStream sinB = userB.getSocket().getInputStream();
            OutputStream soutB = userB.getSocket().getOutputStream();

            // Конвертируем потоки в другой тип, чтоб легче обрабатывать текстовые сообщения.
            inA = new DataInputStream(sinA);
            outA = new DataOutputStream(soutA);
            inB = new DataInputStream(sinB);
            outB = new DataOutputStream(soutB);

        } catch (IOException e) {
            e.printStackTrace();
        }

        new Thread(this).start();
    }

    public void run() {

        try {

            String str = "";
            while (true) {

                str = MainClient.read(inA);
                if(str != null){
                    if (str.equals("exit")) break;
                    outB.writeUTF("userA: " + str);
                }

                str = MainClient.read(inB);
                if(str != null) {
                    if (str.equals("exit")) break;
                    outA.writeUTF("userB: " + str);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
