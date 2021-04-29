package JUC;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class D11RWLock {
    public static void main(String[] args) {
        MyCache cache = new MyCache();

        for (int i = 0; i < 5; i++) {
            final int tmp = i;
            new Thread(() -> {
                cache.get(String.valueOf(tmp));
            }).start();
        }

        // try {
        //     TimeUnit.SECONDS.sleep(1);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }

        for (int i = 0; i < 5; i++) {
            final int tmp = i;
            new Thread(() -> {
                cache.put(String.valueOf(tmp), String.valueOf(tmp));
            }).start();
        }

    }
}

class MyCache {
    private HashMap<String, String> map = new HashMap<>();
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void put(String key, String value) {

        lock.writeLock().lock();
        System.out.println("写入前：" + key);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        map.put(key, value);
        System.out.println("写入后：" + key);
        lock.writeLock().unlock();
    }

    public void get(String key) {
        lock.readLock().lock();
        System.out.println("读取前" + key);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.get(key);
        System.out.println("读取后" + key);
        lock.readLock().unlock();
    }
}
