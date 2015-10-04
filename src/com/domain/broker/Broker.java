/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package com.domain.broker;

import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author RamirezAlonzo
 */
public class Broker {
    private static Broker brokerInstance = null;
    
    private Broker() {
        
    }
    
    public static Broker getInstance() {
        if (brokerInstance == null) {
            brokerInstance = new Broker();
        }
        
        return brokerInstance;
    }
    
    private void beginConnection(int portNumber) {
        boolean listening = true;
        
        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            while (listening) {
                new BrokerThread(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port " + portNumber);
        }
    }
    
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java Broker <port number>");
        }
        
        int portNumber = Integer.parseInt(args[0]);
        Broker broker = Broker.getInstance();
        broker.beginConnection(portNumber);
    }
}
