package base;

/* 线程创建,直接继承Thread */
public class Test01 {
    public static void main(String[] args) throws Exception {
        MyThread01 mt = new MyThread01();
        // mt.run(); //run方法相当于普通调用
        mt.start(); // start方法加入线程调度

        for (int i = 0; i < 20; i++) {
            System.out.println("main:" + i);
        }
    }
}

class MyThread01 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("MyThread:" + i);
        }
    }

}
