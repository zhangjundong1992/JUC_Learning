package JUC;

public class D21Singleton {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                // Lazy.getInstance();
                LazyConcurrent.getInstance();
            }).start();
        }
        
    }
}

/**
 * 饿汉式单例 可能造成内存浪费
 */
class Hungry {
    private Hungry() {
    }

    private final static Hungry instance = new Hungry();

    public static Hungry getInstance() {
        return instance;
    }
}

/**
 * 懒汉式 多线程下有问题
 */
class Lazy {
    private Lazy() {
        System.out.println("new lazy");
    }

    private static Lazy instance;

    public static Lazy getInstance() {

        if (instance == null)
            instance = new Lazy();

        return instance;
    }
}

/**
 * 多线程下的懒汉式
*/
class LazyConcurrent {
    private LazyConcurrent() {
        System.out.println("new lazyConcurrent");
    }

    /**
     * 避免指令重排
    */
    private volatile static LazyConcurrent instance;

    public static LazyConcurrent getInstance() {

        if (instance == null) {
            synchronized (LazyConcurrent.class) {
                if (instance == null) {
                    instance = new LazyConcurrent();
                    /**
                     * 指令重排
                     * 1.分配内存空间
                     * 2、执行构造方法，初始化对象
                     * 3、对象指向空间
                    */

                    /**
                     * 能能的执行顺序1->3->2
                    */
                }
            }
        }

        return instance;
    }
}
