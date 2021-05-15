package JVM;

public class D09LoadSrcCode {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(D09LoadSrcCode.class.getClassLoader());
        Class<?> aClass = D09LoadSrcCode.class.getClassLoader().loadClass("JVM.03String");
        System.out.println(1);
        System.out.println(aClass.getClassLoader());
        Class.forName("");
    }
}

