package udpdemo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class ChatSender {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket=new DatagramSocket(7070);
        Scanner sc=new Scanner(System.in);

        while (sc.hasNextLine()) {
            String msg=sc.nextLine();
            DatagramPacket packet=new DatagramPacket(msg.getBytes(),msg.getBytes().length,new InetSocketAddress("localhost", 9090));
            socket.send(packet);

            if (msg.equals("bye"))
                break; 
        }

        sc.close();
        socket.close();
    }
}
