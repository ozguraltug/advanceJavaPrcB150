package advanceJavaPrc.odev.semaphorex;
/*
Semaphore bir kaynağa erişebilen iş parçacığını sayısını kısıtlamak için kullanılır.
Yani, sychronized sadece bir iş parçacığının kilitlenmesi ve
senkronize blok / yöntemi yürütmesine izin verirken, Semaphore n iş parçacığına izin verir
ve diğerlerini engeller.

senaryo:deneme kabini / deneme kasası
Mağazanın 3 deneme kabini var. 5 kişi mağazanın kabinini
kullanmak istiyor. Bu 5 tane işlem için 5 thread kullanılsın.
 */
/*Adımlar
1.Adım Semaphore objesi tanımlayınız. İçine thread sayısı 3 giriniz
2.Threadleri Person classında oluştur.
3.SemaphorePr classında 5 tane Person person oluştur.(Aslında bunlar thread)
4.person şeklinde oluşturduğun threadleri çalıştır

*/
public class SemaphorePr {
}
