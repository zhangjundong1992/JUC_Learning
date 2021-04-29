package JUC;

public class D01Ticket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                ticket.getTicket();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                ticket.getTicket();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                ticket.getTicket();
            }
        }).start();
    }

}

class Ticket {
    private int num = 20;

    public synchronized void getTicket() {
        if (num > 0)
            System.out.println(Thread.currentThread().getName() + "买到了票： " + num--);
    }
}
