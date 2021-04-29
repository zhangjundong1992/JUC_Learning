package Reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@SuppressWarnings("all")
/* 动态创建对象 */
public class reflect05 {
    public static void main(String[] args) throws Exception {
        /* 通过构造器动态创建对象 */
        Class c1 = Class.forName("Reflect.User");
        User user1 = (User) c1.getDeclaredConstructor(String.class,int.class,int.class).newInstance("zjd",001,29);
        System.out.println(user1);

        /* 通过反射执行方法 */
        User user2=(User)c1.getDeclaredConstructor().newInstance();
        Method setAge=c1.getDeclaredMethod("setAge", int.class);
        setAge.invoke(user2, 20);
        System.out.println(user2);

        /* 通过反射操作属性 */
        User user3=(User)c1.getDeclaredConstructor().newInstance();
        Field id=c1.getDeclaredField("id");
        id.setAccessible(true);
        id.set(user3, 5);
        System.out.println(user3);
        
    }
}
