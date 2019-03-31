package br.com.cvc.hotels.builders.room;

import br.com.cvc.hotels.builders.price.PriceReturnDTOBuilder;
import br.com.cvc.hotels.models.room.RoomReturnDTO;

/**
 * @author Jonathan Taquita (takita.jonathan@gmail.com)
 * @since 2019.03.30
 * @see RoomReturnDTO
 *
 * Class Builder for RoomReturnDTO
 */
public class RoomReturnDTOBuilder {

    private RoomReturnDTO room;

    private RoomReturnDTOBuilder() { }

    public static RoomReturnDTOBuilder oneRoom() {
        RoomReturnDTOBuilder builder = new RoomReturnDTOBuilder();
        builder.room = new RoomReturnDTO();
        builder.room.setPriceDetail(PriceReturnDTOBuilder.onePrice().now());
        return builder;
    }

    public RoomReturnDTO now() {
        return this.room;
    }
}
