package JUC;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁，又称递归锁
 */
public class D23Reentrant {
    public static void main(String[] args) {
        Phone2 phone = new Phone2();
        Phone3 phone3=new Phone3();

        new Thread(() -> {
            phone.foo();
        }).start();

        new Thread(() -> {
            phone3.foo();;
        }).start();
    }
}

class Phone2 {

    public synchronized void foo() {
        bar();
        System.out.println("foo");
    }

    public synchronized void bar() {
        System.out.println("bar");
    }
}

class Phone3 {

    Lock lock = new ReentrantLock();

    public void foo() {
        lock.lock();
        try {
            bar();
            System.out.println("foo");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void bar() {
        lock.lock();
        try {
            System.out.println("bar");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}