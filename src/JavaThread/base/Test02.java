package base;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* 创建线程，实现Callable */
public class Test02 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread02 mt1 = new MyThread02();
        MyThread02 mt2 = new MyThread02();

        /* 适配器 */
        FutureTask<Integer> ft1 = new FutureTask<>(mt1);
        FutureTask<Integer> ft2 = new FutureTask<>(mt2);

        new Thread(ft1).start();
        new Thread(ft2).start();

        System.out.println("ft1:" + ft1.get());
        System.out.println("ft2:" + ft2.get());
    }
}

class MyThread02 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return new Random().nextInt(10);
    }
}
