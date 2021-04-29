package JUC;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* 信号量 */
public class D10Samphore {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);

        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"得到车位");
                    TimeUnit.SECONDS.sleep(2);
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName()+"离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        } 
    }
}
