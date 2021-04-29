package Reflect;

import java.lang.annotation.ElementType;

@SuppressWarnings("all")
/* 所有类型的Class对象 */
public class reflec03 {
    public static void main(String[] args) {
        Class c1 = Object.class;
        Class c2 = Runnable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = Override.class;
        Class c6 = ElementType.class;
        Class c7 = int.class;
        Class c8 = Integer.class;
        Class c9 = Void.class;
        Class c10 = void.class;
        Class c11 = Class.class;

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
        System.out.println(c7);
        System.out.println(c8);
        System.out.println(c9);
        System.out.println(c10);
        System.out.println(c11);
    }

}
