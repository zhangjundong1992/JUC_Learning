package proxy;
/**
 * RealSubject
 */
public class RealSubject implements Subject{
    @Override
    public void action() {
        System.out.println("RealSubject");
    }
    
}