package advance;

import java.util.concurrent.locks.ReentrantLock;

/**
 * TestLock
 */
public class TestLock {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Thread(ticket).start();
        new Thread(ticket).start();
        new Thread(ticket).start();

    }
}

class Ticket implements Runnable {

    int num = 10;

    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {

            lock.lock();

            try {
                if (num <= 0)
                    break;
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + "买到了票： " + num--);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }
}