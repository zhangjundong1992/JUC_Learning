package JVM;

/**
 * 测试方法，两个sout语句只能有一个执行时进行测试
 */
public class D04String {
    public static void main(String[] args) {
        foo3();
    }

    public static void foo1() {
        String s = new String("a") + new String("b"); /* 串池[a,b] */
        System.out.println("ab" == s); /* false,s指向堆中的一个StringBuilder对象 */
    }

    public static void foo2() {
        String s = new String("a") + new String("b"); /* 串池[a,b] */
        s.intern(); /* 串池[a,b,ab] */
        System.out.println("ab" == s); /* true，s指向串池 */
    }

    public static void foo3() {
        String s1 = "ab";
        String s2 = new String("a") + new String("b"); /* 串池[a,b,ab] */
        String s3 = s2.intern(); /* 串池[a,b,ab] */
        System.out.println("ab" == s1); /* true */
        System.out.println("ab" == s2); /* false，s指向对象 */
        System.out.println("ab" == s3); /* true,返回的是串池中的对象 */
    }
}
