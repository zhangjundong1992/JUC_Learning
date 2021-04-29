package JUC;

import java.util.concurrent.TimeUnit;

/* 8锁问题下 */
@SuppressWarnings("all")
public class D05Lock02 {
    public static void main(String[] args) throws InterruptedException {
        Phone02 phone1 = new Phone02();
        Phone02 phone2 = new Phone02();

        new Thread(() -> {
            phone1.sms();
        }).start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(() -> {
            phone1.call();
        }).start();

        new Thread(() -> {
            phone2.weChat();
        }).start();
    }

}

class Phone02 {
    public static synchronized void sms() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public static synchronized void call() {
        System.out.println("打电话");
    }

    public static synchronized void weChat() {
        System.out.println("微信");
    }
}