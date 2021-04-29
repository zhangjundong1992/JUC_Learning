package JUC;

import java.util.concurrent.CountDownLatch;

/* CountdownLatch */
public class D08CountDown {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("开门");

        CountDownLatch cnt = new CountDownLatch(6);
        
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"出门了");
                cnt.countDown();
            },String.valueOf(i)).start();
        }

        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    
        cnt.await();
        System.out.println("关门");
    }
}
