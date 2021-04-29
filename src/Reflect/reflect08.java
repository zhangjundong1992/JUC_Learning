package Reflect;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@SuppressWarnings("all")
/* 反射操作注解 */
public class reflect08 {
    public static void main(String[] args) throws Exception {

        /* 获取类的注解 */
        Class c1 = People.class;
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation ant : annotations) {
            System.out.println(ant);
        }

        System.out.println("===========");

        /* 读取注解的值 */
        TableAnno anno = (TableAnno) c1.getAnnotation(TableAnno.class);
        System.out.println(anno.value());

        System.out.println("===========");

        /* 获得指定注解 */
        Field field = c1.getDeclaredField("name");
        FieldAnno fa = field.getAnnotation(FieldAnno.class);
        System.out.println(fa.columnName());
        System.out.println(fa.type());
        System.out.println(fa.length());
    }

}

@TableAnno("db_people")
class People {
    @FieldAnno(columnName = "db_id", type = "int", length = 10)
    private int id;
    @FieldAnno(columnName = "db_id", type = "varchar", length = 3)
    private String name;
    @FieldAnno(columnName = "db_id", type = "int", length = 10)
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public People() {
    }

    public People(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "People [age=" + age + ", id=" + id + ", name=" + name + "]";
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableAnno {
    String value();
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldAnno {
    String columnName();

    String type();

    int length();
}
