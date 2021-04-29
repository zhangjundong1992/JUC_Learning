package JUC;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class D07Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /* Callable实现类 */
        MyThread mt = new MyThread();

        /**
         *  适配器，将Callable实现类封装为Runnable实现
         * 同时ft实现异步回调*/
        FutureTask<Integer> ft = new FutureTask<>(mt);

        /* 注意,call只执行一次 */
        new Thread(ft).start();
        new Thread(ft).start();

        System.out.println("res : " + ft.get());

        MyRunnable mr = new MyRunnable();
        new Thread(mr).start();
        new Thread(mr).start();
    }
}

class MyThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("call");
        return 1024;
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("run");
    }
}
