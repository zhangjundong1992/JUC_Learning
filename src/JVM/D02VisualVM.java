package JVM;

import java.util.ArrayList;
import java.util.List;

/**
 * visulvm工具测试
*/
@SuppressWarnings("all")
public class D02VisualVM {
    public static void main(String[] args) throws InterruptedException {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            students.add(new Student());
        }
        Thread.sleep(1000000000L);
    }   
}

class Student {
    private byte[] big = new byte[1024*1024];
}
