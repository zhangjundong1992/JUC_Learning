package JVM;

/**
 * 栈帧测试
*/
public class D01StackFrame {
    public static void main(String[] args) {
        foo();
    }

    public static void foo() {
        bar();
    }

    public static void bar() {
        System.out.println("hhhh");
    }
}
