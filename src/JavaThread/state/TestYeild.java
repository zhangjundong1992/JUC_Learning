package state;

public class TestYeild {
    public static void main(String[] args) {
        Runnable my=new MyYield();

        for (int i = 0; i < 10; i++) {
            new Thread(my,"线程"+i).start();
        }
    }

}

class MyYield implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程开始");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "线程结束");
    }
}