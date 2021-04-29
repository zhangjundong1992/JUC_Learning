package state;

public class TestJoin {
    public static void main(String[] args) throws InterruptedException {

        Thread thread= new Thread(new MyJoin());
        thread.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("主线程: "+i);
            if (i==15) {
                thread.join();
            }
        }
        
    }
}

class MyJoin implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("vip线程: "+i);
        }
        
    }
}
