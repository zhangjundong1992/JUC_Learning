package JUC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@SuppressWarnings("all")
/* 集合类的线程安全 */
public class D06Collection {

    public static void main(String[] args) throws InterruptedException {
        
        // List<String> list=new ArrayList<>();
        /* 1、集合工具类实现线程安全的list */ 
        List<String> list1 = Collections.synchronizedList(new ArrayList<>());
        /* 2、CopyOnWriteList线程安全的集合 */
        CopyOnWriteArrayList<String> list2 = new CopyOnWriteArrayList<String>();

        /* set和list十分类似 */
        Set<String> set=new HashSet<>();
        /* map使用的是concurrenthashmap */
        Map<String,String> map=new HashMap<>();
        Map<String,String> map2=new ConcurrentHashMap<>();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list2.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(list2);
            }, String.valueOf(i)).start();
        }

        // TimeUnit.SECONDS.sleep(5);
        // list1.forEach(System.out::println);
    }
}