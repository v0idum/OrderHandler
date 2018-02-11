package com.aven.orderhandler.model;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

public class Client implements Serializable {

    private final String name;

    private boolean isConnected = false;

    public Client(final String name) {
        this.name = name;
    }

    public void sendOrder(final Order order) {
        while (!isConnected) {
            try {
                Socket socket = new Socket("localHost", 9000);
                isConnected = true;
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                outputStream.writeObject(order);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getName() {
        return name;
    }

}
