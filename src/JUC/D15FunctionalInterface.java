package JUC;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 函数式接口 四个原生接口
 */
public class D15FunctionalInterface {
    public static void main(String[] args) {
        /* 1、Function */
        new Function<Integer, String>() {
            @Override
            public String apply(Integer t) {
                System.out.println(t);
                return "ret";
            }
        }.apply(5);

        /* 2、Predicate */
        if (new Predicate<Void>() {
            @Override
            public boolean test(Void t) {
                System.out.print("hello ");
                return false;
            }
        }.test(null)) {
            System.out.println("hello");
        } else {
            System.out.println("world");
        }

        /* 3、Consumer */
        new Consumer<Integer>() {
            public void accept(Integer t) {
                System.out.println(t);
            };
        }.accept(5);

        /* 4、Supplier */
        Integer ret = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return 1024;
            }
        }.get();
        System.out.println(ret);
    }

}
