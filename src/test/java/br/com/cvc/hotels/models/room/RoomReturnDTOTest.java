package br.com.cvc.hotels.models.room;

import br.com.cvc.hotels.builders.price.PriceReturnDTOBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class RoomReturnDTOTest {

    @Test
    public void shouldCheckIfCalcTotalIsCorrect() {
        RoomReturnDTO room = new RoomReturnDTO();
        room.setPriceDetail(PriceReturnDTOBuilder.onePrice().now());
        room.setTotalPrice(1,2, 2);
        assertEquals(571.44, room.getTotalPrice(), 0.01);
    }

    @Test
    public void shouldCheckIfCalcReturnZeroInCaseAdultsNullOrChildrenNull() {
        RoomReturnDTO room = new RoomReturnDTO();
        room.setPriceDetail(PriceReturnDTOBuilder.onePrice().now());
        room.setTotalPrice(0,0, 2);
        assertEquals(0, room.getTotalPrice(), 0.01);
    }

    @Test
    public void shouldCheckIfCalcReturnZeroInCaseDateZero() {
        RoomReturnDTO room = new RoomReturnDTO();
        room.setPriceDetail(PriceReturnDTOBuilder.onePrice().now());
        room.setTotalPrice(4,2, 0);
        assertEquals(0, room.getTotalPrice(), 0.01);
    }

}
