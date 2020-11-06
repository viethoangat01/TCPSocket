/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udpsocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author VIET HOANG
 */
public class Server {
    public static void main(String[] args) throws SocketException, IOException {
        System.out.println("Server is running...");
        DatagramSocket server=new DatagramSocket(12345);
        byte[] buff=new byte[1024];
        DatagramPacket receive =new DatagramPacket(buff, 1024);
        server.receive(receive);
        byte[] receiveByte=receive.getData();
        String receiveString=new String(receiveByte,0,receive.getLength());
        System.out.println(receiveString);
        server.close();
        
        
    }
    
}
