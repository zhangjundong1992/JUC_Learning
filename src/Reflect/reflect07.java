package Reflect;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

@SuppressWarnings("all")
/* 通过反射获得方法参数类型 */
public class reflect07 {
    public static void main(String[] args) throws Exception {
        /* 获得参数列表 */
        Method method01 = reflect07.class.getDeclaredMethod("test01", Map.class, List.class);
        Type[] types01 = method01.getGenericParameterTypes();

        for (Type type : types01) {
            System.out.println(type);
            if (type instanceof ParameterizedType) {
                Type[] atas = ((ParameterizedType) type).getActualTypeArguments();
                for (Type t : atas) {
                    System.out.println(t);
                }
            }
            System.out.println("=========");
        }

        /* 获得返回值 */
        Method method02 = reflect07.class.getDeclaredMethod("test02", null);
        Type type02 = method02.getGenericReturnType();
        System.out.println(type02);
        if (type02 instanceof ParameterizedType) {
            Type[] atas = ((ParameterizedType) type02).getActualTypeArguments();
            for (Type t : atas) {
                System.out.println(t);
            }
        }

    }

    public void test01(Map<String, Integer> map, List<String> list) {
        System.out.println("test01");
    }

    public List<Integer> test02() {
        System.out.println("test02");
        return null;
    }
}
