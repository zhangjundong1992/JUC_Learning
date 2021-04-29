package syn;

public class UnSafeTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Thread(ticket, "小明").start();
        new Thread(ticket, "小红").start();
        new Thread(ticket, "黄牛").start();

    }
}

class Ticket implements Runnable {
    private Integer num = 15; //Integer

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (num <= 0)
                    return;

                /* 模拟延时 */
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "买到了票： " + num--);
            }
        }
    }
}
