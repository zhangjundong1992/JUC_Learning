package JVM;

public class D08InnerClass {
    public static void main(String[] args) {
        
        

        
    }
}

class Outer02 {
    public static int o1;
    private static int o2;

    public static class Inner02 {
        public  int i1;
        private static int i2;

        public  void in_foo1() {
            int in_tmp1 = o1;
            int in_tmp2 = o2;
        }
    }

    public void out_foo1() {
       
    }
}