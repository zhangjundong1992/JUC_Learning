import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        for (int i = 0; i < list.size(); i++) {
            // System.out.println(list.get(i));
            if (list.get(i) % 2 == 0) {
                list.remove(i);
            }
        }

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}