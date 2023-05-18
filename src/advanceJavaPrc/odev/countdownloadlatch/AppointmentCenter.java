package advanceJavaPrc.odev.countdownloadlatch;

import java.time.LocalDate;

public class AppointmentCenter {

    private LocalDate day = LocalDate.now();


    public synchronized LocalDate getAppointmentDate(){
        day = day.plusDays(1);  // Bir gün sonrasını veriri
        return day;
    }
}
