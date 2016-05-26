package client;

import exceptions.ReciveException;
import exceptions.SendException;
import packets.Packets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by maxim.stetsenko.
 */
public class ControllerImpl implements Controller, ActionListener, KeyListener {

    private ObjectOutputStream out;
    private ObjectInputStream in;

    public void actionPerformed(ActionEvent e) {
        System.out.println("Run method actionPerformed( " + e.toString() + " )");
        String eventName = e.getActionCommand();
        System.out.println("Event name is: " + eventName);
        if (eventName.equals("Shot")) {
            System.out.println("The event is \"Shot\"");
            Packets.Shot shot = new Packets.Shot(10, 10);
            try {
                send(shot);
            } catch (SendException e1) {
                e1.printStackTrace();
            }
        } else if (eventName.equals("NewGame")) {
            System.out.println("The event is \"NewGame\"");
        }
    }

    public void send(Serializable object) throws SendException {
        System.out.println("Run method send( " + object.toString() + " )");
        try {
            out.writeObject(object);
            System.out.println("Object was written, object: " + object.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new SendException(e.getMessage(), e);
        }
    }

    public Object recive() throws ReciveException {
        System.out.println("Run method recive()");
        try {
            Object object = (Object) in.readObject();
            System.out.println("Object was read, object: " + object.toString());
            return object;
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            throw new ReciveException(e.getMessage(), e);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new ReciveException(e.getMessage(), e);
        }
    }

    public void keyTyped(KeyEvent e) {
        System.out.println("Run method keyTyped()");
    }

    public void keyPressed(KeyEvent e) {
        System.out.println("Run method keyPressed()");
    }

    public void keyReleased(KeyEvent e) {
        System.out.println("Run method keyReleased()");
    }
}
