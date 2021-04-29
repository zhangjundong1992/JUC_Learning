package tcpdemo;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TcpClient {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream os = null;

        try {
            // 1、服务端ip和端口号
            InetAddress serverIP = InetAddress.getByName("127.0.0.1");
            int port = 9999;

            // 2、创建客户端socket
            socket = new Socket(serverIP, port);

            // 3、使用输出流发送数据
            os = socket.getOutputStream();
            os.write("Hello World!!".getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("客户端关闭");
        }
    }
}
