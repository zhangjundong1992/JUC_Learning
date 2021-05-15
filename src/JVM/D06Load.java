package JVM;

public class D06Load {
    

    public static void main(String[] args) {

        System.out.println(new A().a);
    }
}

class A {
    static {
        System.out.println("static");
    }

    {
        System.out.println("here");
    }

    final int a = 5;
}
