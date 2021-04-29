package state;

/* 测试线程停止 */
public class TestSleep {
    public static void main(String[] args) throws InterruptedException {
        int n = 10;

        while (true) {
            System.out.println(n--);
            Thread.sleep(1000);

            if (n <= 0) 
                break;
        }
    }

}
