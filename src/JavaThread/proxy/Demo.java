package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Demo {
    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

        RealSubject sub = new RealSubject();

        Subject proxy = (Subject) Proxy.newProxyInstance(sub.getClass().getClassLoader(),
                sub.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        return method.invoke(sub, args);
                    }
                });

        // Subject proxy2 = (Subject) Proxy.newProxyInstance(sub.getClass().getClassLoader(),
        //         sub.getClass().getInterfaces(), (p, m, a) -> {
        //             try {
        //                 return m.invoke(sub, args);
        //             } catch (Exception e) {
        //                 e.printStackTrace();
        //             }

        //             return null;
        //         });

        proxy.action();
    }
}
