package JUC;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class D02Ticket {
    public static void main(String[] args) {
        Ticket02 ticket = new Ticket02();

        new Thread(() -> {
            for (int i = 0; i < 10; i++)
                ticket.getTicket();
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++)
                ticket.getTicket();
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++)
                ticket.getTicket();
        }).start();
    }

}

class Ticket02 {
    private int num = 20;
    Lock lock = new ReentrantLock();

    public void getTicket() {
        lock.lock();
        try {
            /* 业务代码 */
            if (num > 0) {
                System.out.println(Thread.currentThread().getName() + "买到了票： " + num--);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
