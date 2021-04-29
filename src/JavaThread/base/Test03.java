package base;

/* 创建线程，实现Runnable */
public class Test03 {
    public static void main(String[] args) throws Exception {
        MyThread03 mt = new MyThread03();
        // mt.run(); //run方法相当于普通调用
        new Thread(mt).start(); // start方法加入线程调度

        for (int i = 0; i < 20; i++) {
            System.out.println("main:" + i);
        }
    }
}

class MyThread03 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("MyThread:" + i);
        }
    }
}
