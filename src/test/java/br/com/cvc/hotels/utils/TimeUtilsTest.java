package br.com.cvc.hotels.utils;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class TimeUtilsTest {

    @Test
    public void shouldCheckIfDiffDateIsCorrectInDaysDiff() {
        LocalDate init = LocalDate.now();
        LocalDate end = init.plusDays(6);

        int diff = TimeUtils.daysDiff(init, end);

        assertEquals(6 , diff);
    }

}
