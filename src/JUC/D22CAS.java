package JUC;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * ABA问题 例子：账户100块 1、线程1：用户转出100，卡住 2、线程2：用户转出100，成功 3、线程3：转入100，成功
 * 4、线程1：恢复，转出100（不应该的转出）
 */
public class D22CAS {
    public static void main(String[] args) {
        /**
         * 带标记的原子引用
         * 注意Integer对象的引用问题，-128-127问题
         */
        AtomicStampedReference<Integer> asRef = new AtomicStampedReference<>(20, 1);

        new Thread(() -> {
            int v =(int) asRef.getReference();
            int stamp = asRef.getStamp();

            /* do calc */
            int j = v + 1;

            boolean isSuccess = asRef.compareAndSet(v, j,stamp, stamp + 1);
            System.out.println(isSuccess);
        }).start();

    }
}
