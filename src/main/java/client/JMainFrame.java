package client;


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class JMainFrame extends JFrame {

    private JPanel north;
    private JPanel south;
    private ControllerImpl controller;


    public JMainFrame(ControllerImpl controller) {

        setTitle("Battleship");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        this.controller = controller;

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension size = kit.getScreenSize();
        setSize(size.width / 2 + 150, size.height / 2);
        setLocation(size.width / 8, size.height / 11);

        JTextField textField = new JTextField(40);
        JTextArea messageArea = new JTextArea(8, 40);

        north = new JPanel();
        south = new JPanel();

        add(north, BorderLayout.NORTH);
        add(south, BorderLayout.SOUTH);

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

        pack();

        // Add Listeners

        textField.addActionListener(controller);
        button1.addActionListener(controller);
        button2.addActionListener(controller);

    }


}
