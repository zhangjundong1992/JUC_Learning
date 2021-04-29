package JUC;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/* CylicBerrier */
public class D09Barrier {
    public static void main(String[] args) throws Exception {
        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            System.out.println("饭做好了");
        });

        for (int i = 0; i < 6; i++) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }

            final int tmp = i;
            new Thread(() -> {
                System.out.println("干饭人: " + tmp);
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }

                System.out.println("干饭"+tmp);
            }).start();
        }
    }
}
