package JUC;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/** 
 * 同步队列容量为0
 * put和take互为同步
 */
public class D13SyncQueue {
    public static void main(String[] args) {
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                queue.put(1);
                System.out.println(Thread.currentThread().getName() + " put " + 1);
                TimeUnit.SECONDS.sleep(3);
                queue.put(2);
                System.out.println(Thread.currentThread().getName() + " put " + 2);
                TimeUnit.SECONDS.sleep(3);
                queue.put(3);
                System.out.println(Thread.currentThread().getName() + " put " + 3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "T1").start();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " take " + queue.take());
                
                System.out.println(Thread.currentThread().getName() + " take " + queue.take());
                
                System.out.println(Thread.currentThread().getName() + " take " + queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "T2").start();
    }

}
