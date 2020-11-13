/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udpsocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author VIET HOANG
 */
public class Server {
    public static void main(String[] args) throws SocketException, IOException {
        int port=12345;
        System.out.println("Server is running...");
        //Mở server socket tịa một cổng có số hiệu xác định
        DatagramSocket server=new DatagramSocket(port);
        //Tạo đối tượng packet tử DatagramPacket để nhận dữ liệu từ phía client để xử lý
        byte[] receiveData=new byte[1024];
        DatagramPacket receivePacket =new DatagramPacket(receiveData, receiveData.length);
        server.receive(receivePacket);
        String input=new String(receivePacket.getData());
        System.out.println(input);
        String reply="Successful";
        //Đóng gói tin DatagramPacket để gửi trả về cho client tương ứng
        byte[] sendData=new byte[1024];
        InetAddress remoteAddress=InetAddress.getByName("localhost");
        sendData=reply.getBytes();
        DatagramPacket sendPacket=new DatagramPacket(sendData, sendData.length,remoteAddress,port);
        //Gửi dữ liệu về client
         server.send(sendPacket);
        System.out.println("Gửi String");
        server.close();
    }
}
