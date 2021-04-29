package JUC;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class D24SpinLock {
    public static void main(String[] args) {
        SpinLock lock=new SpinLock();

        for (int i = 0; i <5; i++) {
            new Thread(()->{
                lock.myLock();
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.myUnLock();
            }).start();
        }

    }
}

/**
 * 手动模拟自旋锁
 */
class SpinLock {

    /**
     * state记录当前获取锁的线程
     */
    AtomicReference<Thread> state = new AtomicReference<>();

    public void myLock() {
        System.out.println(Thread.currentThread().getName() + " apply lock");
        Thread t = Thread.currentThread();
        while (!state.compareAndSet(null, t)) {
        }
        System.out.println(Thread.currentThread().getName() + " get lock");
    }

    public void myUnLock() {
        state.compareAndSet(Thread.currentThread(), null);
        System.out.println(Thread.currentThread().getName() + " release lock");
    }

}