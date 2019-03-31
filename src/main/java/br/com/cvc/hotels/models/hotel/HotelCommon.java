package br.com.cvc.hotels.models.hotel;

import br.com.cvc.hotels.models.room.RoomDTO;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString
@EqualsAndHashCode
abstract class HotelCommon {

    private Long id;
    private String name;
    private Long cityCode;
    private String cityName;

}
