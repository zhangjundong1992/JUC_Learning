package Reflect;

import java.lang.reflect.Method;

/* 性能测试 */
public class reflect06 {
    public static void main(String[] args) throws Exception {
        test01();
        test02();
        test03();
    }

    public static void test01() {
        User user = new User();

        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            user.setAge(20);
        }

        long end = System.currentTimeMillis();
        System.out.println("普通方法调用: " + (end - start));
    }

    public static void test02() throws Exception {
        User user = new User();
        Method setAge=User.class.getDeclaredMethod("setAge", int.class);

        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            setAge.invoke(user, 20);
        }

        long end = System.currentTimeMillis();
        System.out.println("反射方法调用: " + (end - start));
    }

    public static void test03() throws Exception {
        User user = new User();
        Method setAge=User.class.getDeclaredMethod("setAge", int.class);
        setAge.setAccessible(true);

        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            setAge.invoke(user, 20);
        }

        long end = System.currentTimeMillis();
        System.out.println("反射方法调用，开始访问权限: " + (end - start));
    }

}
