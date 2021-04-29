package JUC;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class D16Stream {

    public static void main(String[] args) {
        User u1 = new User(0, 26, "e");
        User u2 = new User(2, 22, "b");
        User u3 = new User(3, 23, "c");
        User u4 = new User(4, 24, "d");

        List<User> list = Arrays.asList(u1, u2, u3, u4);

        /**
         * 链式编程
         * filter
         * map
         * limit
        */
        list.stream().filter(u11 -> u11.id % 2 == 0 && u11.age > 23)
            .map(u12 -> u12.name.toUpperCase())
            .sorted(Comparator.reverseOrder())
            .limit(1)
            .forEach(System.out::println);
    }

}

class User {
    public int id;
    public int age;
    public String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User [age=" + age + ", id=" + id + ", name=" + name + "]";
    }
}
