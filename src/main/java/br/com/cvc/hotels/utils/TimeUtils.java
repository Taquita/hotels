package br.com.cvc.hotels.utils;

import java.time.LocalDate;
import java.time.Period;

/**
 * @author Jonathan Taquita (takita.jonathan@gmail.com)
 * @since 2019.03.30
 *
 * Class for implements utils methods relation the time
 */
public class TimeUtils {

    public static int daysDiff(LocalDate init, LocalDate end) {
        Period period = Period.between(init, end);
        return period.getDays();
    }

}
