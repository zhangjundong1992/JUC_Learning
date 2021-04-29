package syn;

import java.util.ArrayList;
import java.util.List;

public class UnsafeList {
    public static void main(String[] args) throws InterruptedException {
        List<String> arr=new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            Thread t= new Thread(()->{
                synchronized(arr){
                    arr.add(Thread.currentThread().getName());
                }
                
            });
            t.start();
            t.join();
        }

        // Thread.sleep(5000);

        System.out.println(arr.size());
    }
}
