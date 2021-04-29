package udpdemo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UdpClinet
 */
public class UdpClinet {

    public static void main(String[] args) {
        try {
            // 1、建立socket
            DatagramSocket socket = new DatagramSocket();

            // 2、指明ip和端口
            InetAddress ip = InetAddress.getByName("localhost");
            int port = 9090;

            // 3、数据
            String msg = "你好，服务器";
            DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.getBytes().length, ip, port);

            // 4、发送
            socket.send(packet);

            socket.close();
            

        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}