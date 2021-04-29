package chatdemo;

import java.net.InetSocketAddress;

public class Chat {
    public static void main(String[] args) throws Exception {
        new Thread(new ChatSender(new InetSocketAddress("localhost", 9090))).start();
        new Thread(new ChatReceiver(7070)).start();
    }
}
