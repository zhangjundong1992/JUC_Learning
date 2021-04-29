package chatdemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ChatReceiver implements Runnable {

    private DatagramSocket socket;

    public ChatReceiver(int bindingPort) throws Exception {
        socket = new DatagramSocket(bindingPort);
    }

    @Override
    public void run() {
        while (true) {
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            
            try {
                socket.receive(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }

            String msg = new String(packet.getData()).trim();
            System.out.println(msg);

            if (msg.equals("bye")) {
                break;
            }
        }

        socket.close();
    }
}
