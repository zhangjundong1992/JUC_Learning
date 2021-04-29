package Reflect;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* 元注解 */
@MyAnnotation
public class Annotation02 {

}

@Target(value = { ElementType.METHOD, ElementType.TYPE }) // 定义注解的位置
@Retention(value = RetentionPolicy.RUNTIME) // 定义注解的保留时间，比如保留到运行时
@Documented //表示是否生成在javadoc中
@Inherited //表示是否被子类继承
@interface MyAnnotation {

}
