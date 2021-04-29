package Reflect;

import java.util.ArrayList;
import java.util.List;

/* 内置注解 */
public class Annotation01 {

    public static void main(String[] args) {
        Annotation01.test01();

    }

    /* 内置注解 Override */
    @Override
    public String toString() {
        return super.toString();
    }

    /* 内置注解-Deprecated */
    @Deprecated
    public static void test01() {
        System.out.println("deprecated");
    }

    /* 内置注解-SuppressWarning */
    @SuppressWarnings("all")
    public void test02() {
        List list = new ArrayList<>();
    }
}
