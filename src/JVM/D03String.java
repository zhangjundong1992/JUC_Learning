package JVM;

/* 串池是一个固定大小的map，猜测，key是用string的equal判断相等，value是对象指针 */
public class D03String {
    public static void main(String[] args) {
        String s1 = "a"; /* 懒惰 */
        String s2 = "b";
        String s3 = "ab";
        String s4 = s1 + s2; // new StringBuilder().append("a").append("b").toString() new String("ab")
        String s5 = "a" + "b"; // javac 在编译期间的优化，结果已经在编译期确定为ab

        System.out.println(s3 == s4);   /* false,s4是新建的对象 */
        System.out.println(s3 == s5);   /* 编译优化，常量拼接优先串池中查找 */
    }
}
