package JUC;
import java.util.concurrent.TimeUnit;

/* 8锁问题上 */
public class D05Lock01 {
    public static void main(String[] args) throws InterruptedException {
        Phone phone1 = new Phone();
        Phone phone2 = new Phone();

        new Thread(() -> {
            phone1.sms();
        }).start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(() -> {
            phone1.call();
        }).start();

        new Thread(() -> {
            phone1.weChat();
        }).start();

        new Thread(() -> {
            phone2.call();
        }).start();

    }
}

class Phone {
    public synchronized void sms() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public synchronized void call() {
        System.out.println("打电话");
    }

    public void weChat() {
        System.out.println("微信");
    }
}