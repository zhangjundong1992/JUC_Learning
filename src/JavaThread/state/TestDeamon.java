package state;
/**
 * TestDeamon
 */
public class TestDeamon {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true)
                System.out.println("上帝守护着你");
        });
        t1.setDaemon(true);
        t1.start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++)
                System.out.println("用户存活： " + i);
            System.out.println("bye world!");
        }).start();
    }
}