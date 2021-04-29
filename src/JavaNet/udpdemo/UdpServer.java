package udpdemo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpServer {
    public static void main(String[] args) {
        try {
            DatagramSocket socket =new DatagramSocket(9090);
            
            byte[] buffer=new byte[1024];
            DatagramPacket packet=new DatagramPacket(buffer,buffer.length);

            socket.receive(packet);

            socket.close();

            System.out.println(new String(packet.getData()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
