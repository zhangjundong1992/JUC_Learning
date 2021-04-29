package Reflect;
@SuppressWarnings("all")
/* Class类的创建方式 */
public class reflec02 {

    public static void main(String[] args) throws Exception {
        /* 1.Class.forName() */
        Class c1 = Class.forName("Reflect.Student");
        System.out.println(c1.hashCode());

        /* 2.类名获取 */
        Class c2 = Student.class;
        System.out.println(c2.hashCode());

        /* 3.通过实例 */
        Student s = new Student();
        Class c3 = s.getClass();
        System.out.println(c3.hashCode());

        /* 4.获取父类 */
        Class c4= c3.getSuperclass();
        System.out.println(c4);
    }

}

class Person {
    public String name = "人";
}

class Student extends Person {

    public Student() {
        this.name = "学生";
    }
}
