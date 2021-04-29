package JUC;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用atomic原子类保证原子性
*/
public class D20volatile {
    private static int num = 0;
    private static AtomicInteger num2=new AtomicInteger(0);

    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    num++;
                    
                    num2.getAndIncrement();
                }
            }).start();
        }

        while (Thread.activeCount() >2) {
            Thread.yield();
        }

        System.out.println(num);
        System.out.println(num2);
    }
}
