package advanceJavaPrc.odev.countdownloadlatch;

import java.util.concurrent.CountDownLatch;

/*
Geri sayım tamalanıncaya kadar CountDownLatch örneğinin "await()" methodunu çağıran tüm threadler bekletilir.
Geri sayım tamamlandığında bir anlamda kapı sürgüsü açılır ve bekleyen threadler işlemeye devam eder.
Örneğin "n" sayıda threadin işlerini bitirdiklerini bildirene kadar (yani her biri sayacı bir azaltana ve
nihayetinde sayacın değeri sıfıra ulaşana kadar) ana threadin bekletilmesi istediğimiz bir
durumda kullanılabilir.

Task:Bir randevu oluşturma uygulaması tasarlayınız. (AppointmentCenter)
Uygulama herbir talep için bir gün sonrasını tarih vermelidir.
Randevu tarihini veren threadlerden önce randevu öncesinde
bazı işlemleri gerçekleştiren threadlerin çalışmasını sağlayınız.
 */
/*Adımlar
1.Kullanacağınız worker threadleri Worker classında
2.CountDownLatch ve AppointmentCenter objelerini oluştur
3.foreach döngüsü ile Threadler oluştur
4.Worker worker lar türet
5.Türetilen worker ları çalıştır

 */
public class AppointmentApp {
    public static void main(String[] args) {
        String[] users = {"Bill", "Steve", "Linus", "Tim", "Larry"};
    }


}
