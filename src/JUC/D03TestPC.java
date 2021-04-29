package JUC;

/**
 * 交替+1和-1操作
 */
public class D03TestPC {

    public static void main(String[] args) {
        Data data = new Data();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    data.increase();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    data.decrease();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    data.increase();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    data.decrease();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}

class Data {
    int num = 0;

    public synchronized void increase() throws InterruptedException {
        /* 使用while避免虚唤醒
        使用samphore的话，更适合处理生产者消费者问题
        避免了唤醒和重新阻塞的消耗*/
        while (num > 0) { 
            wait();
        }

        num++;
        System.out.println(Thread.currentThread().getName() + " : " + num);

        notifyAll();
    }

    public synchronized void decrease() throws InterruptedException {
        while (num <= 0) {
            wait();
        }

        num--;
        System.out.println(Thread.currentThread().getName() + " : " + num);

        notify();
    }
}