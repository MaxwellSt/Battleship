package client;

import exceptions.ReciveException;
import exceptions.SendException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by maxim.stetsenko on 26.05.2016.
 */
public class ControllerImpl implements Controller, ActionListener, KeyListener {

    private ObjectOutputStream out;
    private ObjectInputStream in;

    public void actionPerformed(ActionEvent e) {

    }

    public void send(Serializable object) throws SendException {
        //log.info( "Run method send( " + object.toString() + " )" );
        try {
            out.writeObject(object);
            //log.debug( "Object was written, object: " + object.toString() );
        } catch (IOException e) {
            //log.error( e.getMessage(), e );
            throw new SendException(e.getMessage(), e);
        }
    }

    public Object recive() throws ReciveException {
        //log.info( "Run method recive()" );
        try {
            Object object = ( Object ) in.readObject();
            //log.debug( "Object was read, object: " + object.toString() );
            return object;
        } catch ( ClassNotFoundException e ) {
            //log.error( e.getMessage(), e );
            throw new ReciveException( e.getMessage(), e );
        } catch ( IOException e ) {
            //log.error( e.getMessage(), e );
            throw new ReciveException( e.getMessage(), e );
        }
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {

    }
}
