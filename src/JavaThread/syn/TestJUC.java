package syn;

import java.util.concurrent.CopyOnWriteArrayList;


public class TestJUC {

    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> arr=new CopyOnWriteArrayList<>();

        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                arr.add(Thread.currentThread().getName()); 
            }).start();
        }

        Thread.sleep(5000);

        System.out.println(arr.size());
    }
}