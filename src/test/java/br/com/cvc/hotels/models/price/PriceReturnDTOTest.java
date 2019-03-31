package br.com.cvc.hotels.models.price;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class PriceReturnDTOTest {

    @Test
    public void shouldCheckIfMultipleForValueIsCorrectForAdults() {
        PriceReturnDTO price = new PriceReturnDTO();
        price.setPricePerDayAdult(100.00);
        assertEquals(142.86, price.getPricePerDayAdult(), 0.01);
    }

    @Test
    public void shouldCheckIfMultipleForValueIsCorrectForChildren() {
        PriceReturnDTO price = new PriceReturnDTO();
        price.setPricePerDayChild(100.00);
        assertEquals(142.86, price.getPricePerDayChild(), 0.01);
    }

}
