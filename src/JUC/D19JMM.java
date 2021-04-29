package JUC;

public class D19JMM {

    public volatile static int num = 0;

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            while (num == 0) {

            }
            System.out.println(Thread.currentThread().getName());
        }).start();

        
        Thread.sleep(1000);
        num = 1;
        System.out.println("main");
    }

}
