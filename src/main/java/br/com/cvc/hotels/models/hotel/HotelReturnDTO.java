package br.com.cvc.hotels.models.hotel;

import br.com.cvc.hotels.models.room.RoomReturnDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class HotelReturnDTO extends HotelCommon {

    private List<RoomReturnDTO> rooms;

}
