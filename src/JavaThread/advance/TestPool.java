package advance;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestPool {

    public static void main(String[] args) {
        /* 阿里规约不允许使用这种方式创建线程池 */
        ExecutorService service = Executors.newFixedThreadPool(10);

        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());

        service.shutdown();

    }

}

class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
