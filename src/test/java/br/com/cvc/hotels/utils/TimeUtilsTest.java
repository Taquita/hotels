package br.com.cvc.hotels.utils;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * @author Jonathan Taquita (takita.jonathan@gmail.com)
 * @since 2019.03.30
 * @see TimeUtils
 *
 * Class test for TimeUtils
 */
@RunWith(SpringRunner.class)
public class TimeUtilsTest {

    /**
     * @since 2019.03.30
     *
     * Method for testing return the daysDiff method
     */
    @Test
    public void shouldCheckIfDiffDateIsCorrectInDaysDiff() {
        LocalDate init = LocalDate.now();
        LocalDate end = init.plusDays(6);

        int diff = TimeUtils.daysDiff(init, end);

        assertEquals(6 , diff);
    }

}
