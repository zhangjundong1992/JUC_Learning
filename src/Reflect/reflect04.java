package Reflect;

import java.lang.reflect.Field;

@SuppressWarnings("all")
/* 获得类的信息 */
public class reflect04 {
    public static void main(String[] args) throws Exception {
        Class c1 = Class.forName("Reflect.User");
        // User user=new User();

        System.out.println("=======类名=======");
        /* 类名 */
        System.out.println(c1.getName());
        System.out.println(c1.getSimpleName());

        System.out.println("=======字段=======");
        /* 字段 */
        Field[] fields = c1.getFields();// public
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("==============");

        fields = c1.getDeclaredFields();// 所有
        for (Field field : fields) {
            // field.setAccessible(true);
            System.out.println(field);
        }

        /* 方法 */
        /* 构造器 */
        
    }
}
