package base;

/*使用runnable接口方便多线程操作统一资源 
并发问题，多线程操作统一资源，线程不安全 */
public class Test04 {
    public static void main(String[] args) {
        InnerTest04 mt = new InnerTest04();

        new Thread(mt, "赵").start();
        new Thread(mt, "钱").start();
        new Thread(mt, "孙").start();
    }
}

class InnerTest04 implements Runnable {
    int resNum = 10;

    @Override
    public void run() {
        while (true) {
            if (resNum <= 0) {
                break;
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " : " + resNum--);
        }
    }
}
