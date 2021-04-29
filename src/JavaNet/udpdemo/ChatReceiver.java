package udpdemo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ChatReceiver {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(9090);

        while (true) {
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);

            String msg = new String(packet.getData()).trim();
            System.out.println(msg);

            if (msg.equals("bye")) {
                break;
            }
        }

        socket.close();
    }
}
