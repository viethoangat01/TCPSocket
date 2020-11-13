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
            int clientPort=12345;
            // TODO code application logic here
            DatagramSocket client=new DatagramSocket();
            String send ="1";
            //Đóng gói thông tin vào gói tin DatagramPacket để gửi đi
            byte[] sendData=new byte[1024];
            InetAddress remoteAddress=InetAddress.getByName("localhost");
            sendData=send.getBytes();
            DatagramPacket sendPacket=new DatagramPacket(sendData, sendData.length,remoteAddress,clientPort);
            //Gửi dữ liệu đến server
            client.send(sendPacket);
            //Nhận dữ liệu đã qua xử lý từ server về
            byte[] receiveData=new byte[1024];
            try {
                //Tạo đối tượng packet tử DatagramPacket để nhận dữ liệu từ phía client để xử lý
                DatagramPacket receivePacket =new DatagramPacket(receiveData, receiveData.length);
                client.receive(receivePacket);
                System.out.println("4");
                String s=new String(receivePacket.getData());
                System.out.println(s);
            } catch (Exception e) {
                System.err.println(e);
            }
            client.close();
        } catch (SocketException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }   
}
