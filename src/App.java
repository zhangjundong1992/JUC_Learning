
public class App {
    public static void main(String[] args) {
        Fruit fruit=new Watermelon();
        fruit.name();
        Test01 t=new Test01();
        t.foo(((Watermelon)fruit));
    }
}

class Test01 {
    public void foo(Watermelon fruit) {
        System.out.println("foo");
        fruit.name();
    }
}

class Fruit {
    public void name() {
        System.out.println("fruit");
    }

}

class Watermelon extends Fruit{
    public void name() {
        System.out.println("watermelon");
    }
}

class Banana extends Fruit{
    public void name() {
        System.out.println("banana");
    }
}