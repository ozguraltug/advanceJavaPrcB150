package advanceJavaPrc.multithreads.interrupt;

import advanceJavaPrc.multithreads.shopwaitnotify.ShopWaitNotify;

/*
Bir marketteki stock miktarınıtakip eden bir uygulama tasarlayınız.
Markette yeterki ürün yoksa yeni ürün gelmesini beklesin.
Yeni ürün eklenince ürün satışı gerçekleşsin.
 */
public class ShopInterrupt {


    public static volatile int stock=2;
    public static void main(String[] args) {
        ShopInterrupt shop=new ShopInterrupt();

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
                //burda tüketiciy durdur diyoruz

                consumerThread.interrupt();

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

        }


    }
    public synchronized void produceProduct(int amount){
        System.out.println();
        System.out.println(Thread.currentThread().getName()+" ürün eklemek istiyor...");
        System.out.println("Yeni ürünler eklendi...");
        stock=stock+amount;
        System.out.println("Güncel stock : "+stock);

        System.out.println();
    }
}
