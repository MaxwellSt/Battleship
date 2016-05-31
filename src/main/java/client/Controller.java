package client;

import exceptions.ReciveException;
import exceptions.SendException;

import java.io.Serializable;

public interface Controller {

    /**
     * method of sending packets
     * 
     * @param object
     * @throws SendException
     */
    void send(Serializable object) throws SendException;

    /**
     * method of reciving packets
     * 
     * @return
     * @throws ReciveException
     */
    Object recive() throws ReciveException;


}
