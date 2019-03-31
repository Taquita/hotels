package br.com.cvc.hotels.utils;

import java.time.LocalDate;
import java.time.Period;

public class TimeUtils {

    public static int daysDiff(LocalDate init, LocalDate end) {
        Period period = Period.between(init, end);
        return period.getDays();
    }

}
