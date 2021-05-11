package JVM;

public class D05Finally {
    public static void main(String[] args) {
        int result1 = test1();
        System.out.println(result1);

        int result2 = test2();
        System.out.println(result2);
    }

    /**
     * 返回20
     * finally中的return语句会吞掉athrow,导致无法自动进行异常检测
    */
    public static int test1() {
        try {
            // int i=1/0; //不会进行异常检测
            return 10;
        } finally {
            return 20;
        }
    }

    /**
     * 返回10
    */
    public static int test2() {
        int i = 10;
        try {
            // int x=10/0; //会进行异常检测
            return i;
        } finally {
            i = 20;
        }
    }
}
