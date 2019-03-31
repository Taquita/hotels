package br.com.cvc.hotels.models.price;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Jonathan Taquita (takita.jonathan@gmail.com)
 * @see 2019.03.30
 * @see PriceReturnDTO
 *
 * Class for testing set methdos in PriceReturnDTO
 */
@RunWith(SpringRunner.class)
public class PriceReturnDTOTest {

    /**
     * @since 2019.03.30
     *
     * Test for calculating value in setPricePerDayAdult
     */
    @Test
    public void shouldCheckIfMultipleForValueIsCorrectForAdults() {
        PriceReturnDTO price = new PriceReturnDTO();
        price.setPricePerDayAdult(100.00);
        assertEquals(142.86, price.getPricePerDayAdult(), 0.01);
    }

    /**
     * @since 2019.03.30
     *
     * Test for calculating value in setPricePerDayChild
     */
    @Test
    public void shouldCheckIfMultipleForValueIsCorrectForChildren() {
        PriceReturnDTO price = new PriceReturnDTO();
        price.setPricePerDayChild(100.00);
        assertEquals(142.86, price.getPricePerDayChild(), 0.01);
    }

}
