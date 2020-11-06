/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udpsocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VIET HOANG
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException, IOException {
        try {
            // TODO code application logic here
            DatagramSocket client=new DatagramSocket();
            String send ="1";
            byte[] sendByte=send.getBytes();
            InetAddress remoteAddress=InetAddress.getByName("localhost");
            DatagramPacket sendPacket=new DatagramPacket(sendByte, sendByte.length,remoteAddress,12345);
            client.send(sendPacket);
            client.close();
            
            
            
            
            
        } catch (SocketException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
