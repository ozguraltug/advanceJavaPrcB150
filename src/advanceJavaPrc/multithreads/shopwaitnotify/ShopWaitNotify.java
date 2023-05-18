package advanceJavaPrc.multithreads.shopwaitnotify;
/*
Task: Bir marketteki stok miktarını takip eden bir uygulama tasarlayınız.
Marketteki yeterli ürün yoksa yeni ürün gelmesi beklensin.
Yeni ürün eklenince ürün satışı gerçekleşsin
 */

public class ShopWaitNotify {

    public static volatile int stock=5;
    public static void main(String[] args) {
        ShopWaitNotify shop=new ShopWaitNotify();

        Thread consumerThread=new Thread(new Runnable() {
            @Override
            public void run() {

                shop.consumeProduct(3);
            }
        });
        consumerThread.setName("Tüketici");

        Thread producerThread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                shop.produceProduct(4);
            }
        });
        producerThread.setName("Üretici");
        consumerThread.start();
        producerThread.start();

    }

    public synchronized void consumeProduct(int amount){
        if(amount>stock){
            System.out.println();
            System.out.println(Thread.currentThread().getName()+" ürün satın almak istiyor...");
            System.out.println(" Yeterli ürün yok. Ürün stoğu :"+ stock);
            System.out.println("Tüketici ürün girişini bekliyor.");

            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        if(amount<=stock){
            System.out.println();
            System.out.println(Thread.currentThread().getName()+" ürün satın almak istiyor...");
            System.out.println("Ürün satın alındı ve stocktan düşülüyor");
            stock=stock-amount;
            System.out.println("Güncel stok : "+stock);
        }
        else{
            System.out.println(Thread.currentThread().getName()+" ürün satın almak istiyor");
            System.out.println("Yeterli ürün yok, Güncel stock : "+stock);
            System.out.println("Bugün git yarın gel...");
        }

    }
    public synchronized void produceProduct(int amount){
        System.out.println();
        System.out.println(Thread.currentThread().getName()+" ürün eklemek istiyor...");
        System.out.println("Yeni ürünler eklendi...");
        stock=stock+amount;
        System.out.println("Güncel stock : "+stock);
        notify();
        System.out.println();
    }
}
