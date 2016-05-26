package client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by maxim.stetsenko on 11.04.2016.
 */
public class MainClient {

    JFrame frame;
    private JTextField textField;
    private JTextArea messageArea;
    private JScrollPane scroll;
    private JPanel north;
    private JPanel south;
    private InputStream in;
    private OutputStream out;

    public static void main(String[] arg) throws Exception {

        MainClient client = new MainClient();
        client.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        client.frame.setVisible(true);
        client.run();

    }

    private void run() throws IOException {

        int serverPort = 2000;
        String address = "127.0.0.1";

        try {

            InetAddress ipAddress = InetAddress.getByName(address);

            Socket socket = new Socket(ipAddress, serverPort);

            in = socket.getInputStream();
            out = socket.getOutputStream();

            while (true) {
                String line = new DataInputStream(in).readUTF();
                System.out.println(line);
                messageArea.append(line + "\n");
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    public MainClient() {

        ControllerImpl controller = new ControllerImpl();

        frame = new JFrame("Chatter");

        textField = new JTextField(40);
        messageArea = new JTextArea(8, 40);

        north = new JPanel();
        south = new JPanel();

        // Layout GUI
        frame.add(north, BorderLayout.NORTH);
        frame.add(south, BorderLayout.SOUTH);

        JButton button1 = new JButton("Shot");
        button1.setActionCommand("Shot");
        north.add(button1);

        JButton button2 = new JButton("New game");
        button2.setActionCommand("NewGame");
        north.add(button2);

        north.add(textField);
        south.add(new JScrollPane(messageArea), "Center");

        textField.setEditable(true);
        textField.setActionCommand("Message");

        frame.pack();

        // Add Listeners

        textField.addActionListener(controller);
        button1.addActionListener(controller);
        button2.addActionListener(controller);
    }
}
