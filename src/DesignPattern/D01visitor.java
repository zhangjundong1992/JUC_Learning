package DesignPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 访问者模式特点： 
 * 1、被访问的对象具有稳定的嵌套结构 
 * 2、经常需要增加不同的访问者，对相同的结构进行不同的处理
 */
public class D01visitor {
    public static void main(String[] args) {
        Store store = new Store();
        IVisitor xm = new Ming();
        store.service(xm);
    }
}

/**
 * 商店是稳定的，供应的水果种类也是稳定的
 */
class Store {
    List<Fruit> list = new ArrayList<>();

    public Store() {
        list.add(new Banana());
        list.add(new Watermelon());
    }

    public void service(IVisitor visitor) {
        for (Fruit fruit : list) {
            // visitor.visit(fruit);    /* Java不支持多重分派 */
            fruit.accept(visitor);  /* 使用单分派模拟多重分派,否则需要进行类型判断，破坏了扩展性 */
        }
    }
}

/* 水果及其子类都是稳定的 */
abstract class Fruit {

    public abstract void accept(IVisitor visitor);
}

class Banana extends Fruit {

    @Override
    public void accept(IVisitor visitor) {
        visitor.visitBanana(this);
    }

}

class Watermelon extends Fruit {

    @Override
    public void accept(IVisitor visitor) {
        visitor.visitWatermelon(this);
    }

}

/**
 * 接口是稳定的，依赖与水果的种类
 */
interface IVisitor {
    void visitBanana(Banana banana);

    void visitWatermelon(Watermelon watermelon);
}

/**
 * 可扩展的访问者，对稳定结构有不同的访问需求
 */
class Ming implements IVisitor {

    @Override
    public void visitBanana(Banana banana) {

    }

    @Override
    public void visitWatermelon(Watermelon watermelon) {

    }

}
