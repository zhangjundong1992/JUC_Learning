package JUC;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


/* CylicBerrier */
/**
 * 举例
 * 八个跑道的运动员，都到齐了才能出发，
 * 阻塞的是运动员线程，而且是循环进行的
*/
public class D09Barrier {
    public static void main(String[] args) throws Exception {
        CyclicBarrier barrier = new CyclicBarrier(6, () -> {
            System.out.println("出发");
        });

        for (int i = 0; i < 6; i++) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }

            final int tmp = i;
            new Thread(() -> {
                System.out.println("运动员到场: " + tmp);
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }

                System.out.println("运动员起跑："+tmp);
            }).start();
        }
    }
}
