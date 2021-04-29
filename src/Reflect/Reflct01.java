package Reflect;
/**
 * 通过反射创建对象实例
*/
@SuppressWarnings("all")
public class Reflct01 {
    public static void main(String[] args) throws Exception {

        Class c1= Class.forName("Reflect.User");
        System.out.println(c1);
    }
}

class User {
    public String name;
    private int id;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User() {
    }

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User [age=" + age + ", id=" + id + ", name=" + name + "]";
    }

}
