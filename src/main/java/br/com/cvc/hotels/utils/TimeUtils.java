package br.com.cvc.hotels.utils;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

/**
 * @author Jonathan Taquita (takita.jonathan@gmail.com)
 * @since 2019.03.30
 *
 * Class for implements utils methods relation the time
 */
public class TimeUtils {

    public static long daysDiff(LocalDate init, LocalDate end) {
        return Duration.between(init.atStartOfDay(), end.atStartOfDay()).toDays();
    }

}
