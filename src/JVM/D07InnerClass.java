package JVM;

import JVM.Outer.Inner;

public class D07InnerClass {
    public static void main(String[] args) {
        Outer.Inner inner=new Outer().new Inner();
    }
}

class Outer{
    public int o1;
    private int o2;

    public class Inner{
        public int i1;
        private int i2;

        public void in_foo1(){
            int in_tmp1=o1;
            int in_tmp2=o2; 
        }
    }

    public void out_foo1(){
        int tmp1= new Inner().i1;
        int tmp2=new Inner().i2;
    }
}
