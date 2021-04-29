package JUC;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 使用ThreadPoolExecutor()创建线程池
 * 7个参数
 * 4种拒绝策略
 * 最大线程数的获取cpu密集，io密集
*/
public class D14ThreadPool {
    public static void main(String[] args) throws InterruptedException {
        // ExecutorService threadPool1 = Executors.newSingleThreadExecutor();
        // ExecutorService threadPool2 = Executors.newFixedThreadPool(3);
        // ExecutorService threadPool3 = Executors.newCachedThreadPool();

        /** 
         * cpu密集型，使用cup的核心数目作为最大线程数 
         * IO密集型，大于使用io的线程，一般两倍
         * */
        final int coreNum= Runtime.getRuntime().availableProcessors();

        /* 阿里开发手册推荐直接使用底层实现 */
        ThreadPoolExecutor threadPool4 = new ThreadPoolExecutor(2, coreNum, 1, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(3), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());

        try {
            for (int i = 0; i < 10; i++) {
                TimeUnit.MILLISECONDS.sleep(10);
                final int tmp = i;
                threadPool4.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " : " + tmp);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        } finally {
            threadPool4.shutdown();
        }
    }
}
