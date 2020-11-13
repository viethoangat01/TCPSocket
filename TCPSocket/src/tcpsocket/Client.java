/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpsocket;

import com.sun.xml.internal.ws.util.StringUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import model.Student;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Answer;
//-1393754107
/**
 *
 * @author Ngoc Bich
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Client client=new Client();
        try {
            client.run();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void run() throws ClassNotFoundException, IOException{
            Socket socket=new Socket("192.168.0.121",11001);
//            ObjectOutputStream objectOutputStream=new ObjectOutputStream(socket.getOutputStream());
//            Scanner input=new Scanner(System.in);
//            System.out.println("Nhap ma sinh vien: ");
//            String maSV;
//            maSV=input.nextLine();
//            System.out.println("NHap ho va ten: ");
//            String hoten;
//            hoten=input.nextLine();
//            String ip ;
//            System.out.println("Nhap IP: ");
//            ip=input.nextLine();
//            System.out.println("Nhom: ");
//            int group;
//            group=input.nextInt();
//            objectOutputStream.writeObject(new Student(maSV, hoten, ip, group));
//            objectOutputStream.flush();
//            ObjectInputStream objectInputStream=new ObjectInputStream(socket.getInputStream());
//            Answer answer=(Answer) objectInputStream.readObject();
//            if(answer!=null){
//                System.out.println("Thanh cong!");
//            }
//            objectInputStream.close();
//            objectOutputStream.close();
//            
//            
//        } catch (IOException ex) {
//            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
//        }
            DataOutputStream outputStream=new DataOutputStream(socket.getOutputStream());
            DataInputStream inputStream=new DataInputStream(socket.getInputStream());
         
            ObjectInputStream objectInputStream=new ObjectInputStream(socket.getInputStream());
            Scanner input=new Scanner(System.in);
            System.out.println("Nhap ma sinh vien: ");
            String maSV;
            maSV=input.nextLine();
            outputStream.writeUTF(maSV);
            outputStream.flush();
            System.out.println("NHap ho va ten: ");
            String hoten;
            hoten=input.nextLine();
            outputStream.writeUTF(hoten);
            outputStream.flush();
            System.out.println("Nhom: ");
            int group;
            group=input.nextInt();
            outputStream.writeInt(group);
            outputStream.flush();
            int code=inputStream.readInt();
            System.out.println(code);
            String xau2=inputStream.readUTF();
            System.out.println(xau2);
            String xau3=inputStream.readUTF();
            System.out.println(xau3);
            int c=(xau2.length()-xau2.replaceAll(xau3, "").length())/xau3.length();
            outputStream.writeInt(c);
            String xau1=inputStream.readUTF();
            System.out.println("Xau1: "+xau1);
            String reverveString=new StringBuffer(xau1).reverse().toString();
            outputStream.writeUTF(reverveString);
            Answer answer=(Answer) objectInputStream.readObject();
            outputStream.close();
            socket.close();
            inputStream.close();
    }

}
