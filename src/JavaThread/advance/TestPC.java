package advance;

public class TestPC {
    public static void main(String[] args) {
        SyncContainer container=new SyncContainer();

        new Productor(container).start();
        new Consumer(container).start();
    }

}

class Productor extends Thread {

    private SyncContainer container;

    public Productor(SyncContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                container.push(new Product(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {

    private SyncContainer container;

    public Consumer(SyncContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                container.pop();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Product {
    public int id;
    public Product(int id){
        this.id=id;
    }
}

class SyncContainer {
    Product[] products = new Product[10];
    int cnt = 0;

    public synchronized void push(Product product) throws InterruptedException {
        if (cnt >= products.length) {
            this.wait();
        }

        Thread.sleep(100);
        products[cnt++] = product;
        System.out.println("生产产品编号： "+product.id+"容器内产品数量为： "+cnt);

        this.notifyAll();
    }

    public synchronized Product pop() throws InterruptedException {
        if (cnt <= 0) {
            this.wait();
        }

        Thread.sleep(100);
        Product res = products[--cnt];
        System.out.println("消费产品编号： "+res.id+"容器内产品数量为： "+cnt);
        this.notifyAll();

        return res;
    }
}
