package advanceJavaPrc.multithreads.volatileKeyword;

public class Numarator {
    private volatile static int counter=0;

    //volatile ilecounter sayısı ram e kayıt olur
    //ancak tüm threadlerin değişkene aynı anda ulaşmasından kaynaklı sorunu çözmez.
    //Bunun için de synchronized keywordu kullanılır

    public synchronized void getOrder(){
        String name=Thread.currentThread().getName();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        counter++;
        System.out.println("Sayın " +name+ " sıranız : "+counter);
    }
}
