package chatdemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class ChatSender implements Runnable {
    private DatagramSocket socket;
    private InetSocketAddress toSA;
    private Scanner sc;

    public ChatSender(InetSocketAddress toSA) throws Exception {
        socket = new DatagramSocket();
        this.toSA = toSA;
        sc = new Scanner(System.in);
    }

    @Override
    public void run() {
        while (sc.hasNextLine()) {
            String msg = sc.nextLine();
            DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.getBytes().length, toSA);

            try {
                socket.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (msg.equals("bye"))
                break;
        }

        sc.close();
        socket.close();
    }
}
