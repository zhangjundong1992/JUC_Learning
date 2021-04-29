package JUC;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 阻塞队列
 * put和take互为同步
 * 生产者消费者模式
*/
public class D12BlockingQueue {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);

        for (int i = 0; i < 6; i++) {
            final int tmp = i;
            new Thread(() -> {
                try {
                    queue.put(tmp);
                    System.out.println(tmp + "入队");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        TimeUnit.SECONDS.sleep(1);

        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                try {
                    int tmp = queue.take();
                    System.out.println(tmp + "出队");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
}