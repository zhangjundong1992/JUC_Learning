package Reflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* 自定义一个注解 */
public class Annotation03 {

    @MyAnnotation02(name = "zjd")
    public void test() {
    }

    @MyAnnotation03("zjd")
    public void test2() {
    }

}

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation02 {

    /* 注解的参数: 类型+参数名+()。可以带默认值 */
    String name();
    int age() default 0;
    int id() default -1;
}

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation03 {
    /* 只有一个value的时候，使用可以省略，其他命名不行 */
    String value();
}