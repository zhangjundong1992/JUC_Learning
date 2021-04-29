package Reflect;

public class AppRef {
    public static void main(String[] args) {
       Fruit fruit=new Banana();

       /* 属性和方法 */
       System.out.println(fruit.name); /* 水果 */
       System.out.println(fruit);   /* Banana [name=香蕉] */

       fruit.foo(); /* banana */

       System.out.println(fruit.bar());

       System.out.println(fruit.getClass());

    }
}

class Fruit{
    public String name="水果";

    public void foo(){
        System.out.println("fruit");
    }

    Fruit bar(){
        return this;
    }

    @Override
    public String toString() {
        return "Fruit [name=" + name + "]";
    }
}

class Banana extends Fruit{
    public String name="香蕉";

    Banana bar(){
        return this;
    }

    public void foo(){
        System.out.println("banana");
    }

    @Override
    public String toString() {
        return "Banana [name=" + name + "]";
    }
}