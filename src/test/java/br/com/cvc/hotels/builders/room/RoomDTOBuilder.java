package br.com.cvc.hotels.builders.room;

import br.com.cvc.hotels.builders.price.PriceDTOBuilder;
import br.com.cvc.hotels.models.hotel.HotelDTO;
import br.com.cvc.hotels.models.room.RoomDTO;

import java.util.ArrayList;
import java.util.List;

public class RoomDTOBuilder {

    private RoomDTO room;

    private RoomDTOBuilder() {}

    public static List<RoomDTO> manyRooms(int length) {
        List<RoomDTO> hotels = new ArrayList<>();
        for (long i = 0; i < length; i++) {
            hotels.add(oneRoom(i).now());
        }
        return hotels;
    }

    public static RoomDTOBuilder oneRoom() {
        return oneRoom(1L);
    }

    public static RoomDTOBuilder oneRoom(Long id) {
        RoomDTOBuilder builder = new RoomDTOBuilder();
        builder.room = new RoomDTO();
        builder.room.setRoomID(id);
        builder.room.setCategoryName("Standard");
        builder.room.setPrice(PriceDTOBuilder.onePrice().now());
        return builder;
    }

    public RoomDTO now() {
        return this.room;
    }

}
