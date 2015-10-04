/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package com.domain.broker;

import java.net.Socket;

/**
 *
 * @author RamirezAlonzo
 */
public class BrokerThread extends Thread {
    private Socket socket = null;
    
    public BrokerThread(Socket socket) {
        super("KKMultiServerThread");
        this.socket = socket;
    }
}
