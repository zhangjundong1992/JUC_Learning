package JUC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class D04TestPC {
    public static void main(String[] args) {
        Data04 data = new Data04();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                data.step01();
            }

        }).start();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                data.step02();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                data.step03();
            }
        }).start();
    }

}

class Data04 {

    int num = 1;

    Lock lock = new ReentrantLock();
    /* 构建不同的阻塞队列,类似信号量 */
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();

    public void step01() {
        lock.lock();

        try {
            if (num != 1)
                c1.await();

            System.out.println(Thread.currentThread().getName() + " run step01");

            num = 2;
            c2.signal();
        
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void step02() {
        lock.lock();

        try {
            if (num != 2)
                c2.await();

            System.out.println(Thread.currentThread().getName() + " run step02");

            num = 3;
            c3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void step03() {
        lock.lock();

        try {
            if (num != 3)
                c3.await();

            System.out.println(Thread.currentThread().getName() + " run step03");

            num = 1;
            c1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
