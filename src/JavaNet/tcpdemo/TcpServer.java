package tcpdemo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            // 1、创建服务端的服务
            serverSocket = new ServerSocket(9999);

            while (true) {
                // 2、接收客户端连接
                socket = serverSocket.accept();

                // 3、使用输入流接收
                is = socket.getInputStream();

                // 4、一般不是这么写的
                baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024]; 
                int len;
                while ((len = is.read(buffer)) != -1) {
                    baos.write(buffer, 0, len);
                }

                System.out.println(baos.toString());
            }
        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (serverSocket != null) {
                try {
                    serverSocket.close();
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

            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("服务端关闭");
        }
    }
}
