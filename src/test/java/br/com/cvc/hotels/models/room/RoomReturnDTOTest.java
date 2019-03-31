package br.com.cvc.hotels.models.room;

import br.com.cvc.hotels.builders.price.PriceReturnDTOBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * @author Jonathan Taquita (takita.jonathan@gmail.com)
 * @since 2019.03.30
 * @see RoomReturnDTO
 *
 * Class for testing setters in RoomReturnDTO
 */
@RunWith(SpringRunner.class)
public class RoomReturnDTOTest {

    /**
     * @since 2019.03.30
     *
     * Test for check calc in setTotalPrice
     */
    @Test
    public void shouldCheckIfCalcTotalIsCorrect() {
        RoomReturnDTO room = new RoomReturnDTO();
        room.setPriceDetail(PriceReturnDTOBuilder.onePrice().now());
        room.setTotalPrice(1,2, 2);
        assertEquals(571.44, room.getTotalPrice(), 0.01);
    }

    /**
     * @since 2019.03.30
     *
     * Test for check calc in setTotalPrice returned zero with zero children and adults
     */
    @Test
    public void shouldCheckIfCalcReturnZeroInCaseAdultsNullOrChildrenNull() {
        RoomReturnDTO room = new RoomReturnDTO();
        room.setPriceDetail(PriceReturnDTOBuilder.onePrice().now());
        room.setTotalPrice(0,0, 2);
        assertEquals(0, room.getTotalPrice(), 0.01);
    }

    /**
     * @since 2019.03.30
     *
     * Test for check calc in setTotalPrice returned zero with zero days
     */
    @Test
    public void shouldCheckIfCalcReturnZeroInCaseDateZero() {
        RoomReturnDTO room = new RoomReturnDTO();
        room.setPriceDetail(PriceReturnDTOBuilder.onePrice().now());
        room.setTotalPrice(4,2, 0);
        assertEquals(0, room.getTotalPrice(), 0.01);
    }

}
