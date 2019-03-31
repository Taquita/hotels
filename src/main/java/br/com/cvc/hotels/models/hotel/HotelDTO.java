package br.com.cvc.hotels.models.hotel;

import br.com.cvc.hotels.models.room.RoomDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class HotelDTO extends HotelCommon {

    private List<RoomDTO> rooms;

}
