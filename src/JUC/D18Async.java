package JUC;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 异步调用future（未提供回调机制） 回调机制 讲解的很浅
 */
public class D18Async {
    public static void main(String[] args) {
        /* 1、future */
        ExecutorService threadPool = Executors.newCachedThreadPool();
        Future<String> future = threadPool.submit(() -> {
            Thread.sleep(1000);
            // int i = 1 / 0;
            return "hello world!";
        });
        /* 阻塞式获取异步调用结果 */
        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        threadPool.shutdown();

        /**
         * 2、CompletableFuture 异步调用 成功回调 失败回调
         */
        /* 无返回值 */
        CompletableFuture.runAsync(() -> {
        });
        var res = CompletableFuture.supplyAsync(() -> {
            return 1024;
        });
        try {
            System.out.println(res.get());
        } catch (Exception e) {
            e.printStackTrace();
        };

        /**
         * 补充一下不阻塞主线程的异步调用 */
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "sync res";
        });

        f1.thenAcceptAsync(System.out::println);

        System.out.println("main");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
